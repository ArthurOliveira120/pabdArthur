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
        
        Customer o = new Customer(1, "Juliana", "Soares", "juliana.soares@escolar.ifrn.edu.br", 11, 1);

        CustomerDAO dao = new CustomerDAO();
        
        //dao.insertCustomer(o);
        
        dao.deleteCustomer(5);
        dao.showCustomers();

    }
}
