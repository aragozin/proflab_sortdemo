package info.ragozin.proflab.sortdemo;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void testSorting10() {

        int[] data = generate(10);
        IntSorter1 s1 = new IntSorter1(data);
        IntSorter2 s2 = new IntSorter2(data);

        Assert.assertTrue(Arrays.equals(s1.order(), s2.order()));

    }

    @Test
    public void testSorting10k() {

        int[] data = generate(10_000);
        IntSorter1 s1 = new IntSorter1(data);
        IntSorter2 s2 = new IntSorter2(data);

        verify(data, s1.order());
        verify(data, s2.order());
    }

    private int[] generate(int n) {
        Random rnd = new Random(1);

        int[] data = new int[n];
        for (int i = 0; i != data.length; ++i) {
            data[i] = rnd.nextInt(2000) - 1000;
        }

        return data;
    }

    private void verify(int[] data, int[] order) {
        for (int i = 1; i != data.length; ++i) {
            int a = data[order[i - 1]];
            int b = data[order[i]];
           Assert.assertTrue(a <= b);
        }
    }

    private static class IntSorter1 extends ArraySorter1<Integer> {

        private final int[] array;

        public IntSorter1(int[] array) {
            this.array = array;
        }

        public int[] order() {
            return order(0, array.length);
        }

        @Override
        protected Integer keyAt_A(int entry) {
            return array[entry];
        }

        @Override
        protected Integer keyAt_B(int entry) {
            return array[entry];
        }

        @Override
        protected int keysCompare(Integer a, Integer b) {
            return Integer.compare(a, b);
        }
    }

    private static class IntSorter2 extends ArraySorter2<Integer> {

        private final int[] array;

        public IntSorter2(int[] array) {
            this.array = array;
        }

        public int[] order() {
            return order(0, array.length);
        }

        @Override
        protected Integer keyAt_A(int entry) {
            return array[entry];
        }

        @Override
        protected Integer keyAt_B(int entry) {
            return array[entry];
        }

        @Override
        protected int keysCompare(Integer a, Integer b) {
            return Integer.compare(a, b);
        }
    }
}
