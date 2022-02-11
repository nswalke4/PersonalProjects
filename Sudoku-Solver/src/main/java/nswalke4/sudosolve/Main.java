package nswalke4.sudosolve;

/**
 * The main class of the Sudoku Solver Java Command Line program.
 * Included in this class are the necessary components to connect the
 * Solver class and the Puzzle Importer class to allow the user to be
 * able to solve the Sudoku puzzle that they input (either in the 
 * command line or by adjusting the import file).
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.03
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Sudoku Solver!");
        
        boolean testSolver = true;
        boolean testParser = true;

        if (testSolver) {
            System.out.println("\nTesting the solver algorithm...");
            Solver solve = new Solver();
            solve.printPuzzle();
            solve.solvePuzzle();
            solve.printPuzzle();
            System.out.println("This concludes the testing of the solver algorithm.");
        }

        if (testParser) {
            System.out.println("\nTesting the parser...");
            FileParser parser = new FileParser();
            Solver solveParsed = new Solver(parser.getParsedBoard());
            solveParsed.printPuzzle();
            solveParsed.solvePuzzle();
            solveParsed.printPuzzle();
            System.out.println("This concludes the testing of the parser.");
        }

        System.out.println("Exiting...");
    }
}