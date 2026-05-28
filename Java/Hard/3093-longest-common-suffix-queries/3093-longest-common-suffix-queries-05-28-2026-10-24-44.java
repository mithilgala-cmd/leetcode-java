class Solution {

    class Node {
        Node[] next = new Node[26];
        int index = -1; // best index
    }

    Node root = new Node();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int best = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[best].length()) {
                best = i;
            }
        }

        for (int i = 0; i < wordsContainer.length; i++) {
            Node node = root;
            String word = new StringBuilder(wordsContainer[i]).reverse().toString();

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (node.next[idx] == null) {
                    node.next[idx] = new Node();
                }

                node = node.next[idx];

                if (node.index == -1 ||
                    wordsContainer[i].length() < wordsContainer[node.index].length() ||
                    (wordsContainer[i].length() == wordsContainer[node.index].length() && i < node.index)) {
                    node.index = i;
                }
            }
        }

        int[] res = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            Node node = root;
            int ans = best;

            String word = new StringBuilder(wordsQuery[i]).reverse().toString();

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (node.next[idx] == null) break;

                node = node.next[idx];

                if (node.index != -1) {
                    ans = node.index;
                }
            }
            res[i] = ans;
        }
        return res;
    }
}