package com.example.mateus.regex.views;

import android.graphics.Bitmap;

import com.googlecode.tesseract.android.TessBaseAPI;

class OCRManager {

    TessBaseAPI baseAPI = null;

    public void initAPI()
    {
        baseAPI = new TessBaseAPI();

        // after copy, my path to trainned data is getExternalFilesDir(null)+"/tessdata/"+"vie.traineddata";
        // but init() function just need parent folder path of "tessdata", so it is getExternalFilesDir(null)
        String dataPath = MainApplication.instance.getTessDataParentDirectory();

        // nome da língua das imagens
        baseAPI.init(dataPath,"por");

        // first param is datapath which is  part to the your trainned data, second is language code
        // now, your trainned data stored in assets folder, we need to copy it to another external storage folder.
        // It is better do this work when application start firt time
    }

    public String startRecognize(Bitmap bitmap)
    {
        if(baseAPI ==null)
            initAPI();
        baseAPI.setImage(bitmap);


        return baseAPI.getUTF8Text();
    }
}

