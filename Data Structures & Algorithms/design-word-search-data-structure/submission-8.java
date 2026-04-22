private class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;        
    }

    public HashMap<Character, TrieNode> getChildren() {return this.children;}

    public void setIsWord(boolean isWord) {this.isWord = isWord;}
    public boolean getIsWord() {return this.isWord;}
}

public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.root;
        for(char c : word.toCharArray()) {
            if(!node.getChildren().containsKey(c)) {
                node.getChildren().put(c, new TrieNode());
            }
            node = node.getChildren().get(c);
        }
        node.setIsWord(true);
    }

    public boolean search(String word) {
        return this.dfs(this.root, 0, word);
    }

    private boolean dfs(TrieNode node, int index, String word) {
        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode child : node.getChildren().values()) {
                    if(this.dfs(child, i + 1, word) == true) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if(!node.getChildren().containsKey(c)) {
                    return false;
                }
                node = node.getChildren().get(c);
            }
        }
        return node.getIsWord();
    }
}
