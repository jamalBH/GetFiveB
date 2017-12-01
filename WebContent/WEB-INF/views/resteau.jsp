<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<input type="hidden" name="Language" value=<c:out value="${f}"></c:out> id="lolz"/>

<script type="text/javascript">


var jsonString ;

document.addEventListener('DOMContentLoaded', function () {
	  if (!Notification) {
	    alert('Desktop notifications not available in your browser. Try Chromium.'); 
	    return;
	  }

	  if (Notification.permission !== "granted")
	    Notification.requestPermission();
	});

	function notifyMe() {
	  if (Notification.permission !== "granted")
	    Notification.requestPermission();
	  else {
	    var notification = new Notification('GetFive Notification', {
	      icon: 'https://cdn0.iconfinder.com/data/icons/social-messaging-ui-color-shapes/128/notification-circle-blue-512.png',
	      body: "Nouvelle commande!",
	    });

	  

	  }

	}
var str1 = "ws://localhost:8081/GetFiveB/ff/a";
var str2 =  document.getElementById('lolz').value ;
var uri = str1.concat(str2);


var socket = new WebSocket(uri) ;
var audio = new Audio('theme/sounds/nice-cut.mp3');

socket.onmessage = function(event) {
	setTimeout(function(){
	    location.reload(true);
	},1000);
	
	
	audio.play();
	notifyMe();

	
	//window.location.reload(true);	
	//alert(event.data) ;
}


function sendAnnule(p) {	
	
	  var obj = new Object();
	   obj.id = p;
	   obj.message  = "AnnulerR";
	  
	    jsonString= JSON.stringify(obj);
	   

	  socket.send(jsonString) ; 
	   
		//var msg = '{ "id" : "ziani", "message"  : "Valide" }';
	    
	}
function sendValide(p) {	
		
  var obj = new Object();
   obj.id = p;
   obj.message  = "ValiderR";
  
    jsonString= JSON.stringify(obj);
   

  socket.send(jsonString) ; 
   
	//var msg = '{ "id" : "ziani", "message"  : "Valide" }';
    
}         

</script>


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
                  <small> </small>
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
          <p>${nameHotel}</p>
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
          <li class=""><a href="compte"><i class="fa fa-hotel"></i> <span>Création Comptes</span></a></li>
          <li class=""><a href="facture"><i class="fa fa-money"></i> <span>Facture</span></a></li>
          <li class=""><a href="menus"><i class="fa  fa-edit "></i> <span>Paramétrage</span></a></li>
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
        Gestion Des Commandes
        <small>Resteau</small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here=================================================================================================== -->
              <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Resteurant commandes</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
            
                <tr>
                  <th>ID</th>
                  <th>Chambre</th>
                  <th>Commande</th>
                  <th>Date/Heure</th>
                  <th>Status</th>
                </tr>
                  
             	  <c:forEach var="l" items="${lc}">
             	  
             	  <tr>
             	   <td>${l.id_commande}</td>
             	   <td>${l.chambre.n_chambre}</td>
             		  <td>
             		  <c:forEach var="c" items="${l.ligne_commande}">
             		   ${c.qte} * ${c.name} </br>
             		  </c:forEach> 
             		  </td>
					
					
					 <td>${l.date}</td>
                  <td>
    <a class="btn btn-success"  onclick="sendValide('${l.client.user}')" href="validerResteau?idcmd=${l.id_commande}">Valider</a> 
     <a class="btn btn-danger"  onclick="sendAnnule('${l.client.user}')" href="anullerResteau?idcmd=${l.id_commande}">Annuler</a>     
                
                
                
                  </td>
                  </tr>
                  </c:forEach> 
               
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
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

 
</body>
</html>
