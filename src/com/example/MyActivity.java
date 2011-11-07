package com.example;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LinearLayout frame = (LinearLayout) findViewById(R.id.frame);
        frame.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MyActivity.this, "frame: " + motionEvent.getX() + " - " + motionEvent.getY(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        MyWebViewFragement leftFragment = new MyWebViewFragement("http://www.google.com");
        ft.add(R.id.left, leftFragment);

        MyWebViewFragement rightFragment = new MyWebViewFragement("http://www.bing.com");
        ft.add(R.id.right, rightFragment);
        
        ft.commit();
    }
}
