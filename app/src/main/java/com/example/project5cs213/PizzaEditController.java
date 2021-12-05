//package com.example.project5cs213;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.event.ActionEvent;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
///**
// * @author Kevan Patel
// * @author Manav Patel
// */
//
///**
// * Controller class for the gui that lets you edit your pizza
// */
//public class PizzaEditController {
//    /**
//     * initializing variables
//     */
//    private MainController stage;
//    private String flavour = "Deluxe";
//    @FXML
//    private ImageView pizzaImage;
//    @FXML
//    private CheckBox BlackOlives;
//    @FXML
//    private CheckBox Ham;
//    @FXML
//    private CheckBox Mushroom;
//    @FXML
//    private CheckBox Onion;
//    @FXML
//    private CheckBox Pepper;
//    @FXML
//    private CheckBox Pepperoni;
//    @FXML
//    private CheckBox Pineapple;
//    @FXML
//    private CheckBox Sausage;
//    @FXML
//    private ComboBox<String> sizeCombo;
//    @FXML
//    private TextField pizzaPrice;
//    @FXML
//    private Button pizzaIdentity;
//    private static double roundHundredPlace=100.0;
//    private static double deluxeHolderPrice=12.99;
//    private static double hawaiianHolderPrice=10.99;
//    private static double pepperoniHolderPrice=8.99;
//    PizzaMaker pizzaMaker = new PizzaMaker();
//
//    /**
//     * method to set the imageview based on the pizza that was clicked on the mainmenu
//     *
//     * @param type of pizza we are going to be using
//     */
//    @FXML
//    public void setPizza(String type) {
//        Image pizza = new Image("file:src/main/resources/com/example/project4cs213/deluxepizza.jpg");
//        pizzaIdentity.setText("Order Deluxe");
//        if (type.equals("Pepperoni")) {
//            pizza = new Image("file:src/main/resources/com/example/project4cs213/pepperonipizza.jpg");
//            pizzaIdentity.setText("Order Pepperoni");
//        }
//        if (type.equals("Hawaiian")) {
//            pizza = new Image("file:src/main/resources/com/example/project4cs213/hawaiianpizza.jpg");
//            pizzaIdentity.setText("Order Hawaiian");
//        }
//        pizzaImage.setImage(pizza);
//    }
//
//    /**
//     * set the new stage to be launched
//     *
//     * @param stage to set
//     */
//    public void setMainController(MainController stage) {
//        this.stage = stage;
//    }
//
//    /**
//     * counter for toppings
//     */
//    @FXML
//    private void counter() {
//        int count = 0;
//        if (Pepperoni.isSelected()) {
//            count++;
//        }
//        if (Onion.isSelected()) {
//            count++;
//        }
//        if (Pepper.isSelected()) {
//            count++;
//        }
//        if (Sausage.isSelected()) {
//            count++;
//        }
//        if (Mushroom.isSelected()) {
//            count++;
//        }
//        if (BlackOlives.isSelected()) {
//            count++;
//        }
//        if (Ham.isSelected()) {
//            count++;
//        }
//        if (Pineapple.isSelected()) {
//            count++;
//        }
//        if(count>=7){
//            if(!Pineapple.isSelected()){
//                Pineapple.setDisable(true);
//            }
//            if (!Ham.isSelected()){
//                Ham.setDisable(true);
//            }
//            if (!Pepperoni.isSelected()){
//                Pepperoni.setDisable(true);
//            }
//            if (!BlackOlives.isSelected()){
//                BlackOlives.setDisable(true);
//            }
//            if (!Mushroom.isSelected()){
//                Mushroom.setDisable(true);
//            }
//            if (!Onion.isSelected()){
//                Onion.setDisable(true);
//            }
//            if (!Sausage.isSelected()){
//                Sausage.setDisable(true);
//            }
//            if (!Pepper.isSelected()){
//                Ham.setDisable(true);
//            }
//        }
//        else {
//            Pineapple.setDisable(false);
//            Ham.setDisable(false);
//            BlackOlives.setDisable(false);
//            Mushroom.setDisable(false);
//            Onion.setDisable(false);
//            Pepperoni.setDisable(false);
//            Pepper.setDisable(false);
//            Sausage.setDisable(false);
//        }
//    }
//
//
//    /**
//     * method to add the selected pizza with parameters to the order
//     *
//     * @param actionEvent that triggers the add
//     */
//    public void addPizza(ActionEvent actionEvent) {
//        try {
//            Pizza temp = pizzaMaker.createPizza(this.flavour);
//            addSize(temp);
//            addToppings(temp);
//            stage.addPizza(temp);
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Successfully Added");
//            alert.setHeaderText("The pizza you created has been added");
//            alert.showAndWait();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Pizza addToppings(Pizza pizza) {
//        if (Pepperoni.isSelected()) {
//            pizza.toppings.add(Topping.Pepperoni);
//        }
//        if (Onion.isSelected()) {
//            pizza.toppings.add(Topping.Onion);
//        }
//        if (Pepper.isSelected()) {
//            pizza.toppings.add(Topping.Pepper);
//        }
//        if (Sausage.isSelected()) {
//            pizza.toppings.add(Topping.Sausage);
//        }
//        if (Mushroom.isSelected()) {
//            pizza.toppings.add(Topping.Mushroom);
//        }
//        if (BlackOlives.isSelected()) {
//            pizza.toppings.add(Topping.BlackOlives);
//        }
//        if (Ham.isSelected()) {
//            pizza.toppings.add(Topping.Ham);
//
//        }
//        if (Pineapple.isSelected()) {
//            pizza.toppings.add(Topping.Pineapple);
//        }
//
//        return pizza;
//    }
//
//
//    /**
//     * command to set the type of pizza being set in
//     *
//     * @param orderType
//     */
//    public void pizzaType(String orderType) {
//
//        if (orderType.equals("Deluxe")) {
//            sizeCombo.setValue("Small");
//            selectSize();
//            pizzaPrice.setText(deluxeHolderPrice + " ");
//            flavour = "Deluxe";
//            Pepperoni.setSelected(true);
//            Onion.setSelected(true);
//            Pepper.setSelected(true);
//            Sausage.setSelected(true);
//            Mushroom.setSelected(true);
//
//
//        } else if (orderType.equals("Hawaiian")) {
//            sizeCombo.setValue("Small");
//            flavour = "Hawaiian";
//
//            selectSize();
//            pizzaPrice.setText(hawaiianHolderPrice + " ");
//
//            Ham.setSelected(true);
//            Pineapple.setSelected(true);
//        } else if (orderType.equals("Pepperoni")) {
//            sizeCombo.setValue("Small");
//            flavour = "Pepperoni";
//
//            selectSize();
//            pizzaPrice.setText(pepperoniHolderPrice + " ");
//
//            Pepperoni.setSelected(true);
//        }
//    }
//
//
//    /**
//     * method to add size of pizza
//     * @param pizza to get size added
//     * @return Pizza with size
//     */
//    public Pizza addSize(Pizza pizza) {
//        if (sizeCombo.getValue() != null || pizzaPrice != null) {
//            counter();
//
//            String size = sizeCombo.getValue();
//
//            switch (size) {
//                case "Small":
//                    pizza.setSize(Size.small);
//                    break;
//                case "Medium":
//                    pizza.setSize(Size.medium);
//                    break;
//                case "Large":
//                    pizza.setSize(Size.large);
//                    break;
//            }
//        }
//
//    return pizza;
//    }
//
//    /**
//     * method to show price of pizza based on size and toppings
//     */
//    public void selectSize() {
//        if (sizeCombo.getValue() != null || pizzaPrice != null) {
//            counter();
//
//            Pizza temp = pizzaMaker.createPizza(this.flavour);
//            addSize(temp);
//            addToppings(temp);
//            pizzaPrice.setText(String.valueOf(Math.round(temp.price() * roundHundredPlace) / roundHundredPlace));
//
//
//        }
//
//
//    }
//
//
//}
