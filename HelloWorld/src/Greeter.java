public class Greeter {
    public String getMessage(String[] args) {
        StringBuilder sb = new StringBuilder();
        if (args == null || args.length == 0) {
            return "Hello, world!";
        }
        for (int i = 0; i < args.length; ++i) {
            String name = args[i].length() > 0 ? args[i] : "world";
            if (i == 0) {
                sb.append("Hello, ").append(name);

            } else {
                sb.append(' ').append(name);
            }
        }
        sb.append('!');
        return sb.toString();
    }
}
