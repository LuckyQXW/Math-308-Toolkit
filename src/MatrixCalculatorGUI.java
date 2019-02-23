import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Constructs the GUI for a matrix calculator that can do addition, subtraction, and 
 * multiplication. More function to be added... But the Java GUI framework is not the
 * most pleasant thing to work with. 
 * @author Wen Qiu
 *
 */
public class MatrixCalculatorGUI {
	public static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Matrix Calculator");
		
		// General anchors for configuring layout
		int leftColX = 20;
		int rightColX = 300;

		// GUI for setting dimensions of the matrix
		JLabel dimensionInstruction = new JLabel("Set matrix dimensions: ");
		dimensionInstruction.setBounds(leftColX, 20, 500, 20);
		f.add(dimensionInstruction);

		// Set dimensions of A
		JLabel aLabel = new JLabel("A: ");
		JTextField aRows = new JTextField();
		JTextField aCols = new JTextField();
		aLabel.setBounds(leftColX, 40, 20, 20);
		aRows.setBounds(leftColX + 20, 40, 40, 20);
		aCols.setBounds(leftColX + 80, 40, 40, 20);
		f.add(aLabel);
		f.add(aRows);
		f.add(aCols);

		// Set dimensions of B
		JLabel bLabel = new JLabel("B: ");
		JTextField bRows = new JTextField();
		JTextField bCols = new JTextField();
		bLabel.setBounds(leftColX, 70, 20, 20);
		bRows.setBounds(leftColX + 20, 70, 40, 20);
		bCols.setBounds(leftColX + 80, 70, 40, 20);
		f.add(bLabel);
		f.add(bRows);
		f.add(bCols);

		// Choose operation options
		JLabel optionLabel = new JLabel("Select operation: ");
		optionLabel.setBounds(rightColX, 20, 200, 20);
		f.add(optionLabel);
		JRadioButton addOption = new JRadioButton("A + B");
		addOption.setBounds(rightColX, 40, 80, 20);
		f.add(addOption);
		JRadioButton subtractOption = new JRadioButton("A - B");
		subtractOption.setBounds(rightColX, 60, 80, 20);
		f.add(subtractOption);
		JRadioButton multiplyOption = new JRadioButton("A * B");
		multiplyOption.setBounds(rightColX, 80, 80, 20);
		f.add(multiplyOption);
		JRadioButton determinantOption = new JRadioButton("det(A)");
		determinantOption.setBounds(rightColX + 80, 40, 80, 20);
		f.add(determinantOption);
		
		ButtonGroup options = new ButtonGroup();
		options.add(addOption);
		options.add(subtractOption);
		options.add(multiplyOption);
		options.add(determinantOption);

		/* Set contents for the matrices. Currently each matrix is given a max size
		 * to begin with, since changing the layout in runtime requires a lot of work
		 * (refer to GroupLayout, where the layout needs to be specified from both 
		 * horizontal and vertical direction, very complicated to sort out the groups)
		 */
		// Set contents of A
		JLabel aLabel2 = new JLabel("A");
		aLabel2.setBounds(leftColX + 80, 100, 20, 20);
		f.add(aLabel2);
		JTextField[][] aEntries = new JTextField[MAX_SIZE][MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			for (int j = 0; j < MAX_SIZE; j++) {
				JTextField entry = new JTextField();
				entry.setBounds(leftColX + j * 35, 120 + i * 30, 30, 20);
				aEntries[i][j] = entry;
				f.add(entry);
			}
		}

		// Set contents of B
		JLabel bLabel2 = new JLabel("B");
		bLabel2.setBounds(rightColX + 80, 100, 20, 20);
		f.add(bLabel2);
		JTextField[][] bEntries = new JTextField[MAX_SIZE][MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			for (int j = 0; j < MAX_SIZE; j++) {
				JTextField entry = new JTextField();
				entry.setBounds(rightColX + j * 35, 120 + i * 30, 30, 20);
				bEntries[i][j] = entry;
				f.add(entry);
			}
		}

		// Display the answer
		JLabel answerLabel = new JLabel("Answer: ");
		answerLabel.setBounds(20, 310, 80, 20);
		f.add(answerLabel);
		JTextArea answerContent = new JTextArea();
		answerContent.setBounds(20, 330, 440, 100);
		answerContent.setEditable(false);
		f.add(answerContent);
		
		// The confirm button that does the operation, also check for invalid entries and display
		// an error message if some exception occurs
		JButton confirmMatrixButton = new JButton("Confirm");
		confirmMatrixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Get the row and col info from the dimension setting
					int ar = Integer.parseInt(aRows.getText());
					int ac = Integer.parseInt(aCols.getText());
					int br = Integer.parseInt(bRows.getText());
					int bc = Integer.parseInt(bCols.getText());
					
					// Get content info from the textfields and construct matrix a and b
					int[][] aContent = new int[ar][ac];
					for (int i = 0; i < ar; i++) {
						for (int j = 0; j < ac; j++) {
							aContent[i][j] = Integer.parseInt(aEntries[i][j].getText());
						}
					}
					Matrix a = new Matrix(ar, ac, aContent);

					int[][] bContent = new int[br][bc];
					for (int i = 0; i < br; i++) {
						for (int j = 0; j < bc; j++) {
							bContent[i][j] = Integer.parseInt(bEntries[i][j].getText());
						}
					}
					Matrix b = new Matrix(br, bc, bContent);

					// Use functions in MatrixCalculator to do the chosen operation
					int[][] result = new int[0][0];
					if (addOption.isSelected()) {
						result = MatrixCalculator.addMatrices(a, b);
					} else if (subtractOption.isSelected()) {
						result = MatrixCalculator.subtractMatrices(a, b);
					} else if (multiplyOption.isSelected()) {
						result = MatrixCalculator.multiplyMatrices(a, b);
					}
					
					// Display the answer
					if(!determinantOption.isSelected()) {
						answerContent.setText(MatrixCalculator.matrixToString(result));
					} else {
						answerContent.setText("" + MatrixCalculator.getDeterminant(a));
					}
				} catch (Exception exception) {
					answerContent.setText("Invalid entries detected\n" + 
							"Double check if dimensions and corresponding entries are specified\n" +
							"Also make sure the dimensions are valid for the chosen operation");
				}
			}
		});
		confirmMatrixButton.setBounds(210, 280, 80, 20);
		f.add(confirmMatrixButton);

		// General configuration of the frame
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
