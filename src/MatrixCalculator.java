/**
 * This class contains methods that could do basic matrix operations
 * @author Wen Qiu
 */
public class MatrixCalculator {
	/**
	 * Adds two given matrices and prints the result, the two matrices must have the 
	 * same dimension, throws IllegalArgumentException otherwise
	 * @param a The first matrix
	 * @param b The second matrix
	 * @return The resulting matrix from a + b
	 */
	public static int[][] addMatrices(int[][] a, int[][] b) {
		checkEqualDimensions(a, b);
		int[][] c = new int[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		System.out.println("a + b = ");
		printMatrix(c);
		return c;
	}
	
	/**
	 * Adds two given matrices and prints the result, the two matrices must have the 
	 * same dimension, throws IllegalArgumentException otherwise
	 * @param aMatrix The first matrix
	 * @param bMatrix The second matrix
	 * @return The resulting matrix from a + b
	 */
	public static int[][] addMatrices(Matrix aMatrix, Matrix bMatrix) {
		int[][] a = aMatrix.getContent();
		int[][] b = bMatrix.getContent();

		return addMatrices(a, b);
	}
	
	/**
	 * Subtracts the second matrix from the first matrix and prints the result, 
	 * the two matrices must have the same dimension, throws IllegalArgumentException
	 * otherwise
	 * @param a The first matrix
	 * @param b The second matrix
	 * @return The resulting matrix from a - b
	 */
	public static int[][] subtractMatrices(int[][] a, int[][] b) {
		checkEqualDimensions(a, b);
		int[][] c = new int[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		System.out.println("a - b = ");
		printMatrix(c);
		return c;
	}
	
	/**
	 * Subtracts the second matrix from the first matrix and prints the result, 
	 * the two matrices must have the same dimension, throws IllegalArgumentException
	 * otherwise
	 * @param aMatrix The first matrix
	 * @param bMatrix The second matrix
	 * @return The resulting matrix from a - b
	 */
	public static int[][] subtractMatrices(Matrix aMatrix, Matrix bMatrix) {
		int[][] a = aMatrix.getContent();
		int[][] b = bMatrix.getContent();
		return subtractMatrices(a, b);
	}
	
	/**
	 * Perform the operation a * b, where a must have the same number of columns
	 * as the number of rows in b, throws IllegalArgumentException otherwise
	 * @param a The first matrix (m x k)
	 * @param b The second matrix (k x n)
	 * @return The resulting matrix from a * b
	 */
	public static int[][] multiplyMatrices(int[][] a, int[][] b) {
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
		printMatrix(c);
		return c;
	}
	
	/**
	 * Perform the operation a * b, where a must have the same number of columns
	 * as the number of rows in b, throws IllegalArgumentException otherwise
	 * @param aMatrix The first matrix (m x k)
	 * @param bMatrix The second matrix (k x n)
	 * @return The resulting matrix from a * b
	 */
	public static int[][] multiplyMatrices(Matrix aMatrix, Matrix bMatrix) {
		int[][] a = aMatrix.getContent();
		int[][] b = bMatrix.getContent();
		return multiplyMatrices(a, b);
	}
	
	/**
	 * Calculates the determinant of a matrix
	 * @param a A square matrix
	 * @return the determinant of the given matrix
	 */
	public static int getDeterminant(int[][] a) {
		checkSquareMatrix(a);
		return getCofactorSum(a);
	}
	
	/**
	 * Calculates the determinant of a matrix
	 * @param a A square matrix
	 * @return the determinant of the given matrix
	 */
	public static int getDeterminant(Matrix a) {
		return getDeterminant(a.getContent());
	}
	
	/**
	 * Calculates the determinant of the given matrix recursively
	 * @param a A square matrix, could be the original matrix or a minor of it
	 * @return The determinant of the given matrix
	 */
	public static int getCofactorSum(int[][] a) {
		if(a.length == 2) {
			return a[0][0] * a[1][1] - a[0][1] * a[1][0];
		} else {
			int cofactorSum = 0;
			for(int i = 0; i < a[0].length; i++) {
				int cofactor = (int)Math.pow(-1, i) * a[0][i] * getCofactorSum(getMinor(a, 0, i));
				// System.out.println(cofactor);
				cofactorSum += cofactor;
				
			}
			return cofactorSum;
		}
	}
	
	/**
	 * Returns the minor of the given matrix after removing the given row 
	 * and columns from it
	 * @param a A square matrix
	 * @param row The row to be removed from the matrix
	 * @param col The column to be removed from the matrix
	 * @return The corresponding minor of the given matrix
	 */
	private static int[][] getMinor(int[][] a, int row, int col) {
		int[][] minor = new int[a.length - 1][a[0].length - 1];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(i < row && j < col) {
					minor[i][j] = a[i][j];
				} else if(i > row && j < col) {
					minor[i-1][j] = a[i][j];
				} else if(i < row && j > col) {
					minor[i][j-1] = a[i][j];
				} else if(i > row && j > col){
					minor[i-1][j-1] = a[i][j];
				}
			}
		}
		// printMatrix(minor);
		return minor;
	}
	
	/**
	 * Swaps two rows in the given matrix
	 * @param a The matrix to swap rows
	 * @param i The first row to be swapped
	 * @param j The second row to be swapped
	 */
	private static void swapRow(int[][] a, int i, int j) {
		for(int k = 0; k < a[i].length; k++) {
			int temp = a[i][k];
			a[i][k] = a[i][j];
			a[i][j] = temp;
		}
	}
	
	/**
	 * Prints the given matrix, with each row on a new line and elements in the row
	 * separated by a tab
	 * @param c The matrix that needs to be printed
	 */
	private static void printMatrix(int[][] c) {
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Returns a String representation of the given matrix, with each row on a new line 
	 * and elements in the row separated by a tab
	 * @param c The matrix that needs to be printed
	 */
	public static String matrixToString(int[][] c) {
		String result = "";
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				result += c[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
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
	
	/**
	 * Check if the given matrix is a square matrix, throws IllegalArgumentException otherwise
	 * @param a A matrix
	 */
	private static void checkSquareMatrix(int[][] a) {
		if(a.length != a[0].length) {
			throw new IllegalArgumentException("The matrix has to have same number of rows and columns");
		}
	}
}
