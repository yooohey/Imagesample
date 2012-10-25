package com.example.imagesample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.ImageView;
import android.content.res.Resources;

public class Test03_01 extends Activity
{
    private final int FP = ViewGroup.LayoutParams.FILL_PARENT; 
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT; 

    @Override protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        setContentView(linearLayout);

        Resources r = getResources();
        Bitmap bmp1 = BitmapFactory.decodeResource(r, R.drawable.sample1);
        //Bitmap bmp2 = BitmapFactory.decodeResource(r, R.drawable.back);
        //Bitmap bmp3 = BitmapFactory.decodeResource(r, R.drawable.back);
        
        Bitmap b = bmp1.copy(Bitmap.Config.ARGB_8888, true);  
        
        int dot = 8;  
        // ピクセルデータ分ループ  
        for (int i=0;i<b.getWidth()/dot;i++) {  
            for (int j=0;j<b.getHeight()/dot;j++){  
                int color = bmp1.getPixel(i, j);  
                  
                // ドットの中の平均値を使う  
                int rr = 0;  
                int gg = 0;  
                int bb = 0;  
                for (int k=0;k<dot;k++) {  
                    for (int l=0;l<dot;l++){  
                        int dotColor = bmp1.getPixel(i*dot+k, j*dot+l);  
                        rr += Color.red(dotColor);  
                        gg += Color.green(dotColor);  
                        bb += Color.blue(dotColor);  
                    }  
                }  
                rr = rr/(dot*dot);  
                gg = gg/(dot*dot);  
                bb = bb/(dot*dot);  
                  
                for (int k=0;k<dot;k++) {  
                    for (int l=0;l<dot;l++){  
                        b.setPixel(i*dot+k, j*dot+l, Color.rgb(rr, gg, bb));  
                    }  
                }  
            }  
        } 
        
        //LinearLayout tv = (LinearLayout) findViewById(R.id.view1);
        //tv.addView(image1);
        
        //ImageView image1 = new ImageView(this);
        //image1.setImageBitmap(b);
        //linearLayout.addView(image1, createParam(WC, WC));
               
     
    }
    
    

    private LinearLayout.LayoutParams createParam(int w, int h){
        return new LinearLayout.LayoutParams(w, h);
    }
    
}
