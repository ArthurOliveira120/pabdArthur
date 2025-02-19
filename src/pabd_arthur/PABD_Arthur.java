/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pabd_arthur;

import java.sql.*;
import java.util.List;

/**
 *
 * @author 20221074010008
 */
public class PABD_Arthur {
    public static void main(String[] args) throws SQLException {
        CustomerDAO dao = new CustomerDAO();
        
        System.out.println(dao.getCustomers().toString());
    }
}