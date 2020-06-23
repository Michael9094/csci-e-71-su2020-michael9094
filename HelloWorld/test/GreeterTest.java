import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {
    private static class TestCase {
        public String label;
        public String[] input;
        public String output;

        public TestCase(String label, String[] input, String output) {
            this.label = label;
            this.input = input;
            this.output = output;
        }
    }

    @TestFactory
    Stream<DynamicTest> getMessage() {
        List<TestCase> cases = new ArrayList<>(Arrays.asList(
                new TestCase("null", null, "Hello, world!"),
                new TestCase("empty", new String[0], "Hello, world!"),
                new TestCase("blank", new String[]{""}, "Hello, world!"),
                new TestCase("Richard", new String[]{"Richard"}, "Hello, Richard!"),
                new TestCase("Michael", new String[]{"Michael"}, "Hello, Michael!"),
                new TestCase("Anupam", new String[]{"Anupam", "Preet", "Kaur"}, "Hello, Anupam Preet Kaur!")
        ));
        Greeter greeter = new Greeter();
        return cases.stream().map(testCase -> DynamicTest.dynamicTest(testCase.label, () ->
                assertEquals(testCase.output, greeter.getMessage(testCase.input))
        ));
    }
}