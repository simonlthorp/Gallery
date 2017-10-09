package com.example.simon.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    private Button buttonSearch;
    private Button buttonTag;
    private Button buttonSnap;

    private final String image_titles[] = {
            "Img1",
            "Img2",
            "Img3",
            "Img4",
            "Img5",
            "Img6",
            "Img7",
            "Img8",
            "Img9",
            "Img10",
            "Img11",
    };

    private final Integer image_ids[] = {
            R.drawable.thumb_saturn_eclipse,
            R.drawable.thumb_squish_bed,
            R.drawable.thumb_squish_bridge,
            R.drawable.thumb_squish_car,
            R.drawable.thumb_squish_car,
            R.drawable.thumb_squish_log,
            R.drawable.thumb_squish_table,
            R.drawable.thumb_squish_tractor,
            R.drawable.thumb_squish_trail,
            R.drawable.thumb_squish_view,
            R.drawable.thumb_squish_work,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);

        buttonSearch = (Button)findViewById(R.id.buttonSearch);
        buttonTag = (Button)findViewById(R.id.buttonTag);
        buttonSnap = (Button)findViewById(R.id.buttonSnap);

    }

    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theImage = new ArrayList<>();

        for (int i = 0; i < image_titles.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_id(image_ids[i]);
            theImage.add(createList);
        }
        return theImage;

    }

    public void setButtonSearch(View view){

        Intent intent = new Intent(this, Search.class);
        startActivity(intent);

    }

}
