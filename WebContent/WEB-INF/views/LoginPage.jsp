<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>
GETFIVE services</title>
    
    
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
    
    <link href="assets/css/login.css" rel="stylesheet" />
    <script type="text/javascript" src="assets/js/login.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    

     
</head>
    <body style="background-color:#d4e6f1;">
    
<div class="container">
    <div class="row"  id="startrow">
        <div><img src="assets/img/GetFive.png" id="startimage"></div>   
    </div>
	<div class="row">
         <div class="col-xs-6 box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Se Connecter</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" action="<c:url value='/j_spring_security_check' />" method='POST'>
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-3 control-label">Nom d'utilisateur</label>

                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="username" placeholder="user">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-3 control-label">Mot de passe</label>

                  <div class="col-sm-9">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox"> Me Souvenir
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">Se connecter</button>
              </div>
          <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
            </form>
            

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
          </div>
        <div class="col-xs-1"></div>
        <div class="col-xs-5 box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">S'inscrire</h3>
            </div>
            <!-- form start -->
            <form:form class="form-horizontal" action="saveHotel2" method="post"  modelAttribute="hotel">
              <div class="box-body">
                <div class="form-group">
                  <form:label path="nom" for="inputEmail3" class="col-sm-3 control-label">Nom d'Hotel</form:label>

                  <div class="col-sm-9">
                    <form:input path="nom" type="text" name="hotelName" class="form-control" id="inputEmail3" placeholder="Nom d'hotel"/>
                  </div>
                  
                </div>
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="nom" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                
                <div class="form-group">
                  <form:label path="adresse" for="inputEmail3" class="col-sm-3 control-label">Adresse</form:label>

                  <div class="col-sm-9">
                    <form:input path="adresse" type="text" name="hotelAdresse" class="form-control" id="inputEmail3" placeholder="Adresse"/>
                  </div>
                </div>
                <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="adresse" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                  <div class="form-group">
                  <form:label path="ville" for="inputEmail3" class="col-sm-3 control-label">Ville</form:label>

                  <div class="col-sm-9">
                    <form:input path="ville" type="text" name="hotelVille" class="form-control" id="inputEmail3" placeholder="Ville"/>
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
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios1" value="1" checked=""/>
                        1</form:label>
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios2" value="2" checked=""/>
                        2</form:label>
                       <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios3" value="3" checked=""/>
                        3</form:label>
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios4" value="4" checked=""/>
                        4</form:label>
                      <form:label path="classe" class="col-xs-2">
                      <form:radiobutton path="classe"  name="hotelClass" id="optionsRadios5" value="5" checked=""/>
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
                    <form:input path="tel" type="text" name="hotelTel" class="form-control" id="inputEmail3" placeholder="Telephone"/>
                  </div>
                </div>
                 <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="tel" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                 <div class="form-group">
                  <form:label path="username" for="inputEmail3" class="col-sm-3 control-label">Nom d'utilisateur</form:label>

                  <div class="col-sm-9">
                    <form:input path="username" type="text" name="hotelUser" class="form-control" id="inputEmail3" placeholder="Username"/>
                  </div>
                </div>
                 <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="username" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                  <div class="form-group">
                  <form:label path="password" for="inputEmail3" class="col-sm-3 control-label">Mot de passe</form:label>
                  <div class="col-sm-9">
                    <form:password path="password" name="hotelPass" class="form-control" id="inputEmail3" placeholder="Password"/>
                  </div>
                </div>
                 <div class="form-group">
                <div class="col-xs-4"></div><form:errors path="password" cssClass="text-warning alert alert-danger fade in"/>
                </div>
                <div class="form-group">
                  <form:label path="image" for="inputEmail3" class="col-sm-3 control-label">Lien de Image</form:label>
                  <div class="col-sm-9">
                    <form:input path="image" name="hotelimage" class="form-control" id="inputEmail3" placeholder="URL Image"/>
                  </div>
                </div>
                <form:input type="text" path="role" class="hidden" value="ROLE_ADMIN"/>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="reset" class="btn btn-default">Annuler</button>
                <button type="submit" class="btn btn-info pull-right" id="savecompte">S'inscrire</button>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
              </div>
              <!-- /.box-footer -->
            </form:form>
        
        </div>
    </div>
        
        </div>
        
</body>