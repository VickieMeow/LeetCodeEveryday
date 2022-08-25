public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });
        
    }
}
