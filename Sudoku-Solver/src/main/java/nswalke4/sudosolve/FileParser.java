package nswalke4.sudosolve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The FileParser class is used to parse the file to gather the Sudoku board
 * from the file.  Although this class does allow the user to choose the file
 * they wish to import, the file that is being imported must match the style
 * of the original in order to be properly parsed.  More information about the
 * accepted format of the import files can be found in the parseFile method
 * or in the README included in this project.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class FileParser {

    /////////////////////////////////////////////////////////////////////////////////////
    //// Class Variables

    /** The String of the file that will be imported and parsed to gather the Sudoku board. */
    private final String fileName;

    /** The two dimensional integer array representation of the Sudoku board from the file. */
    private int[][] parsedBoard;

    /////////////////////////////////////////////////////////////////////////////////////
    //// Constructors

    /**
     * The basic constructor call, which utilizes the given "SudokuInput.txt" file
     * as the file input for the parser to utilize.
     */
    public FileParser() {
        this("SudokuInput.txt");
    }

    /**
     * The constructor for the FileParser that takes in the file name as a parameter
     * before instantiating the parsedBoard array and running the parseFile method.
     * 
     * @param pFileName the name of the file that will be parsed
     */
    public FileParser(String pFileName) {
        this.fileName = pFileName;
        this.parsedBoard = new int[9][9];
        this.parseFile();
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //// Getters / Setters

    /**
     * Set's the given cell of the parsedBoard two dimensional array to the
     * given value.
     * 
     * @param row the row of the parsedBoard to set the value to
     * @param col the column of the parsedBoard to set the value to
     * @param val the value to set
     */
    private void setCell(int row, int col, int val) {
        this.parsedBoard[row][col] = val;
    }
    
    private void setNullBoard() {
        this.parsedBoard = null;
    }

    /**
     * Get's the two dimensional integer array representation of the Sudoku
     * puzzle that was parsed from the "SudokuInput.txt" file.
     * 
     * @return the two dimensional integer array parsed from the file
     */
    public int[][] getParsedBoard() {
        return this.parsedBoard;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //// Supporting Methods (private)

    /**
     * Parses the file and creates the parsedBoard two dimensional integer
     * array that will be used by the Solver class to solve the Sudoku puzzle.
     * NOTE: This parsing algorithm looks for specific items in order to
     *       properly parse the file.  Specifically, all of the lines that
     *       include the Sudoku puzzle must begin with a "|" character.
     *       Also, the unknown values must be represented either with a 0 or
     *       an 'x'.  Assuming that the file follows those conventions for each
     *       row in the Sudoku puzzle, any file should be able to be imported.
     *       EXAMPLES OF ROWs THAT CAN BE PARSED:
     *              "|8,0,9|0,0,3|1,2,0|" / "|8x9xx312x"
     */
    private void parseFile() {
        BufferedReader reader;
        int row = 0;
        File test = new File(fileName);
        if (test.exists()) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
                String line = reader.readLine();
                while (line != null) {
                    if ((!line.isEmpty()) && (line.charAt(0) == '|')) {
                        this.parseString(line, row);
                        row++;
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException ioex) {
                System.out.println("[ERROR] Something went wrong with the file reader...");
                ioex.printStackTrace();
            }
        } else {
            this.setNullBoard();
        }
    }

    /**
     * Parses the string into a character array to determine the values that
     * need to be added to the parsedBoard variable by determining if the
     * character is a number (or an 'x'), which then adds the values into the
     * given row of the parsedBoard.
     * 
     * @param line the string that will be parsed to gather the numbers from
     * @param row the row of the parsedBoard to add the data to
     */
    private void parseString(String line, int row) {
        char[] chars = line.toCharArray();
        int col = 0;
        for (int i=0; i < chars.length; i++) {
            try {
                int val = Integer.parseInt(Character.toString(chars[i]));
                this.setCell(row, col, val);
                col++;
            } catch (NumberFormatException nfe) {
                if (chars[i] == 'x') {
                    this.setCell(row, col, 0);
                    col++;
                }
            }
        }
    }
}
