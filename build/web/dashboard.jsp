
<%@include file="includes/admin_header.jsp" %>
             
<h2>Plain Page</h2>
     <div class="x_content">
                  <br />
        <form method="POST" action="FileController" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id="file" /> <br/>
            
            <input type="submit" value="Upload" name="upload" id="upload" />
        </form>
     </div>

<%@include file="includes/admin_footer.jsp" %>

    