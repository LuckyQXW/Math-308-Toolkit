/**
 * This class contains methods that could do basic matrix operations
 * @author Wen Qiu
 *
 */
public class MatrixCalculator {
	/**
	 * Adds two given matrices and prints the result, the two matrices must have the 
	 * same dimension, throws IllegalArgumentException otherwise
	 * @param a The first matrix
	 * @param b The second matrix
	 */
	public static void addMatrices(int[][] a, int[][] b) {
		checkEqualDimensions(a, b);
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
	 * Subtracts the second matrix from the first matrix and prints the result, 
	 * the two matrices must have the same dimension, throws IllegalArgumentException
	 * otherwise
	 * @param a The first matrix
	 * @param b The second matrix
	 */
	public static void subtractMatrices(int[][] a, int[][] b) {
		checkEqualDimensions(a, b);
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
	 * Perform the operation a * b, where a must have the same number of columns
	 * as the number of rows in b, throws IllegalArgumentException otherwise
	 * @param a The first matrix (m x k)
	 * @param b The second matrix (k x n)
	 */
	public static void multiplyMatrices(int[][] a, int[][] b) {
		checkMultiplicationDimensions(a, b);
		int[][] c = new int[a.length][b[0].length];
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				int sum = 0;
				for(int k = 0; k < a[0].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
		System.out.println("a * b = ");
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
	private static void checkEqualDimensions(int[][] a, int[][] b) {
		if(a.length == 0 || b.length == 0) {
			throw new IllegalArgumentException("The matrices can't be empty");
		} else if( a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("The two matrices must have the same dimension");
		}
	}
	
	/**
	 * Check if the given two matrices have valid dimension for matrix multiplication, 
	 * throws IllegalArgumentException otherwise
	 * @param a The first matrix
	 * @param b The second matrix
	 */
	private static void checkMultiplicationDimensions(int[][] a, int[][] b) {
		if(a.length == 0 || b.length == 0) {
			throw new IllegalArgumentException("The matrices can't be empty");
		} else if(a[0].length != b.length) {
			throw new IllegalArgumentException("Invalid dimensions for multiplication");
		}
	}
}
