
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%
            String username = null;
            try {
                
                if ( session.getAttribute("activeUser") == null) {
                    response.sendRedirect("login.jsp");
                }else{
                    username = session.getAttribute("activeUser").toString();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        %>
<% String base_path = request.getContextPath();%>
<%
    String styles = base_path+"/assets/css";
    String scripts = base_path+"/assets/js";
    String fonts = base_path+"/assets/fonts";
    String images = base_path+"/assets/images";
    %>
    
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Admin | </title>

        <!-- Bootstrap core CSS -->

        <link href="<%=styles+"/bootstrap.min_1.css"%>" rel="stylesheet">

        <link href="<%=fonts+"/font-awesome.min.css"%>" rel="stylesheet">
        <link href="<%=styles+"/animate.min.css"%>" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="<%=styles+"/custom.css"%>" rel="stylesheet">

        <script src="<%=scripts+"/jquery.min.js"%>"></script>
        <style>
            .message{
                padding: 30px;
            }
        </style>

    </head>

    <body class="nav-md">
     
        <div class="container body">
            <div class="main_container">

                <%@include file="admin_leftbar.jsp" %>

                <%@include file="admin_top.jsp" %>
                <div class="right_col" role="main">
                    <!-- page content -->

                    <div class="row">
                        <div class="page-title">
                            <div class="title_left">
                                <p>Online Book Store System Developed By Sanjok Dangol, Tulasi Bhandari, Gajendra Yadab, Manish Rayamajhi.
                                    IIMS College, Dhobidhara.</p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">

                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel" style="height:600px;">
                                    <div class="x_title">