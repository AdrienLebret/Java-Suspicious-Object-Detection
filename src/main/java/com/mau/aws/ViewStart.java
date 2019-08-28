package com.mau.aws;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * 
 * ViewStart is the class representing the launch window. She inherited it from
 * JDialog. This window is characterized by JPanel pan, container and
 * tabScorePanels The JButton buttonYes and buttonNo The JLabel icon that shows
 * the background image
 * 
 * @author Adrien
 *
 */
public class ViewStart extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Panel
	 */
	private JPanel pan = new JPanel();

	/**
	 * Panel Principal
	 */
	private JPanel container = new JPanel();

	/**
	 * Button that will allow the player to launch the app
	 */
	private JButton yesButton = new JButton("Launch The Application");

	/**
	 * Button that will allow the player to exit, which will close the app.
	 */
	private JButton noButton = new JButton("Quit");

	/**
	 * Label allowing the display of the startup image available in the resource
	 * folder
	 */
	private JLabel icon;

	public ViewStart(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initialize();
		this.setVisible(true);
	}

	private void initialize() {

		this.setSize(1024, 720);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);

		// Adding actions on buttons
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// Layout of the buttons
		JPanel south = new JPanel();
		south.setOpaque(false);
		south.add(yesButton);
		south.add(noButton);
		container.add(south, BorderLayout.SOUTH);

		this.setContentPane(container);

		icon = new JLabel(new ImageIcon("resources/images/fonts/StartView.jpg"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(icon);
		this.getContentPane().add(panIcon, BorderLayout.CENTER);
	}

}
