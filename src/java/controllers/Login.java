/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Auth;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanjok
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean isPost = "POST".equals(request.getMethod());
        if(isPost){
            String username, password;
            username = request.getParameter("username");
            password = request.getParameter("password");
            
            Auth a = new Auth();
                if(a.auth(username, password)){
                      HttpSession session = request.getSession(true);
                      session.setAttribute("activeUser", username);

                      response.sendRedirect("dashboard.jsp");

                }else{
                    response.sendRedirect("login.jsp?message=username or password incorrectl!!!");
                }
            
        }
        
    }

}
