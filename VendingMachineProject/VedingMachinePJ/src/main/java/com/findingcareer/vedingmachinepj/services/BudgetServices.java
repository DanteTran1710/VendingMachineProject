/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.vedingmachinepj.services;

import com.findingcareer.vedingmachinepj.pojo.BudgetDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class BudgetServices {
    public static boolean addBudget(BudgetDate bd) throws SQLException{
        if(bd.getBudget() > 0){
            
            Connection connect = Utils.getConnection();
            
            String query = "insert into vedingmachinedb.budget_date(budget, date)"
                    + " values (?, ?)";
            
            connect.setAutoCommit(false);
            
            PreparedStatement stm = connect.prepareCall(query);
            stm.setInt(1, bd.getBudget());
            stm.setDate(2, bd.getDate());

            stm.executeUpdate();

            connect.commit();
            return true;
        }
    return false;
}
    public static BudgetDate getBudget() throws SQLException{
         String query = "SELECT * FROM vedingmachinedb.budget_date ORDER BY id DESC LIMIT 1";

        Connection connect = Utils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        
        ResultSet rs = stm.executeQuery();
        BudgetDate o = new BudgetDate();
        while (rs.next()) {
            o.setId(rs.getInt("id"));
            o.setBudget(rs.getInt("budget"));
            o.setDate(rs.getDate("date"));
        }

        return o;
    }
}
