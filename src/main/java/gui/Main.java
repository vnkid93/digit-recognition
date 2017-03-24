package gui;

import java.util.List;

import data.Image;
import loader.DataLoader;
import util.Constants;

public class Main {

	public static final String TRAIN_DATA = "train-images.idx3-ubyte";
	public static final String TRAIN_LABEL = "train-labels.idx1-ubyte";
	public static final String TEST_DATA = "t10k-images.idx3-ubyte";
	public static final String TEST_LABEL = "t10k-labels.idx1-ubyte";
	
	public static void main(String[] args){
		List<Image> dataList = DataLoader.getInstance().getImageData(TRAIN_DATA, TRAIN_LABEL, Constants.IMG_OFFSET, Constants.LABEL_OFFSET, 3);
		
		
		for (Image image : dataList) {
			System.out.println(image.toString(true));
		}
	}
}
