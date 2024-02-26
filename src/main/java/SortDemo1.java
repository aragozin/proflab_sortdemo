

import java.util.concurrent.TimeUnit;

import info.ragozin.proflab.sortdemo.DataGen;
import info.ragozin.proflab.sortdemo.StringSorter1;

public class SortDemo1 {

    static int[] order = null;

    public static void main(String... args) {

        int size = 1 << 10;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        String[] data = DataGen.generate1(size);
        StringSorter1 ss = new StringSorter1(data);

        System.out.println("Sorting " + size + " elements");
        while (true) {
            doSort(ss);
        }
    }

    private static void doSort(StringSorter1 ss) {
        long ts = System.nanoTime();
        int i;
        for (i = 0; i != 100; ++i) {
            order = ss.order();
            long timeNS = System.nanoTime() - ts;
            if (timeNS > TimeUnit.SECONDS.toNanos(5)) {
                ++i;
                break;
            }
        }
        long timeNS = System.nanoTime() - ts;
        System.out.println(String.format("Average sort time %.2fms (%d iterations)", 1d * timeNS / i / TimeUnit.MILLISECONDS.toNanos(1), i));
    }
}
