﻿<html>
<head>
<title>课后练习题</title>

</head>


<body>
	<form action="UserSearch"  method="get">
		姓名:<input id="username" name="username">
		<br>
		性别:<input type="radio" name="sex" checked  id=" sex1" value="0">男
		     <input type="radio"  name="sex" id="sex2"  value="1">女
			 <br>
	       专业:<select id="major" name="major">
	        <option value="">-</option>
			<option value="0">软件工程</option>
			<option value="1" >英语</option>
			<option value="2">数学</option>
		    </select>
		    <br><br>
		    <input type="submit" value="検索">
		<br><br><br>
		検索一覧表
		<hr>
		
	</form>
</body>
</html>