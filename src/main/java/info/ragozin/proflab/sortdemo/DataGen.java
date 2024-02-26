package info.ragozin.proflab.sortdemo;

import java.util.Arrays;
import java.util.Random;

public class DataGen {

    private static final int STR_WASTE = 2 << 10;

    public static String[] generate1(int size) {
        Random rnd = new Random(1);
        String[] array = new String[size];
        for (int i = 0; i != array.length; ++i) {
            char[] ca1 = new char[1];
            Arrays.fill(ca1, '.');
            char[] ca2 = new char[STR_WASTE - 1];
            Arrays.fill(ca2, '.');
            array[i] = new StringBuffer().append(ca1).append(rnd.nextInt(2 * size)).append(ca2).toString();
        }

        return array;
    }

    public static String[] generate2(int size) {
        Random rnd = new Random(1);
        String[] array = new String[size];
        for (int i = 0; i != array.length; ++i) {
            char[] ca = new char[STR_WASTE];
            Arrays.fill(ca, '.');
            array[i] = new StringBuffer().append(ca).append(rnd.nextInt(2 * size)).toString();
        }

        return array;
    }
}
