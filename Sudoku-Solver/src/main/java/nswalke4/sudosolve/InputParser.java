package nswalke4.sudosolve;

import java.util.Scanner;

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
     * The constructor for the InputParser that takes instantiates the parsedBoard array before
     * executing the parsing method.
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
