class Solution {
    class Node {
        int l, r, max, pre, suf;
        char preChar, sufChar;
        Node left, right;
    }

    Node build(char[] arr, int l, int r) {
        Node node = new Node();
        node.l = l; node.r = r;
        if (l == r) {
            node.max = node.pre = node.suf = 1;
            node.preChar = node.sufChar = arr[l];
            return node;
        }
        int m = (l + r) / 2;
        node.left = build(arr, l, m);
        node.right = build(arr, m+1, r);
        return merge(node);
    }

    Node merge(Node node) {
        Node L = node.left, R = node.right;
        node.preChar = L.preChar;
        node.sufChar = R.sufChar;
        node.pre = L.pre;
        if (L.pre == L.r - L.l + 1 && L.sufChar == R.preChar) node.pre += R.pre;
        node.suf = R.suf;
        if (R.suf == R.r - R.l + 1 && R.preChar == L.sufChar) node.suf += L.suf;
        node.max = Math.max(L.max, R.max);
        if (L.sufChar == R.preChar) node.max = Math.max(node.max, L.suf + R.pre);
        return node;
    }

    void update(Node node, int idx, char c) {
        if (node.l == node.r) {
            node.preChar = node.sufChar = c;
            node.max = node.pre = node.suf = 1;
            return;
        }
        if (idx <= node.left.r) update(node.left, idx, c);
        else update(node.right, idx, c);
        merge(node);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        Node root = build(arr, 0, arr.length-1);
        int[] res = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            update(root, queryIndices[i], queryCharacters.charAt(i));
            res[i] = root.max;
        }
        return res;
    }
}