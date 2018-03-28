/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.BookBeans;
import dao.Connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanjok
 */
public class BookController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String name = request.getParameter("name");
       String author = request.getParameter("author");
       String price = request.getParameter("price");
       String action = request.getParameter("action");
       if(action.equals("add")){
            PreparedStatement pmst;
            try{
                Connect cn = new Connect();
                String sql = "insert into "+ BookBeans.table +" (name, author, price) values(?,?,?)";
                pmst = cn.con.prepareStatement(sql);
                pmst.setString(1, name);
                pmst.setString(2, author);
                pmst.setString(3, price);
                boolean result = pmst.execute();
                if(result){
                    request.getSession().setAttribute("message", "success");
                }else{
                    request.getSession().setAttribute("message", "error");
                }
                cn.con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            response.sendRedirect("BookController?action=list");
       }
       if(action.equals("edit")){
           String id = request.getParameter("id");
           ArrayList<BookBeans> book = new ArrayList<BookBeans>();
           Statement stmt;
           try{
               Connect cn = new Connect();
               stmt = cn.con.createStatement();
               ResultSet rs = stmt.executeQuery("select * from " +BookBeans.table+" where id="+id);
               while(rs.next()){
                   BookBeans b = new BookBeans();
                   b.setId(Integer.parseInt(id));
                   b.setName(rs.getString("name"));
                   b.setAuthor(rs.getString("author"));
                   b.setPrice(rs.getString("price"));
                   book.add(b);
                   
               }
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
           request.setAttribute("data", book);

        RequestDispatcher view = request.getRequestDispatcher("update_book.jsp");
            view.forward(request, response);
           
       }
       if(action.equals("update")){
           
           String id = request.getParameter("id");
           String bookName = request.getParameter("name");
           String authorName = request.getParameter("author");
           String amount = request.getParameter("price");

           PreparedStatement pmst;
            try{
                Connect cn = new Connect();
                String sql = "update "+ BookBeans.table +" set name=?, author=?, price=? where id="+id;
                pmst = cn.con.prepareStatement(sql);
                pmst.setString(1, bookName);
                pmst.setString(2, authorName);
                pmst.setString(3, amount);
                int result = pmst.executeUpdate();
                if(result==1){
                    request.getSession().setAttribute("message", "success");
                }else{
                    request.getSession().setAttribute("message", "error");
                }
                cn.con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            response.sendRedirect("BookController?action=list");
       }
       
       if(action.equals("delete")){
           String id = request.getParameter("id");
           Statement st;
            try{
                Connect cn = new Connect();
                String sql = "delete from "+ BookBeans.table +" where id="+id;
                st = cn.con.createStatement();
               
                boolean result = st.execute(sql);
                if(result){
                    request.getSession().setAttribute("message", "success");
                }else{
                    request.getSession().setAttribute("message", "error");
                }
                cn.con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            response.sendRedirect("BookController?action=list");
           
       }
       
       if(action.equals("list")){
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
        
        request.setAttribute("data", data);

        RequestDispatcher view = request.getRequestDispatcher("list_book.jsp");
            view.forward(request, response);
           
       }
       
       if(action.equals("logout")){
           HttpSession session = request.getSession(false);
            if(session!=null)
            session.invalidate();
            response.sendRedirect("home.jsp");
       }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
