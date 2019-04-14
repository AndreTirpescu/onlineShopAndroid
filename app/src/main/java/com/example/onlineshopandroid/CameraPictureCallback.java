package com.example.onlineshopandroid;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraPictureCallback implements Camera.PictureCallback
{
    private Context appContext;

    CameraPictureCallback(Context context)
    {
        this.appContext = context;
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera)
    {
        File file = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "out.jpeg"
        );

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
