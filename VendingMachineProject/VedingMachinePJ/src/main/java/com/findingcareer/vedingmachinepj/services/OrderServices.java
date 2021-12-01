/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.vedingmachinepj.services;

import com.findingcareer.vedingmachinepj.pojo.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class OrderServices {

    public static boolean addOrder(Order o) throws SQLException {
        if (!o.getOrderdate().equals("")) {
            Connection connect = Utils.getConnection();

            String query = "insert into vedingmachinedb.order(idUser, moneyReceived,"
                    + " chance, orderdate, moneyRefund) values (?, ?, ?, ?, ?)";

            connect.setAutoCommit(false);
            PreparedStatement stm = connect.prepareCall(query);
            stm.setInt(1, o.getIdUser());
            stm.setDouble(2, o.getMoneyReceived());
            stm.setDouble(5, o.getMoneyRefund());
            stm.setDouble(3, o.getChance());
            stm.setDate(4, o.getOrderdate());

            stm.executeUpdate();

            connect.commit();
            return true;
        }
        return false;
    }

    public static Order getOrder() throws SQLException {
        String query = "SELECT id, orderdate FROM vedingmachinedb.order ORDER BY id DESC LIMIT 1";

        Connection connect = Utils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);

        ResultSet rs = stm.executeQuery();
        Order o = new Order();
        while (rs.next()) {
            o.setId(rs.getInt("id"));
            o.setOrderdate(rs.getDate("orderdate"));
        }

        return o;
    }
}
