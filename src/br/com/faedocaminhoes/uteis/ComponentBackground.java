/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.uteis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Poison
 */
public class ComponentBackground extends JPanel{

	private static final long serialVersionUID = -3910426527759806439L;
	private Image image;
	
       public ComponentBackground(Image image) {
    	       super();
               this.image = image;
      }

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	protected void paintComponent(Graphics graphics) {
		Graphics g = graphics.create();
		Graphics2D g2D = (Graphics2D) g;
		
		if (image != null) {
			g2D.fillRect(0, 0, getWidth(), getHeight());
			
			g2D.fillRect(0, 0, image.getWidth(this), image.getHeight(this));
			g2D.drawImage(image, 50, 0, this);
			g2D.dispose();
		}
	}
}
