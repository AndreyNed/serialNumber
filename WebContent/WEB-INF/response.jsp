<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Заключение</h1>
	<p>Продукт: ${ product }</p>
	<p>Серийный номер: ${ serial }</p>
	<p>${ conclusion }</p>
	<br/>
	<a href="Controller?command=input">проверить другой номер</a>
</body>
</html>