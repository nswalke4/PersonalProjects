package nswalke4.sudosolve;

import java.util.Scanner;

/**
 * The main class of the Sudoku Solver Java Command Line program.
 * Included in this class are the necessary components to connect the
 * Solver class and the Puzzle Importer class to allow the user to be
 * able to solve the Sudoku puzzle that they input (either in the 
 * command line or by adjusting the import file).
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.04
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Sudoku Solver!");
        
        boolean testSolver = false;
        boolean testParser = false;
        Scanner scan = new Scanner(System.in);
        String input;
        FileParser parser;
        Solver solve;

        if (testSolver) {
            System.out.println("\nTesting the solver algorithm...");
            solve = new Solver();
            solve.printPuzzle();
            solve.solvePuzzle();
            solve.printPuzzle();
            System.out.println("This concludes the testing of the solver algorithm.");
        }

        if (testParser) {
            System.out.println("\nTesting the parser...");
            parser = new FileParser();
            solve = new Solver(parser.getParsedBoard());
            solve.printPuzzle();
            solve.solvePuzzle();
            solve.printPuzzle();
            System.out.println("This concludes the testing of the parser.");
        }

        if (!testSolver && !testParser) {
            System.out.println("\nFirst, we need to import the puzzle you would like to be solved.");
            boolean validResponse = false;
            boolean importFromFile = false;
            while (!validResponse) {
                System.out.println("Are you importing the data from a text file? (Y=Yes, N=No)");
                System.out.print(">>");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("Y")) {
                    validResponse = true;
                    importFromFile = true;
                } else if (input.equalsIgnoreCase("N")) {
                    validResponse = true;
                } else {
                    System.out.println("\nSorry, that was not a valid response...");
                }
            }

            if (importFromFile) {
                System.out.println("\nOkay, so we are importing the Sudoku puzzle from a file!");
                validResponse = false;
                boolean givenFile = true;
                while(!validResponse) {
                    System.out.println("Are you using the given file to import your data? (Y=Yes, N=No)");
                    System.out.print(">>");
                    input = scan.nextLine();
                    if (input.equalsIgnoreCase("Y")) {
                        validResponse = true;
                    } else if (input.equalsIgnoreCase("N")) {
                        validResponse = true;
                        givenFile = false;
                    } else {
                        System.out.println("\nSorry, that was not a valid response...");
                    }
                }

                if (!givenFile) {
                    validResponse = false;
                    String fileName = "";
                    while (!validResponse) {
                        System.out.println("Please give the file name that you wish to import:");
                        System.out.println("(Must be a txt file, and include its relative path)");
                        System.out.print(">>");
                        fileName = scan.nextLine();
                        if ((fileName.length() > 4) && (fileName.substring(fileName.length() - 4).equals(".txt"))) {
                            validResponse = true;
                        } else {
                            System.out.println("\nSorry, that was not a valid response...");
                        }
                    }
                    System.out.println("\nGiven file name: " + fileName);
                    // parser = new FileParser(fileName);
                    
                } else {
                    System.out.println("Chosen the original file to be imported");
                    // parser = new FileParser();
                }
                // solve = new Solver(parser.getParsedBoard());

            } else {
                System.out.println("\nOkay, so we are going to do this the hard way it seems... :)\n");
                String instructions = "----------------------------------------------------------\n First off, we need to discuss some \"rules\". The importing\nwill occur row-by-row, with an entire row being brought in\nat one time. An entire row should be input before pressing\nthe 'enter' key. Inside each row, you may separate out the\nnumbers by either spaces or commas. All of our values that\nare unknown should be represented by a 0. Pressing 'enter'\n (or 'return') will 'parse' that row and inform you of any\n   issues. If you see the '>>', you will know that the\n previous row has been accepted and you can input the next\n row. If the previous row was unsuccessful for any reason,\n  the program will inform you, and you will have to input\n   that row again. After all 9 rows have been input, the\n   puzzle will be presented to you to ensure that it is\n   correct. At that point, you will have the ability to\n     choose an incorrect cell and adjust it directly.\n----------------------------------------------------------";
                System.out.println(instructions);
                System.out.println("\nOkay, so let's start by having you input the first row:");
            }
        }

        System.out.print(">>");
        input = scan.nextLine();
        System.out.println("Exiting...");
    }
}