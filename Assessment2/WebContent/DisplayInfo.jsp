<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Dashboard.jsp" method="post">
<h1>
Update info of ${Id} having name ${Name} 
<pre>

Id			: <input type="text" name="t0" value=${Id}  readonly><br>
Name		: <input type="text" name="t1" value=${Name}  readonly><br>
Role      	:<input type="text" name="t2" value=${Role}  readonly><br>
Salary 		: <input type="text" name="t3" value=${Salary}  readonly><br>
Username        : <input type="text" name="t4" value=${Username}  readonly><br>
Password        : <input type="text" name="t5" value=${Password}  readonly><br>
<input type="submit" name="b1" value="Dashboard"> 

</pre>
</h1>
</form>

</body>
</html>