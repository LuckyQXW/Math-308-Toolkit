import java.util.*;

public class ToolkitTester {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to matrix calculator!");
		int[][] a = matrixBuilder(console, 1);
		int[][] b = matrixBuilder(console, 2);
		System.out.println();
		MatrixCalculator.addMatrices(a, b);
	}
	
	/**
	 * Prompts the user to build a matrix, including giving the dimension and the content
	 * of the matrix, also prints out the final matrix in the end
	 * @param console A scanner object accepting user input from console
	 * @param matrixID Labels which matrix the user is building
	 * @return An 2D int array storing the given matrix
	 */
	public static int[][] matrixBuilder(Scanner console, int matrixID) {
		System.out.println("What is the dimension of your matrix " + matrixID + " ?");
		System.out.print("Row: ");
		int aRow = console.nextInt();
		System.out.print("Col: ");
		int aCol = console.nextInt();
		int[][] a = new int[aRow][aCol];
		for(int i = 0; i < aRow; i++) {
			for(int j = 0; j < aCol; j++) {
				System.out.print("Row " + (i+1) + " Col " + (j+1) + " : ");
				a[i][j] = console.nextInt();
			}
		}
		System.out.println(Arrays.deepToString(a));
		return a;
	}
}