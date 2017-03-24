package data;

import java.util.Arrays;

public class Image {

	public int[][] matrix;
	public int label;
	
	public Image(int[][] matrix, int label){
		this.matrix = matrix;
		this.label = label;
	}
	
	public Image(int[][] matrix, int label, boolean deepCopy){
		this.label = label;
		if(deepCopy){
			this.matrix = matrix.clone();
		}else{
			this.matrix = matrix;
		}
	}
	
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			str.append(Arrays.toString(matrix[i])+"\n");
		}
		str.append("> "+label);
		return str.toString();
	}
	
	public String toString(boolean highContrast){
		if(highContrast){
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < matrix.length; i++) {

				for (int j = 0; j < matrix.length; j++) {
					char c = matrix[i][j] == 0 ? ' ' : '@';
					str.append("["+c+"]");
				}
				str.append('\n');
			}
			str.append("> "+label);
			return str.toString();
		}else{
			return toString();
		}
	}
}
