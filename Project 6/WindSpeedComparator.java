
/**
 * Date: 4/19/2022
 * This class describes a WindSpeedComparator which lets us compare two Storm objects based on their windspeed. This 
 * class implements Comparator<Storm> and overrides the compare method.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.*;

public class WindSpeedComparator implements Comparator<Storm> {
	
	/**
	 * This is a method that compares the two specified Storm objects based on their windspeed. This was taken from Professor
	 * Esmaili's examples in Homework 6 instructions. It was applied to this homework's specifications.
	 * @return
	 * 		The method returns -1 if the left windspeed is less than the right windspeed, returns 0 if their 
	 *      windspeeds are equivalent, and returns 1 otherwise. 
	 */
	public int compare(Storm left, Storm right) {
		if(left.getWspeed() < right.getWspeed()) {
			return -1;
		}
		else if(left.getWspeed() == right.getWspeed()) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
