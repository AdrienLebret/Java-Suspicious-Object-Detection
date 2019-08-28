package com.mau.aws;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Window is the class representing the main window of the game.
 * 
 * @author Adrien
 *
 */
public class Window extends JFrame {

	private ViewParameters parametersPanel;

	public Window() {
		initialize();
	}

	/**
	 * Initializes the entire JFrame window
	 */
	private void initialize() {
		this.setTitle("Suspicious Object Detection");
		this.setIconImage(new ImageIcon("/resources/images/fonts/LogoCSD.jpg").getImage());
		this.setSize(1024, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.parametersPanel = new ViewParameters();
		// this.parametresPanel = new VueChoixParametres();
		ViewStart vp = new ViewStart(null, "Suspicious Object Detection", true);

		this.setContentPane(parametersPanel);
		this.setVisible(true);
	}

}
