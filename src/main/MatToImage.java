package main;

import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MatToImage {
	Mat mat = new Mat();
	BufferedImage img;
	byte[] dat;

	public MatToImage() {
	}

	public MatToImage(Mat mat) {
		getSpace(mat);
	}

	public void getSpace(Mat mat) {
		this.mat = mat;
		Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2BGR);
		int w = mat.cols(), h = mat.rows();
		if (dat == null || dat.length != w * h * 3)
			dat = new byte[w * h * 3];
		if (img == null || img.getWidth() != w || img.getHeight() != h || img.getType() != BufferedImage.TYPE_3BYTE_BGR)
			img = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
	}

	BufferedImage getImage(Mat mat) {
		getSpace(mat);
		mat.get(0, 0, dat);
		img.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), dat);
		return img;
	}

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
}
