import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
    @TestFactory
    Stream<DynamicTest> getMessage() {
        List<String> labels = Arrays.asList(
                "null",
                "empty",
                "blank",
                "Richard",
                "Michael",
                "Anupam"
        );
        List<String[]> inputs = Arrays.asList(
                null,
                new String[0],
                new String[]{""},
                new String[]{"Richard"},
                new String[]{"Michael"},
                new String[]{"Anupam", "Preet", "Kaur"}
        );
        List<String> outputs = Arrays.asList(
                "Hello, world!",
                "Hello, world!",
                "Hello, world!",
                "Hello, Richard!",
                "Hello, Michael!",
                "Hello, Anupam Preet Kaur!"
        );
        return labels.stream().map(label -> DynamicTest.dynamicTest(label, () -> {
            int idx = labels.indexOf(label);
            Greeter greeter = new Greeter();
            assertEquals(outputs.get(idx), greeter.getMessage(inputs.get(idx)));
        }));
    }
}