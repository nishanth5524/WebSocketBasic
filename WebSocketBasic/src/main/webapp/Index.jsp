<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		var ws = new WebSocket("ws://" + window.location.host
				+ "/WebSocketBasic/end-point");

		ws.onopen = function() {
			document.write("open<br>");
			ws.send("Hi from jsp");

		}

		ws.onclose = function() {
			document.write("close<br>");
		}

		ws.onmessage = function(msg) {
			document.write("Message - >" + msg.data + "<br>");
			ws.close();
		}

		ws.onerror = function() {
			document.write("error");
		}
	</script>
</body>
</html>