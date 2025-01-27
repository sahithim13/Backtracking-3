/* Time Complexity : O(m*n*3^l), l is the length if the word string
 * Space Complexity : O(l), for recursive stack space
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    private int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        //null
        if(board == null || board.length == 0) return false;
        m = board.length; 
        n = board[0].length;
        dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i =0; i< m; i++){
            for(int j= 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(backtrack(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int i, int j, String word, int index){
        //base
        if(index == word.length()) return true;
        //check bounds
        if(i < 0 || j <0 || i == m || j == n || board[i][j] == '#') return false;
        //logic
        if(board[i][j] == word.charAt(index)){
            //action
              board[i][j] = '#';
            //recurse
           for(int [] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board, r, c, word, index+1)) return true;
            } 
            //backtrack
              board[i][j] = word.charAt(index);
        }
        return false;
    }
}
