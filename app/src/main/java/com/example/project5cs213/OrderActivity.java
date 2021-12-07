package com.example.project5cs213;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    /**
     * create variables
     */
    private ListView orderListView;
    private static Order order;

    private TextView subtotal;
    private TextView salesTaxLabel;
    private TextView ordertotal;
    private TextView orderCustomerNumberView;

    private static final int updatecode = 9;
    private static final int paycode = 10;
    private TextView getNumber;

    /**
     * code to be executed on creation
     * @param savedInstanceState to be saved
     */
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
        setTitle("Orders");


        subtotal = findViewById(R.id.subtotalText);
        salesTaxLabel = findViewById(R.id.salesTaxText);
        ordertotal = findViewById(R.id.ordertotal);
     //   orderCustomerNumberView = findViewById(R.id.orderCustomerNumberView);

        subtotal.setText(String.format("%,.2f", order.getTotal()));
        salesTaxLabel.setText(String.format("%,.2f", order.getSalesTax()));
        ordertotal.setText(String.format("%,.2f", order.getOrderTotal()));


        getNumber =  findViewById(R.id.phoneNumberText);
        String number = intent.getStringExtra("phonenumber");
        getNumber.setText(number);

        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * code to be executed on item click
             * @param parent to be grabbed
             * @param view to be shown
             * @param position of edits
             * @param id of items
             */
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
    /**
     * code to be executed when updating order
     * @param view
     */
    public void updateOrder(View view) {
        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("curOrder",  order);
        setResult(updatecode, intent);
        finish();
    }

    /**
     * code to be executed on button click
     * @param view
     */
    public void onButtonClick(View view) {
        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("curOrder",  order);
        setResult(paycode, intent);
        finish();
    }
}
