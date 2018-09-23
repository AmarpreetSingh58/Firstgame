package com.example.amarp.firstgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceholder;
    private GameView gameView;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder,GameView gameView){

        super();

        this.surfaceholder = surfaceHolder;
        this.gameView = gameView;

    }

    @Override
    public void run() {
        while (running){
            canvas = null;

            try {
                canvas=this.surfaceholder.lockCanvas();
                synchronized (surfaceholder){
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }

            }catch (Exception e){
            }
            finally {
                if (canvas != null){
                    try {
                     surfaceholder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){

                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning){
        running = isRunning;
    }
}
