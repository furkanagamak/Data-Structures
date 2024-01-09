
/**
 * Date: 4/19/2022
 * This class describes a PrecipitationComparator which lets us compare two Storm objects based on their precipitation. This 
 * class implements Comparator<Storm> and overrides the compare method.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.*;

public class PrecipitationComparator implements Comparator<Storm> {
	
	/**
	 * This is a method that compares the two specified Storm objects based on their precipitation. This was taken from Professor
	 * Esmaili's examples in Homework 6 instructions. It was applied to this homework's specifications.
	 * @return
	 * 		The method returns -1 if the left precipitation is less than the right precipitation, returns 0 if their 
	 *      precipitations are equivalent, and returns 1 otherwise. 
	 */
	public int compare(Storm left, Storm right) {
		if(left.getPrecip() < right.getPrecip()) {
			return -1;
		}
		else if(left.getPrecip() == right.getPrecip()) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
