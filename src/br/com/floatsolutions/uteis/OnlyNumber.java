/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.uteis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Poison
 */
public class OnlyNumber implements KeyListener {

	private int fieldLength;
	public void keyTyped(KeyEvent event) {
		JTextField jtf = (JTextField) event.getSource();
		char key = event.getKeyChar();
		boolean press = (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_DELETE || Character
				.isDigit(key));
		if (!press || jtf.getText().length() == getFieldLength()) {
			event.consume();
		}
	}

	public void keyPressed(KeyEvent event) {
                     //
	}	
	public void keyReleased(KeyEvent event) {
                    //
	}
	public int getFieldLength() {
		return fieldLength;
	}
	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	} 
}
