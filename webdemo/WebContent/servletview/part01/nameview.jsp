<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {

   });
</script>
</head>
<body>
<fieldset>
   <legend>get방식</legend>
   <form name="frm" method="get" action="NamePro">
      <span>name:</span> 
      <input type="text" name="fname" />
      <input type="submit" name="commit" />
   </form>

</fieldset>
<hr>
<fieldset>
   <legend>post방식</legend>
   <form name="frm" method="post" action="NamePro">
      <span>name:</span> 
      <input type="text" name="fname" />
      <input type="submit" name="commit" />
   </form>

</fieldset>
</body>
</html>