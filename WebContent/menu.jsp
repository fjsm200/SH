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
    //工具条  
    var toolbar = new Ext.Toolbar({  
        renderTo:'toolbar',  
        width:window.screen.width,  
        height:50
    });  
    //文件菜单  
    var fileMenu = new Ext.menu.Menu({  
        //设置菜单四条边都有阴影  
        shadow : 'frame',  
        //添加菜单项  
        items:[  
            {  
                text:'上传',  
                handler:onMenuCheck  
            },  
            {  
                text:'下载',  
                handler:onMenuCheck  
            }  
        ]  
    });  
    //编辑菜单  
    var editMenu = new Ext.menu.Menu({  
        shadow : 'frame',  
        items:[  
            {  
                text:'复制',  
                handler:onMenuCheck  
            },  
            {  
                text:'黏贴',  
                handler:onMenuCheck  
            },  
            {  
                text:'剪切',  
                handler:onMenuCheck  
            }  
        ]  
    });  
    //添加菜单到工具条  
    toolbar.add(  
        {text:'文件',menu:fileMenu},  
        {text:'编辑',menu:editMenu}  
    );  
    //菜单项被点击时候的回调函数  
    function onMenuCheck(item){  
        alert(item.text);
        alert(window.screen.width);
    }  
}); 
</script>
<title>菜单栏</title>
</head>
<body>
	<div id = "toolbar"></div>
	<!-- <div id="content"></div>
	<form id="form1" method="post" action="system.do?method=showFileUpAndDown">
		<input id="F1" type="submit" value="文件上传下载功能" />
	</form>
	
	<form id="fohrm2" method="post" action="system.do?method=showChangeWord" >
		<input type="submit" value="转化worl功能" />
	</form> -->
	
</body>
</html>