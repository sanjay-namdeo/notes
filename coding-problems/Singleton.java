public class Singleton {
    public static void main(String[] args) {
        System.out.println(Log.getInstance());
        System.out.println(Log.getInstance());
    }
}

class Log {
    private Log() {
    }

    private static class InnerLog {
        private static final Log instance = new Log();
    }

    public static Log getInstance() {
        return InnerLog.instance;
    }
}