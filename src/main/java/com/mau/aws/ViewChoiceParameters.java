package com.mau.aws;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewChoiceParameters extends JPanel {

	private static final long serialVersionUID = 1L;

	// =================
	// PARAMETERS ITEM
	// =================

	private JLabel labelNbC = new JLabel("Number of Cameras: One"); // Label describing the number of cameras, which will
																	// change according to the addition or deletion of
																	// cameras
	private JSlider slide = new JSlider(); // Slider to choose parameters

	private String[] ipList = { "192.168.20.246", "192.168.20.247", "192.168.20.248", "192.168.20.249",
			"192.168.20.250", "192.168.20.251", "192.168.20.252", "192.168.20.253", "192.168.20.254" }; // IP List for
																										// the combo box

	// CAMERA 1

	private JLabel labelC1 = new JLabel("Camera: ONE");
	private JComboBox cbCam1 = new JComboBox(ipList);
	private JTextArea port1 = new JTextArea();
	private JLabel labelP1 = new JLabel("Port: ONE");

	/**
	 * Note : Frame and resolution are like defaults values
	 */

	// CAMERA 2

	private JLabel labelC2 = new JLabel("Camera: TWO");
	private JComboBox cbCam2 = new JComboBox(ipList);
	private JTextArea port2 = new JTextArea();
	private JLabel labelP2 = new JLabel("Port: TWO");

	// CAMERA 3

	private JLabel labelC3 = new JLabel("Camera: THREE");
	private JComboBox cbCam3 = new JComboBox(ipList);
	private JTextArea port3 = new JTextArea();
	private JLabel labelP3 = new JLabel("Port: THREE");

	public ViewChoiceParameters() {
		initialize();
	}

	private void initialize() {
		this.setBackground(Color.white);
		this.setOpaque(false);
		this.setLayout(new GridLayout(7, 2, 40, 40));

		// Font
		Font police = new Font("Tahoma", Font.BOLD, 20);

		labelNbC.setFont(police);
		labelNbC.setForeground(Color.white);
		labelC1.setFont(police);
		labelC1.setForeground(Color.white);
		labelC2.setFont(police);
		labelC2.setForeground(Color.white);
		labelC3.setFont(police);
		labelC3.setForeground(Color.white);

		/*
		 * Slide
		 */
		labelNbC.setHorizontalAlignment(SwingConstants.RIGHT);

		slide.setMaximum(3);
		slide.setMinimum(1);
		slide.setValue(1);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(1);
		slide.setMajorTickSpacing(1);
		slide.setFont(police);
		slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (slide.getValueIsAdjusting()) {
					System.out.println("Slide: " + slide.getValue());
					labelNbC.setText("Number Of Cameras: " + slide.getValue());

					// Add the fact that I need to add or remove cameras label / item

					switch (slide.getValue()) {
					case 1:
						labelC2.setVisible(false);
						cbCam2.setVisible(false);
						labelP2.setVisible(false);
						port2.setVisible(false);
						labelC3.setVisible(false);
						cbCam3.setVisible(false);
						labelP3.setVisible(false);
						port3.setVisible(false);
						break;
					case 2:
						labelC2.setVisible(true);
						cbCam2.setVisible(true);
						labelP2.setVisible(true);
						port2.setVisible(true);
						labelC3.setVisible(false);
						cbCam3.setVisible(false);
						labelP3.setVisible(false);
						port3.setVisible(false);
						break;
					case 3:
						labelC2.setVisible(true);
						cbCam2.setVisible(true);
						labelP2.setVisible(true);
						port2.setVisible(true);
						labelC3.setVisible(true);
						cbCam3.setVisible(true);
						labelP3.setVisible(true);
						port3.setVisible(true);
						break;

					}

					// this.repaint()
				}

			}
		});

		/*
		 * Camera 1
		 */
		cbCam1.setPreferredSize(new Dimension(100, 20));
		cbCam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("IP Address Camera - ONE: " + cbCam1.getSelectedItem());
			}
		});
		labelC1.setHorizontalAlignment(SwingConstants.RIGHT);

		labelP1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labelP1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelP1.setForeground(Color.white);

		port1.setText("Port Camera 1"); // empty
		port1.setEditable(true);
		port1.setFont(new Font("Tahoma", Font.BOLD, 17));
		port1.setForeground(Color.BLACK);

		/*
		 * Camera 2
		 */
		cbCam2.setPreferredSize(new Dimension(100, 20));
		cbCam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("IP Address Camera - Two: " + cbCam2.getSelectedItem());
			}
		});
		labelC2.setHorizontalAlignment(SwingConstants.RIGHT);

		labelP2.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labelP2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelP2.setForeground(Color.white);

		port2.setText("Port Camera 2");
		port2.setEditable(true);
		port2.setFont(new Font("Tahoma", Font.BOLD, 17));
		port2.setForeground(Color.BLACK);

		/*
		 * Camera 3
		 */
		cbCam3.setPreferredSize(new Dimension(100, 20));
		cbCam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("IP Address Camera - Three: " + cbCam3.getSelectedItem());
			}
		});
		labelC3.setHorizontalAlignment(SwingConstants.RIGHT);

		labelP3.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labelP3.setHorizontalAlignment(SwingConstants.RIGHT);
		labelP3.setForeground(Color.white);

		port3.setText("Port Camera 3");
		port3.setEditable(true);
		port3.setFont(new Font("Tahoma", Font.BOLD, 17));
		port3.setForeground(Color.BLACK);

		/*
		 * Adding components to the window
		 */

		this.add(labelNbC);
		this.add(slide);

		this.add(labelC1);
		this.add(cbCam1);
		this.add(labelP1);
		this.add(port1);

		this.add(labelC2);
		this.add(cbCam2);
		this.add(labelP2);
		this.add(port2);

		this.add(labelC3);
		this.add(cbCam3);
		this.add(labelP3);
		this.add(port3);

		labelC2.setVisible(false);
		cbCam2.setVisible(false);
		labelP2.setVisible(false);
		port2.setVisible(false);
		labelC3.setVisible(false);
		cbCam3.setVisible(false);
		labelP3.setVisible(false);
		port3.setVisible(false);
	}

	public int getNbCam() {
		return slide.getValue();
	}

	public String getIPAddress(int x) {
		String ipAdd = "";

		switch (x) {
		case 1:
			ipAdd = (String) cbCam1.getSelectedItem();
			break;
		case 2:
			ipAdd = (String) cbCam2.getSelectedItem();
			break;
		case 3:
			ipAdd = (String) cbCam3.getSelectedItem();
			break;
		}
		return ipAdd;
	}

	public String getPort(int x) {
		String port = " ";

		switch (x) {
		case 1:
			port = port1.getText();
			break;
		case 2:
			port = port2.getText();
			break;
		case 3:
			port = port3.getText();
			break;
		}
		return port;
	}

}
