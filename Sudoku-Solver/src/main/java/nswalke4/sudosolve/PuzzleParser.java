package nswalke4.sudosolve;

/**
 * The PuzzleParser interface allows different styles of parsing to be used
 * with the same goal of creating and presenting a "parsed board".  Classes
 * that implement this interface are required to implement the "getParsedBoard"
 * method, ensuring that the Solver class can collect the 2d int array from
 * any implementation of the PuzzleParser and attempt to solve the "parsed"
 * Sudoku puzzle.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public interface PuzzleParser {
    
    /** Returns the parsedBoard collected by the PuzzleParser's implementation. */
    public int[][] getParsedBoard();
}
