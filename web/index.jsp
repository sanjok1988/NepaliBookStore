<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Beans" %>
<%@include file="includes/header.jsp" %>
<style>
    .product{
        width:20%;
        float: left;
        margin-right: 45px;
    }
    </style>
<%
    
List<Beans> products = new ArrayList<Beans>();
    
    Beans p1 = new Beans("apple",20.0,0.5,"apple.jpg");
    Beans p2 = new Beans("Ball",30.0,0.5,"ball.jpg");
    Beans p3 = new Beans("cat",200.0,0.5,"cat.jpg");
    Beans p4 = new Beans("dog",50.0,0.5,"dog.jpg");
    
    products.add(p1);
    products.add(p2);
    products.add(p3);
    products.add(p4);

  

    %>
    
<style>
    .pink{
        background: #751879;
        color: #fff;
        padding:5px;
    }
</style>
        <div class="container">
            <div class="col-md-12">
                <h1>Book Catalogs</h1>
            </div>
            <div class="row">
        
        <%for(Beans b:products){ %>
    
        <form method="GET" action="CartController">
        <div class="col-md-3">
            <div class="row">
<!--            <img src="<%out.print(b.getImage());%>"height="200px" width="100%">-->
            <table>
                <tr>
                    <td><h4>Product Name</h4></td>
                    <td><input type="text" name="name" value="<%out.print(b.getName());%>" readonly></td>
                </tr>
                <tr>
                    <td>
                        <p>Product Details</p>
                    </td>
                    <td>
                        <input type="text" name="details" value="this is product details" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <b class="price">Product Price</b>
                    </td>
                    <td>
                        <input type="text" name="price" value="<%out.print(b.getPrice());%>" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4 class="qty">Quantity 
                    </td>
                    <td>
                        <input type="number" name="qty" value="1" style="width:40px"></h4>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="btn">
                            <input type="submit" value="Add To Card">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="pink">
                        2nd Less 50%
                        <input name="discount" value="50" hidden>
                    </td>
                    
                </tr>
                <tr>
                    <td colspan="2" class="pink">
                        2nd at RM 0.50
                    </td>
                </tr>
            </table>
            
            
            </div>
        </div>
        </form>
        <%}%>
        </div>
        </div>
<%@include file="includes/footer.jsp" %>
