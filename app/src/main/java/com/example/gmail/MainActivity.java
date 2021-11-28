package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList <Row> arrayMsg;
    Faker arrayData[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listMail);
        arrayMsg = new ArrayList<>();

        arrayData = new Faker[11];

        for (int i = 1; i <= 10; i++){
            arrayData[i] = new Faker();
            arrayMsg.add(new Row(arrayData[i].name.name(), arrayData[i].lorem.sentence()));
        }

        AdapterRow ad = new AdapterRow(this, R.layout.row, arrayMsg);
        listView.setAdapter(ad);

    }
}