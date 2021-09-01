package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class InputListener implements ActionListener {
	
	private Sudoku sudoku;
	public InputListener(Sudoku s){
		if (s == null)
			throw new IllegalArgumentException("Sudoku obj should not be null.");
		this.sudoku = s;
	}
	   
   @Override
    public void actionPerformed(ActionEvent e) {

       // Get the source object that fired the event
	    /* [TODO 2]
	     * All the 9*9 JTextFileds invoke this handler. 
	     * 1.We need to determine which JTextField (which row and column) is the source for this invocation.
	     * 2.To check if user's input is correct.
	     * 3.To check if Game is over.
	     * Hint: please notice the member method defined in class Sudoku 
	     */	     	
       
    }

}
