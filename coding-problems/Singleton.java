public class Singleton {
    public static void main(String[] args) {
        System.out.println(Log.getInstanse());
        System.out.println(Log.getInstanse());
    }
}

class Log {
    static class InnerClass {
        private static Log log;

        private static Log getInstanse() {
            if (log == null) {
                log = new Log();
            }
            return log;
        }
    }

    public static Log getInstanse() {
        return InnerClass.getInstanse();
    }
}