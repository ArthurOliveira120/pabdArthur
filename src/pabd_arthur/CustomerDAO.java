/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pabd_arthur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20221074010008
 */
public class CustomerDAO {
    
    private Connection con;
    
    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Conexão OK!");
    }
    
    public void insertCustomer(Customer c) throws SQLException {
        String sql = "insert into customer"
                + " (store_id, first_name, last_name, email, address_id, active)"
                + " values "
                + " (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());
        
        pst.execute();
        pst.close();
        System.out.println("Customer added!");
    }
    
    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from customer"
                + " where customer_id = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, id);
        
        pst.execute();
        pst.close();
        System.out.println("Cliente deletado");
    }
    
    public void updateCustomer() {
        
    }
    
    public void showCustomers() throws SQLException {
        String query = "select * from customer"
                + " order by customer_id desc"
                + "limit 10";
        
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(query);
        
        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i));
            } System.out.println("");
        }
    }
    
    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        
        String query = "select * from customer limit 10";
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(query);
        
        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();
        
        while (rs.next()) {
            Customer c = new Customer();
            
            c.setStore_id(rs.getInt(2));
            c.setFirst_name(rs.getString(3));
            c.setLast_name(rs.getString(4));
            c.setEmail(rs.getString(5));
            c.setAddress_id(rs.getInt(6));
            c.setActive(rs.getInt(7));
            
            customers.add(c);
        }
        
        return customers;
    }
    
}
