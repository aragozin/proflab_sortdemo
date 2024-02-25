package info.ragozin.proflab.sortdemo;

public abstract class ArraySorter1<K> extends ArraySortedBase<K> {

    /**
     * Return object associated with entry. Object could be reused between call to this
     * method, but not shared with {@link #keyAt_B(int)}
     *
     * @return comparable object
     */
    @Override
    protected K keyAt_A(int entry) {
        throw new UnsupportedOperationException();
    }

    /**
     * Return object associated with entry. Object could be reused between call to this
     * method, but not shared with {@link #keyAt_A(int)}
     *
     * @return comparable object
     */
    @Override
    protected K keyAt_B(int entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected int keysCompare(K a, K b) {
        return ((Comparable)a).compareTo(b);
    }

    @Override
    public int[] order(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Negative range");
        }
        int[] refs = new int[to - from];
        for (int i = 0; i < refs.length; ++i) {
            refs[i] = from + i;
        }

        sortRefs(refs);
        return refs;
    }

    protected void sortRefs(int[] rows) {
        sort_internal(rows, 0, rows.length);
    }

    protected void sort_internal(int[] rows, int start, int end) {
        int length = end - start;
        if (length < 2) {
            return;
        }
        int n = start + 1;
        while (n < end) {
            // move down
            int l = n;
            while(l > start && cmp(rows, l - 1, l) > 0) {
                swap(rows, l - 1, l);
                --l;
            }
            ++n;
        }
    }

    protected int cmp(int[] rows, int a, int b) {
        return cmp(rows[a], rows[b]);
    }

    @Override
    protected int cmp(int a, int b) {
        return keysCompare(keyAt_A(a), keyAt_B(b));
    }

    private static void swap(int x[], int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
