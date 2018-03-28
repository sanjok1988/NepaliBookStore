/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Beans.BookBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author sanjok
 */

public class Books {    
    
   
   Connect db = new Connect();
    
    public static ArrayList<BookBeans> getBooks(){
                        
         ArrayList<BookBeans> data = new ArrayList<BookBeans>();
            Statement stmt;
            Connect cn = new Connect();
        
        try{
            String sql = "select * from " + BookBeans.table+ " order by id DESC";
            stmt = cn.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                BookBeans b = new BookBeans();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                
                data.add(b);
            }
            cn.con.close();           
            
        }catch(Exception e){
            e.printStackTrace();
        }                        
        
        return data;
//        request.setAttribute("data", data);
//
//        RequestDispatcher view = request.getRequestDispatcher("list_book.jsp");
//            view.forward(request, response);
    }
}
