<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_017_RegExp</title>
</head>
<body>
 <script type="text/javascript">
 var str = "The BEst things in best life are best free";
 //ig -> i : 대소문자 구분없이, g : 모든 문자열에 해당하도록 = 대소문자 상관없이 주어진 문자열에 해당한다면 해당하는 모든 문자열을 치환하라
 //대소문자구분
 //19
 document.write(str.search(/best/)+"<br/>");
 
 //대문소자 구분안함
 //4
 document.write(str.search(/best/i)+"<br/>");
 document.write("<hr/>");
 
 //best
 document.write(str.match(/best/) + "<br/>");
 //best,best
 document.write(str.match(/best/g) + "<br/>");
 //Best,best,best
 document.write(str.match(/best/gi) + "<br/>");
 
 var patt=/e/;
 document.write(patt.test(str) +"<br/>"); //true
 
 patt=/y/i; //정규화 표현식 객체 생성
 document.write(patt.test(str) +"<br/>"); //false
 
 //일치하는 값이 없으면 null을 리턴한다.
 document.write(patt.exec(str) +"<br/>"); //null
 
 document.write(/e/.exec(str)+"<br/>"); //e
 document.write("<hr/>");
 
 //e
 document.write(/e/.exec(str)+"<br/>"); 
 document.write("<hr/>");
 
 
 var ex=new RegExp("e"); //정규화 표현식 객체 생성
 document.write(ex.test(str)+"<br/>");//true
 
 ex=new RegExp("F","i"); //정규화 표현식 객체 생성
 document.write(ex.test(str)+"<br/>"); //true
 </script>
</body>
</html>











