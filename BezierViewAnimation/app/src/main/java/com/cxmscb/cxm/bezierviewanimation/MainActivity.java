package com.cxmscb.cxm.bezierviewanimation;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton) findViewById(R.id.imagebtn);
    }

    public void onImgClick(View view) {
        ViewPath path = new ViewPath(); //偏移坐标
        path.moveTo(0,0);
        path.lineTo(0,500);
         path.curveTo(-300,200,-600,800,-800,400);
        path.lineTo(-800,100);

        ObjectAnimator anim = ObjectAnimator.ofObject(this,"fabLoc",new ViewPathEvaluator(),path.getPoints().toArray());
        anim.setInterpolator(new AccelerateDecelerateInterpolator());

        anim.setDuration(3000);
        anim.start();

    }


    public void setFabLoc(ViewPoint newLoc){
        imageButton.setTranslationX(newLoc.x);
        imageButton.setTranslationY(newLoc.y);
    }
}
