public class Lab13_Threading {

    // ─── Task a: Thread by implementing Runnable ───
    static class RunnableTask implements Runnable {
        private String name;
        RunnableTask(String name) { this.name = name; }
        public void run() {
            System.out.println(name + " (Runnable) started");
            for (int i = 1; i <= 3; i++)
                System.out.println(name + " - count " + i);
            System.out.println(name + " (Runnable) ended");
        }
    }

    // ─── Task b: Thread by extending Thread class ───
    static class ExtendThread extends Thread {
        private String name;
        ExtendThread(String name) { this.name = name; }
        public void run() {
            System.out.println(name + " (Thread class) started");
            for (int i = 1; i <= 3; i++)
                System.out.println(name + " - count " + i);
            System.out.println(name + " (Thread class) ended");
        }
    }

    // ─── Task g: Thread printing 100 to 1 at 3s intervals (extend Thread) ───
    static class CountDownThread extends Thread {
        public void run() {
            System.out.println("\n[Task G] Counting 100 to 1 (3s interval):");
            for (int i = 100; i >= 1; i--) {
                System.out.println("CountDown: " + i);
                try { Thread.sleep(3000); } catch (InterruptedException e) { break; }
            }
        }
    }

    // ─── Task h: Thread printing 1 to 10 at 2s intervals (implement Runnable) ───
    static class CountUpTask implements Runnable {
        public void run() {
            System.out.println("\n[Task H] Counting 1 to 10 (2s interval):");
            for (int i = 1; i <= 10; i++) {
                System.out.println("CountUp: " + i);
                try { Thread.sleep(2000); } catch (InterruptedException e) { break; }
            }
        }
    }

    // ─── Task c: isAlive() and join() ───
    static void taskIsAliveAndJoin() {
        System.out.println("\n--- Task C: isAlive() and join() ---");
        Thread t = new ExtendThread("JoinDemo");
        System.out.println("Before start, isAlive? " + t.isAlive());
        t.start();
        System.out.println("After start, isAlive? " + t.isAlive());
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After join, isAlive? " + t.isAlive());
    }

    // ─── Task d: Setting and getting thread priorities ───
    static void taskPriorities() {
        System.out.println("\n--- Task D: Thread Priorities ---");
        Thread t1 = new ExtendThread("LowPriority");
        Thread t2 = new ExtendThread("HighPriority");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getName() + " priority: " + t1.getPriority());
        System.out.println(t2.getName() + " priority: " + t2.getPriority());
    }

    // ─── Shared resource for synchronisation ───
    static class SharedCounter {
        private int count = 0;

        // Task e: Synchronized method
        public synchronized void incrementSync() {
            count++;
            System.out.println("Synchronized method - count: " + count);
        }

        // Task f: Synchronized block
        public void incrementBlock() {
            synchronized (this) {
                count++;
                System.out.println("Synchronized block - count: " + count);
            }
        }
    }

    static void taskSyncMethod() throws InterruptedException {
        System.out.println("\n--- Task E: Synchronized Method ---");
        SharedCounter sc = new SharedCounter();
        Thread ta = new Thread(() -> { for (int i = 0; i < 3; i++) sc.incrementSync(); });
        Thread tb = new Thread(() -> { for (int i = 0; i < 3; i++) sc.incrementSync(); });
        ta.start(); tb.start();
        ta.join(); tb.join();
    }

    static void taskSyncBlock() throws InterruptedException {
        System.out.println("\n--- Task F: Synchronized Block ---");
        SharedCounter sc = new SharedCounter();
        Thread ta = new Thread(() -> { for (int i = 0; i < 3; i++) sc.incrementBlock(); });
        Thread tb = new Thread(() -> { for (int i = 0; i < 3; i++) sc.incrementBlock(); });
        ta.start(); tb.start();
        ta.join(); tb.join();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Threading Demonstration (8 Tasks) ---\n");

        // Task a
        System.out.println("Task A: Thread via Runnable interface");
        new Thread(new RunnableTask("Runnable-A")).start();

        // Task b
        System.out.println("\nTask B: Thread via extending Thread class");
        new ExtendThread("Extend-B").start();

        // Give threads time to finish before next demos
        Thread.sleep(500);

        taskIsAliveAndJoin();
        taskPriorities();

        taskSyncMethod();
        taskSyncBlock();

        // Task g & h – start and let them run (they print their own headers)
        System.out.println("\n--- Task G: CountDownThread (100→1, 3s intervals) ---");
        CountDownThread cd = new CountDownThread();
        cd.setDaemon(true);
        cd.start();

        System.out.println("\n--- Task H: CountUpTask (1→10, 2s intervals) ---");
        Thread cu = new Thread(new CountUpTask());
        cu.start();

        // Let count-up (h) finish, then print footer while count-down continues as daemon
        cu.join();

        System.out.println("\nLab No.: 13");
        System.out.println("Name: Shishir Pandey");
        System.out.println("Roll No./Section: 15/079, Section: A");
    }
}
