/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import dao.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sanjok
 */
public class Basket {

    public final static String table_name = "baskets";
    
    private String items;
    private String qty;
    private String price;
    private String discount;
    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    

    /**
     * @return the items
     */
    public String getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
    
    
    public Basket(){
        
    }
    
    public Basket(String items, String qty, String price, String discount){
        this.items = items;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
    }
    
    public static void store(Basket basket){
        PreparedStatement pmst;
        Connect cn = new Connect();
        try{
            String sql = "insert into " + table_name +" (item, qty, price, discount) values( ?,?,?,?)";
            pmst = cn.con.prepareStatement(sql);
            pmst.setString(1, basket.getItems());
            pmst.setString(2, basket.getQty());
            pmst.setString(3, basket.getPrice());
            pmst.setString(4, basket.getDiscount());
            
            pmst.execute();
            cn.con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static List<Basket> getData(){
        ArrayList<Basket> data = new ArrayList<Basket>();
        Statement stmt;
        Connect cn = new Connect();
        
        try{
            String sql = "select * from " + table_name;
            stmt = cn.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Basket b = new Basket();
                System.out.println(rs.getString("item"));
                
                b.setItems(rs.getString("item"));
                b.setQty(rs.getString("qty"));
                b.setPrice(rs.getString("price"));
                b.setDiscount(rs.getString("discount"));
                data.add(b);
            }
            cn.con.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
        
    }
}
