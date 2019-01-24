<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_045_gallery</title>
<style type="text/css">
 * {
   margin: 0;
   padding: 0;
   border-width:0
}

li {
   list-style: none;
}

a {
   text-decoration: none;
   color: #000;
}

#gallery{
   width: 350px;
   margin: 30px auto; /*auto: 좌우/ 자동 가운데 배치*/
   border: 1px solid #999;
}

#gallery h1{
   text-align: center;
}

#gallery img{
   border: 1px solid #666;
}

#photo{
   text-align: center;
}

#gallery ul{
   width: 800px;
   margin: 0 auto;
}

#gallery ul li{
   width: 100px;
   float: left;
   text-align: center;
}


#photo_list{
   width: 300px;
   margin: 10px auto;
   overflow: hidden;
}


.btn_wrap{
   text-align: center;
   clear: both;
}

.btn_wrap a{
   font-weight: border;
   font-size: 25px;
}
</style>

<script type="text/javascript">
   window.onload=function(){
      /*포토 목록에 작은 이미지를 클릭했을 때 큰 이미지를 바꿉니다.*/
      var list_zone=document.getElementById("inner_list");
      var ul_li=list_zone.children;
      for(var i=0; i < ul_li.length; i++){
         //a요소 객체값 받아온다
         ul_li[i].children[0].onclick=function(e){
            var ph=document.getElementById("photo").children[0];//ph에 img 저장
            ph.src=this.href; //this = a요소
            //<a>를 클릭했을 때 링크가 되지 않도록 한다.
            //e.preventDefault();
            return false; //다른 창을 안띄우게 하기 위해서 return false
            
         }
      }
      
      /*
      	이전, 다음 버튼을 클릭할 때 마다 <ul>이 100px 만큼 증가 또는 감소되어
      	좌,우측으로 이동됩니다.
      */
      
      /*다음 버튼을 클릭했을 때 마다 <ul>이 100px만큼 좌측으로 이동해야한다.*/
      var m_num=0;//클릭수
      
      var b_btn=document.getElementById("next_btn");
      b_btn.onclick=function(){
         if(m_num>=ul_li.length-3)
            return false;
         
            m_num++;
            list_zone.style.marginLeft= -100*m_num+"px";
            return false;
      };
      
      
      /*이전 버튼을 클릭했을 때 마다 <ul>이 100px만큼 우측으로 이동해야한다.*/
      var n_btn=document.getElementById("before_btn");
      n_btn.onclick=function(){
         if(m_num<=0)
            return false;
         
         m_num--;
         list_zone.style.marginLeft= -100*m_num+"px";
         //<a>를 클릭했을 때 링크가 되지 않도록한다.
         return false;
      }
   }//window.onload/////////////

</script>
</head>
<body>
<div id="gallery">
      <h1>동해안 갤러리</h1>
      <p id="photo">
         <img src="images/pic_1.jpg" width="320" alt="" />
      </p>
      <!-- width: 300px -->
      <div id="photo_list"> 
      <!-- width:800px -->
         <ul id="inner_list">
            <li><a href="images/pic_1.jpg"> <img
                  src="images/pic_t1.jpg" alt="사진1" /></a></li>
            <li><a href="images/pic_2.jpg"> <img
                  src="images/pic_t2.jpg" alt="사진2" /></a></li>
            <li><a href="images/pic_3.jpg"> <img
                  src="images/pic_t3.jpg" alt="사진3" /></a></li>
            <li><a href="images/pic_4.jpg"> <img
                  src="images/pic_t4.jpg" alt="사진4" /></a></li>
            <li><a href="images/pic_5.jpg"> <img
                  src="images/pic_t5.jpg" alt="사진5" /></a></li>
            <li><a href="images/pic_6.jpg"> <img
                  src="images/pic_t6.jpg" alt="사진6" /></a></li>
            <li><a href="images/pic_7.jpg"> <img
                  src="images/pic_t7.jpg" alt="사진7" /></a></li>
            <li><a href="images/pic_8.jpg"> <img
                  src="images/pic_t8.jpg" alt="사진8" /></a></li>
         </ul>
      </div>
      <p class="btn_wrap">
         <a href="#" id="before_btn">&lt;</a> 
         <a href="#" id="next_btn">&gt;</a>
      </p>
   </div>
</body>
</html>