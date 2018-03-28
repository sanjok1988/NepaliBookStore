
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.BookBeans"%>
<%@include file="includes/admin_header.jsp" %>
<%
    ArrayList<BookBeans> books = (ArrayList<BookBeans>) request.getAttribute("data");
   
%>
             
                  <h2>Update Book</h2>
                  
                  <div class="x_content">
                  <br />
                  <form action="BookController?action=update" method="POST" id="demo-form2" class="form-horizontal form-label-left">
                      <input type="hidden" name="id" value="<%out.print(books.get(0).getId());%>">
                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Book Name <span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" name="name" value="<%out.print(books.get(0).getName());%>" required="required" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Author Name <span class="required">*</span>
                      </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" name="author" value="<%out.print(books.get(0).getAuthor());%>" required="required" class="form-control col-md-7 col-xs-12">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Price</label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <input class="form-control col-md-7 col-xs-12" type="text" name="price" value="<%out.print(books.get(0).getPrice());%>">
                      </div>
                    </div>
                    
                    <div class="ln_solid"></div>
                    <div class="form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button type="submit" class="btn btn-primary">Cancel</button>
                        <button type="submit" class="btn btn-success">Submit</button>
                      </div>
                    </div>

                  </form>
                </div>
                  
   
        <%@include file="includes/admin_footer.jsp" %>

    
