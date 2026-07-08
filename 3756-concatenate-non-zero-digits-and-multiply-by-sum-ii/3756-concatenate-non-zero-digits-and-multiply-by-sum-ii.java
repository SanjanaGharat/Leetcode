class Solution {
    static final int MOD = 1_000_000_007;

    class Node {
        int len;
        long val;
        int sum;
    }

    Node[] tree;
    long[] pow10;
    String s;

    public int[] sumAndMultiply(String s, int[][] queries) {
        this.s = s;
        int n = s.length();

        pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Node res = query(1, 0, n - 1, queries[i][0], queries[i][1]);
            ans[i] = (int) ((res.val * res.sum) % MOD);
        }
        return ans;
    }

    private void build(int idx, int l, int r) {
        tree[idx] = new Node();

        if (l == r) {
            int d = s.charAt(l) - '0';
            if (d != 0) {
                tree[idx].len = 1;
                tree[idx].val = d;
                tree[idx].sum = d;
            }
            return;
        }

        int mid = (l + r) >> 1;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private Node query(int idx, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) return tree[idx];

        int mid = (l + r) >> 1;

        if (qr <= mid) return query(idx * 2, l, mid, ql, qr);
        if (ql > mid) return query(idx * 2 + 1, mid + 1, r, ql, qr);

        return merge(
            query(idx * 2, l, mid, ql, qr),
            query(idx * 2 + 1, mid + 1, r, ql, qr)
        );
    }

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.len = left.len + right.len;
        res.sum = left.sum + right.sum;
        res.val = (left.val * pow10[right.len] + right.val) % MOD;
        return res;
    }
}