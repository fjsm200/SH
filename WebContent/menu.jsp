<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="lib/ext4.1/resources/css/ext-all.css"></link>  
<script type="text/javascript" src="lib/ext4.1/ext-all.js"></script>          
<script type="text/javascript" src="lib/ext4.1/locale/ext-lang-zh_CN.js"></script>

<script type="text/javascript">
	Ext.onReady(function(){
		var toolbar = new Ext.Toolbar({
			renderTo:"toolbar",
			width   :window.screen.width,
			height  :30
		});
		
		var fileMenu = new Ext.menu.Menu({
			shadow 	:"frame",
			items	:[
			     	  {
			     		text:"文件上传",
			     	   	handler:onMenuClick1
			     	   },
			     	  {
			     		text:"文件下载",
			     		handler:onMenuClick2
			     	   }
			     	   ]
		});
		
		toolbar.add({text:"文件功能",menu:fileMenu});
		function onMenuClick1(item){
			alert(item.text);
			document.location.href="system.do?method=showFileUpAndDown&pv=22";
		};
		function onMenuClick2(item){
			document.location.href="system.do?method=showChangeWord";
		}
	});
	
</script>
<title>菜单栏</title>
</head>
<body>
	<div id = "toolbar"></div>
</body>
</html>