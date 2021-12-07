package com.example.project5cs213;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StoreOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<String> phoneNumbers = new ArrayList<String>(); // Create an ArrayList object
    StoreOrders storeOrders;
    private Spinner spinner;
    private ListView listView;
    private static  int numSelected;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_view);
        Intent intent = getIntent();

        storeOrders = (StoreOrders) intent.getSerializableExtra("StoreOrder");

        for(Order o:storeOrders.orders){
            phoneNumbers.add(o.getPhoneNumber());
        }
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener (this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,phoneNumbers);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);

        listView = findViewById(R.id.orderDisplay);

        if(storeOrders==null){
            List<String> your_array_list = new ArrayList<String>();
            your_array_list.add("NO STORE ODERS");



            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    your_array_list );
            listView.setAdapter(arrayAdapter);
            setTitle("Orders");
        }

    }

    public void onButtonClick(View view) {

         storeOrders.orders.remove(numSelected);



        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("curStoreOrder",  storeOrders);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        numSelected= i;
        List<String> your_array_list = new ArrayList<String>();

        Order o = storeOrders.orders.get(i);

        for (Pizza p : o.pizzas) {
            your_array_list.add(p.toString());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );
        listView.setAdapter(arrayAdapter);
        setTitle("Orders");


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        List<String> your_array_list = new ArrayList<String>();


        for(Order o : storeOrders.orders){
        for (Pizza p : o.pizzas) {
            your_array_list.add(p.toString());
        }}

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );
        listView.setAdapter(arrayAdapter);
        setTitle("Orders");
    }
}