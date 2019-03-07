package nl.vu.cs.Mining;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class PictureAnalyzer {

	public void AnalyzePictures(BufferedImage buffImage) {
		byte[] pixels = ((DataBufferByte) buffImage.getRaster().getDataBuffer()).getData();
		for(int i = 0; i<pixels.length; i+=1) {
			System.out.println(pixels[i]);
		}
	}
	
}
