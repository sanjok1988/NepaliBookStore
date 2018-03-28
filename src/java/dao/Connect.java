package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanjok
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    
    public Connection con;
    
    public Connect(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","dngl");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
