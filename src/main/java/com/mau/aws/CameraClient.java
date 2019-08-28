package com.mau.aws;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

public class CameraClient extends JPanel {

	public JLabel Image_View_Label = new JLabel();
	public JLabel resultLabel = new JLabel();
	JLabel labelPA;

	private String hostUrl;
	private int portNo = 8080;
	ImageIcon Img_Icon = new ImageIcon();
	
	public CameraClient(String host, int port) {
		initialize();
		hostUrl = host;
		portNo = port;
		// Needs to call once Camera is integrated to the system
		//StartStreaming();
		Test();

	}

	private void initialize() {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());

		/*
		 * NORTH
		 */
		labelPA = new JLabel("Choice Of Parameters");
		Font policeNorth = new Font("Tahoma", Font.BOLD, 12);
		labelPA.setFont(policeNorth);
		labelPA.setForeground(Color.black);
		labelPA.setHorizontalAlignment(SwingConstants.CENTER);
		labelPA.setOpaque(false);
		this.add(labelPA, BorderLayout.CENTER);

		Image_View_Label.setBounds(0, 25, this.getWidth(), 200);

		Image_View_Label.setIcon(new ImageIcon("resources/images/camera/" + "Test" + ".jpg"));
		//Image_View_Label.setIcon(new ImageIcon("resources/images/camera/" + "Carreau.png"));
		
		this.add(Image_View_Label);

		resultLabel = new JLabel();

		Font resultfont = new Font("Tahoma", Font.PLAIN, 20);
		resultLabel.setFont(resultfont);
		resultLabel.setForeground(Color.black);
		resultLabel.setHorizontalAlignment(SwingConstants.LEFT);
		resultLabel.setOpaque(false);
		this.add(resultLabel, BorderLayout.EAST);

	}

	private void Test() {
		byte[] bytes;
		try {
			bytes = Files.readAllBytes(Paths.get("resources/images/camera/" + "Test" + ".jpg"));
			//bytes = Files.readAllBytes(Paths.get("resources/images/camera/" + "Carreau.png"));
		} catch (IOException e) {
			System.err.println("Failed to load image: " + e.getMessage());
			throw new RuntimeException("Failed to load image");
		}
		Recognise(bytes);
	}

	Boolean isRecognising = false;

	public void StartStreaming() {
		try {

			Socket socket;
			socket = new Socket(hostUrl, portNo);

			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

			// passing the Frames Per Seconds (fps) to the camera.
			dout.write("25".getBytes());
			dout.flush();
			// Passing the Resolution to the camera.
			dout.write("320x240".getBytes());
			dout.flush();

			// Declaring and preparing the frame where the image stream will be
			// viewed.

			// The following block of code has the main process of the program,
			// which is to receive and render the image stream for the client.
			while (!isRecognising) {

				int sizeOfImage = 0; // Used to save the size of the images that
										// will be sent to the client.
				int Freq_counter = 1; // An iterator that its value starts at 1
										// and keeps increasing by "1" until it
										// reaches the number of frames.
				while (Freq_counter <= 25) {
					sizeOfImage = din.readInt(); // Receiving the image's size
													// from the camera.
					byte[] readData = new byte[sizeOfImage]; // Declaring and
																// initializing
																// a byte array
																// to save the
																// image as a
																// sequence of
																// bytes.

					// Acknowledging the receipt of the size of the image.
					dout.write("Got it".getBytes());
					dout.flush();

					// Reading the image and save it as byte array in the
					// previously declared array "readData".
					din.readFully(readData, 0, sizeOfImage);

					// Acknowledging the receipt of the image.
					dout.write("Image received".getBytes());
					dout.flush();

					// The process of reforming the image from bytes to an
					// ImageIcon, so it would be ready to be rendered in
					// Image_View_Label Label.
					Img_Icon = new ImageIcon(); // Creating new
												// ImageIcon
												// "Img_Icon" and
												// setting its value
												// to an empty
												// ImageIcon.
					ByteArrayInputStream bais = new ByteArrayInputStream(readData); // Creating BAIS "bais" to read the
																					// byte
																					// array "readData".
					BufferedImage My_Image = ImageIO.read(bais); // Declaring a
																	// BufferedImage
																	// "My_Image"
																	// and
																	// making it
					Recognise(readData); // read the
					// bytes
					// stream
					// from the
					// BAIS
					// "bais".
					Img_Icon.setImage(My_Image); // Setting the Image to be
													// shown in the ImageIcon
													// "Img_Icon".

					Image_View_Label.setIcon(Img_Icon); // Updating the Icon of
														// Image_View_Label, in
														// which the image
														// stream will be
														// rendered for the
														// client.

					Freq_counter++;
				} // While loop for Frequency ends here.

				// Checking if the user wants to end the stream.

			}
			dout.close();
			din.close();
			socket.close();
		} // end of try.
		catch (Exception exc) {

		} // end of catch.

	}

	/**
	 * @param data
	 */
	private void Recognise(byte[] data) {
		isRecognising = true;

		DetectLabels detectLabels = new DetectLabels();
		String results = detectLabels.DetectWithBytes(data);

		// results gives all objects within a picture
		// we need to have a suspect item array
		// compare this list to the result and highlights the match !
		
		
		resultLabel.setText(results);
	}
}
