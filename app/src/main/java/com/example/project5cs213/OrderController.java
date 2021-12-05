//package com.example.project5cs213;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
///**
// * @author Kevan Patel
// * @author Manav Patel
// */
//
///**
// * controller that works with order menu
// */
//
//public class OrderController {
//    /**
//     * initialize varaibles
//     */
//    private MainController stage;
//    @FXML
//    private ListView<String> displayOrder;
//    @FXML
//    private TextField phoneNumber;
//    @FXML
//    private TextField subTotal;
//    @FXML
//    private TextField salesTaxLabel;
//    @FXML
//    private TextField totalLabel;
//    private Order order;
//    private ObservableList<String> items = FXCollections.observableArrayList();
//    private static double formatZero=0.0;
//
//    /**
//     * method to initialize an order by connecting main and order controller
//     *
//     * @param order to be sent through
//     */
//
//    public void init(Order order) {
//        try {
//            this.order = order;
//            phoneNumber.setText(order.orderNumber + "");
//            if (subTotal != null) {
//
//                subTotal.setText(String.format("%,.2f", order.getTotal()));
//            }
//
//            if (salesTaxLabel != null) {
//
//                salesTaxLabel.setText(String.format("%,.2f", order.getSalesTax()));
//            }
//            if (totalLabel != null) {
//
//                totalLabel.setText(String.format("%,.2f", order.getOrderTotal()));
//            }
//
//            displayOrder.setItems(items);
//
//            for (Pizza p : order.pizzas) {
//                items.add(p.toString());
//            }
//        } catch (Exception e) {
//
//        }
//    }
//
//    /**
//     * method to setNumber entered
//     *
//     * @param number entered
//     */
//
//    @FXML
//    public void setNumber(String number) {
//
//        phoneNumber.setText(number);
//
//    }
//
//    /**
//     * method to removeitem from order
//     */
//    public void removeItem() {
//        try {
//            this.items.remove(displayOrder.getSelectionModel().getSelectedItem());
//            order.remove(displayOrder.getSelectionModel().getSelectedIndex());
//
//            subTotal.setText(String.format("%,.2f", order.getTotal()));
//            salesTaxLabel.setText(String.format("%,.2f", order.getSalesTax()));
//            totalLabel.setText(String.format("%,.2f", order.getOrderTotal()));
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Successfully Removed");
//            alert.setHeaderText("The pizza you created has been removed!");
//            alert.showAndWait();
//
//            if (this.items.size() == 0) {
//                this.subTotal.setText(String.format("%,.2f", formatZero));
//                this.salesTaxLabel.setText(String.format("%,.2f", formatZero));
//                this.totalLabel.setText(String.format("%,.2f", formatZero));
//            }
//        } catch (Exception e) {
//            this.subTotal.setText(String.format("%,.2f", formatZero));
//            this.salesTaxLabel.setText(String.format("%,.2f", formatZero));
//            this.totalLabel.setText(String.format("%,.2f", formatZero));
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("No more pizzas");
//            alert.setHeaderText("No more pizzas");
//            alert.showAndWait();
//
//        }
//
//    }
//
//    /**
//     * method to connect order to main
//     *
//     * @param actionEvent to trigger
//     */
//
//    public void addOrderToMain(ActionEvent actionEvent) {
//        if (order != null) {
//            try {
//                if(order.isEmpty()){
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Warning!");
//                    alert.setHeaderText("Empty order");
//                    alert.setContentText("Please order something >:(");
//                    alert.showAndWait();
//                    return;
//                }
//                if(stage.getStoreOrders().isin(phoneNumber.getText())){
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Warning!");
//                    alert.setHeaderText("Phone number already used to place order!");
//                    alert.setContentText("Please enter valid 10 digit phone-number with outstanding orders");
//                    alert.showAndWait();
//                    return;
//                }
//                stage.addOrder(this.order, phoneNumber.getText());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * set main stage method
//     * @param stage to set
//     */
//
//    public void setMainController(MainController stage) {
//        this.stage = stage;
//    }
//}
