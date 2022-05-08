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
 * @version 1.01
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
     * This method executes the parsing algorithm used to collect the user input in order
     * to create a 2d array representation of the Sudoku Puzzle that the user wishes to
     * solve.  This algorithm collects each line one at a time, allows the user to request
     * to review the instructions at any time, and allows the user to make any modifications
     * to any rows before finalizing their puzzle.
     */
    private void executeParsing() {

        System.out.println(instructions);
        System.out.println("\nOkay, so let's start by having you input the first row:");
        // Need to finish this execution...
        
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
