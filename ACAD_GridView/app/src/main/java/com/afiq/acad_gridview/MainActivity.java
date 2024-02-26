package com.afiq.acad_gridview;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView coursesGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel("Operating System", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Data Structure", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("CyberSecurity", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Native Programming", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Web Development", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Mobile Application Development", R.drawable.ic_launcher_background));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
    }
}
