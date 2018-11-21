package main;

import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;

public class VideoCap {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    VideoCapture cap;
    MatToImage mat2Img = new MatToImage();

    /**
     * Create and open the camera stream
     */
    VideoCap(){
        cap = new VideoCapture();
        cap.open(0);
    } 
 
    /**
     * Retrieves a frame.
     */
    BufferedImage getOneFrame() {
        cap.read(mat2Img.mat);
        return mat2Img.getImage(mat2Img.mat);
    }
}
