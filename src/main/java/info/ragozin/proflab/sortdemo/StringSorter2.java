package info.ragozin.proflab.sortdemo;

public class StringSorter2 extends ArraySorter2<String> {

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
        return a.compareTo(b);
    }

    public int[] order() {
        return order(0, array.length);
    }
}
