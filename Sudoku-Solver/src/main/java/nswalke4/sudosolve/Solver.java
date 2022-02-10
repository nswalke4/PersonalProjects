package nswalke4.sudosolve;

/**
 * The Solver class contains all of the necessary functionality to solve a Sudoku puzzle.
 * The methods contained in this class are mostly supporting methods, with only the 
 * solvePuzzle() and printPuzzle() methods available outside of this class.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public class Solver {
    
    /////////////////////////////////////////////////////////////////////////////////////
    //// Class Variables

    /** The Sudoku board represented as a 2 dimensional integer array of valuse 0-9. */
    private int[][] board;

    /** The basic size of a Sudoku puzzle is 9x9, with numbers 1-9 avaliable for use. */
    private final int SIZE = 9;

    /** The "test" case Sudoku puzzle to be used when no board is given. */
    private final int[][] TEST_BOARD = {
        {8,0,0,9,3,0,0,0,2},
        {0,0,9,0,0,0,0,4,0},
        {7,0,2,1,0,0,9,6,0},
        {2,0,0,0,0,0,0,9,0},
        {0,6,0,0,0,0,0,7,0},
        {0,7,0,0,0,6,0,0,5},
        {0,2,7,0,0,8,4,0,6},
        {0,3,0,0,0,0,5,0,0},
        {5,0,0,0,6,2,0,0,8}
    };


    /////////////////////////////////////////////////////////////////////////////////////
    //// Constructors

    /**
     * Basic constructor of the solver class that uses a "test" puzzle as the board.
     */
    public Solver() {
        this.setBoard(TEST_BOARD);
    }

    /**
     * Constructor of the solver class that accepts a 2 dimensional integer array as
     * a parameter to initalize the Sudoku board to.
     * 
     * @param pBoard the Sudoku board to set the solver's board to
     */
    public Solver(int[][] pBoard) {
        this.setBoard(pBoard);
    }


    /////////////////////////////////////////////////////////////////////////////////////
    //// Getters/Setters
    
    /**
     * Set's the board to the given parameter.
     * 
     * @param pBoard the board to set the solver's board to
     */
    private void setBoard(int[][] pBoard) {
        this.board = pBoard;
    }

    /**
     * Set's the board's value at the given location to the given value.
     * 
     * @param val the value to set
     * @param row the row to set the value at
     * @param col the column to set the value at
     */
    private void setBoardValue(int val, int row, int col) {
        this.board[row][col] = val;
    }

    /**
     * Get's the value of the board at the given location.
     * 
     * @param row the row to get the value from
     * @param col the column to get the value from
     * @return the value at the given location
     */
    private int getBoardValue(int row, int col) {
        return this.board[row][col];
    }


    /////////////////////////////////////////////////////////////////////////////////////
    //// Private Methods (Supporting Methods)

    /**
     * Checks the given column in the given Sudoku board to see if the
     * given value is used.
     * 
     * @param val the value to check to see if it has been used in the column
     * @param col the column to check to see if the value is used in it
     * @return (T or F) the given value is contained in the given column on
     *         the given Sudoku board
     */
    private boolean isInCol(int val, int col) {
        for (int i=0; i < SIZE; i++) {
            if (getBoardValue(i, col) == val) {
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
     * @return (T or F) the given value is contained in the given row on
     *         the given Sudoku board
     */
    private boolean isInRow(int val, int row) {
        for (int i=0; i < SIZE; i++) {
            if (getBoardValue(row, i) == val) {
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
     * @return (T or F) the given value is contained in inner box determined by
     *         the given row/column on the given Sudoku board.
     */
    private boolean isInSquare(int val, int row, int col) {
        int boxStartRow = calculateBoxStartValue(row);
        int boxStartCol = calculateBoxStartValue(col);
        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                if (getBoardValue(i + boxStartRow, j + boxStartCol) == val) {
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
     * 
     * @param originalVal the value to find the box start from
     * @return the upper value that will represent the "box start" value
     */
    private int calculateBoxStartValue(int originalVal) {
        return (originalVal - (originalVal % 3));
    }
    
    /**
     * Checks all of the different stages to see if the given value is allowed
     * to be there (by checking that the value is not in the row, column, or 
     * inner square it is being put into).
     * 
     * @param val the value being checked if it is in a valid location
     * @param row the row that the value is being placed into
     * @param col the column that the value is being placed into
     * @return (T or F) the given value can be placed into the given row/column
     *         on the given Sudoku board without breaking any of the Sudoku rules
     */
    private boolean isValidMove(int val, int row, int col) {
        return (!isInCol(val, col) && !isInRow(val, row) && !isInSquare(val, row, col));
    }


    /////////////////////////////////////////////////////////////////////////////////////
    //// Public Methods (Solve and Print)

    /**
     * A recursive method that checks each row and column to attempt to replace
     * any 0 it finds with a correct value.  This will go from the top left corner
     * of the puzzle, across the row, and then down to the next row to find the
     * values it needs to replace.  When it arrives at a zero, it will then begin
     * with 1 and loop through the values to see if any of the numbers from 1 to 9
     * can fit in the current location.  Once it finds a value that can fit in that
     * location, it changes the board to that value and then recursively calls itself
     * to see if the puzzle can be solved with that value.  If there are no values
     * that can fit in that location, it will return false, signaling that the puzzle
     * cannot be completed with the current values.  This will then cause its calling
     * method to set the current location back to 0 and move on to attempt to find a
     * different value that will fit in that location to solve the puzzle.  This will
     * recursively call until all of the values are either valid, or the puzzle is
     * considered unsolvable.
     * 
     * @return (T or F) the Sudoku puzzle can be solved in this given state
     */
    public boolean solvePuzzle() {
        for (int i=0; i < SIZE; i++) {
            for (int j=0; j < SIZE; j++) {
                if (getBoardValue(i, j) == 0) {
                    for (int k=1; k <= SIZE; k++) {
                        if (isValidMove(k, i, j)) {
                            setBoardValue(k, i, j);
                            if (solvePuzzle()) {
                                return true;
                            }
                            else {
                                setBoardValue(0, i, j);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Prints out the puzzle in a nice, readable format in the command line by
     * setting the unknown values to "x" and adding in lines to separate out
     * the sets of 3 rows/columns.
     * 
     * @param board the Sudoku board to print to the command line
     */
    public void printPuzzle() {
        System.out.println("");
        for (int i=0; i < SIZE; i++) {
            if ((i != 0) && (i % 3 == 0)) {
                System.out.println("-----------");
            }
            for (int j=0; j < SIZE; j++) {
                if ((j != 0) && (j % 3 == 0)) {
                    System.out.print("|");
                }
                if (getBoardValue(i, j) == 0) {
                    System.out.print("x");
                } else {
                    System.out.print(getBoardValue(i, j));
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
}

