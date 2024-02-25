package info.ragozin.proflab.sortdemo;

public abstract class ArraySortedBase<K> {

    protected abstract int cmp(int a, int b);

    public abstract int[] order(int from, int to);

    protected abstract int keysCompare(K a, K b);

    protected abstract K keyAt_B(int entry);

    protected abstract K keyAt_A(int entry);

}
