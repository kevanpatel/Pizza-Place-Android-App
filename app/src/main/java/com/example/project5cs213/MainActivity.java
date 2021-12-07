package com.example.project5cs213;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * class that runs the main page of the app
 */
public class MainActivity extends AppCompatActivity {
    /**
     * creating variables
     */
    private static final int PIZZAEDIT_ACTIVITY_REQUEST_CODE = 0;
    private static final int ORDERACTIVITY_ACTIVITY_REQUEST_CODE = 1;
    private static final int STOREORDER_ACTIVITY_REQUEST_CODE = 2;
    private static final int updatecode = 9;
    private static final int paycode = 10;
    private EditText editTextPhone;
    private  Order curOrder = new Order();
    private static StoreOrders storeOrders = new StoreOrders();
    protected ArrayList<Order> unpaidOrders = new ArrayList<Order>();
    private static Pizza curPizza;
    private static long curPhoneNumber;

    /**
     * code to run when project is run
     * @param savedInstanceState being held/created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPhone = findViewById(R.id.editTextPhone);
        setTitle("Pizza Parlor Main Menu");

    }

    /**
     * When creating a deluxe pizza
     * @param view to be used
     */

    public void onDeluxeClick(View view){
        if(editTextPhone.getText().toString().equals("") ||editTextPhone.getText().toString().length()!=10 ){
            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.invalid_Number) ,Toast.LENGTH_SHORT).show();
            return;

        }
        if(curOrder== null || curPhoneNumber!=Long.parseLong( editTextPhone.getText().toString())){
            curPhoneNumber =Long.parseLong( editTextPhone.getText().toString());
            curOrder=new Order();
            curOrder.setPhoneNumber(editTextPhone.getText().toString());
        }

        Intent intent = new Intent(this, PizzaEditActivity.class);
        String pizzaType = "deluxe";
        intent.putExtra("phonenumber",editTextPhone.getText().toString());

        intent.putExtra("PIZZA", pizzaType);
        if(editTextPhone.getText()!=null){
            if(numberChecker(editTextPhone.getText().toString()))
                startActivityForResult(intent, PIZZAEDIT_ACTIVITY_REQUEST_CODE);
        }
    }

    /**
     * When creating a hawaiian pizza
     * @param view to be used
     */
    public void onHawaiianClick(View view){
        if(editTextPhone.getText().toString().equals("") ||editTextPhone.getText().toString().length()!=10 ){
            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.invalid_Number) ,Toast.LENGTH_SHORT).show();
            return;

        }
        if(curOrder== null || curPhoneNumber!=Long.parseLong( editTextPhone.getText().toString())){
            curPhoneNumber =Long.parseLong( editTextPhone.getText().toString());
            curOrder=new Order();
            curOrder.setPhoneNumber(editTextPhone.getText().toString());
        }
        Intent intent = new Intent(this, PizzaEditActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("phonenumber",editTextPhone.getText().toString());

        intent.putExtra("PIZZA", pizzaType);
        if(editTextPhone.getText()!=null) {
            if (numberChecker(editTextPhone.getText().toString()))
                startActivityForResult(intent, PIZZAEDIT_ACTIVITY_REQUEST_CODE);
        }
        }


    /**
     * When creating a pepperoni pizza
     * @param view to be used
     */
    public void onPepperoniClick(View view){
        if(editTextPhone.getText().toString().equals("") ||editTextPhone.getText().toString().length()!=10 ){
            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.invalid_Number) ,Toast.LENGTH_SHORT).show();
            return;

        }
        if(curOrder== null || curPhoneNumber!=Long.parseLong( editTextPhone.getText().toString())){
            curPhoneNumber =Long.parseLong( editTextPhone.getText().toString());
            curOrder=new Order();
            curOrder.setPhoneNumber(editTextPhone.getText().toString());
        }
        Intent intent = new Intent(this, PizzaEditActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        if(editTextPhone.getText()!=null){
        if(numberChecker(editTextPhone.getText().toString()))
            startActivityForResult(intent, PIZZAEDIT_ACTIVITY_REQUEST_CODE);
            }
    }

    /**
     * When user hits Current order button
     * @param view to be used
     */
    public void onCurrentOrderClick(View view){

        if(unpaidOrders== null){

            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.no_existing_orders),Toast.LENGTH_SHORT).show();
            return;

        }
        else {

            for(Order o : unpaidOrders){
                if(o.getPhoneNumber().equals(editTextPhone.getText().toString())){
                    Intent intent = new Intent(this, OrderActivity.class);

                    intent.putExtra("phonenumber",editTextPhone.getText().toString());

                    intent.putExtra("curOrder", o);
                    intent.putExtra("phoneNumber", o.getPhoneNumber());
                            startActivityForResult(intent, ORDERACTIVITY_ACTIVITY_REQUEST_CODE);

                    return;
                }
            }
            Toast.makeText(getApplicationContext(),"No matching orders" ,Toast.LENGTH_SHORT).show();


        }

    }

    /**
     * When checking all orders made
     * @param view to be used
     */
    public void onStoreOrderClick(View view){
        if(storeOrders== null){
            Toast.makeText(getApplicationContext(),"No store orders" ,Toast.LENGTH_SHORT).show();
            return;
        }else{
        Intent intent = new Intent(this, StoreOrderActivity.class);

        intent.putExtra("StoreOrder", storeOrders);
        startActivityForResult(intent, STOREORDER_ACTIVITY_REQUEST_CODE);
        }
    }

    /**
     * checks if number length of phone is correct
     * @param t to be checked
     * @return true if correct/false if not
     */
    public boolean numberChecker(String t){
        String num =  t;
        if(num.length() == 10){
            return true;
        }
        else {
            Toast.makeText(getApplicationContext(),getApplicationContext().getString((R.string.invalid_Number)),Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    /**
     * method that holds and gives information based on user input
     * @param requestCode to be used
     * @param resultCode given back
     * @param data used
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == PIZZAEDIT_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                curPizza = (Pizza) data.getSerializableExtra("curPizza");
                curOrder.add(curPizza);
                curOrder.setPhoneNumber(editTextPhone.getText().toString());
                if(unpaidOrders.isEmpty()){
                    unpaidOrders.add(curOrder);

                }
                Iterator<Order> iterator = unpaidOrders.iterator();
                while(iterator.hasNext()){
                    Order order = iterator.next();

                    if(order.getPhoneNumber().equals(curOrder.getPhoneNumber())){
                        iterator.remove();
                        unpaidOrders.add(curOrder);
                        Toast.makeText(getApplicationContext(),getApplicationContext().getText(R.string.order_added),Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                if(unpaidOrders.contains(curOrder)==false){
                    unpaidOrders.add(curOrder);
                }

            }

        }
        if (requestCode == ORDERACTIVITY_ACTIVITY_REQUEST_CODE) {
            if (resultCode == updatecode) {

                // Get String data from Intent
                curOrder = (Order) data.getSerializableExtra("curOrder");

                if(unpaidOrders.isEmpty()){
                    unpaidOrders.add(curOrder);

                }
                Iterator<Order> iterator = unpaidOrders.iterator();
                while(iterator.hasNext()){
                    Order order = iterator.next();

                    if(order.getPhoneNumber().equals(curOrder.getPhoneNumber())){
                        iterator.remove();
                        unpaidOrders.add(curOrder);
                        Toast.makeText(getApplicationContext(),getApplicationContext().getText(R.string.order_updated),Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                if(unpaidOrders.contains(curOrder)==false){
                    unpaidOrders.add(curOrder);
                }


            }
            if(resultCode==paycode){
                curOrder = (Order) data.getSerializableExtra("curOrder");
                storeOrders.addOrder(curOrder);
            }
        }
        try{
        if (requestCode == STOREORDER_ACTIVITY_REQUEST_CODE) {
            storeOrders = (StoreOrders) data.getSerializableExtra("curStoreOrder");

        }}catch(Exception e){

        }
    }
}