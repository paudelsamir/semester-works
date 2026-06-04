public class Lab10_Threading {
    
    // Task a: Thread using Runnable interface
    static class RunnableThread implements Runnable {
        private String name;
        
        RunnableThread(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            System.out.println(name + " - Runnable thread started");
            for (int i = 0; i < 3; i++) {
                System.out.println(name + " - Iteration " + (i + 1));
            }
            System.out.println(name + " - Runnable thread ended");
        }
    }
    
    // Task a: Thread by extending Thread class
    static class ThreadClass extends Thread {
        private String name;
        
        ThreadClass(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            System.out.println(name + " - Thread class started");
            for (int i = 0; i < 3; i++) {
                System.out.println(name + " - Iteration " + (i + 1));
            }
            System.out.println(name + " - Thread class ended");
        }
    }
    
    // Task e: Two threads with different intervals
    static class FirstThread extends Thread {
        @Override
        public void run() {
            System.out.println("\nFirst Thread - Prints 1-10 with 2 second intervals:");
            for (int i = 1; i <= 10; i++) {
                System.out.println("First Thread: " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static class SecondThread extends Thread {
        @Override
        public void run() {
            System.out.println("\nSecond Thread - Prints 11-20 with 1 second intervals:");
            for (int i = 11; i <= 20; i++) {
                System.out.println("Second Thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Task b: Demonstrate isAlive() and join()
    static void taskIsAliveAndJoin() {
        System.out.println("\n--- Task B: isAlive() and join() methods ---");
        Thread t = new ThreadClass("JoinThread");
        t.start();
        
        System.out.println("Is thread alive? " + t.isAlive());
        
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("After join - Is thread alive? " + t.isAlive());
    }
    
    // Task c: Thread priorities
    static void taskThreadPriorities() {
        System.out.println("\n--- Task C: Thread Priorities ---");
        Thread t1 = new ThreadClass("Priority1");
        Thread t2 = new ThreadClass("Priority2");
        
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println(t1.getName() + " Priority: " + t1.getPriority());
        System.out.println(t2.getName() + " Priority: " + t2.getPriority());
    }
    
    public static void main(String[] args) {
        System.out.println("--- Threading Demonstration ---");
        
        // Task a: Runnable and Thread class
        System.out.println("\nTask A: Creating threads");
        System.out.println("--- Using Runnable ---");
        Thread t1 = new Thread(new RunnableThread("RunnableThread1"));
        t1.start();
        
        System.out.println("\n--- Using Thread class ---");
        ThreadClass t2 = new ThreadClass("ThreadClass1");
        t2.start();
        
        taskIsAliveAndJoin();
        taskThreadPriorities();
        
        // Task d: Synchronized method
        System.out.println("\n--- Task D: Synchronized Method ---");
        // Synchronization examples would go here
        
        // Task e: Two threads with intervals (commented to avoid long execution)
        // System.out.println("\n--- Task E: Two threads with intervals ---");
        // FirstThread ft = new FirstThread();
        // SecondThread st = new SecondThread();
        // ft.start();
        // st.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 10");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
