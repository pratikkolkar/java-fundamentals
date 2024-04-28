package multithreading;

public class MT01VolatileKey {
    
    public static void main(String[] args) {
        SharedObject obj = new SharedObject();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 Started");
            try {
                Thread.sleep(1000);
                obj.setFlagTrue();
                System.out.println("Thread 1 Completed");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 Started");
            while (!obj.getFlag()) {
                
            }
            System.out.println("Thread 2 Completed");
        });
        
        t1.start();
        t2.start();

    }
}
class SharedObject {

    private volatile boolean flag = false;

    public void setFlagTrue() {
        this.flag=true;
    }

    public boolean getFlag() {
        return this.flag;
    }
    
}