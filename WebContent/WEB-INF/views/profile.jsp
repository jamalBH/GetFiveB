<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
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
                  <small>Member since Nov. 2017</small>
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
        Votre Hotel profile
        <small></small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here=================================================================================================== -->
          
            <!-- /.box-header -->
            <!-- form start -->
                <div class="row">
                    <div class="col-sm-6">
                          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Compte</h3>
            </div>
     <!-- HOTEL FOR UPDATE DATA FORM==================================================================== -->       
         <form:form class="form-horizontal" action="updateHotel" method="POST" modelAttribute="hotelUpdate">
              <div class="box-body">
               
                <div class="form-group">
                  <form:label path="nom" for="inputEmail3" class="col-sm-3 control-label">Nom d'Hotel</form:label>

                  <div class="col-sm-9">
                    <form:input path="nom" type="text" value="${hot.nom_hotel}" name="hotelName" class="form-control" id="inputEmail3" placeholder="Nom d'hotel"/>
                  </div>
                  
                </div>
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="nom" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                
                <div class="form-group">
                  <form:label path="adresse" for="inputEmail3" class="col-sm-3 control-label">Adresse</form:label>

                  <div class="col-sm-9">
                    <form:input path="adresse" type="text" value="${hot.address_hotel}" name="hotelAdresse" class="form-control" id="inputEmail3" placeholder="Adresse"/>
                  </div>
                </div>
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="adresse" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                  <div class="form-group">
                  <form:label path="ville" for="inputEmail3" class="col-sm-3 control-label">Ville</form:label>

                  <div class="col-sm-9">
                    <form:input path="ville" type="text" value="${hot.ville_hotel}" name="hotelVille" class="form-control" id="inputEmail3" placeholder="Ville"/>
                  </div>
                </div>
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="ville" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                
              <div class="form-group">
                <form:label path="paye" class="col-sm-3 control-label">Paye </form:label>
                      <div class="col-sm-8">
                <form:select path="paye" class="form-control">
                   <option value="af">Afghanistan </option>
                    <option value="al">Albania </option>
                    <option value="dz">Algeria </option>
                    <option value="as">American Samoa </option>
                    <option value="ad">Andorra </option>
                    <option value="ao">Angola </option>
                    <option value="ai">Anguilla </option>
                    <option value="aq">Antarctica </option>
                    <option value="ag">Antigua and Barbuda </option>
                    <option value="ar">Argentina </option>
                    <option value="am">Armenia </option>
                    <option value="aw">Aruba </option>
                    <option value="au">Australia </option>
                    <option value="at">Austria </option>
                    <option value="az">Azerbaijan </option>
                    <option value="bs">Bahamas </option>
                    <option value="bh">Bahrain </option>
                    <option value="bd">Bangladesh </option>
                    <option value="bb">Barbados </option>
                    <option value="by">Belarus </option>
                    <option value="be">Belgium </option>
                    <option value="bz">Belize </option>
                    <option value="bj">Benin </option>
                    <option value="bm">Bermuda </option>
                    <option value="bt">Bhutan </option>
                    <option value="bo">Bolivia </option>
                    <option value="ba">Bosnia and Herzegovina </option>
                    <option value="bw">Botswana </option>
                    <option value="bv">Bouvet Island </option>
                    <option value="br">Brazil </option>
                    <option value="io">British Indian Ocean Territory </option>
                    <option value="vg">British Virgin Islands </option>
                    <option value="bn">Brunei </option>
                    <option value="bg">Bulgaria </option>
                    <option value="bf">Burkina Faso </option>
                    <option value="bi">Burundi </option>
                    <option value="kh">Cambodia </option>
                    <option value="cm">Cameroon </option>
                    <option value="ca">Canada </option>
                    <option value="cv">Cape Verde </option>
                    <option value="ky">Cayman Islands </option>
                    <option value="cf">Central African Republic </option>
                    <option value="td">Chad </option>
                    <option value="cl">Chile </option>
                    <option value="cn">China </option>
                    <option value="cx">Christmas Island </option>
                    <option value="cc">Cocos Islands </option>
                    <option value="co">Colombia </option>
                    <option value="km">Comoros </option>
                    <option value="cg">Congo </option>
                    <option value="ck">Cook Islands </option>
                    <option value="cr">Costa Rica </option>
                    <option value="hr">Croatia </option>
                    <option value="cu">Cuba </option>
                    <option value="cy">Cyprus </option>
                    <option value="cz">Czech Republic </option>
                    <option value="dk">Denmark </option>
                    <option value="dj">Djibouti </option>
                    <option value="dm">Dominica </option>
                    <option value="do">Dominican Republic </option>
                    <option value="tp">East Timor </option>
                    <option value="ec">Ecuador </option>
                    <option value="eg">Egypt </option>
                    <option value="sv">El Salvador </option>
                    <option value="gq">Equatorial Guinea </option>
                    <option value="er">Eritrea </option>
                    <option value="ee">Estonia </option>
                    <option value="et">Ethiopia </option>
                    <option value="fk">Falkland Islands </option>
                    <option value="fo">Faroe Islands </option>
                    <option value="fj">Fiji </option>
                    <option value="fi">Finland </option>
                    <option value="fr">France </option>
                    <option value="gf">French Guiana </option>
                    <option value="pf">French Polynesia </option>
                    <option value="tf">French Southern Territories </option>
                    <option value="ga">Gabon </option>
                    <option value="gm">Gambia </option>
                    <option value="ge">Georgia </option>
                    <option value="de">Germany </option>
                    <option value="gh">Ghana </option>
                    <option value="gi">Gibraltar </option>
                    <option value="gr">Greece </option>
                    <option value="gl">Greenland </option>
                    <option value="gd">Grenada </option>
                    <option value="gp">Guadeloupe </option>
                    <option value="gu">Guam </option>
                    <option value="gt">Guatemala </option>
                    <option value="gn">Guinea </option>
                    <option value="gw">Guinea-Bissau </option>
                    <option value="gy">Guyana </option>
                    <option value="ht">Haiti </option>
                    <option value="hm">Heard and McDonald Islands </option>
                    <option value="hn">Honduras </option>
                    <option value="hk">Hong Kong </option>
                    <option value="hu">Hungary </option>
                    <option value="is">Iceland </option>
                    <option value="in">India </option>
                    <option value="id">Indonesia </option>
                    <option value="ir">Iran </option>
                    <option value="iq">Iraq </option>
                    <option value="ie">Ireland </option>
                    <option value="il">Israel </option>
                    <option value="it">Italy </option>
                    <option value="ci">Ivory Coast </option>
                    <option value="jm">Jamaica </option>
                    <option value="jp">Japan </option>
                    <option value="jo">Jordan </option>
                    <option value="kz">Kazakhstan </option>
                    <option value="ke">Kenya </option>
                    <option value="ki">Kiribati </option>
                    <option value="kp">Korea, North </option>
                    <option value="kr">Korea, South </option>
                    <option value="kw">Kuwait </option>
                    <option value="kg">Kyrgyzstan </option>
                    <option value="la">Laos </option>
                    <option value="lv">Latvia </option>
                    <option value="lb">Lebanon </option>
                    <option value="ls">Lesotho </option>
                    <option value="lr">Liberia </option>
                    <option value="ly">Libya </option>
                    <option value="li">Liechtenstein </option>
                    <option value="lt">Lithuania </option>
                    <option value="lu">Luxembourg </option>
                    <option value="mo">Macau </option>
                    <option value="mk">Macedonia, Yugoslav Republic of </option>
                    <option value="mg">Madagascar </option>
                    <option value="mw">Malawi </option>
                    <option value="my">Malaysia </option>
                    <option value="mv">Maldives </option>
                    <option value="ml">Mali </option>
                    <option value="mt">Malta </option>
                    <option value="mh">Marshall Islands </option>
                    <option value="mq">Martinique </option>
                    <option value="mr">Mauritania </option>
                    <option value="mu">Mauritius </option>
                    <option value="yt">Mayotte </option>
                    <option value="mx">Mexico </option>
                    <option value="fm">Micronesia, Federated States of </option>
                    <option value="md">Moldova </option>
                    <option value="mc">Monaco </option>
                    <option value="mn">Mongolia </option>
                    <option value="ms">Montserrat </option>
                    <option value="ma" selected="selected">Morocco </option>
                    <option value="mz">Mozambique </option>
                    <option value="mm">Myanmar </option>
                    <option value="na">Namibia </option>
                    <option value="nr">Nauru </option>
                    <option value="np">Nepal </option>
                    <option value="nl">Netherlands </option>
                    <option value="an">Netherlands Antilles </option>
                    <option value="nc">New Caledonia </option>
                    <option value="nz">New Zealand </option>
                    <option value="ni">Nicaragua </option>
                    <option value="ne">Niger </option>
                    <option value="ng">Nigeria </option>
                    <option value="nu">Niue </option>
                    <option value="nf">Norfolk Island </option>
                    <option value="mp">Northern Mariana Islands </option>
                    <option value="no">Norway </option>
                    <option value="om">Oman </option>
                    <option value="pk">Pakistan </option>
                    <option value="pw">Palau </option>
                    <option value="pa">Panama </option>
                    <option value="pg">Papua New Guinea </option>
                    <option value="py">Paraguay </option>
                    <option value="pe">Peru </option>
                    <option value="ph">Philippines </option>
                    <option value="pn">Pitcairn Island </option>
                    <option value="pl">Poland </option>
                    <option value="pt">Portugal </option>
                    <option value="pr">Puerto Rico </option>
                    <option value="qa">Qatar </option>
                    <option value="re">Reunion </option>
                    <option value="ro">Romania </option>
                    <option value="ru">Russia </option>
                    <option value="rw">Rwanda </option>
                    <option value="gs">S. Georgia and S. Sandwich Isls. </option>
                    <option value="kn">Saint Kitts &amp; Nevis </option>
                    <option value="lc">Saint Lucia </option>
                    <option value="vc">Saint Vincent and The Grenadines </option>
                    <option value="ws">Samoa </option>
                    <option value="sm">San Marino </option>
                    <option value="st">Sao Tome and Principe </option>
                    <option value="sa">Saudi Arabia </option>
                    <option value="sn">Senegal </option>
                    <option value="sc">Seychelles </option>
                    <option value="sl">Sierra Leone </option>
                    <option value="sg">Singapore </option>
                    <option value="sk">Slovakia </option>
                    <option value="si">Slovenia </option>
                    <option value="so">Somalia </option>
                    <option value="za">South Africa </option>
                    <option value="es">Spain </option>
                    <option value="lk">Sri Lanka </option>
                    <option value="sh">St. Helena </option>
                    <option value="pm">St. Pierre and Miquelon </option>
                    <option value="sd">Sudan </option>
                    <option value="sr">Suriname </option>
                    <option value="sj">Svalbard and Jan Mayen Islands </option>
                    <option value="sz">Swaziland </option>
                    <option value="se">Sweden </option>
                    <option value="ch">Switzerland </option>
                    <option value="sy">Syria </option>
                    <option value="tw">Taiwan </option>
                    <option value="tj">Tajikistan </option>
                    <option value="tz">Tanzania </option>
                    <option value="th">Thailand </option>
                    <option value="tg">Togo </option>
                    <option value="tk">Tokelau </option>
                    <option value="to">Tonga </option>
                    <option value="tt">Trinidad and Tobago </option>
                    <option value="tn">Tunisia </option>
                    <option value="tr">Turkey </option>
                    <option value="tm">Turkmenistan </option>
                    <option value="tc">Turks and Caicos Islands </option>
                    <option value="tv">Tuvalu </option>
                    <option value="um">U.S. Minor Outlying Islands </option>
                    <option value="ug">Uganda </option>
                    <option value="ua">Ukraine </option>
                    <option value="ae">United Arab Emirates </option>
                    <option value="uk">United Kingdom </option>
                    <option value="us">United States of America</option>
                    <option value="uy">Uruguay </option>
                    <option value="uz">Uzbekistan </option>
                    <option value="vu">Vanuatu </option>
                    <option value="va">Vatican City </option>
                    <option value="ve">Venezuela </option>
                    <option value="vn">Vietnam </option>
                    <option value="vi">Virgin Islands </option>
                    <option value="wf">Wallis and Futuna Islands </option>
                    <option value="eh">Western Sahara </option>
                    <option value="ye">Yemen </option>
                    <option value="yu">Yugoslavia (Former) </option>
                    <option value="zr">Zaire </option>
                    <option value="zm">Zambia </option>
                    <option value="zw">Zimbabwe </option>
                </form:select>
                      </div></div>
                  <div class="form-group">
                  <form:label path="classe" for="inputEmail3" class="col-sm-3 control-label">Classe</form:label>
                
                  <div class="col-sm-9">
                            <div class="row">
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios1" value="1" />
                        1</form:label>
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios2" value="2"/>
                        2</form:label>
                       <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios3" value="3"/>
                        3</form:label>
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios4" value="4" />
                        4</form:label>
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios5" value="5" />
                        5</form:label>
                        </div>  
                      </div>
                </div>
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="classe" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                  <div class="form-group">
                  <form:label path="tel" for="inputEmail3" class="col-sm-3 control-label">Telephone</form:label>

                  <div class="col-sm-9">
                    <form:input path="tel" type="text" value="${hot.tel_hotel}" name="hotelTel" class="form-control" id="inputEmail3" placeholder="Telephone"/>
                  </div>
                </div>
                 <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="tel" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                 
                </div>
              <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-right">Enregistrer</button>
              </div>
              <!-- /.box-footer -->
                  
            </form:form>
           </div>
                                  <!--Categories des chambres=================================================-->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Categories de Chambre</h3>
            </div>
            <form:form class="form-horizontal" action="saveCat" method="POST" modelAttribute="categorie">
              <div class="box-body">
                 <div class="form-group">
   <!-- A changer la valeur de IDHOTEL XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->              
               
                  <form:label path="nom_chambre_categorie" for="inputEmail3" class="col-sm-3 control-label">Nom de Categorie</form:label>

                  <div class="col-sm-9">
                    <form:input path="nom_chambre_categorie" type="text" class="form-control" id="inputEmail3" placeholder="Nom de categorie"/>
                  </div>
                </div>
                <div class="form-group">
                 <div class="col-xs-4"></div><form:errors path="nom_chambre_categorie" cssClass="text-warning alert alert-danger fade in"/> 
                </div>
                </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">Enregistrer</button>
              </div>
              <!-- /.box-footer -->
                  
            </form:form>
           </div>
                         <!-- chambres=======================================================================-->
         <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Chambres</h3>
            </div>
            <form:form class="form-horizontal" action="saveChambre" method="POST" modelAttribute="chambre">
              <div class="box-body">
                 <!-- XXXXXXXXXXXXXXX ID HOTEL XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->  
             
                 <div class="form-group">
                  <form:label path="chambre_categorie" for="inputEmail3" class="col-sm-3 control-label">
                  Choisie une Categorie</form:label>

                  <div class="col-sm-9">
                     <form:select path="chambre_categorie" class="form-control">
                     
                     <c:forEach items="${l}" var="cat">
                       <form:option value="${cat.id_chambre_categorie}">      <c:out value="${cat.nom_chambre_categorie} "/>     </form:option>
	                   </c:forEach>
                     
                 
	                    
                      </form:select>
                  </div>
                  
                </div>
                <div class="form-group">
                <form:errors path="chambre_categorie" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                <div class="form-group">
                  <form:label path="N_chambre" for="inputEmail3" class="col-sm-3 control-label">N° Chambre</form:label>

                  <div class="col-sm-9">
                    <form:input path="N_chambre" type="text" class="form-control" id="inputEmail3" placeholder="N° du Chambre"/>
                  </div>
                </div> 
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="N_chambre" cssClass="text-warning alert alert-danger fade in"/></div>
                </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">Enregistrer</button>
              </div>
              <!-- /.box-footer -->
                  
            </form:form>
           </div>
        </div>
         <div class="col-sm-6">
            <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Création des utilisateurs</h3>
            </div>  
                 <form:form class="form-horizontal" action="CreateUser" method="POST" modelAttribute="user">
                     <div class="box-body">
                     <!-- XXXXXXXXXXXXXXX ID HOTEL XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->            
                   <form:input path="idHotel" class="hidden" value="${idHotel}"/>
                     <div class="form-group">
                  <form:label path="name" class="col-sm-3 control-label">Nom d'utilisateur</form:label>
                  <div class="col-sm-8">
                    <form:input path="name" type="text" class="form-control" id="inputNom" placeholder="Nom d'utilisateur" />
                  </div>
                </div>
                <div class="form-group">
                  <form:label path="password"  class="col-sm-3 control-label">Mot de passe</form:label>
                  <div class="col-sm-8">
                    <form:input path="password" type="password" class="form-control" id="inputPrenom" placeholder="Mot de passe" />
                  </div>
                </div>
                <div class="form-group">
                  <form:label path="role"  class="col-sm-3 control-label">Role</form:label>
                  <div class="col-sm-8">
               			 <form:select path="role" class="form-control">
               			   <option value="ROLE_ADMIN">Admin</option>
               			   <option value="ROLE_SERVICE">Service Manager</option>
               			   <option value="ROLE_RESTEAU">Resteau Manager</option>
               			   <option value="ROLE_RECEPTION">Reception</option>
               			 </form:select>
                  </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                     </div>
                       <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-right">Enregistrer</button>
              </div>
              <!-- /.box-footer -->
                </form:form>
        </div>
                 <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Description <small>Pour publication</small></h3>
            </div>  
                 <form class="form-horizontal">
                     <div class="box-body">
                    <div class="form-group">
                        <div class="col-xs-1"></div>
                       <div class="col-xs-10"> <textarea class="form-control" rows="4" placeholder="Entrez votre descrption ici..."></textarea></div>
                        <div class="col-xs-1"></div>
                    </div>
                     </div>
                      <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-right">Enregistrer</button>
              </div>
                </form>
        </div>
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