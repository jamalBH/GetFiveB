<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>GETFIVE services | Commandes</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
   
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">

 
</head>
 
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="resteau" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>G</b>F</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>GET</b>FIVE</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the messages -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <!-- User Image -->
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <!-- Message title and timestamp -->
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <!-- The message -->
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
                <!-- /.menu -->
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- /.messages-menu -->

          <!-- Notifications Menu -->
          <li class="dropdown notifications-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 commandes</li>
              <li>
                <!-- Inner Menu: contains the notifications -->
                <ul class="menu">
                  <li><!-- start notification -->
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <!-- end notification -->
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
         
          <!-- Hotel Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The hotel image in the navbar-->
              <img src="dist/img/hotel-building.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${nameHotel}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The hotel icon image in the menu -->
              <li class="user-header">
                <img src="dist/img/hotel-building.png" class="img-circle" alt="User Image">

                <p> <!-- HOTEL NAME======================================================================================================= -->
                  ${nameHotel}
                  <small></small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-6 text-center">
                    <a href="#">Clients actives:</a>
                  </div>
                     <!-- NOMBRE CLIENTS ACTIVES ================================================================================-->

                  <div class="col-xs-6 text-center">
                    <a href="#">150</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="profile" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
	            <form action="${logoutUrl}" method="post" id="logoutForm">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
               	<script>
	               	function formSubmit() {
		          	document.getElementById("logoutForm").submit(); }
	               	</script>
                     <a href="javascript:formSubmit()" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
    <!-- TOUS CE QUI CONCERNE SIDE BARE -===========================================================================----------->

  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar Hotel panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/hotel-building.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p> ${nameHotel}</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Active </a>
        </div>
      </div>


      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">Tableau de bord</li>
        <!-- Optionally, you can add icons to the links -->
    <!--    <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Gestion CMD</span></a></li> -->
        <li class="treeview">
          <a href="#"><i class="fa fa-send"></i> <span>Gestion Commandes</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="resteau">Resteau</a></li>
            <li><a href="services">Service</a></li>
          </ul>
        </li>
          <li class=""><a href="compte"><i class="fa fa-hotel"></i> <span>Creation Comptes</span></a></li>
          <li class=""><a href="facture"><i class="fa fa-money"></i> <span>Facture</span></a></li>
          <li class=""><a href="menus"><i class="fa  fa-edit "></i> <span>Parametrage</span></a></li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
    
      <!-- TITRE DE LA PAGE=================================================================================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Parametrage de vos Menus
        <small></small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here=================================================================================================== -->
        
        
          <!-- START XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
       <c:forEach items="${m}" var="m">
         <div class="col-lg-4 col-xs-6">
                <div class="small-box 
                <c:choose>
                	<c:when test="${m.typeMenu eq 'Service'}">
                		<c:out value="bg-yellow"/>
                	</c:when>
                	<c:otherwise>
                		<c:out value="bg-aqua"/>
                	</c:otherwise>
                </c:choose>">
                    
                   
                   <button type="button" class="close">&times;</button>
                     
                    
                     <div class="inner">
                        <h4><c:out value="${m.nomMenu}"></c:out></h4>

                        <p>Menu <c:out value="${m.typeMenu}"></c:out> </p>
                    </div>
                    <div class="icon">
                        <i class="fa 
                        <c:choose>
                	<c:when test="${m.typeMenu eq 'Service'}">
                		<c:out value="fa-wrench"/>
                	</c:when>
                	<c:otherwise>
                		<c:out value="fa-cutlery"/>
                	</c:otherwise>
                </c:choose>"></i>
                    </div>
                <a href="#" class="small-box-footer" data-toggle="modal" data-target="#myModal${m.idService}">
                  Details <i class="fa fa-arrow-circle-right"></i>
                </a>
                <!-- MODAL START YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY -->
             <div id="myModal${m.idService}" class="modal fade" role="dialog" style="overflow-y: auto;">
                <div class="modal-dialog">
                	
					 <!-- START Modal content-->
					 <div class="modal-content bg-gray ">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><c:out value="${m.nomMenu}"></c:out></h4>
                      </div>
                      <div class="modal-body">
                        <p>Categories</p>
                       	 <ul class="list-group">
	                      <c:forEach items="${m.article_categorie}" var="art">
		                      <li class="list-group-item justify-content-between">
	                                <span>${art.nomCategorie}</span>
	                                <a href="#" class="small-box-footer" data-toggle="modal" data-target="#articlesmodal${art.idArticleCategorie}"><small>[Afficher articles]</small></a>
	                                	<!-- START AJOUTE ARTICLE BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB -->
	                                	<div id="articlesmodal${art.idArticleCategorie}" class="modal fade" role="dialog" style="overflow-y: auto;">
                                          <div class="modal-dialog">
                                           <div class="modal-content bg-gray ">
                                              <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Catégorie articles</h4>
                                              </div>
                                                <div class="modal-body">
                                                <p>Articles</p>
                                                <ul class="list-group">
                                                	<c:forEach items="${art.article}" var="article">
                                                		<li class="list-group-item justify-content-between">
                                                        <span>${article.nom_article}</span>
                                                        <a href="#"><small>[Modifier]</small></a>
                                                        <a href="#"><small>[Supprimer]</small></a> 
                                                        <span class="badge badge-primary badge-pill">${article.prix_article}<span>DH</spanp></span>
                                                    </li>
                                                	</c:forEach>
                                                </ul>
                                                  <a href="#" data-toggle="collapse" data-target="#addArt${art.idArticleCategorie}">Ajouter nouveau article...</a> 
                                                    <div id="addArt${art.idArticleCategorie}" class="collapse">
                                                        <form:form action="addArticle" method="POST" modelAttribute="article">
                                                        <form:input path="id_categ" type="hidden" value="${art.idArticleCategorie}"/>
                                                         <div class="row form-group">
                                                          <form:label path="nom_article"  class="col-sm-3 control-label">Nom Article</form:label>
                                                          <div class="col-sm-8">
                                                            <form:input path="nom_article" type="text" class="form-control" id="inputNom" placeholder="Nom Catégorie"/>
                                                          </div>     
                                                        </div>
                                                        <div class="row form-group">
                                                          <form:label path="prix_article" class="col-sm-3 control-label">Prix</form:label>
                                                          <div class="col-sm-8">
                                                            <form:input path="prix_article" type="text" class="form-control" id="inputNom" placeholder="Prix"/>
                                                          </div>     
                                                        </div>
                                                        <div class="row form-group">
                                                          <form:label path="description" class="col-sm-3 control-label">Description</form:label>
                                                          <div class="col-sm-8">
                                                            <form:input path="description" type="text" class="form-control" id="inputNom" placeholder="Description ..."/>
                                                          </div>     
                                                        </div>
                                                        <div class="row form-group">
                                                          <form:label path="image" class="col-sm-3 control-label">Image</form:label>
                                                          <div class="col-sm-8">
                                                            <form:input path="image" type="text" class="form-control" id="inputNom" placeholder="Image URL"/>
                                                          </div>     
                                                        </div>
                                                        <div class="col-sm-3 pull-right">
                                                           <button type="submit" class="btn btn-primary">Ajouter</button>     
                                                         </div>
                                                         </form:form>
                                                    </div>
                                                </div>
                                                 </br></br></br>
                                                 <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                                              </div>
                                              </div>
                                          </div>
                                          </div>
	                                	<!-- START AJOUTE ARTICLE BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB -->
	                                <a href="#"><small>[Supprimer]</small></a>
	                           </li>
	                      </c:forEach>
                     	 </ul>
                     	 <!-- AJOUTE CATEGORIE ARTCILE AAAAAAAAAAAAAAAAAAAAAAAAAAAAA -->
                     	  <a href="#" data-toggle="collapse" data-target="#addCat${m.idService}">Ajouter nouveau catégorie...</a> 
                            <div id="addCat${m.idService}" class="collapse">
                            <form:form action="addCateg" method="POST" modelAttribute="categ">
                                  <form:input path="idMenu" class="hidden" value="${m.idService}"/>
                                 <div class="form-group">
                                  <form:label path="name" class="col-sm-3 control-label">Nom Catégorie</form:label>
                                  <div class="col-sm-6">
                                    <form:input path="name" type="text" class="form-control" id="inputNom" placeholder="Nom Catégorie"/>
                                  </div>
                                  <div class="col-sm-3">
                                   <button type="submit" class="btn btn-primary">Ajouter</button>     
                                 </div>     
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                 </form:form>
                            </div>
                            <!-- END AJOUTE CATEGORIE ARTCILE AAAAAAAAAAAAAAAAAAAAAAAAAAAAA -->
                            
                     	  </div>
                     	  </br></br></br>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                     
                      </div>
                      </div>
					 <!-- END Modal content-->
					
				</div>
			</div>
                <!-- MODAL END YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY -->
                </div>
              </div>
	  </c:forEach>
       <!-- END XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
        
        
              
         <div class="col-lg-4 col-xs-6">
                <div class="small-box bg-green">
                    <div class="inner">
                        <h4>Ajouter Menu</h4>

                        <p>Crier un neauvou menu</p>
                             <!-- Modal -->
                                <div id="addMenu" class="modal fade" role="dialog">
                                  <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content bg-gray ">
                                      <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Ajouter nouveau Menu</h4>
                                      </div>
                                      <div class="modal-body">
                                        <p>Menu</p>
                                        
                                            <div class="form-group">
                                            <form:form action="addMenu" method="POST" modelAttribute="menu">
                                            <div class="hidden"><form:input type="text" path="idHotel" value="${idHotel}" /></div>
                                                <span>Choisie le type de votre Menu:</span>
                                              <div class="radio">
                                                <label>
                                                  <form:radiobutton path="typeMenu"  name="typeMenu" value="Resteau"/>
                                                  Resteau
                                                </label>
                                                  </br>
                                                  <label>
                                                  <form:radiobutton path="typeMenu"  name="typeMenu" value="Service"/>
                                                  Service
                                                </label>
                                              </div>    
                                            <form:label path="nomMenu"  class="col-sm-3 control-label">Nom Menu</form:label>
                                              <div class="col-sm-6">
                                                <form:input path="nomMenu" type="text" class="form-control" id="inputNom" placeholder="Nom Menu"/>
                                              </div>
                                              <div class="col-sm-3">
                                               <button type="submit" class="btn btn-primary">Ajouter</button>     
                                             </div>  
                                             </form:form>   
                                            </div>
                                            
                                          </br></br>
                                      </div>
                                      <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                                      </div>
                                    </div>

                                  </div>
                                </div>
                    </div>
                    <div class="icon">
                        <i class="fa fa-plus-square"></i>
                    </div>
                <a href="#" class="small-box-footer" data-toggle="modal" data-target="#addMenu">
                  Ajouter <i class="fa fa-arrow-circle-right"></i>
                </a>
              </div>
            </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      GetFive services
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">GetFive</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                  <span class="label label-danger pull-right">70%</span>
                </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
    <!-- Select2 -->


</body>
</html>
