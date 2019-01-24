<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_034_window_setInterval</title>
<script type="text/javascript">
  window.onload=function(){
     var timer = document.getElementById("time");
     var itvID=window.setInterval(function(){
          var now = new Date();
         var year = now.getFullYear();
         var month = now.getMonth();
         var date = now.getDate();
         var day = now.getDay();
         var hour = now.getHours();
         var minute = now.getMinutes();
         var second = now.getSeconds();
         var how = '오전';
         switch (day) {
         case 0:
            day = "일요일";
            break;
         case 1:
            day = "월요일";
            break;
         case 2:
            day = "화요일";
            break;
         case 3:
            day = "수요일";
            break;
         case 4:
            day = "목요일";
            break;
         case 5:
            day = "금요일";
            break;
         case 6:
            day = "토요일";
            break;
         }
         
         if (hour > 12) {
            hour -= 12;
            how = '오후';
         }
         
         if (minute < 10)
            minute = "0" + minute;
         
         if (second < 10)
            second = "0" + second;
      
      timer.innerHTML = year + '년 ' + (month + 1) + '월 '
       + date + '일 ' + day
       + ' ' + how + hour + ':' + minute + ':' + second;
     },1000);
     
     var btn=document.getElementsByTagName("input")[0];
     btn.onclick=stop;
     
     function stop(){
        clearInterval(itvID);
     }
  };
  
  
</script>
</head>
<body>
   <div id="time">Time</div>
   <input type="button" value="Stop timer">
</body>
</html>



