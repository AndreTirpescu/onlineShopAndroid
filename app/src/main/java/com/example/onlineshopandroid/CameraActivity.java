package com.example.onlineshopandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity
{
    private Button openCameraButton;
    private Button nextCameraButton;
    private SurfaceView cameraPreview;
    private CameraPreview preview;
    private Camera cameraInstance;
    private Integer currentCamId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        this.openCameraButton = (Button) findViewById(R.id.open_camera);
        this.nextCameraButton = (Button) findViewById(R.id.switch_camera);
        this.cameraPreview = (SurfaceView) findViewById(R.id.camera_preview);
        this.preview = new CameraPreview(getApplicationContext(), this.cameraPreview);
        this.cameraInstance = null;
        this.currentCamId = 0;

        askForPermissions();
    }

    private Integer getNextCamera()
    {
        return (currentCamId + 1) % Camera.getNumberOfCameras();
    }

    private void askForPermissions()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 103);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET}, 102);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
        }
    }

    public void openCamera(View view)
    {
        if (cameraInstance == null) {
            cameraInstance = Camera.open(currentCamId);
        }

        try {
            cameraInstance.setPreviewDisplay(preview.getSurfaceHolder());
            cameraInstance.startPreview();
            cameraInstance.setDisplayOrientation(90);
            cameraInstance.enableShutterSound(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void switchCamera(View view)
    {
        if (cameraInstance != null) {
            cameraInstance.release();
            cameraInstance = null;
            currentCamId = getNextCamera();
            openCamera(view);
        }
    }

    public void takePicture(View view)
    {
        CameraShutterCallback cback = new CameraShutterCallback();
        CameraPictureCallback pictureTaken = new CameraPictureCallback(this.getApplicationContext());

        cameraInstance.takePicture(cback, null, null, pictureTaken);
    }
}
