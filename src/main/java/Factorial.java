import java.math.BigInteger;
import java.util.*;

public class Factorial extends Thread {

    static List<BigInteger> results = new ArrayList<>();
    static MyThread anotherthread;


    public static void main(String[] args) throws InterruptedException {

        int[] array = new int[]{3, 13, 25, 39, 41, 54};
        anotherthread = new MyThread(array);
        anotherthread.start();
        anotherthread.join();
        System.out.println(results);
      }

    public static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

    static class MyThread extends Thread {

        private int[] array;

        MyThread(int... array) {
            this.array = array;

        }

        @Override
        public void run() {
            for (int x = 0; x < array.length; x++) {
                BigInteger a = factorial(array[x]);
                results.add(a);

            }
        }
    }

}
