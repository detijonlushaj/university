import java.util.concurrent.atomic.*;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(countFactorsStream(1_000_000_000L));
        long stop = System.currentTimeMillis();
        System.out.println((stop-start)/1000.0);
    }

    public static long countFactors(long n) {
        return countFactors(n, 1, n/2) +1; // +1 for n
        }
    
    public static long countFactors(long n, long from, long to) {
        long cnt= 0;
        for (long i=from; i<=to; i++) {
            if (isFactor(i, n)) cnt++;
        }
        return cnt;
    }

    public static boolean isFactor(long i, long n) {
        return n % i == 0;
    }

    private static AtomicLong cnt= new AtomicLong(0L);

    static class C extends Thread {
        private long n, from, to;    
        C(long n, long from, long to) {
            this.n= n; this.from= from; this.to= to;
        }

        @Override public void run() {
            cnt.addAndGet(countFactors(n, from, to));
        } 
    }

    private static long countFactorsThread(long n) {
        C[] t= new C[4]; // 4 Threads
        double d= (n/2 / (double)t.length);
        for (int i=0; i<t.length; i++) {
            t[i]= new C(n, 1+(long)(i*d), (long)((i+1)*d));
            t[i].start();
        }
        for (int i=0; i<t.length; i++) {
            try { t[i].join(); } catch (InterruptedException e) { }
        }
        return cnt.get() +1;
    }
    
    public static long countFactorsStream(long n) {
        long cnt= LongStream.rangeClosed(1, n/2)
        .parallel()
        .filter( i -> isFactor(i, n) )
        .count();
        return cnt+1;
        }
}