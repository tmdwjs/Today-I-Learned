// https://school.programmers.co.kr/learn/courses/30/lessons/120866

class Solution {
    public int solution(int[][] board) {
        // 새로운 2차원 배열 생성
        int[][] bombBoard = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) { // 반복문 돌다 지뢰를 발견하면,
                    danger(i, j, bombBoard); // 현재 인덱스와 2차원 배열을 
                }
            }
        }
        
        int count = 0;
        
        for (int[] bombs: bombBoard) {
            for (int bomb: bombs) {
                if (bomb == 0) {
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    public void danger(int x, int y, int[][] bombBoard) {
        int bombX = 0;
        int bombY = 0;
        int[] aroundX = {0, -1, -1, -1,  0, 0,  1, 1, 1}; 
        int[] aroundY = {0, -1,  0,  1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 9; i++) {
            bombX = x + aroundX[i];
            bombY = y + aroundY[i];
            
            if (bombX < bombBoard.length && bombX >= 0 && bombY >= 0 && bombY < bombBoard.length) {
                bombBoard[bombX][bombY] = 1;
            }
        }
    }
}