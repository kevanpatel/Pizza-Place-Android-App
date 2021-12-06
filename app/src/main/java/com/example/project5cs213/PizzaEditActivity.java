package com.example.project5cs213;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaEditActivity extends AppCompatActivity {

    private ImageView pizzaImage;

    private CheckBox BlackOlives;
    private CheckBox Ham;
    private CheckBox Mushroom;
    private CheckBox Onion;
    private CheckBox Pepper;
    private CheckBox Pepperoni;
    private CheckBox Pineapple;
    private CheckBox Sausage;

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


        if(pizzaType.equals("deluxe")){
            pizzaImage.setImageResource(R.drawable.deluxepizza);
        } else if(pizzaType.equals("hawaiian")){
            pizzaImage.setImageResource(R.drawable.hawaiianpizza);
        } else if(pizzaType.equals("pepperoni")){
            pizzaImage.setImageResource(R.drawable.pepperonipizza);
        }
    }
    private void counter() {
        int count = 0;
        if (Pepperoni.isSelected()) {
            count++;
        }
        if (Onion.isSelected()) {
            count++;
        }
        if (Pepper.isSelected()) {
            count++;
        }
        if (Sausage.isSelected()) {
            count++;
        }
        if (Mushroom.isSelected()) {
            count++;
        }
        if (BlackOlives.isSelected()) {
            count++;
        }
        if (Ham.isSelected()) {
            count++;
        }
        if (Pineapple.isSelected()) {
            count++;
        }
        if(count>=7){
            if(!Pineapple.isSelected()){
                Pineapple.setEnabled(false);
            }
            if (!Ham.isSelected()){
                Ham.setEnabled(false);
            }
            if (!Pepperoni.isSelected()){
                Pepperoni.setEnabled(false);
            }
            if (!BlackOlives.isSelected()){
                BlackOlives.setEnabled(false);
            }
            if (!Mushroom.isSelected()){
                Mushroom.setEnabled(false);
            }
            if (!Onion.isSelected()){
                Onion.setEnabled(false);
            }
            if (!Sausage.isSelected()){
                Sausage.setEnabled(false);
            }
            if (!Pepper.isSelected()){
                Ham.setEnabled(false);
            }
        }
        else {
            Pineapple.setEnabled(false);
            Ham.setEnabled(false);
            BlackOlives.setEnabled(false);
            Mushroom.setEnabled(false);
            Onion.setEnabled(false);
            Pepperoni.setEnabled(false);
            Pepper.setEnabled(false);
            Sausage.setEnabled(false);
        }
    }


}
