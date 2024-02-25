

import java.util.concurrent.TimeUnit;

import info.ragozin.proflab.sortdemo.DataGen;
import info.ragozin.proflab.sortdemo.StringSorter2;

public class SortDemo2 {

    static int[] order = null;

    public static void main(String... args) {

        int size = 2 << 10;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        String[] data = DataGen.generate2(size);
        StringSorter2 ss = new StringSorter2(data);

        System.out.println("Sorting " + size + " elements");
        while (true) {
            doSort(ss);
        }
    }

    private static void doSort(StringSorter2 ss) {
        long ts = System.nanoTime();
        for (int i = 0; i != 100; ++i) {
            order = ss.order();
        }
        long timeNS = System.nanoTime() - ts;
        System.out.println(String.format("Average sort time %.2fms (100 iterations)", 0.01d * timeNS / TimeUnit.MILLISECONDS.toNanos(1)));
    }
}
