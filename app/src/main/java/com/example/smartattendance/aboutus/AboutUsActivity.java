package com.example.smartattendance.aboutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.smartattendance.Adapters.ViewpagerAdapter;
import com.example.smartattendance.Model.ItemModel;
import com.example.smartattendance.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AboutUsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewpagerAdapter adapter;
    private Button nextBtn;
    private List<ItemModel> arrItems;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        arrItems = new ArrayList<>();

        arrItems.add(new ItemModel(
                "Unity University – SCASS",
                "Smart Campus Attendance & Safety System (SCASS)\n"
                        + "MOBILE APPLICATION DEVELOPMENT MINI-PROJECT (COSC 4023)\n\n"
                        + "Prepared by:\n"
                        + "1. Dawit Jemil – UU92765R\n"
                        + "2. Yonatan Amare – UU93645R\n"
                        + "3. Naod MuluBirhan – UU93146R\n"
                        + "4. Leoul Endryas – UU94355R\n"
                        + "5. Moti Isreal – UU92559R\n\n"
                        + "SCASS is an Android prototype that integrates automated face-recognition attendance with essential campus safety tools.",
                R.raw.class_room));

        arrItems.add(new ItemModel(
                "Face-Recognition Attendance",
                "The system automatically identifies enrolled students using ML Kit and TensorFlow Lite, "
                        + "recording accurate and secure attendance for each class session.",
                R.raw.selfi));

        arrItems.add(new ItemModel(
                "Campus Safety Features",
                "SCASS includes an optional panic-alert system and incident reporting tool, enabling students to quickly notify campus authorities.",
                R.raw.class_test));

        arrItems.add(new ItemModel(
                "Efficient & Reliable",
                "The app reduces instructor workload, eliminates proxy attendance, and synchronizes data securely with cloud services while supporting offline operation.",
                R.raw.time_management));


        viewPager = findViewById(R.id.about_viewPager);
        nextBtn = findViewById(R.id.about_next_button);

        //viewpager setup
        adapter = new ViewpagerAdapter(this, arrItems);

        viewPager.setAdapter(adapter);

        //click listener on next button
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = viewPager.getCurrentItem();
                if (pos < arrItems.size()) {
                    pos++;
                    viewPager.setCurrentItem(pos);
                }
                if (pos == arrItems.size() - 1) {
                    //hide the tabLayout and next button and make visible the getStarted button
                    getLastScreen();
                }
            }
        });
    }

    private void getLastScreen() {
        nextBtn.setVisibility(View.INVISIBLE);
    }

}