import java.util.Arrays;

/**
 * This class stores information in a matrix
 * @author Wen Qiu
 *
 */
public class Matrix {
	private int rows;
	private int cols;
	private int[][] content;

	/**
	 * Constructs a matrix using the given row, column, and content
	 * @param content A 2D array storing values in a matrix
	 */
	public Matrix(int r, int c, int[][] content) {
		checkMatrixInfo(r, c, content);
		rows = r;
		cols = c;
		this.content = content;
	}
	
	/**
	 * Checks if the given matrix info agrees with each other, throw IllegalArgumentException
	 * otherwise
	 * @param r The number of rows in the matrix
	 * @param c The number of columns in the matrix
	 * @param content The content of the matrix
	 */
	private static void checkMatrixInfo(int r, int c, int[][] content) {
		if(content != null && (content.length != r || content[0].length != c)) {
			throw new IllegalArgumentException("The information provided must match!");
		}
	}
	
	/**
	 * Gets the content of the matrix
	 * @return A 2D array storing the values in the matrix
	 */
	public int[][] getContent() {
		return content;
	}
	
	/**
	 * Gets the number of rows in the matrix
	 * @return rows
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Gets the number of columns in the matrix
	 * @return cols
	 */
	public int getColumns() {
		return cols;
	}
	
	/**
	 * Returns a string representation of the matrix
	 */
	public String toString() {
		String result = "Rows: " + rows + "\tCols: " + cols;
		if(content != null) {
			result += "\t" + Arrays.deepToString(content);
		}
		return result;
	}
}