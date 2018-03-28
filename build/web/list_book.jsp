
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.BookBeans"%>
<%@include file="includes/admin_header.jsp" %>
                
                  <h2>List of Books</h2>
                  
                  <div class="x_content">
                      <a href="add_book.jsp" class="btn btn-primary">Add New</a>
                  <br />
                  <table class="table table-striped table-bordered">
                      <thead>
                      <th>
                          sn
                      </th>
                      <th>Name</th>
                      <th>Author</th>
                      <th>Price</th>
                      <th>Actions</th>
                      </thead>
                      <tbody>
                          <%
                              ArrayList<BookBeans> list = (ArrayList<BookBeans>)request.getAttribute("data");
                              int i=0;
                              for(BookBeans b:list){
                                  i++;
                                  
                             %>
                          <tr>
                              <td><%=i%></td>
                              <td><%out.print(b.getName());%></td>
                              <td><%out.print(b.getAuthor());%></td>
                              <td><%out.print(b.getPrice());%></td>
                              <td>
                                  <a class="btn btn-primary btn-sm" href="BookController?action=edit&id=<%out.print(b.getId());%>">
                                      <i class="fa fa-pencil"></i>
                                  </a>
                                      <a class="btn btn-danger btn-sm" href="BookController?action=delete&id=<%out.print(b.getId());%>">
                                          <i class="fa fa-trash-o"></i>
                                      </a>
                              </td>
                          </tr>
                          <%}%>
                      </tbody>
                  </table>
                </div>
                  
   
        <%@include file="includes/admin_footer.jsp" %>

    