<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Beans.Basket"%>
<%@include file="includes/header.jsp" %>
<style>
    th{
        background: #ff46cf;
        padding: 5px;
    }
    </style>
<%
    String name="";
    double price=0;
    int qty=1;
    double discount = 0;
    
    %>
    
    <div class="container">

      <div class="row">

    <h1>Product History</h1>
    <table>
        <tr>
            <th>Items</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Discount(RM)</th>
            <th>Total after Discount(RM)</th>
        </tr>
        <%
            
            ArrayList<Basket> datas=(ArrayList<Basket>) request.getAttribute("data"); 
            for(Basket bt:datas) {  
            String item = bt.getItems();
            double p = Double.parseDouble(bt.getPrice());
            int q = Integer.parseInt(bt.getQty());
            double d = Double.parseDouble(bt.getDiscount());
            d=d/100;
          %>
        <tr>
            <td><%out.print(item);%></td>
            <td><%out.print(q);%></td>
            <td><%out.print(p);%></td>
            <td><%out.print(q*p);%></td>
            <td style="background: greenyellow"><%out.print(d*q*p);%></td>
            <td style="background:yellow"><%out.print((q*p)-(d*q*p));%></td>
        </tr>
        <%}%>
    </table>

        
        <a href="index.jsp">Back to catlog</a>
</div>        
    </div>
<%@include file="includes/footer.jsp" %>
        

