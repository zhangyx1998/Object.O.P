package sudoku;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SudokuGame extends JFrame{
	public SudokuGame()
	{
		this.add(new Sudoku());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setTitle("Sudoku");
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
		/**
		 * [TODO 1]
		 * Check Swing program template on how to run the constructor
		 */
   }

}
