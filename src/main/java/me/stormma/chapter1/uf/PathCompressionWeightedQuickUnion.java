package me.stormma.chapter1.uf;

/**
 * This {@code PathCompressionWeightedQuickUnion} class is best implementation of union-find algorithm.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class PathCompressionWeightedQuickUnion {

    private int[] id;

    private int count;

    private int[] sz;

    public PathCompressionWeightedQuickUnion(int count) {
        this.count = count;
        id = new int[count];
        sz = new int[count];
        // Initialize the component
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int temp = p;
        while (id[p] != p) {
            p = id[p];
        }
        id[temp] = p;
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = id[qRoot];
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = id[pRoot];
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }
}
