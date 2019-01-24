<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_049_imgbutton</title>
<script type="text/javascript">
   window.onload=function(){
      var sign=document.getElementsByTagName('input')[2]; //button
      sign.onclick=function(){
         var id=document.getElementById('fid').value;////name을 통해서 입력한 값이 밸류에 저장된다.
         console.log("fid: " + id);
         var pass=document.getElementById('fpass').value;
         console.log("fpass: " + pass);
                  
         document.frm.action="script_049_process.jsp";
         document.frm.submit();//서브밋 이벤트 발생시킨다.
      }////////////////////////
      var sign2=document.getElementsByTagName('input')[3]; //submit
      //sign2.onsubmit 현재 페이지 요청
      sign2.onclick=function(){
         document.frm.action="script_049_process.jsp";
      }//////////////////////////////
      
      var sign3=document.getElementsByTagName('button')[0]; //button
      sign3.onclick=function(){
         document.frm.action="script_049_process.jsp";
      }//////////////////////////////
      
      var sign4=document.getElementsByTagName('input')[4]; //submit
      sign4.onclick=function(){
         document.frm.action="script_049_process.jsp";
      }//////////////////////////////
      
      //input type="button" 인 경우에만 강제 서브밋 이벤트를 발생시켜야 한다.
      
      
   }//window.onload///////////////////////////////////////////
</script>
</head>
<body>
   <form name="frm">
      <input type="text" id="fid" name="fid" placeholder="아이디"/>
      <input type="password" id="fpass" name="fpass" placeholder="비밀번호"/>
      <input type="button" value="로그인1" alt="로그인"/> <!-- 강제 submit -->
      <input type="submit" value="로그인2"/> <!-- 자동 submit -->
      <button>로그인3</button> <!-- 자동 submit -->
      
      <!-- 자동 submit -->
      <input type="image" src="images/signin.gif" alt="로그인"/> <!--텍스트 => 알트 속성에다 지정--> 
   </form>
</body>
</html>