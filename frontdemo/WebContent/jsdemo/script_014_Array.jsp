<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_014_Array</title>
</head>
<body>

   <script type="text/javascript">
      var cars = [ "Saab", "Volvo", "BMW" ];
      for (var index in cars)
         document.write(cars[index] + "<br/>");
      document.write("<hr/>");

      //object true
      document.write(typeof cars + " " + (cars instanceof Array));
      document.write("<hr/>");
      
      var cars2 = new Array("Saab", "Volvo", "BMW");
      	for(var index in cars2)
      			document.write(cars2[index] + "<br/>");
      	document.write("<hr/>");
      	
      var person = ["Jhon", "Doe", 26];
      for(var index in person)
      	document.write(typeof person[index] + "<br/>");
      document.write("<hr/>");
      
      var person2 = [];
      document.write(person2.length + "<br/>"); // 0
      
      person2[0] = "java";
      person2[3] = "script";
      document.write(person2.length + "<br/>"); // 4
      
      for(var index in person2)
    	  document.write(index + ":" + person2[index] + "<br/>");
      document.write("<hr/>");
      
  	  for(var index = 0; index < person2.length ; index++)
  		document.write(index + ":" + person2[index] + "<br/>");
      document.write("<hr/>");
      
      var point = new Array(10); // 배열의 크기
      document.write(point.length); // 10
      document.write("<hr/>");
      
      var point2 = new Array(10, 20);
      document.write(point2.length); // 2 (10, 20)이 요소로 들어간 것
      document.write(point2[1]); // 20
      document.write("<hr/>");
   </script>

</body>
</html>