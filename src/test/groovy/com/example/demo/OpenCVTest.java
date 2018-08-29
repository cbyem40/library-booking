package com.example.demo;

//import org.bytedeco.javacpp.BytePointer;
//import org.bytedeco.javacpp.lept;
//import org.bytedeco.javacpp.opencv_core;
//import org.bytedeco.javacpp.tesseract;
import org.junit.Test;

//import static java.awt.Color.gray;
//import static org.bytedeco.javacpp.lept.pixDestroy;
//import static org.bytedeco.javacpp.lept.pixRead;
//import static org.bytedeco.javacpp.opencv_core.addWeighted;
//import static org.bytedeco.javacpp.opencv_highgui.*;
//import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
//import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
//import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
//import static org.bytedeco.javacpp.opencv_imgproc.*;
//import static org.bytedeco.javacpp.opencv_photo.fastNlMeansDenoising;

public class OpenCVTest {


    @Test
    public void test() {
//        String tessDataDir = "/usr/local/Cellar/tesseract/3.05.02/share/tessdata";
//        String sampleFile = "/Users/rachel.tung/Code/library-booking/src/main/resources/img/sample.jpg";
//        String greyFile = "/Users/rachel.tung/Code/library-booking/src/main/resources/img/grey.jpg";
//        String horizonFile = "/Users/rachel.tung/Code/library-booking/src/main/resources/img/horizon.jpg";
//        String verticalFile = "/Users/rachel.tung/Code/library-booking/src/main/resources/img/vertical.jpg";
//        opencv_core.Mat src = imread(sampleFile, CV_LOAD_IMAGE_GRAYSCALE);
//
//        opencv_core.Mat grey = src.clone();
////        opencv_core.Mat bw = new opencv_core.Mat();
//        opencv_core.Mat canny = new opencv_core.Mat();
////        cvtColor(src, grey, COLOR_BGR2GRAY);
//        imwrite(greyFile, grey);
//
////        adaptiveThreshold(grey, bw, 255, CV_ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 15, -2);
////        imwrite(outputFile, bw);
//
//        // Create the images that will use to extract the horizontal and vertical lines
//        opencv_core.Mat horizontal = grey.clone();
//        // Specify size on horizontal axis
//        System.out.println(horizontal.cols());
//        int horizontalsize = horizontal.cols() / 70;
//        opencv_core.Mat horizontalStructure = getStructuringElement(MORPH_RECT, new opencv_core.Size(horizontalsize,2), new opencv_core.Point(0,0));
//        erode(horizontal, horizontal, horizontalStructure);
//        imwrite(horizonFile, horizontal);
//
//
//        opencv_core.Mat vertical = src.clone();
//        threshold(vertical, vertical, 108, 255,THRESH_BINARY);
//        opencv_core.Mat verticalStructure = getStructuringElement(MORPH_RECT, new opencv_core.Size(1,1), new opencv_core.Point(0,0));
//        erode(vertical, vertical, verticalStructure);
//        imwrite(verticalFile, vertical);
//
//        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
//        if (api.Init(tessDataDir, "eng") != 0){
//            System.err.println("Could not initialize tesseract.");
//            System.exit(1);
//        }
//
//        lept.PIX imagePixel = pixRead(verticalFile);
//        api.SetImage(imagePixel);
//        BytePointer outputText = api.GetUTF8Text();
//        System.out.println(outputText.getString());
//
//        api.End();
//        outputText.deallocate();
//        pixDestroy(imagePixel);

    }
}
