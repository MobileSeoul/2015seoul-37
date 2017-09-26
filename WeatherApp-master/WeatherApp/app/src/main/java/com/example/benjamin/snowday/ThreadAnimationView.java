package com.example.benjamin.snowday;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by 박정철 on 2015-09-07.
 */
public class ThreadAnimationView extends ImageView {


    Handler handler = new Handler();
    int img[] = {R.drawable.main1,R.drawable.main2,R.drawable.main3};
    public ThreadAnimationView(Context context) {
        super(context);
        init(context);
    }

    public ThreadAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        ImageThread thread = new ImageThread();
        thread.start();



    }

    class ImageThread extends Thread {
        boolean running = false;
        int index = 0;
        public void run() {
            running = true;

            while(running) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setImageResource(img[index]);
                    }
                });

                try{
                    Thread.sleep(1000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                index++;
                if(index > 2) {
                    index = 0;
                }
            }
        }
    }
}
