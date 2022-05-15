public class ThreadNumber {
    int counter = 1;
    static int N;

    private void printOddNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " ");
                counter++;
                notify();
            }
        }
    }

    private void printEvenNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter + " ");
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        N = 10;
        ThreadNumber threadNumber = new ThreadNumber();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadNumber.printEvenNumber();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadNumber.printOddNumber();
            }
        });
        t1.start();
        t2.start();
    }
}