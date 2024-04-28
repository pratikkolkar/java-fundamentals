/**
 * StringBuilderVsStringBuffer
 */
public class StringBuilderVsStringBuffer {

    public static void main(String[] args) {
        /**
         * StringBuilder is not thread safe | StringBuffer is thread safe
         * StringBuilder is fast | StringBuffer is slow due to handling of threadsafety
         * Use StringBuilder in case of single thread | Use String Buffer in multithreaded application 
         * 
         */

        // StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("A");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("B");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(sb.toString().length());

    }
}