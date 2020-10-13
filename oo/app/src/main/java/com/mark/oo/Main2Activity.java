package com.mark.oo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import io.github.kbiakov.codeview.CodeView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.analytics.FirebaseAnalytics;

public class Main2Activity extends AppCompatActivity {
    private ImageView imageView;
    private TextView mytextView;
    private TextView mytext2View;
    private PhotoView imageView2;
    private CodeView codeView;
    private TextView enwan1;
    private TextView enwan2;
    private TextView tfasel2j;
    private TextView enwan3;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        }
        getids();

    }

    private void getids() {
        imageView = findViewById(R.id.imageView);
        mytextView = findViewById(R.id.image);
        mytext2View = findViewById(R.id.tfasel);
        tfasel2j = findViewById(R.id.tfasel2);
        codeView = findViewById(R.id.code_view);
        imageView2 = findViewById(R.id.imageView2);
        enwan1 = findViewById(R.id.enwan1);
        enwan2 = findViewById(R.id.enwan2);
        enwan3 = findViewById(R.id.enwan3);

        String name = getIntent().getStringExtra("text");
        int image = getIntent().getIntExtra("image", 0);
        String name2 = getIntent().getStringExtra("text2");
        String code3 = getIntent().getStringExtra("code3");
        int image2 = getIntent().getIntExtra("image2", 0);
        int type = getIntent().getIntExtra("type", 0);
        String tfasel2 = getIntent().getStringExtra("name");
        int array = getIntent().getIntExtra("array", 0);
        imageView.setImageResource(image);
        mytextView.setText(name);
        mytext2View.setText(name2);
        codeView.setCode(code3);
        imageView2.setImageResource(image2);

        if (type == 1) {
            enwan1.setText("تفاصيل " + code3);
            codeView.setVisibility(View.GONE);
            enwan2.setText("أنواع " + code3);
            tfasel2j.setText(tfasel2);
            enwan3.setVisibility(View.GONE);
        }
        if (type == 0) {
            tfasel2j.setVisibility(View.GONE);

        }
    }
}
