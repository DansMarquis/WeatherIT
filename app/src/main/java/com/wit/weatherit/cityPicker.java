package com.wit.weatherit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class cityPicker extends AppCompatActivity {
    String[] cities = { "Berlin",
                        "Copenhagen",
                        "Dublin",
                        "Lisbon",
                        "London",
                        "Madrid",
                        "Paris",
                        "Prague",
                        "Rome",
                        "Vienna"};

    Integer[] citiesIcon = {    R.drawable.berlim,
                                R.drawable.copenhaga,
                                R.drawable.dublin,
                                R.drawable.lisboa,
                                R.drawable.londres,
                                R.drawable.madrid,
                                R.drawable.paris,
                                R.drawable.praga,
                                R.drawable.roma,
                                R.drawable.viena };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker);

        ImageView backButton=findViewById(R.id.backButtonPicker);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CityListAdapter adapter=new CityListAdapter(this, cities, citiesIcon);

        ListView listView = (ListView) findViewById(R.id.city_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String newCity = (String) parent.getItemAtPosition(position);
                System.out.println("--------------------------------------Inside Picker Clicked: "+newCity);
                Intent intent=new Intent(cityPicker.this, MainActivity.class);
                intent.putExtra("City",newCity);
                startActivity(intent);
            }
        });

    }
}