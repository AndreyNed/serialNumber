<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input serial number</title>
</head>
<body>
    <div class="wrapper">
    	<div class="form_container">
    		<h1>Введите серийный номер</h1>
    		<form action="Controller" method="post">
    			<input type="hidden" name="command" value="analyze" />
    			<input type="text" name="serial" placeholder="Введите 5 последних цифр" />
    			<input type="submit" name="submit" value="Проверить" />
    		</form>
    	</div>
    </div>
</body>
</html>