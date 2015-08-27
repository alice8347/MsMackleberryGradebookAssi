<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Ms Mackleberry's Gradebook</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="GradeInput">Ms Mackleberry's Gradebook</a>
</div>
<div>
<ul class="nav navbar-nav">
<li><a href="GradeInput">Input Form</a></li>
<li><a href="GradeOutput">Grade Book</a></li>
<li class="active"><a href="GradeAve">Average</a></li>
</ul>
</div>
</div>
</nav>
<div class="container">
<p>Average = ${formattedAve}</p>
</div>

</body>
</html>