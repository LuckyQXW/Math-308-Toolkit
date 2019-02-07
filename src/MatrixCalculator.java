/**
 * This class contains methods that could do basic matrix operations
 * @author Wen Qiu
 *
 */
public class MatrixCalculator {
	/**
	 * Adds two given matrices and prints the result
	 * @param a The first matrix
	 * @param b The second matrix
	 */
	public static void addMatrices(int[][] a, int[][] b) {
		checkDimensions(a, b);
		int[][] c = new int[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		System.out.println("a + b = ");
		printResult(c);
	}
	
	/**
	 * Subtracts the second matrix from the first matrix and prints the result
	 * @param a The first matrix
	 * @param b The second matrix
	 */
	public static void subtractMatrices(int[][] a, int[][] b) {
		checkDimensions(a, b);
		checkDimensions(a, b);
		int[][] c = new int[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		System.out.println("a - b = ");
		printResult(c);
	}
	
	/**
	 * Prints the given matrix, with each row on a new line and elements in the row
	 * separated by a tab
	 * @param c The matrix that needs to be printed
	 */
	private static void printResult(int[][] c) {
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Check if the given two matrices are nonempty and have the same dimension, 
	 * throws IllegalArgumentException otherwise
	 * @param a The first matrix
	 * @param b The second matrix
	 */
	private static void checkDimensions(int[][] a, int[][] b) {
		if(a.length == 0 || b.length == 0) {
			throw new IllegalArgumentException("The matrices can't be empty");
		} else if( a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("The two matrices must have the same dimension");
		}
	}
}
