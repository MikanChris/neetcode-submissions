class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if(row.contains(board[i][j])){
                    return false;
                }
                row.add(board[i][j]);             
            }
        }

        for (int j = 0; j < 9; j++) {
            HashSet<Character> col = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if(col.contains(board[i][j])){
                    return false;
                }
                col.add(board[i][j]);             
            }
        }
         
        for(int rowStart = 0; rowStart < 9; rowStart += 3){
            for(int colStart = 0; colStart < 9; colStart += 3){
                HashSet<Character> squ = new HashSet<>();
                for(int i = rowStart; i < rowStart + 3; i++){
                    for(int j = colStart; j < colStart + 3; j++){
                        if(board[i][j] == '.'){
                            continue;
                        }
                        if(squ.contains(board[i][j])){
                            return false;
                        }
                        squ.add(board[i][j]);
                    }
                }
            }
        }


        return true;      
    }
}
