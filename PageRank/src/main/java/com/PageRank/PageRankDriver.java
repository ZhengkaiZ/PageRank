/**
 * 
 */
package com.PageRank;

/**
 * @author Zhengkai Zhang
 *
 */
public class PageRankDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length != 4) {
			throw new IllegalArgumentException();
		}
		
		String inputPathMatrix = args[0];
		String inputPathColumn = args[1];
		String output = args[2];
		int numOfEpoches = Integer.valueOf(args[3]);
		
		for (int i = 0; i < numOfEpoches; i++) {
			MatirxMutiply mm = new MatrixMutiply();
			mm.main(inputPathMatrix, inputPathColumn);
			
		}
	}
}
