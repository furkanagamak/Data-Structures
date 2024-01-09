
/**
 * Date: 3/22/2022
 * This class describes a BooleanSource which creates an object that has a probability p between 0 and 1.
 * Note: This class was copied directly from Professor Esmaili's lecture slides.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class BooleanSource {
	
	/**
	 * A double value representing the probability.
	 */
	private double probability;
	
	/**
	 * This constructor creates a BooleanSource object with the specified probability.
	 * @param p
	 * 		A double value representing the probability.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if the probability is either less than 0.0 or more than 1.0.
	 */
	public BooleanSource(double p) throws IllegalArgumentException {
		if (p < 0.0 || p > 1.0)
			throw new IllegalArgumentException();
		this.probability = p;
	}
	
	/**
	 * This is a method that returns a boolean value based on if the probability occurs by comparing
	 * the probability to a random number which is Math.random().
	 * @return
	 * 		Returns true when the random number is less than probability, if not it returns false.
	 */
	public boolean occurs() {
		return (Math.random() < this.probability);
	}

}
