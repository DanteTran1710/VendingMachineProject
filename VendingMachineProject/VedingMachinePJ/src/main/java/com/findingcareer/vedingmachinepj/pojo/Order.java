/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.vedingmachinepj.pojo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author hp
 */
public class Order {
    private int id;
    private int idUser;
    private double moneyReceived;
    private double moneyRefund;
    private double chance;
    private Date orderdate;
    private List<OrderDetail> details;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the moneyReceived
     */
    public double getMoneyReceived() {
        return moneyReceived;
    }

    /**
     * @param moneyReceived the moneyReceived to set
     */
    public void setMoneyReceived(double moneyReceived) {
        this.moneyReceived = moneyReceived;
    }

    /**
     * @return the moneyRefund
     */
    public double getMoneyRefund() {
        return moneyRefund;
    }

    /**
     * @param moneyRefund the moneyRefund to set
     */
    public void setMoneyRefund(double moneyRefund) {
        this.moneyRefund = moneyRefund;
    }

    /**
     * @return the chance
     */
    public double getChance() {
        return chance;
    }

    /**
     * @param chance the chance to set
     */
    public void setChance(double chance) {
        this.chance = chance;
    }

    /**
     * @return the orderdate
     */
    public Date getOrderdate() {
        return orderdate;
    }

    /**
     * @param orderdate the orderdate to set
     */
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * @return the details
     */
    public List<OrderDetail> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}
