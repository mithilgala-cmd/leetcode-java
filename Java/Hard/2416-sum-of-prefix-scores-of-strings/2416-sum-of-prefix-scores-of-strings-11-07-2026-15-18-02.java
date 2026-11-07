class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
                node.count++;
            }
        }

        int[] answer = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            int score = 0;

            for (char c : words[i].toCharArray()) {
                node = node.children[c - 'a'];
                score += node.count;
            }

            answer[i] = score;
        }

        return answer;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }
}