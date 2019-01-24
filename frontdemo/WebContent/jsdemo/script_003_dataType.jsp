<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_003_dataType</title>
<script type="text/javascript">
   
</script>


</head>
<body>

<!-- 
데이터 타입             특징
숫자             자바스크립트는 정수 값과 실수 값을 구분하지 않는다. 
                 모든 숫자는 IEEE 754표준에 의해 정의된 8바이트 크기의 실수로 표현하며 ±5 X 1010308 

문자열(string)   유니코드 문자나 숫자, 문장부호들의 시퀀스로 텍스트를 표현한다.
				 작은따옴표(‘) 큰따옴표(“)쌍으로 문자열을 둘러싸서 문자열을 표현한다. 단일 문자 표현은 길이가 1인문자열로 표현한다.

불리언(Boolean)   불리언 형은 참/거짓의 진리 값 두개를 표현하는데, true 또는 false값을 가진다.

null             예약어 null은 보통 참조 타입과 함께 쓰여, 어떠한 객체도 나타내지 않는 특수한 값으로 사용 한다.

undefined      undefined는 변수는 선언되었으나 값이 할당된 적이 없는 변수에 접근하거나, 존재하지   않는 객체 프로퍼티에 접근할 경우 반환되는 값이다.

배열(array)      배열은 데이터 값들의 모음이다.
				 배열의 각 데이터 값에는 0부터 시작하는 인덱스라는 번호가 있어서 배열명 다음에 대괄호([ ])로 둘러싼 인덱스를 써서 값을 가져올 수 있다.

객체(object)      객체는 이름이 붙은 값들의 모음이다. 이 이름이 붙은 값들을 프로퍼티라고 하며, 객체 프로퍼티는 객체명 다음에 점(.)과 프로퍼티명을 붙이거나,
				 객체명 다음에 대괄호([ ])로 둘러싼 프로퍼티명의 문자열을 써서 접근할 수 있다.

함수(function)   자바스크립트에서 함수는 객체 프로퍼티에 할당 될 수 있는 실행가능한 코드를 가지고 있는 데이터 타입이다.

함수를 실행할 때는 무조건 function 사용해야함 **
function 함수명 (매개변수) {

}
-->

   <script type="text/javascript">
      var num = 10;
      document.write("num=" + typeof num + "<br/>"); //[출력결과] - number

      var str = 'javascript';
      document.write('str=' + typeof str + "<br/>");//[출력결과] - string

      var check = true;
      document.write("check=" + typeof check + "<br/>"); //[출력결과] - boolean

      var data;
      document.write("data=" + typeof data + "<br/>"); //[출력결과] - undefined

      var ko = null;
      document.write("ko=" + typeof ko + "<br/>"); //[출력결과] - object

      var arr = [ 10, 20, 30 ];
      document.write("arr=" + typeof arr + "<br/>"); //[출력결과] - object

      var rect = {
         width : 10,
         height : 20
      };
      document.write("rect=" + typeof rect + "<br/>"); //[출력결과] - object

      var add = function() {
         return "val"
      };
      document.write("add=" + typeof add + "<br/>"); //[출력결과] - function

      document.write("arr[0]=" + arr[0] + "<br/>"); //[출력결과] - 10
      document.write("rect.width=" + rect.width + "<br/>"); //[출력결과] - 10
      document.write("add=" + add + "<br/>"); //[출력결과] - function(){return "val"}
      document.write("add()=" + add() + "<br/>"); //[출력결과] - val
      
      var sum = function(a,b) {return a+b};
      document.write("sum(a,b)=" + sum(5,3) + "<br/>"); //[출력결과] - 8
      
   </script>

</body>
</html>