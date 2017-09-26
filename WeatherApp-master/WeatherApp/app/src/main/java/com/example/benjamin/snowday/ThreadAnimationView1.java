package com.example.benjamin.snowday;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by 박정철 on 2015-09-07.
 */
public class ThreadAnimationView1 extends ImageView {


    Handler handler = new Handler();
    int img[] = {R.drawable.num3,R.drawable.num1,R.drawable.num2,R.drawable.num4,R.drawable.num5};
    public ThreadAnimationView1(Context context) {
        super(context);
        init(context);
    }

    public ThreadAnimationView1(Context context, AttributeSet attrs) {
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
                    Thread.sleep(550);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                index++;
                if(index > 4) {
                    index = 0;
                }
            }
        }
    }
}
