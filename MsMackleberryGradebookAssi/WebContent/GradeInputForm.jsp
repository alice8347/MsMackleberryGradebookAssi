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
<li class="active"><a href="GradeInput">Input Form</a></li>
<li><a href="GradeOutput">Grade Book</a></li>
<li><a href="GradeAve">Average</a></li>
</ul>
</div>
</div>
</nav>

<div class="container">
<br />
<form class="form-horizontal" role="form" style="width:50% text-align:center" action="GradeInput" method="post">
<div class="form-group">
<label class="control-label col-sm-2" for="assignment">Assignment:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="assignment" id="assignment" placeholder="Enter assignment">
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="grade">Grade:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="grade" id="grade" placeholder="Enter grade">
</div>
</div>
<div class="form-group"> 
<div class="col-sm-offset-2 col-sm-10">
<button type="submit" class="btn btn-default">Submit</button>
</div>
</div>
</form>
</div>

</body>
</html>