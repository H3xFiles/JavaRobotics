package nl.vu.cs.Mining;

import java.util.Random;

public class MathRand{
	

public int MathRand(int min, int max) {
	  	Random rand = new Random();
	    int magicNumber;
	    magicNumber = rand.nextInt((max-min)+1)+min;
		return magicNumber;	
	}

}
