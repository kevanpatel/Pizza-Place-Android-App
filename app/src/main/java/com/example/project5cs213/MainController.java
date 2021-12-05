package com.example.project4cs213;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

/**
 * Controller for the main menu of the gui
 */
public class MainController {
    /**
     * Create variables
     */

    private static Order curOrder = new Order();
    private static StoreOrders storeOrders = new StoreOrders();
    private static int lengthPhoneNumber=10;

    @FXML
    private TextField phoneNumber;

    /**
     * method to add Pizza to an order
     *
     * @param pizza
     */
    public void addPizza(Pizza pizza) {
        curOrder.add(pizza);

    }

    /**
     * method to add order to list of orders
     *
     * @param order       to be added to list
     * @param phoneNumber of the number being added
     */
    public void addOrder(Order order, String phoneNumber) {

        order.setPhoneNumber(phoneNumber);

        storeOrders.addOrder(order);

        curOrder = new Order();
    }

    /**
     * remove order from set
     *
     * @param phoneNumber to be removed
     */

    public void removeOrder(String phoneNumber) {
        storeOrders.remove(phoneNumber);
    }

    /**
     * getter method for store orders
     *
     * @return storeOrders
     */
    public StoreOrders getStoreOrders() {
        return storeOrders;
    }

    /**
     * method to open Order menu
     *
     * @param event that triggers the code
     */
    @FXML
    private void openOrderMenu(ActionEvent event) {
        if (curOrder == null || !(phoneNumber.getText().matches("[0-9]+") && phoneNumber.getText().length() == lengthPhoneNumber)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("No Order Available!");
            alert.setContentText("Please enter valid 10 digit phone-number with outstanding orders");
            alert.showAndWait();
            return;
        }
        if (storeOrders.isin(phoneNumber.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Phone in use");
            alert.setContentText("Please enter valid 10 digit phone-number with outstanding orders");
            alert.showAndWait();
            return;
        }
        if (!phoneNumber.getText().equals(curOrder.getPhoneNumber())) {
            curOrder = new Order();
        }
        if (curOrder != null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ProgressOrderView.fxml"));
                Parent tableViewParent = loader.load();
                Scene tableViewScene = new Scene(tableViewParent);

                //access the controller and call a method
                OrderController orderController = loader.getController();

                orderController.setMainController(this);
                orderController.init(curOrder);
                orderController.setNumber(phoneNumber.getText());

                //This line gets the Stage information
                Stage window = new Stage();
                window.setTitle("Order in Progress");
                window.setScene(tableViewScene);
                window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Unknown Error!");
            alert.setContentText("Unexpected error has occured.");
            alert.showAndWait();

        }
    }

    /**
     * method to open Store order menu
     *
     * @param event that triggers this event
     */
    @FXML
    private void openStoreOrderMenu(ActionEvent event) {

        if (storeOrders != null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("OrderFromStoreView.fxml"));
                Parent tableViewParent = loader.load();
                Scene tableViewScene = new Scene(tableViewParent);

                //access the controller and call a method
                StoreOrderController storeOrderController = loader.getController();
                storeOrderController.setMainController(this);


                storeOrderController.init(storeOrders);

                //This line gets the Stage information
                Stage window = new Stage();
                window.setTitle("All Orders");
                window.setScene(tableViewScene);
                window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //make an alert here

        }
    }

    /**
     * method to open Deluxe menu editor
     *
     * @param event that triggers the code
     */
    @FXML
    private void openDeluxeOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizza");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        if (!(phoneNumber.getText().matches("[0-9]+") && phoneNumber.getText().length() == lengthPhoneNumber)) {
            alert.setTitle("Alert!");
            alert.setHeaderText("Phone number is invalid");
            alert.setContentText("Please fix this issue before moving on!");
            alert.showAndWait();
            return;
        }
        if (storeOrders.isin(phoneNumber.getText())) {
            alert.setTitle("Alert!");
            alert.setHeaderText("Phone number is in use");
            alert.setContentText("Please fix this issue before moving on!");
            alert.showAndWait();
            return;
        }
        if (curOrder.getPhoneNumber() == null || !curOrder.getPhoneNumber().equals(phoneNumber.getText())) {
            curOrder = new Order();
            curOrder.setPhoneNumber(phoneNumber.getText());
        }
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PizzaEditView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PizzaEditController pizzaCustomController = fxmlLoader.getController();
            pizzaCustomController.setMainController(this);
            pizzaCustomController.pizzaType("Deluxe");
            pizzaCustomController.setPizza("Deluxe");
            Stage stage = new Stage();
            stage.setTitle("Deluxe Pizza Editor");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * method to open Hawaiian menu editor
     *
     * @param event that triggers the code
     */
    @FXML
    private void openHawaiianOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizza");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        if (!(phoneNumber.getText().matches("[0-9]+") && phoneNumber.getText().length() == lengthPhoneNumber)) {
            alert.setTitle("Alert!");
            alert.setHeaderText("Phone number is invalid");
            alert.setContentText("Please fix this issue before moving on!");
            alert.showAndWait();
            return;
        }
        if (storeOrders.isin(phoneNumber.getText())) {
            alert.setTitle("Alert!");
            alert.setHeaderText("Phone number is in use");
            alert.setContentText("Please fix this issue before moving on!");
            alert.showAndWait();
            return;
        }
        if (curOrder.getPhoneNumber() == null || !curOrder.getPhoneNumber().equals(phoneNumber.getText())) {
            curOrder = new Order();
            curOrder.setPhoneNumber(phoneNumber.getText());
        }
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PizzaEditView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PizzaEditController pizzaCustomController = fxmlLoader.getController();
            pizzaCustomController.setMainController(this);
            pizzaCustomController.pizzaType("Hawaiian");
            pizzaCustomController.setPizza("Hawaiian");
            Stage stage = new Stage();
            stage.setTitle("Hawaiian Pizza Editor");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * method to open Pepperoni menu editor
     *
     * @param event that triggers the code
     */
    @FXML
    private void openPepperoniOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizza");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        if (!(phoneNumber.getText().matches("[0-9]+") && phoneNumber.getText().length() == lengthPhoneNumber)) {
            alert.setTitle("Alert!");
            alert.setHeaderText("Phone number is invalid");
            alert.setContentText("Please fix this issue before moving on!");
            alert.showAndWait();
            return;
        }
        if (storeOrders.isin(phoneNumber.getText())) {
            alert.setTitle("Alert!");
            alert.setHeaderText("Phone number is in use");
            alert.setContentText("Please fix this issue before moving on!");
            alert.showAndWait();
            return;
        }
        if (curOrder.getPhoneNumber() == null || !curOrder.getPhoneNumber().equals(phoneNumber.getText())) {
            curOrder = new Order();
            curOrder.setPhoneNumber(phoneNumber.getText());
        }
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PizzaEditView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PizzaEditController pizzaCustomController = fxmlLoader.getController();
            pizzaCustomController.setMainController(this);
            pizzaCustomController.pizzaType("Pepperoni");
            pizzaCustomController.setPizza("Pepperoni");
            Stage stage = new Stage();
            stage.setTitle("Pepperoni Pizza Editor");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}









