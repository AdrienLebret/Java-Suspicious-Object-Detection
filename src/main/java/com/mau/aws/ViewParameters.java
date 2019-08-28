package com.mau.aws;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * ViewParameters is the class representing the parameter selection window of
 * the different cameras
 * 
 * @author adrie
 *
 */
public class ViewParameters extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel labelPA; // Label that corresponds to the description of the window
	private JButton okButton; // Validate button allowing the user to validate his different choices

	private ViewChoiceParameters vcp;

	public ViewParameters() {
		initialize();
	}

	private void initialize() {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());

		/*
		 * NORTH
		 */
		labelPA = new JLabel("Choice Of Parameters");
		Font policeNorth = new Font("Tahoma", Font.BOLD, 47);
		labelPA.setFont(policeNorth);
		labelPA.setForeground(Color.black);
		labelPA.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPA.setOpaque(false);
		this.add(labelPA, BorderLayout.NORTH);

		/*
		 * CENTER
		 */

		vcp = new ViewChoiceParameters();
		this.add(vcp, BorderLayout.CENTER);

		/*
		 * SOUTH
		 */

		okButton = new JButton("Launch The Control");
		this.okButton.setOpaque(false);
		this.add(okButton, BorderLayout.SOUTH);
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				// cg.demarrerPartie();
				// get and send the number of cameras who chose the user

				// create a JDialog to display the 1 / 2 / 3 images

				// ViewCameras vc = new ViewCameras(null, "SUSPICIOUS OBJECT DETECTION", true,
				// vcp.getNbCam());

				/*
				 * if(checkDataUser()) { ViewCameras vc = new ViewCameras(vcp.getNbCam()); }
				 * else { // JDialogo / alert message }
				 */

				if (checkDataUser()) {
					ViewCameras vc = new ViewCameras(vcp.getNbCam(), vcp);
				}

			}
		});
	}

	protected boolean checkDataUser() {

		boolean answer = false;

		if (vcp.getNbCam() == 1) {
			// Classic control
			if (vcp.getPort(1).equals("Port Camera 1")) {
				JOptionPane.showMessageDialog(null, "Please enter a correct port number for camera 1");
			} else {
				// We assume that the user enters something good, it will be necessary to add a
				// port check with the server part
				answer = true;
			}
		} else if (vcp.getNbCam() == 2) {
			// Control 1 : IP address
			if (vcp.getIPAddress(1).equals(vcp.getIPAddress(2))) {
				System.out.println("1: " + vcp.getIPAddress(1) + "\n2: " + vcp.getIPAddress(2));
				JOptionPane.showMessageDialog(null, "Please take 2 different IP addresses for cameras 1 and 2");
			} else {
				// Control 2 : Port
				if (!vcp.getPort(1).equals("Port Camera 1") && !vcp.getPort(2).equals("Port Camera 2")) {
					// if one of this 2 ports are true, it's false due to the "&&" T && F = F
					answer = true;
				} else {
					System.out.println("1: " + vcp.getPort(1) + "\n2: " + vcp.getPort(2));
					JOptionPane.showMessageDialog(null, "Please enter a correct port number");
				}
			}

		} else if (vcp.getNbCam() == 3) {
			if (vcp.getIPAddress(1).equals(vcp.getIPAddress(2))) {
				System.out.println("1: " + vcp.getIPAddress(1) + "\n2: " + vcp.getIPAddress(2));
				JOptionPane.showMessageDialog(null, "Please take 2 different IP addresses for cameras 1 and 2");

			} else if (vcp.getIPAddress(2).equals(vcp.getIPAddress(3))) {
				System.out.println("2: " + vcp.getIPAddress(2) + "\n3: " + vcp.getIPAddress(3));
				JOptionPane.showMessageDialog(null, "Please take 2 different IP addresses for cameras 2 and 3");

			} else if (vcp.getIPAddress(1).equals(vcp.getIPAddress(3))) {
				System.out.println("1: " + vcp.getIPAddress(1) + "\n3: " + vcp.getIPAddress(3));
				JOptionPane.showMessageDialog(null, "Please take 2 different IP addresses for cameras 1 and 3");

			} else {
				// Control 2 : Port
				if (!vcp.getPort(1).equals("Port Camera 1") && !vcp.getPort(2).equals("Port Camera 2")
						&& !vcp.getPort(3).equals("Port Camera 3")) {

					answer = true;
				} else {
					System.out.println("1: " + vcp.getPort(1) + "\n2: " + vcp.getPort(2));
					JOptionPane.showMessageDialog(null, "Please enter a correct port number");
				}
			}
		}

		return answer;
	}

	/**
	 * Displaying the background image available in resource
	 */
	@Override
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("resources/images/fonts/MenuView.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
