class TrieNode {

    public HashMap<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

class Solution {
    
    private List<String> foundWords = new ArrayList<>();
    private int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        rows = board.length;
        cols = board[0].length;

        for(String word : words) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                dfs(row, col, root, "", board);
            }
        }

        return foundWords; 
    }

    private void dfs(int row, int col, TrieNode node, String path, char[][] board) {
        if(row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] == '#') {return;}
        char c = board[row][col];
        if(!node.children.containsKey(c)) {return;}

        node = node.children.get(c);
        path += c;

        if(node.isWord == true) {
            foundWords.add(path);
            node.isWord = false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        dfs(row+1, col, node, path, board);
        dfs(row-1, col, node, path, board);
        dfs(row, col+1, node, path, board);
        dfs(row, col-1, node, path, board);

        board[row][col] = temp;
    }
}