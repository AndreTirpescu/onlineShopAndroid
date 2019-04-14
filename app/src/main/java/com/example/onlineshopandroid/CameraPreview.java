package com.example.onlineshopandroid;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

public class CameraPreview  extends ViewGroup implements SurfaceHolder.Callback  {

    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    SurfaceTexture surfaceTexture;
    Context context;

    CameraPreview(Context context, SurfaceView surfaceView)
    {
        super(context);
        this.surfaceView = surfaceView;
        this.context = context;
        this.surfaceHolder = this.surfaceView.getHolder();
        this.surfaceHolder.addCallback(this);
        this.surfaceTexture = new SurfaceTexture(0);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public SurfaceHolder getSurfaceHolder()
    {
        return this.surfaceHolder;
    }

    public SurfaceTexture getSurfaceTexture()
    {
        return  this.surfaceTexture;
    }
}
