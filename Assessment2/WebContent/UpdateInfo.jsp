<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateServlet1" method="post">
<h1>
Update info of ${Id} having name ${Name} 
<pre>

Id			: <input type="text" name="t0" value=${Id}  readonly><br>
Name		: <input type="text" name="t1" value=${Name}  readonly><br>
Role      	: <input type="text" name="t2"><br>
Salary 		: <input type="text" name="t3"><br>
Username        : <input type="text" name="t4"><br>
Password        : <input type="password" name="t5"><br>

<input type="submit" name="b1" value="Register"> 
<input type="reset" name="b2" value="RESET">
</pre>
</h1>
</form>

</body>
</html>