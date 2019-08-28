package com.mau.aws;

import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewCameras extends JDialog {

	private static final long serialVersionUID = 1L;

	JFrame jf = new JFrame();
	JPanel jp = new JPanel();

	private int nbCamera;
	
	ViewChoiceParameters vcp;

	public ViewCameras(int nbC, ViewChoiceParameters v) {
		this.vcp = v;
		this.nbCamera = nbC;
		System.out.println("No Of Cameras: " + nbC);
		initialize();
		this.setVisible(true);
	}

	private void initialize() {
		this.requestFocus();
		this.setAlwaysOnTop(true);
		// this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setSize(1280, 960);
		// this.getContentPane().setLayout(new GridLayout(2,2));

		/*
		 * We divide the screen according to the number of cameras selected. We always
		 * add a part so that we can later insert text.
		 */
		switch (nbCamera) {
		case 1:
			// CAM1 + TEXT
			this.getContentPane().setLayout(new GridLayout(1, 2));
			break;
		case 2:
			// CAM1 + TEXT + CAM2
			this.getContentPane().setLayout(new GridLayout(1, 3));
			break;
		case 3:
			// CAM1 + CAM2
			// CAM3 + TEXT
			this.getContentPane().setLayout(new GridLayout(2, 2));
			break;
		}

		for (int i = 1; i <= nbCamera; i++) {
			switch(i) {
			case 1 :
				CameraClient cameraPanel1 = new CameraClient(vcp.getIPAddress(1), Integer.parseInt(vcp.getPort(1))); // Put the IP and the Port;
				this.getContentPane().add(cameraPanel1);
				break;
			case 222 :
				CameraClient cameraPanel2 = new CameraClient(vcp.getIPAddress(2), Integer.parseInt(vcp.getPort(2))); // Put the IP and the Port;
				this.getContentPane().add(cameraPanel2);
				break;
			case 333 :
				CameraClient cameraPanel3 = new CameraClient(vcp.getIPAddress(3), Integer.parseInt(vcp.getPort(3))); // Put the IP and the Port;
				this.getContentPane().add(cameraPanel3);
				break;
			}
			 
			/*
			 * JLabel cameraLabel = new JLabel(); cameraLabel.setIcon(new
			 * ImageIcon("ressources/images/camera/"+ i +".jpg"));
			 * cameraPanel.add(cameraLabel); cameraPanel.setName("Camera" + i);
			 */
			/*
			 * cameraPanel.addMouseListener(new java.awt.event.MouseAdapter(){
			 * 
			 * @Override public void mouseReleased(java.awt.event.MouseEvent evt){
			 * controler.changercamera(evt); } });
			 */

			//this.getContentPane().add(cameraPanel);
		}

		// ADD TEXT TO DESCRIBE IF THERE ARE WEAPONS OR NOT
	}

}
