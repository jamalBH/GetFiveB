<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<input type="hidden" name="Language" value=<c:out value="${f}"></c:out> id="lolz"/>

<script type="text/javascript">

var str1 = "ws://localhost:8081/GetFive8/ff/a";
var str2 =  document.getElementById('lolz').value ;
var uri = str1.concat(str2);
var socket = new WebSocket(uri) ;
socket.onmessage = function(event) {
	
	alert(event.data) ;
	
}

</script>



</body>
</html>