class Solution {
    static int[] xTraversal = {-1, 0, 1, 0};
    static int[] yTraversal = {0, -1, 0, 1};
    public boolean solve(int i, int j, int idx, String word, char[][]board ){
        if(idx == word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '#') return false;
        if(board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        for(int p =0; p<4; p++){
            if (solve(xTraversal[p]+i, yTraversal[p]+j, idx+1, word, board)) return true;
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){

                    if(solve(i, j, 0, word, board)) return true;
                }
            }
        }
        return false;
        
    }
}