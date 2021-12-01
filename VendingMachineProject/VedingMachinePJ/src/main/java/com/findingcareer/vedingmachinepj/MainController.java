package com.findingcareer.vedingmachinepj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.findingcareer.vedingmachinepj.pojo.BudgetDate;
import com.findingcareer.vedingmachinepj.pojo.Order;
import com.findingcareer.vedingmachinepj.pojo.OrderDetail;
import com.findingcareer.vedingmachinepj.services.BudgetServices;
import com.findingcareer.vedingmachinepj.services.OrderDetailServices;
import com.findingcareer.vedingmachinepj.services.OrderServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MainController implements Initializable {

    @FXML
    TextField name;
    @FXML
    TextField phone;
    @FXML
    ComboBox money;
    @FXML
    Spinner FantaCounted;
    @FXML
    Spinner ColaCounted;
    @FXML
    Spinner PepsiCounted;
    @FXML
    Text FantaQuantity;
    @FXML
    Text FantaTotal;
    @FXML
    Text ColaTotal;
    @FXML
    Text PepsiTotal;
    @FXML
    Text ColaQuantity;
    @FXML
    Text PepsiQuantity;
    @FXML
    Text total;

    private double wallet;
    private int totalBill;
    private int budget = 50;
    private double promo = 0.1;

    private int totalFanta;
    private int totalCola;
    private int totalPepsi;

    public void addToWallet() {
        if (!this.name.getText().equals("") && !this.phone.getText().equals("")) {
            String s = this.money.getSelectionModel().getSelectedItem().toString();
            if (wallet == 0) {
                switch (s) {
                    case "10.000 VND":
                        wallet = 10;
                        break;
                    case "20.000 VND":
                        wallet = 20;
                        break;
                    case "50.000 VND":
                        wallet = 50;
                        break;
                    case "100.000 VND":
                        wallet = 100;
                        break;
                    case "200.000 VND":
                        wallet = 200;
                        break;
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("You have incharge " + s + " to your wallet!");
                alert.showAndWait();

            } else if (wallet != 0) {
                switch (s) {
                    case "10.000 VND":
                        wallet += 10;
                        break;
                    case "20.000 VND":
                        wallet += 20;
                        break;
                    case "50.000 VND":
                        wallet += 50;
                        break;
                    case "100.000 VND":
                        wallet += 100;
                        break;
                    case "200.000 VND":
                        wallet += 200;
                        break;
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("You have incharge more " + s + " to your wallet!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please complete your form before submit!");
            alert.showAndWait();
        }
    }

    public void checkOrder() {
        this.FantaQuantity.setText(this.FantaCounted.getValue().toString());
        this.ColaQuantity.setText(this.ColaCounted.getValue().toString());
        this.PepsiQuantity.setText(this.PepsiCounted.getValue().toString());

        totalFanta = Integer.parseInt(this.FantaCounted.getValue().toString()) * 20;
        totalCola = Integer.parseInt(this.ColaCounted.getValue().toString()) * 10;
        totalPepsi = Integer.parseInt(this.PepsiCounted.getValue().toString()) * 10;

        this.FantaTotal.setText(totalFanta + ".000 VND");
        this.ColaTotal.setText(totalCola + ".000 VND");
        this.PepsiTotal.setText(totalPepsi + ".000 VND");

        totalBill = totalCola + totalFanta + totalPepsi;
        this.total.setText(totalBill + ".000 VND");
    }

    public void order() throws SQLException {
        if (wallet >= totalBill) {
            // ADD ORDER
            Order o = new Order();
            long millis = System.currentTimeMillis();

            Date date = new Date(millis);
            o.setOrderdate(date);
            o.setIdUser(1);
            if (this.FantaQuantity.getText().equals("3")
                    || this.ColaQuantity.getText().equals("3")
                    || this.PepsiQuantity.getText().equals("3")) {
                double numRandom = Math.floor(Math.random() * (100) + 1);
                if (BudgetServices.getBudget().getBudget() == 0) {
                    if (numRandom >= 1 && numRandom <= Math.floor(promo * 100)) {
                        int discount = 0;
                        if (this.FantaQuantity.getText().equals("3")) {
                            discount = 20;
                        } else if (this.ColaQuantity.getText().equals("3")
                                || this.PepsiQuantity.getText().equals("3")) {
                            discount = 10;
                        }
                        o.setChance(promo);
                        o.setMoneyReceived(totalBill - discount);
                        o.setMoneyRefund(wallet - totalBill - discount);

                        budget -= discount;
                        BudgetDate b = new BudgetDate();
                        b.setBudget(budget);
                        b.setDate(date);
                    }
                } else if (BudgetServices.getBudget().getBudget() > 0) {
                    promo += (promo / 2);
                    if (numRandom >= 1 && numRandom <= Math.floor(promo * 100)) {
                        int discount = 0;
                        if (this.FantaQuantity.getText().equals("3")) {
                            discount = 20;
                        } else if (this.ColaQuantity.getText().equals("3")
                                || this.PepsiQuantity.getText().equals("3")) {
                            discount = 10;
                        }
                        o.setChance(promo);
                        o.setMoneyReceived(totalBill - discount);
                        o.setMoneyRefund(wallet - totalBill - discount);

                        budget -= discount;
                        BudgetDate b = new BudgetDate();
                        b.setBudget(budget);
                        b.setDate(date);
                    }
                }
            } else {
                o.setChance(0);
                o.setMoneyReceived(totalBill);
                o.setMoneyRefund(wallet - totalBill);

                OrderServices.addOrder(o);
            }
            List<Integer> listAmount = new ArrayList<>();

            listAmount.add(Integer.parseInt(this.FantaQuantity.getText()));
            listAmount.add(Integer.parseInt(this.ColaQuantity.getText()));
            listAmount.add(Integer.parseInt(this.PepsiQuantity.getText()));

            // ADD ORDER DETAIL
            for (int i = 0; i < 3; i++) {
                if (listAmount.get(i) > 0) {
                    OrderDetail od = new OrderDetail();
                    od.setIdOrder(OrderServices.getOrder().getId());
                    switch (i) {
                        case 0:
                            od.setName("Fanta");
                            od.setPrice(totalFanta);
                            od.setQuantity(listAmount.get(i));
                            break;
                        case 1:
                            od.setName("Coca cola");
                            od.setPrice(totalCola);
                            od.setQuantity(listAmount.get(i));
                            break;
                        case 2:
                            od.setName("Pepsi");
                            od.setPrice(totalPepsi);
                            od.setQuantity(listAmount.get(i));
                            break;
                    }
                    OrderDetailServices.addOrderDetail(od);
                }
            }
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setContentText("Order successful!");
            alert2.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please incharge more to your wallet!");
            alert.showAndWait();
        }
    }

    public void cancel() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Cancel successful! You still have " + wallet
                + ".000 VND in wallet");
        alert.showAndWait();
    }

    public boolean checkDate() throws SQLException {
        long millis = System.currentTimeMillis();
        Date now = new Date(millis);

        int i = now.compareTo(OrderServices.getOrder().getOrderdate());

        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> money = new ArrayList<>();
        money.add("10.000 VND");
        money.add("20.000 VND");
        money.add("50.000 VND");
        money.add("100.000 VND");
        money.add("200.000 VND");

        this.money.getItems().addAll(money);

        FantaCounted.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10));
        ColaCounted.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10));
        PepsiCounted.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10));
    }

}
