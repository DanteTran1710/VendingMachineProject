/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.vedingmachinepj.services;

import com.findingcareer.vedingmachinepj.pojo.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class OrderDetailServices {
    public static boolean addOrderDetail(OrderDetail d) throws SQLException{
        if(!d.getName().equals("")){
            
            Connection connect = Utils.getConnection();
            
            String query = "insert into vedingmachinedb.order_detail(name, idOrder, price, quantity)"
                    + " values (?, ?, ?, ?)";
            
            connect.setAutoCommit(false);
            
            PreparedStatement stm = connect.prepareCall(query);
            stm.setString(1, d.getName());
            stm.setObject(2, d.getIdOrder());
            stm.setInt(3, d.getPrice());
            stm.setInt(4, d.getQuantity());

            stm.executeUpdate();

            connect.commit();
            return true;
        }
        return false;
    }
}
