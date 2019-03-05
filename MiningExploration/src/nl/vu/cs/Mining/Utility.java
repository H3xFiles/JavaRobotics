package nl.vu.cs.Mining;

import java.util.Random;

public class Utility {
	public int mathRand(int min, int max) {
		  final Random rand = new Random();
	      final int magicNumber = rand.nextInt(max - min + 1) + min;
	      return magicNumber;    
	  }
}
