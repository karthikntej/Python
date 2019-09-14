class SampleThread extends Thread {
    synchronized public void run() {
        
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Sample thread - "+  i);
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        }
        
    }
}

class MyThread {

    public static void main (String args[]) {
        SampleThread t1 = new SampleThread();
        SampleThread t2 = new SampleThread();
        t1.start();
        t1.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Main thread - " + i);
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        }
    }
}
