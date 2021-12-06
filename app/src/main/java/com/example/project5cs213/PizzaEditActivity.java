package com.example.project5cs213;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaEditActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageView pizzaImage;

    private CheckBox BlackOlives;
    private CheckBox Ham;
    private CheckBox Mushroom;
    private CheckBox Onion;
    private CheckBox Pepper;
    private CheckBox Pepperoni;
    private CheckBox Pineapple;
    private CheckBox Sausage;

    private Spinner sizeSelect;

    String[] sizes={"Small","Medium","large"};

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







        //spinner
        sizeSelect = findViewById(R.id.sizeSelect);
        sizeSelect.setOnItemSelectedListener (this);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sizes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sizeSelect.setAdapter(aa);




        if(pizzaType.equals("deluxe")){
            pizzaImage.setImageResource(R.drawable.deluxepizza);
        } else if(pizzaType.equals("hawaiian")){
            pizzaImage.setImageResource(R.drawable.hawaiianpizza);
        } else if(pizzaType.equals("pepperoni")){
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




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), sizes[i], Toast.LENGTH_LONG).show();
        counter(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}
