package nswalke4.sudosolve;

import java.util.Scanner;

/**
 * The InputParser class is used to parse the user's input to gather the Sudoku
 * board that they wish to be solved.  Any of the information related to collecting
 * user input in order to create a Sudoku board is handled in this class, including
 * the presentation of instructions, as well as the collection and verification of
 * the puzzle the user wishes to have solved.  This class implements the PuzzleParser
 * interface to be able to present the collected puzzle board.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class InputParser implements PuzzleParser {

    /////////////////////////////////////////////////////////////////////////////////////
    //// Class Variables

    /** The instructions for users on how to 'input' their puzzle to be parsed correctly. */
    private String instructions = "----------------------------------------------------------\n First off, we need to discuss some \"rules\". The importing\nwill occur row-by-row, with an entire row being brought in\nat one time. An entire row should be input before pressing\nthe 'enter' key. Inside each row, you may separate out the\nnumbers by either spaces or commas. All of our values that\nare unknown should be represented by a 0. Pressing 'enter'\n (or 'return') will 'parse' that row and inform you of any\n   issues. If you see the '>>', you will know that the\n previous row has been accepted and you can input the next\n row. If the previous row was unsuccessful for any reason,\n  the program will inform you, and you will have to input\n   that row again. After all 9 rows have been input, the\n   puzzle will be presented to you to ensure that it is\n   correct. At that point, you will have the ability to\n     choose an incorrect cell and adjust it directly.\n----------------------------------------------------------";

    /** The scanner used to collect the user input. */
    private Scanner scan;

    /** The two dimensional integer array representation of the Sudoku board collected from the user's input. */
    private int[][] parsedBoard;

    /////////////////////////////////////////////////////////////////////////////////////
    //// Constructors

    /**
     * Basic constructor for the InputParser class that uses the "System.in" as the Scanner,
     * and then using the other constructor call to instantiate the object.
     */
    public InputParser() {
        this(new Scanner(System.in));
    }

    /**
     * The constructor for the InputParser that takes instantiates the parsedBoard array 
     * before executing the parsing method, using the given scanner as a way to collect
     * the user's input.
     * 
     * @param pScan the scanner being used to collect the user input
     */
    public InputParser(Scanner pScan) {
        this.scan = pScan;
        this.parsedBoard = new int[9][9];
        this.executeParsing();
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //// Supporting Methods (private)

    /**
     * Collects data from the user to add to the given row.  This method also checks that
     * the users passes valid data to be parsed, and will continue to loop until the user
     * presents valid data.
     */
    private void collectRow(int row) {
        System.out.println("\nPlease input the data for row " + (i+1));
        System.out.print(">>");
        String input = this.scan.nextLine();
        // need to add the row into the parsedBoard
    }

    /**
     * This method executes the parsing algorithm used to collect the user input in order
     * to create a 2d array representation of the Sudoku Puzzle that the user wishes to
     * solve.  This algorithm collects each line one at a time and then allows the user 
     * to check the parsed puzzle and make any modifications to any rows before finalizing
     * the parsed puzzle.
     */
    private void executeParsing() {
        System.out.println(instructions);
        for (int i=0; i < 9; i++) {
            this.collectRow(i);
        }
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("  Okay, now that all rows have been input, its time to review.");
        System.out.println("You will have the opportunity to fix any cell that is incorrect.");
        System.out.println("----------------------------------------------------------------");
        this.review();
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Excellent!  Your puzzle has been successfully parsed.");
        System.out.println("-----------------------------------------------------");
        
    }

    /**
     * Presents the current parsed board with each row labeled to help the user select
     * a row that might have incorrect data.
     */
    private void presentCurrentBoard() {
        for (int i=0; i < 9; i++) {
            if (i%3 == 0) {
                System.out.println("");
            }
            System.out.print("Row " + (i+1) + ": ");
            for (int j=0; j < 9; j++) {
                if (j%3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(this.parsedBoard[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * This method will continually loop, allowing the user to modify any row that might
     * have invalid data.  If the user detect's a row that has invalid data, this method
     * allows the user to select that row and be able to update that row in the system
     */
    private void review() {
        boolean boardInvalid = true;
        while (boardInvalid) {
            this.presentCurrentBoard();
            boolean invalidInput = true;
            while (invalidInput) {
                System.out.println("Enter the number of the row that needs to be corrected.");
                System.out.println("Enter '0' if all rows are correct.");
                System.out.print(">>");
                String input = this.scan.nextLine();
                switch (input) {
                    case "0":
                        invalidInput = false;
                        boardInvalid = false;
                        System.out.println("  ~~ User: [ALL ROWS ARE CORRECT]");
                        break;
                    case "1":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 1]");
                        this.collectRow(0);
                        break;
                    case "2":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 2]");
                        this.collectRow(1);
                        break;
                    case "3":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 3]");
                        this.collectRow(2);
                        break;
                    case "4":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 4]");
                        this.collectRow(3);
                        break;
                    case "5":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 5]");
                        this.collectRow(4);
                        break;
                    case "6":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 6]");
                        this.collectRow(5);
                        break;
                    case "7":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 7]");
                        this.collectRow(6);
                        break;
                    case "8":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 8]");
                        this.collectRow(7);
                        break;
                    case "9":
                        invalidInput = false;
                        System.out.println("  ~~ User: [UPDATE ROW 9]");
                        this.collectRow(8);
                        break;
                    default:
                        System.out.println("\nInvalid user input!");
                        break;
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //// Interface Implementation Method Override

    /**
     * Get's the two dimensional integer array representation of the Sudoku
     * puzzle that was parsed from the user's input.
     * 
     * @return the two dimensional integer array parsed from the user input
     */
    @Override
    public int[][] getParsedBoard() {
        return this.parsedBoard;
    }
    
}
