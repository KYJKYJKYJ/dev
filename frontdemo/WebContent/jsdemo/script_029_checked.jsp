<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_029_checked</title>
</head>
<body>
   <form name="frm" action="#" method="get">
      <textarea rows="3" cols="20">
Most JavaScript programs contain many JavaScript statements.
The statements are executed, one by one, in the same order as they are written.
In this example x, y, and z are given values, and finally z is displayed: 
Most JavaScript programs contain many JavaScript statements.
The statements are executed, one by one, in the same order as they are written.In this example x, y, and z are given values, and finally z is displayed: 
</textarea>

      <br /> <input type="checkbox" name="admin" />약관에 동의합니다.<br />
      <hr />

      <input type="checkbox" name="allCheck" id="allCheck">전체선택<br />
      <input type="checkbox" name="subject1" id="subject1">과목1<br />
      <input type="checkbox" name="subject2" id="subject2">과목2<br />
      <input type="checkbox" name="subject3" id="subject3">과목3<br />
      <input type="submit" value="commit" />
   </form>

   <script type="text/javascript">
      /*
         form요소에서 checked속성
         1. 체크박스와 라디오버튼에서 체크 상태값을 반환하거나 또는 체크 여부를 제어할 수 있다.
         2. 체크가 되어 있으면 true, 안되어 있으면 false를 리턴한다.
       */

      document.frm.allCheck.onclick = function() {
         // alert(this.checked);
         document.frm.subject1.checked = this.checked;
         document.frm.subject2.checked = this.checked;
         document.frm.subject3.checked = this.checked;
      };


      document.frm.onsubmit = function() {
         var admin = document.frm.admin;
         if (!admin.checked) {
            alert("약관에 동의해야 합니다.");
            
            // 경고창 보여주고 더이상 진행되지 않게 하기 위해서 false 리턴.
            return false;
         }
      };
   </script>
</body>
</html>