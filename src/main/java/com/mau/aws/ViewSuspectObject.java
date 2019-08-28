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
 * ViewSuspectObject is the class representing the window that show what kind of suspect object
 * there is on the image that we get. She inherited it from
 * JDialog. This window is characterized by JPanel pan, container and
 * tabScorePanels The JButton buttonYes and buttonNo The JLabel icon that shows
 * the background image
 * 
 * @author Adrien
 *
 */
public class ViewSuspectObject extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel pan = new JPanel();
	private JPanel container = new JPanel();
	private JLabel icon;
	private Double confidence;
	private String object;

	public ViewSuspectObject(JFrame parent, String title, boolean modal, Double c, String o) {
		super(parent, title, modal);
		this.confidence = c;
		this.object = o;
		initialize();
		this.setVisible(true);
	}

	private void initialize() {
		
		/**
		 * TO DO : 	enlever le bouton de quitter l'application
		 * 			faire en sorte que l'on puisse utiliser la croix rouge
		 * 			affichage d'une image en fonction du nom de l'objet suspect
		 * 			paramètre quand on crée cette fenêtre : Nom de l'objet suspect + % de confiance
		 *			position RANDOM 			
		 */

		this.setSize(512, 360);
		//this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setLocation(400, 200);
		//this.setAlwaysOnTop(true);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);


		this.setContentPane(container);

		icon = new JLabel(new ImageIcon("resources/images/fonts/IMG_CSD_Knife.jpg"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(icon);
		this.getContentPane().add(panIcon, BorderLayout.CENTER);
	}

}
