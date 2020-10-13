package com.mark.oo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import io.github.kbiakov.codeview.classifier.CodeProcessor;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CodeProcessor.init(this);
        bottomNavigationView = findViewById(R.id.BottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);
        SetFragment(new MkwnatFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.mkwnat:
                        SetFragment(new MkwnatFragment());
                        return true;
                    case R.id.msharea:
                        SetFragment(new Msharea());
                        return true;
                    case R.id.contactus:
                        SetFragment(new ContactUs());
                        return true;
                    default:
                        return false;
                }


            }
        });
    }

    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
