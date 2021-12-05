//package com.example.project5cs213;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.File;
///**
// * @author Kevan Patel
// * @author Manav Patel
// */
//
///**
// * controller that works with the Store order menu
// */
//
//public class StoreOrderController {
//    /**
//     * initialise variables
//     */
//    private MainController stage;
//
//    @FXML
//    private TextArea displayStoreOrders;
//    @FXML
//    private ComboBox<String> phoneNumber;
//    @FXML
//    private TextField orderTotalLabel;
//    private StoreOrders storeOrders;
//    private static double roundToHundredPlace=100.0;
//    private ObservableList<String> phones = FXCollections.observableArrayList();
//
//
//    public void setMainController(MainController stage) {
//        this.stage = stage;
//    }
//
//
//    /**
//     * method to initialize storeOrder/phoneNumbers
//     *
//     * @param storeOrders to be stored into
//     */
//    public void init(StoreOrders storeOrders) {
//        try {
//            this.storeOrders = storeOrders;
//
//            for (int i = 0; i < storeOrders.getOrders().size(); i++) {
//                phones.add(String.valueOf(storeOrders.getOrders().get(i).getPhoneNumber()));
//            }
//            phoneNumber.setItems(phones);
//            phoneNumber.setValue(String.valueOf(storeOrders.getOrders().get(0).getPhoneNumber()));
//
//            displayStoreOrders.setText(storeOrders.getOrders().get(0).toString());
//            orderTotalLabel.setText(String.valueOf(Math.round(storeOrders.getOrders().get(0).getOrderTotal() * roundToHundredPlace) / roundToHundredPlace));
//
//        } catch (Exception e) {
//        }
//    }
//
//    /**
//     * method to remove order
//     */
//    @FXML
//    public void removeOrder() {
//        if (phones.size() <= 0) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning");
//            alert.setHeaderText("No orders");
//            alert.setContentText("None to remove");
//            alert.showAndWait();
//            return;
//        }
//        try {
//            stage.removeOrder(phoneNumber.getValue());
//            storeOrders.remove(phoneNumber.getValue());
//            phones.remove(phoneNumber.getValue());
//            phoneNumber.getItems().remove(phoneNumber.getValue());
//            displayStoreOrders.clear();
//            orderTotalLabel.clear();
//
//        } catch (Exception e) {
//        }
//
//    }
//
//    @FXML
//    void numChange(ActionEvent event) {
//        if (phoneNumber.getValue() == null) {
//            return;
//        }
//        displayStoreOrders.setText(storeOrders.getOrders().get(storeOrders.returnIndex(phoneNumber.getValue())).toString());
//        orderTotalLabel.setText(String.valueOf(Math.round(storeOrders.getOrders().get(storeOrders.returnIndex(phoneNumber.getValue())).getOrderTotal() * 100.0) / 100.0));
//    }
//
//    /**
//     * method to export File into text
//     *
//     * @param event to trigger
//     */
//    @FXML
//    void exportFile(ActionEvent event) {
//        try {
//            FileChooser chooser = new FileChooser();
//            chooser.setTitle("Select Textfile for export");
//            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
//                    new FileChooser.ExtensionFilter("All Files", "*.*"));
//            Stage stage = new Stage();
//            File targetFile = chooser.showSaveDialog(stage);
//            storeOrders.export(targetFile);
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Please select a valid file!");
//            alert.setContentText("Please choose a valid file!");
//            alert.showAndWait();
//            return;
//
//        }
//    }
//
//
//}
