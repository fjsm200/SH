<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h2>文件上传</h2>
	<form id="upLoader"action="system.do?method=upLoaderFile" enctype="multipart/form-data" method="post">

		<input type="file" name="file1" value="浏览">
		<input type="submit" value="开始上传">

</form>
</body>
</html>