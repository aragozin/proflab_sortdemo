package info.ragozin.proflab.sortdemo;

public class StringSorter2 extends ArraySorter2<String> {

    private volatile int factor = 1;

    private final String[] array;

    public StringSorter2(String[] array) {
        this.array = array;
    }

    @Override
    protected String keyAt_A(int entry) {
        return array[entry];
    }

    @Override
    protected String keyAt_B(int entry) {
        return array[entry];
    }

    @Override
    protected int keysCompare(String a, String b) {
        int ch = 0;
        while(true) {
            ch += strCmp(a, b);
            if (factor > 0) {
                break;
            }
        }
        return ch;
    }

    private int strCmp(String a, String b) {
        return a.compareTo(b);
    }

    public int[] order() {
        return order(0, array.length);
    }
}
