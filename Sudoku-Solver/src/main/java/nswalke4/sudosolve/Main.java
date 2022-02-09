package nswalke4.sudosolve;

public class Main {

    private static final int SIZE = 9;

    /**
     * Checks the given column in the given Sudoku board to see if the
     * given value is used.
     * 
     * @param val the value to check to see if it has been used in the column
     * @param col the column to check to see if the value is used in it
     * @param board the Sudoku board
     * @return (T or F) the given value is contained in the given column on
     *         the given Sudoku board
     */
    private static boolean isInCol(int val, int col, int[][] board) {
        for (int i=0; i < SIZE; i++) {
            if (board[i][col] == val) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the given row in the given Sudoku board to see if the
     * given value is used.
     * 
     * @param val the value to check to see if it has been used in the row
     * @param col the row to check to see if the value is used in it
     * @param board the Sudoku board
     * @return (T or F) the given value is contained in the given row on
     *         the given Sudoku board
     */
    private static boolean isInRow(int val, int row, int[][] board) {
        for (int i=0; i < SIZE; i++) {
            if (board[row][i] == val) {
                return true;
            }
        }
        return false;
    }

    /**
     * Takes the given row/column and calculates the "box start" (upper left
     * corner of a 3x3 box in the overall 9x9 Sudoku grid) values, and then
     * iterates through the inner box to see if the given value is used.
     * 
     * @param val the value to check to see if it has been used in the inner box
     * @param row the row that will be used to find the inner box start
     * @param col the column that will be used to find the inner box start
     * @param board the Sudoku board
     * @return (T or F) the given value is contained in inner box determined by
     *         the given row/column on the given Sudoku board.
     */
    private static boolean isInSquare(int val, int row, int col, int[][] board) {
        int boxStartRow = calculateBoxStartValue(row);
        int boxStartCol = calculateBoxStartValue(col);
        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                if (board[i+boxStartRow][j+boxStartCol] == val) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Takes the given value and subtracts it from its remainder after being
     * divided by 3.  This is uses to find the "inner box start" of a Sudoku
     * grid.
     */
    private static int calculateBoxStartValue(int originalVal) {
        return (originalVal - (originalVal % 3));
    }

    private static boolean isValidMove(int val, int row, int col, int[][] board) {
        return (!isInCol(val, col, board) && !isInRow(val, row, board) 
                && !isInSquare(val, row, col, board));
    }

    private static int[][] solvePuzzle(int[][] board) {
        for (int i=0; i < SIZE; i++) {
            for (int j=0; j < SIZE; j++) {
                for (int k=1; k <= SIZE; k++) {
                    if (board[i][j] == 0) {

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Sudoku Solver!");

    }
}