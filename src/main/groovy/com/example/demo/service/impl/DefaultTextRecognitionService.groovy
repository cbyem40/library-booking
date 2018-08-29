package com.example.demo.service.impl

import com.example.demo.service.intl.TextRecognitionService
//import org.bytedeco.javacpp.BytePointer
//import org.bytedeco.javacpp.lept
//import org.bytedeco.javacpp.opencv_core
//import org.bytedeco.javacpp.tesseract
import org.springframework.stereotype.Service

//import static org.bytedeco.javacpp.opencv_core.*
//import static org.bytedeco.javacpp.opencv_imgcodecs.*
//import static org.bytedeco.javacpp.opencv_highgui.*
//import static org.bytedeco.javacpp.lept.pixDestroy
//import static org.bytedeco.javacpp.lept.pixRead

@Service
class DefaultTextRecognitionService implements TextRecognitionService {

    @Override
    void getImage() {
//        String tessDataDir = "/usr/local/Cellar/tesseract/3.05.02/share/tessdata";
//        String sampleFile = "/Users/rachel.tung/Code/library-booking/src/main/resources/img/hello.jpg"
//        String outputFile = "/Users/rachel.tung/Code/library-booking/src/main/resources/img/output.jpg"
//        Mat img = imread sampleFile
//        System.out.println img.arrayChannels()
//        System.out.println img.arrayDepth()
//        System.out.println img.arrayWidth()
//        System.out.println img.arrayHeight()
//        namedWindow "DisplayWindow"
//        imshow "DisplayWindow", img
//        waitKey 8000


//        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
//        if (api.Init(tessDataDir, "eng") != 0){
//            System.err.println("Could not initialize tesseract.");
//            System.exit(1);
//        }
//
//
//        lept.PIX imagePixel = pixRead(sampleFile);
//        api.SetImage(imagePixel);
//        BytePointer outputText = api.GetUTF8Text();
//        System.out.println(outputText.getString());
//
//        api.End();
//        outputText.deallocate();
//        pixDestroy(imagePixel);
    }
}
