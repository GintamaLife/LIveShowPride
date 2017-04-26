package com.marong.apple.liveshowpride;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.security.Provider;
import java.util.ArrayList;

import lib.homhomlib.view2.DivergeView;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private DivergeView divergeView;
    private ImageView iv_start;
    private ArrayList<Bitmap> mList;
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
        divergeView = (DivergeView) findViewById(R.id.divergeView);
        iv_start = (ImageView) findViewById(R.id.iv_start);
        mList = new ArrayList<>();
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm2, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm3, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm4, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm5, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm6, null)).getBitmap());
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex == 5){
                    mIndex = 0 ;
                }
                divergeView.startDiverges(mIndex);
                mIndex++;

            }
        });
        divergeView = (DivergeView) findViewById(R.id.divergeView);
        divergeView.post(new Runnable() {
            @Override
            public void run() {
                divergeView.setEndPoint(new PointF(divergeView.getMeasuredWidth()/2,0));
                divergeView.setDivergeViewProvider(new Provider());
            }
        });

    }


    class Provider implements DivergeView.DivergeViewProvider {

        @Override
        public Bitmap getBitmap(Object obj) {
            return mList == null ? null : mList.get((int) obj);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mList != null) {
            mList.clear();
            mList = null;
        }
    }

}
