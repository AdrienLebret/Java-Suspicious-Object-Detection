package com.mau.aws;

import java.io.IOException;

/**
 * Identify the objects within an image
 *
 */

public class ImageObjectDetection {
	// public static JFrame Stream_Frame = new JFrame("Image Streaming");
	// public static JLabel Image_View_Label = new JLabel();

	public static String[] suspectedObjects = { "Baby", "Knife", "Weapon" };

	public static void main(String[] args) throws IOException {

		Window window = new Window();
		/*
		 * System.out.println("AWS - Image Object Detection Started...");
		 * 
		 * // Declaring and preparing the frame where the image stream will be //
		 * viewed. DetectLabels detectLabels = new DetectLabels();
		 * 
		 * File fi = new File("C:\\temp\\thSOPZHYLP.jpg"); byte[] fileContent =
		 * Files.readAllBytes(fi.toPath());
		 * 
		 * List<Label> imageLabels = detectLabels.run("C:\\temp\\thSOPZHYLP.jpg");
		 * 
		 * BoundingBox boundingBox = null; String img = ""; for (Label label :
		 * imageLabels) { System.out.println(label.getName() + ": " +
		 * label.getConfidence()); System.out.println(label); for (String
		 * suspectedObject : suspectedObjects) { if
		 * (suspectedObject.equals(label.getName())) { img = label.getName(); for
		 * (Instance instance : label.getInstances()) { boundingBox =
		 * instance.getBoundingBox(); } } } } System.out.println("boundingBox: " +
		 * boundingBox);
		 */

		/*
		 * ImageIcon Img_Icon = new ImageIcon();
		 * 
		 * ByteArrayInputStream bais = new ByteArrayInputStream(fileContent);
		 * BufferedImage My_Image = ImageIO.read(bais);
		 * 
		 * Img_Icon.setImage(My_Image);
		 * 
		 * Stream_Frame.getContentPane().add(Image_View_Label, BorderLayout.CENTER);
		 * Stream_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 * Stream_Frame.setBounds(0, 0, 232, 234); Stream_Frame.setResizable(true);
		 * Image_View_Label.setBounds(0, 0, 232, 234);
		 * Image_View_Label.setIcon(Img_Icon);
		 * 
		 * // Image_View_Label.setHorizontalTextPosition(100);
		 * 
		 * JPanel panel = new JPanel(); LayoutManager overlay = new
		 * OverlayLayout(panel); panel.setLayout(overlay);
		 * 
		 * Image_View_Label.setForeground(Color.GREEN); Image_View_Label.setFont(new
		 * Font("SansSerif", Font.BOLD, 16)); Image_View_Label.setAlignmentX(0.5f);
		 * Image_View_Label.setAlignmentY(0.5f); panel.add(Image_View_Label);
		 * 
		 * JLabel label2 = new JLabel(new
		 * ImageIcon(OverlayLabelApp.class.getResource("C:\\temp\\thSOPZHYLP.jpg")));
		 * label2.setAlignmentX(0.5f); label2.setAlignmentY(0.5f); panel.add(label2);
		 * 
		 * frame.add(panel); frame.pack(); frame.setVisible(true);
		 * 
		 * Image_View_Label.setText(img);
		 * 
		 * Stream_Frame.setVisible(true);
		 */

		/*
		 * JFrame frame = new JFrame("Overlay App");
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * JPanel panel = new JPanel();
		 * 
		 * LayoutManager overlay = new OverlayLayout(panel); panel.setLayout(overlay);
		 * 
		 * JLabel label1 = new JLabel(img); label1.setForeground(Color.GREEN);
		 * label1.setFont(new Font("SansSerif", Font.BOLD, 16));
		 * label1.setAlignmentX(0.5f); label1.setAlignmentY(0.5f); panel.add(label1);
		 * 
		 * JLabel label2 = new JLabel(new
		 * ImageIcon(ImageObjectDetection.class.getResource("/images/sunset.jpg")));
		 * label2.setAlignmentX(0.5f); label2.setAlignmentY(0.5f); panel.add(label2);
		 * 
		 * frame.add(panel); frame.pack(); frame.setVisible(true);
		 */

	}
}
