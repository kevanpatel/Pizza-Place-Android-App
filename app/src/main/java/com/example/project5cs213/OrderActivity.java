package com.example.project5cs213;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private ListView orderListView;
    private Order order;

    private TextView subtotal;
    private TextView salesTaxLabel;
    private TextView ordertotal;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.store_view);

        orderListView = findViewById(R.id.orderListView);

        Intent intent = getIntent();

        order = (Order) intent.getSerializableExtra("curOrder");

        List<String> your_array_list = new ArrayList<String>();

        for (Pizza p : order.pizzas) {
            your_array_list.add(p.toString());
            }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );
        orderListView.setAdapter(arrayAdapter);


        subtotal = findViewById(R.id.subtotalText);
        salesTaxLabel = findViewById(R.id.salesTaxText);
        ordertotal = findViewById(R.id.ordertotal);

        subtotal.setText(String.format("%,.2f", order.getTotal()));
        salesTaxLabel.setText(String.format("%,.2f", order.getSalesTax()));
        ordertotal.setText(String.format("%,.2f", order.getOrderTotal()));

        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                your_array_list.remove(position);
                order.remove(position);
                arrayAdapter.notifyDataSetChanged();
                subtotal.setText(String.format("%,.2f", order.getTotal()));
                salesTaxLabel.setText(String.format("%,.2f", order.getSalesTax()));
                ordertotal.setText(String.format("%,.2f", order.getOrderTotal()));
            }
        });
    }

    public void onButtonClick(View view) {



        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("curOrder",  order);
        setResult(RESULT_OK, intent);
        finish();
    }
}
