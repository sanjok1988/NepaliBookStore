<div class="col-md-3 left_col">
        <div class="left_col scroll-view">

          <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-book"></i> <span>Online Book Store</span></a>
          </div>
          <div class="clearfix"></div>

          <div class="profile">
            <div class="profile_pic">
              <img src="<%=images+"/user.png"%>" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>Welcome,</span>
              <h2><%=session.getAttribute("activeUser")%></h2>
            </div>
          </div>
          <!-- /menu prile quick info -->

          <br />

          <!-- sidebar menu -->
          <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
              <h3>Menu</h3>
              <ul class="nav side-menu">
                <li><a><i class="fa fa-book"></i> Books <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    
                    <li><a href="BookController?action=list">List Product</a>
                    </li>
                    
                    <li><a href="add_book.jsp">Add Product</a>
                    </li>
                   <li><a href="CartController">Product History</a>
                    </li>
                  </ul>
                </li>
               
              </ul>
            </div>
            

          </div>
          <!-- /sidebar menu -->

          <!-- /menu footer buttons -->
          <div class="sidebar-footer hidden-small">
            
            <a href="BookController?action=logout" data-toggle="tooltip" data-placement="top" title="Logout">
              <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
          </div>
          <!-- /menu footer buttons -->
        </div>
      </div>