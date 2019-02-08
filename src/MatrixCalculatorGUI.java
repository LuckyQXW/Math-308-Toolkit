import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MatrixCalculatorGUI {
	public static void main(String[] args) {
		JFrame f = new JFrame("Matrix Calculator");
		Matrix aInfo = new Matrix();
		Matrix bInfo = new Matrix();
		
		// GUI for setting dimensions of the matrix
		JLabel dimensionInstruction = new JLabel("Set matrix dimensions: ");
		dimensionInstruction.setBounds(20, 20, 500, 20);
		f.add(dimensionInstruction);

		JLabel aLabel = new JLabel("A: ");
		JTextField aRows = new JTextField();
		JTextField aCols = new JTextField();
		aLabel.setBounds(20, 40, 20, 20);
		aRows.setBounds(40, 40, 40, 20);
		aCols.setBounds(100, 40, 40, 20);
		f.add(aLabel);
		f.add(aRows);
		f.add(aCols);
		
		JLabel bLabel = new JLabel("B: ");
		JTextField bRows = new JTextField();
		JTextField bCols = new JTextField();
		bLabel.setBounds(20, 70, 20, 20);
		bRows.setBounds(40, 70, 40, 20);
		bCols.setBounds(100, 70, 40, 20);
		f.add(bLabel);
		f.add(bRows);
		f.add(bCols);
		
		JButton confirmMatrixButton = new JButton("Confirm");
		confirmMatrixButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            int ar = Integer.parseInt(aRows.getText());
			            int ac = Integer.parseInt(aCols.getText());
			            int br = Integer.parseInt(bRows.getText());
			            int bc = Integer.parseInt(bCols.getText());
			            aInfo.setMatrixInfo(ar,ac);
			            bInfo.setMatrixInfo(br,bc);
			            System.out.println(aInfo);
			            System.out.println(bInfo);
			        }
			    });
		confirmMatrixButton.setBounds(200, 50, 80, 20);
		f.add(confirmMatrixButton);
		
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
