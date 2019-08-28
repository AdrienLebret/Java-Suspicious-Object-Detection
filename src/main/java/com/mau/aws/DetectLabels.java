package com.mau.aws;

import java.awt.Toolkit;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;

public class DetectLabels {

	// SUSPECT ITEMS 
	
	public static String[] suspectedObjects = { "Knife", "Weapon", "Gun", "Axe", "Bomb"};
	
	
	
	public List<Label> run(String imgPath) {

		byte[] bytes;
		try {
			bytes = Files.readAllBytes(Paths.get(imgPath));
		} catch (IOException e) {
			System.err.println("Failed to load image: " + e.getMessage());
			throw new RuntimeException("Failed to load image");
		}
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

		AmazonRekognition rekognition = ClientFactory.createClient();

		DetectLabelsRequest request = new DetectLabelsRequest().withImage(new Image().withBytes(byteBuffer))
				.withMaxLabels(10);
		DetectLabelsResult result = rekognition.detectLabels(request);

		List<Label> labels = result.getLabels();
		for (Label label : labels) {
			System.out.println(label.getName() + ": " + label.getConfidence());
			System.out.println(label);
		}
		return labels;
	}

	public String DetectWithBytes(byte[] bytes) {

		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

		AmazonRekognition rekognition = ClientFactory.createClient();

		DetectLabelsRequest request = new DetectLabelsRequest().withImage(new Image().withBytes(byteBuffer))
				.withMaxLabels(10);
		DetectLabelsResult result = rekognition.detectLabels(request);

		List<Label> labels = result.getLabels();
		String results = "";
		results += "<html>"; // only way to have a list in a JLabel
		int nbOfSO = 0; // number of suspect objects
		for (Label label : labels) {
			double number1 = label.getConfidence();
	        double number2 = (int)Math.round(number1 * 100)/(double)100;
	        
	        if(Arrays.asList(suspectedObjects).contains(label.getName())) { // SUSPECT OBJECT
				results += ("<span size='7' style='color:red;font-weight: bold;'><b>" + label.getName() + ": " + number2 + "% </b></span> <br/>");
				nbOfSO++;
				/**
				 * 	Afficher une alerte !
				 * 	A transformer par une JFrame que l'on crée nous même
				 * 	Le message de dialog doit être enlever avant
				 * 	Cette alerte doit comporter :
				 * 		- Une image de l'objet
				 * 			==> une base de données des objets suspects
				 * 		- Un texte en haut avec le pourcentage de confiance en rouge
				 * 		- Un placement aléatoire de la position de la fenêtre
				 * 		- Un son
				 */
				//JOptionPane.showMessageDialog(null, " HELLOOOO");
				//ViewSuspectObject vp = new ViewSuspectObject(null, "Suspicious Object Detected", true, number2, label.getName());
				//JOptionPane.showMessageDialog(null, " HELLOOOO");
				
				Toolkit.getDefaultToolkit().beep();
				JOptionPane jop1;      
			    jop1 = new JOptionPane();
			    ImageIcon img = new ImageIcon("resources/images/suspectobjects/" + label.getName() +".png");
			    jop1.showMessageDialog(null, "1 " + label.getName() + " is detected!", "Suspicious Object Detected", JOptionPane.INFORMATION_MESSAGE, img);

	        } else {
				results += (label.getName() + ": " + number2 + "% <br/>");
	        }
		}

		if(nbOfSO == 0) {
			results += "<br/> <h1>NO SUSPECT OBJECTS</h1> <br/>";
		}
		results += "</html>";
		return results;
	}
}
