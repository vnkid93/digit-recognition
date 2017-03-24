package loader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.Image;
import util.Constants;

public class DataLoader {
	private static DataLoader instance;
	
	private DataLoader(){
	}
	
	public static DataLoader getInstance(){
		if(instance == null){
			instance = new DataLoader();
		}
		return instance;
	}
	
	/**
	 * Get image data from file
	 * @param path
	 * @param offset
	 * @return
	 */
	public List<Image> getImageData(String dataPath, String labelPath, int dataOffset, int labelOffset){
		List<Image> dataList = new ArrayList<Image>();
		try {
			FileInputStream inData = new FileInputStream(dataPath);
			BufferedInputStream binData = new BufferedInputStream(inData);
			FileInputStream inLabel = new FileInputStream(labelPath);
			BufferedInputStream binLabel = new BufferedInputStream(inLabel);
			byte[] singleImage = new byte[Constants.IMG_SIZE];
			int singleLabel;
			
			inData.read(new byte[dataOffset]);
			inLabel.read(new byte[labelOffset]);
			while(binData.read(singleImage) != -1  &&  (singleLabel = binLabel.read()) != -1){
				int[][] matrix = new int[Constants.IMG_DIMENSION][Constants.IMG_DIMENSION];
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix.length; j++) {
						byte tmp = singleImage[i*Constants.IMG_DIMENSION + j];
						matrix[i][j] = (tmp == 0) ? 0 : 1;
					}
				}
				
				dataList.add(new Image(matrix, singleLabel));
			}
			
			binData.close();
			inData.close();
			binLabel.close();
			inLabel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
	/**
	 * Get image data from file
	 * @param path
	 * @param offset
	 * @return
	 */
	public List<Image> getImageData(String dataPath, String labelPath, int dataOffset, int labelOffset, int count){
		List<Image> dataList = new ArrayList<Image>();
		try {
			FileInputStream inData = new FileInputStream(dataPath);
			BufferedInputStream binData = new BufferedInputStream(inData);
			FileInputStream inLabel = new FileInputStream(labelPath);
			BufferedInputStream binLabel = new BufferedInputStream(inLabel);
			byte[] singleImage = new byte[Constants.IMG_SIZE];
			int singleLabel;
			
			inData.read(new byte[dataOffset]);
			inLabel.read(new byte[labelOffset]);
			while(binData.read(singleImage) != -1  &&  (singleLabel = binLabel.read()) != -1 && count-- > 0){
				int[][] matrix = new int[Constants.IMG_DIMENSION][Constants.IMG_DIMENSION];
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix.length; j++) {
						byte tmp = singleImage[i*Constants.IMG_DIMENSION + j];
						matrix[i][j] = (tmp == 0) ? 0 : 1;
					}
				}
				
				dataList.add(new Image(matrix, singleLabel));
			}
			
			binData.close();
			inData.close();
			binLabel.close();
			inLabel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
}
