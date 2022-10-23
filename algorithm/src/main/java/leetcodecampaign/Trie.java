package leetcodecampaign;

public class Trie {

    private boolean isEnd;

    private Trie[] next;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int index = c[i] - 'a';
            if (curr.next[index] == null) {
                curr.next[index] = new Trie();
            }
            curr = curr.next[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = prefix(word);
        if (curr == null) return false;

        return curr != null && curr.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        Trie curr = prefix(prefix);
        return curr != null;
    }

    private Trie prefix(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        Trie curr = this;
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int index = c[i] - 'a';
            if (curr.next[index] == null) {
                return null;
            }
            curr = curr.next[index];
        }
        return curr;
    }
}
