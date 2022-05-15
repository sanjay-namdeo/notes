public class TwoThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Test.m1();
            };
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Test.m2();
            };
        });
        t1.start();
        t2.start();
    }

}

class Test {
    public static synchronized void m1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ", i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void m2() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ", i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
