package com.example.project5cs213;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PIZZAEDIT_ACTIVITY_REQUEST_CODE = 0;
    private static final int ORDERACTIVITY_ACTIVITY_REQUEST_CODE = 1;


    private EditText editTextPhone;

    private static Order curOrder = new Order();
    private static StoreOrders storeOrders = new StoreOrders();

    private static Pizza curPizza;
    private static int curPhoneNumber;

    private static int lengthPhoneNumber=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPhone = findViewById(R.id.editTextPhone);

    }

    public void onDeluxeClick(View view){
        Intent intent = new Intent(this, PizzaEditActivity.class);
        String pizzaType = "deluxe";
        intent.putExtra("PIZZA", pizzaType);
        if(editTextPhone.getText()!=null){
            if(numberChecker(editTextPhone.getText().toString()))
                startActivityForResult(intent, PIZZAEDIT_ACTIVITY_REQUEST_CODE);
        }
    }

    public void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaEditActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        if(editTextPhone.getText()!=null){
            if(numberChecker(editTextPhone.getText().toString()))
                startActivityForResult(intent, PIZZAEDIT_ACTIVITY_REQUEST_CODE);
        }
    }

    public void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaEditActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        if(editTextPhone.getText()!=null){
        if(numberChecker(editTextPhone.getText().toString()))
            startActivityForResult(intent, PIZZAEDIT_ACTIVITY_REQUEST_CODE);
            }
    }

    public void onCurrentOrderClick(View view){

        if(curOrder==null){
            Toast.makeText(getApplicationContext(),"No pizza selected" ,Toast.LENGTH_SHORT).show();

        }
        else if(!numberChecker(editTextPhone.getText().toString())){
        }
        else{
            curPhoneNumber=  Integer.parseInt(editTextPhone.getText().toString());

            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("curOrder", curOrder);
            intent.putExtra("phoneNumber", curPhoneNumber);

            if(editTextPhone.getText()!=null){
                if(numberChecker(editTextPhone.getText().toString()))
                    startActivityForResult(intent, ORDERACTIVITY_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    public boolean numberChecker(String t){
        String num =  t;
        if(num.length() == 10){
            return true;
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid Phone Number " + num.length(),Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == PIZZAEDIT_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                curPizza = (Pizza) data.getSerializableExtra("curPizza");
                curOrder.add(curPizza);

            }
        }
        if (requestCode == ORDERACTIVITY_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                curOrder = (Order) data.getSerializableExtra("curOrder");
                storeOrders.addOrder(curOrder);
            }
        }
    }
}