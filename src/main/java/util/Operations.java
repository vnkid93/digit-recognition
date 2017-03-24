package util;

public class Operations {

	public static int[][] matrixMultiply(int[][] m1, int[][] m2){
		int [][] result = null;
		int m1Column = m1[0].length;
		int m1Row = m1.length;
		int m2Column = m2[0].length;
		int m2Row = m2.length;
		
		if(m1Column == m2Row){
			// multiplyable
			result = new int[m2Column][m1Row];
			
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					int value = 0;
					for (int j2 = 0; j2 < m1Column; j2++) {
						value += m1[i][j2] * m2[j2][j];
					}
					result[i][j] = value;
				}
			}
		}
		return result;
	}
}
