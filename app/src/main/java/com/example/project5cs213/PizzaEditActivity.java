package com.example.project5cs213;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaEditActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageView pizzaImage;
    private TextView pizzaPrice;

    private CheckBox BlackOlives;
    private CheckBox Ham;
    private CheckBox Mushroom;
    private CheckBox Onion;
    private CheckBox Pepper;
    private CheckBox Pepperoni;
    private CheckBox Pineapple;
    private CheckBox Sausage;

    private Spinner sizeSelect;

    private static double roundHundredPlace=100.0;
    private static double deluxeHolderPrice=12.99;
    private static double hawaiianHolderPrice=10.99;
    private static double pepperoniHolderPrice=8.99;

    PizzaMaker pizzaMaker = new PizzaMaker();
    private String flavour = "Deluxe";
    Pizza curPizza;


    String[] sizes={"Small","Medium","Large"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pizza_order);



        Intent intent = getIntent();

        String pizzaType = intent.getStringExtra("PIZZA");

        //find all the ids
        pizzaImage = findViewById(R.id.pizzaImage);
        BlackOlives = findViewById(R.id.blackOlivesButton);
        Ham = findViewById(R.id.hamButton);
        Mushroom = findViewById(R.id.mushroomButton);
        Onion = findViewById(R.id.onionButton);
        Pepper = findViewById(R.id.pepperButton);
        Pepperoni = findViewById(R.id.pepperoniButton);
        Pineapple = findViewById(R.id.pineappleButton);
        Sausage = findViewById(R.id.sausageButton);

        pizzaPrice = findViewById(R.id.pizzaPrice);





        //spinner
        sizeSelect = findViewById(R.id.sizeSelect);
        sizeSelect.setOnItemSelectedListener (this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sizes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sizeSelect.setAdapter(aa);




        if(pizzaType.equals("deluxe")){
            flavour = "Deluxe";
            pizzaImage.setImageResource(R.drawable.deluxepizza);
        } else if(pizzaType.equals("hawaiian")){
            flavour = "Pepperoni";
            pizzaImage.setImageResource(R.drawable.hawaiianpizza);
        } else if(pizzaType.equals("pepperoni")){
            flavour = "Hawaiian";
            pizzaImage.setImageResource(R.drawable.pepperonipizza);
        }
    }
    public void counter(View view) {
        int count=0;
        if (Pepperoni.isChecked()) {
            count++;
        }

        if (Onion.isChecked()) {
            count++;
        }
        if (Pepper.isChecked()) {
            count++;

        }
        if (Sausage.isChecked()) {
            count++;
        }
        if (Mushroom.isChecked()) {
            count++;
        }
        if (BlackOlives.isChecked()) {
            count++;
        }
        if (Ham.isChecked()) {
            count++;
        }
        if (Pineapple.isChecked()) {
            count++;
        }
        if(count>=7){
            if(!Pineapple.isChecked()){
                Pineapple.setEnabled(false);
            }
            if (!Ham.isChecked()){
                Ham.setEnabled(false);
            }
            if (!Pepperoni.isChecked()){
                Pepperoni.setEnabled(false);
            }
            if (!BlackOlives.isChecked()){
                BlackOlives.setEnabled(false);
            }
            if (!Mushroom.isChecked()){
                Mushroom.setEnabled(false);
            }
            if (!Onion.isChecked()){
                Onion.setEnabled(false);
            }
            if (!Sausage.isChecked()){
                Sausage.setEnabled(false);
            }
            if (!Pepper.isChecked()){
                Pepper.setEnabled(false);
            }
        }
        else {
            Pineapple.setEnabled(true);
            Ham.setEnabled(true);
            BlackOlives.setEnabled(true);
            Mushroom.setEnabled(true);
            Onion.setEnabled(true);
            Pepperoni.setEnabled(true);
            Pepper.setEnabled(true);
            Sausage.setEnabled(true);
        }
    }


    public Pizza addToppings(Pizza pizza) {
        if (Pepperoni.isChecked()) {
            pizza.toppings.add(Topping.Pepperoni);
        }
        if (Onion.isChecked()) {
            pizza.toppings.add(Topping.Onion);
        }
        if (Pepper.isChecked()) {
            pizza.toppings.add(Topping.Pepper);
        }
        if (Sausage.isChecked()) {
            pizza.toppings.add(Topping.Sausage);
        }
        if (Mushroom.isChecked()) {
            pizza.toppings.add(Topping.Mushroom);
        }
        if (BlackOlives.isChecked()) {
            pizza.toppings.add(Topping.BlackOlives);
        }
        if (Ham.isChecked()) {
            pizza.toppings.add(Topping.Ham);

        }
        if (Pineapple.isChecked()) {
            pizza.toppings.add(Topping.Pineapple);
        }

        return pizza;
    }


    public void onButtonClick(View view) {



        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("curPizza", (Parcelable) curPizza);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Pizza temp = pizzaMaker.createPizza(this.flavour);

        if(i==0){
            temp.setSize(Size.small);
        }
        if(i==1){
            temp.setSize(Size.medium);
        }
        if(i==2){
            temp.setSize(Size.large);
        }
        addToppings(temp);
        curPizza= temp;
        pizzaPrice.setText(String.valueOf(Math.round(temp.price() * roundHundredPlace) / roundHundredPlace));

       // Toast.makeText(getApplicationContext(), sizes[i], Toast.LENGTH_LONG).show();
        //counter(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}
