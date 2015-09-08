package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 1
 *  returns their name and a
 *  modified string
 *
 *  @author Shyam Natarajan
 *  @version 1.2
 */
public class Person1 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person1(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 2 positions.
	 * given "gtg123b" it should return
	 * "g123bgt".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  String[] inputArray = input.split("");
      String[] output = new String[inputArray.length];
      for (int i = 0; i < inputArray.length; i++) {
          if (i + 2 < inputArray.length) {
              output[i] = inputArray[i + 2];
          } else {
              output[i] = inputArray[i + 2 - inputArray.length];
          }
      }
	  return java.util.Arrays.toString(output);
	}

	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}