/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Beans.Basket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanjok
 */
public class CartController extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        List<Basket> data;
        
            try{
              
                Basket.store(new Basket(name, qty, price, discount));
                request.setAttribute("data", Basket.getData());
            }catch(Exception e){
                
            }          
            
            RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
            view.forward(request, response);
            response.sendRedirect("cart.jsp");
        
    }
}
