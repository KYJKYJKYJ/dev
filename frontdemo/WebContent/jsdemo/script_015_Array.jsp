<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_015_Array</title>
</head>
<body>
	<script type="text/javascript">
		var fruits = ["Banana", "Orange", "Apple", "Mango"];
		document.write(typeof fruits.toString() + "<br/>");
		document.write(typeof String(fruits) + "<br/>");
		//배열도 string으로 받아오는게 가능하다.
		document.write("<hr/>");
		
		//Banana, Orange, Apple, Mango
		document.write(fruits.toString() + "<br/>"); // string 값으로 받아서 그대로 출력
		
		//Banana, Orange, Apple, Mango
		document.write(fruits.join() + "<br/>"); // string으로 바뀌어 있음
		document.write(typeof fruits.join() + "<br/>"); // join()이 공백이면 , 로 연결해서 보여줌
		
		document.write(fruits.join('*') + "<br/>");
		document.write("<hr/>");
		
		fruits[4] = "kiwi";
		document.write(fruits + "<br/>");
		
		document.write(fruits.push("Melon") + "<br/>"); // 6
		document.write(fruits + "<br/>");
		//push해주면 5 인덱스에 들어감
		
		document.write(fruits.pop() + "<br/>"); // Melon 추출
		document.write(fruits + "<br/>");
		document.write("<hr/>");
		
		var fruits2 = ["Banana", "Orange", "Apple", "Mango"];
		document.write(fruits2.slice(1, 3) + "<br/>"); // 인덱스 1 이상 3 미만 복사해서 가져옴
		document.write(fruits2); // 복사해서 가져오는거라 배열에 변동은 없음
		document.write("<hr/>");
		
		//배열에 인덱스를 통해 추가해주는 splice
		//Apple
		//2인덱스부터 1개를 삭제하고 "Lemon", "kiwi" 데이터를 삽입한다.
		document.write(fruits2.splice(2,1,"Lemon","Kiwi") + "<br/>"); // 삭제되는 값만 출력됨
		//앞의 숫자는 몇번 인덱스에 추가할 것인가, 뒤의 숫자는 몇개를 삭제할 것인가?
		document.write(fruits2);
		document.write("<hr/>");
		
		//배열을 합치는  concat
		var myGirls = ["Cecilie", "Lone"];
		var myBoys = ["Emil", "Tobias", "Linus"];
		//Cecilie, Lone, Emil, Tobias, Linus
		document.write(myGirls.concat(myBoys) + "<br/>");
		//object
		document.write(typeof myGirls.concat(myBoys) + "<br/>");
		//2개의 배열을 합쳐서 가져온다.. 배열로
		document.write((myGirls.concat(myBoys) instanceof Array) + "<br/>"); // true
		document.write("<hr/>");
		
		//배열을 정렬하는 sort
		//Banana, Kiwi, Lemon, Mango, Orange
		document.write(fruits2.sort() + "<br/>"); // 배열 자체를 정렬시켜버림 (오름차순)
		document.write(fruits2 + "<br/>"); // 원본도 바뀜 (저장된 메모리영역 자체에서 정렬됨)
		
		//Orange, Mango, Lemon, Kiwi, Banana
		document.write(fruits2.sort().reverse() + "<br/>"); // 정렬된 것을 역순으로 배열 (내림차순)
		document.write("<hr/>");
		
		var point = [40, 100, 1, 5, 10];
		//40,100,1,5,10
		document.write(point + "<br/>");
		
		//1,10,100,40,5
		document.write(point.sort() + "<br/>"); // 원하는 대로 정렬이 되지 않았음
		
		//1,5,10,40,100
		document.write(point.sort(function(a,b) { // 숫자를 정렬할 때는 함수 하나를 추가로 넣어줘야함
			return a-b;
		}));
		
		document.write("<br/>");
		
		document.write(point.sort(function(a,b) { // 숫자를 정렬할 때는 함수 하나를 추가로 넣어줘야함
			return b-a;
		}));
		document.write("<hr/>");
		
		//함수적용하는 reduce, map
		var data = new Array(2, 2, 3);
		function getSum(total, num) { //total은 기본값 0으로 되면서 배열의 요소값이 num에 들어감
			return total + num; // 0 + 2, 2 + 2, 4 + 3 수행하게됨
		}
		
		document.write(data.reduce(getSum) + "<br/>");
		// 왼쪽에서 오른쪽으로 이동하며 배열의 각 요소마다 누적계산값과 함께 함수를 적용하여 하나의 값으로 만들어주는 reduce
		
		// 2,3,4,5
		var numbers = [4, 9, 16, 25];
		document.write(numbers.map(Math.sqrt) + "<br/>");
		// 배열의 모든 요소에 각각 제공된 함수를 호출하고 결과를 모아 새로운 배열을 반환하는 map
		
		// 16, 81, 256, 625
		function myFunction(num) {
			return num * num;
		}
		document.write(numbers.map(myFunction) + "<br/>");
		document.write("<hr/>");
		
		// 배열의 맨 앞에 요소를 추가해주는 unshift
		// Lemon,Banana,Orange,Apple,Mango
		var fruits3 = ["Banana", "Orange", "Apple", "Mango"];
		fruits3.unshift("Lemon");
		document.write(fruits3 + "<br/>");
		
		// 배열의 맨 앞부터 요소를 가져오는 shift
		// Lemon
		document.write(fruits3.shift() + "<br/>");
		document.write("<hr/>");
		
		// 배열의 인덱스를 정해 복사해주는 copyWithin
		var fruits4 = ["Banana", "Orange", "Apple", "Mango"];
		//fruits4.copyWithin(2, 0); // 2번째 인덱스에 0번째 인덱스 부터의 요소를 복사하라
		//Banana, Orange, Banana, Orange
		//document.write(fruits4 + "<br/>");
		
		//fruits4.copyWithin(2, 1); // Orange가 Apple자리에 복사되고 Apple이 Mango자리에 복사됨
		//Banana,Orange,Orange,Apple
		//document.write(fruits4 + "<br/>");
		
		fruits4.copyWithin(2, 3); // Apple 자리에 Mango가 복사됨
		//Banana, Orange, Mango, Mango
		document.write(fruits4 + "<br/>");
		document.write("<hr/>");
		
		//배열 요소마다 한번씩 주어진 함수를 실행해주는 forEach
		var numbers2 = [4, 9, 16, 25];
		function myGet(item, index) { //요소값을 받을 item, 인덱스를 받을 index
			//[0] = 4
			document.write("[" + index + "] = " + item + "<br/>");
		}
		
		//배열 요소마다 한 번씩 주어진 함수를 실행해주는 forEach
		numbers2.forEach(myGet);
		
		
	</script>
</body>
</html>