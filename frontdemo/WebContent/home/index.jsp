<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="google-translate-customization" content="6f1073ba568f1202-9c8990a4b3025b3e-ga74e3ea243d3f01d-14"></meta> <!-- 세계 언어 선택 메타 태그 -->
<title> 이지스퍼블리싱 </title>

<link rel="stylesheet" 
        type="text/css" 
        href="css/jquery-ui-1.10.4.custom.min.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css"  />
<link rel="stylesheet" type="text/css" href="css/main.css"  />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
<script type="text/javascript" src="js/swipe.js"></script> 
<script type="text/javascript" src="js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>  

<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<script type="text/javascript">

</script>

<style type="text/css">
 .bx-wrapper{
   margin: auto auto;
 } 
</style>
</head>
<body>
<div id="wrap">
<dl class="hide">
 <dt>스킵 메뉴</dt>
 <dd><a href="#container">본문 바로가기</a></dd>
</dl>
<div id="header">
  <h1><a href="#"><img src="images/logo.gif" alt="이지스퍼블리싱" /></a></h1>
  <dl id="util_menu">
     <dt class="hide">유틸 메뉴</dt>
     <dd class="util_first">
        <ul>
           <li class="login_wrap">
           <a href="#">
           <img src="images/util_menu_1.gif" alt="로그인" />
           </a>
             <!-- 로그인 폼 -->
             <form action="#" method="post" name="log_f" id="login_f">
               <fieldset>
                 <legend>로그인</legend>
                 <p class="user_id">
                    <label for="user_id">
                      <img src="images/login_title_id.gif" alt="아이디" />
                    </label>
                    <input type="text" name="user_id" id="user_id" />
                 </p>
                 <p class="user_pw">
                    <label for="user_pw">
                      <img src="images/login_title_pw.gif" alt="아이디" />
                    </label>
                    <input type="password" name="user_pw" id="user_pw" /></p>
                 <p>
                    <input type="checkbox" name="save_id" id="save_id" />
                    <label for="save_id"> 비밀번호 저장</label>
                 </p>
                 <p class="log_btn">
                    <input type="image" src="images/login_btn.gif" alt="로그인버튼" />
                 </p>
                 <p class="join_btn_wrap">
                     <a href="#">회원가입</a>
                     <a href="#" class="sch_id_btn">아이디/비밀번호 찾기</a>
                 </p>
                 <p class="login_close_btn">
                     <a href="#">
                     <img src="images/login_close_btn.gif" alt="닫기버튼" />
                     </a>
                 </p>
               </fieldset>
             </form>
           </li>
           <li>
            <a href="#"><img src="images/util_menu_2.gif" alt="회원가입" /></a>
           </li>
           <li>
            <a href="#"><img src="images/util_menu_3.gif" alt="도서목록" /></a>
           </li>
           <li>
            <a href="#"><img src="images/util_menu_4.gif" alt="원고지원" /></a>
           </li>
           <li>
            <a href="#"><img src="images/util_menu_5.gif" alt="사이트맵" /></a>
           </li>
        </ul>
     </dd>
     <dd>
        <ul id="zoom">
           <li><img src="images/util_zoom_1.gif" alt="" /></li>
           <li>
            <a href="#" class="zoom_in"><img src="images/util_zoom_2.gif" alt="" /></a>
           </li>
           <li>
            <a href="#" class="zoom_return"><img src="images/util_zoom_3.gif" alt="" /></a>
           </li>
           <li>
            <a href="#" class="zoom_out"><img src="images/util_zoom_4.gif" alt="" /></a>
           </li>
        </ul>
     </dd>
     <dd>
      <a href="#" class="print_btn">
        <img src="images/util_print.gif" alt="" />
      </a>
     </dd>
     <dd>
        <div id="google_translate_element"></div>
     </dd>
  </dl>
  <form action="#" method="get" name="sch_f" id="sch_f">
     <fieldset>
        <legend>검색폼</legend>
        <p>
           <input type="text" name="keyword" id="keyword" title="검색어입력" />
           <input type="image" src="images/header_sch_btn.gif" alt="검색" />
        </p>
     </fieldset>
  </form>
  <h2 class="hide">메인메뉴</h2>
  <ul id="gnb">
     <li><a href="#"><img src="images/gnb_1_out.gif" alt="" /></a>
        <ul class="sub1">
           <li><a href="#">홈으로이동</a></li>
        </ul>
     </li>
     <li>
        <a href="#"><img src="images/gnb_2_out.gif" alt="" /></a>
        <ul class="sub2">
           <li><a href="#">회사소개</a></li>
           <li><a href="#">출간분야</a></li>
           <li><a href="#">찾아오시는 길</a></li>
        </ul>
     </li>
     <li><a href="#"><img src="images/gnb_3_out.gif" alt="" /></a>
        <ul class="sub3">
           <li><a href="#">신간도서</a></li>
           <li><a href="#">인기도서</a></li>
           <li><a href="#">추천도서</a></li>
        </ul>
     </li>
     <li><a href="#"><img src="images/gnb_4_out.gif" alt="" /></a>
        <ul class="sub4">
           <li><a href="#">고객문의</a></li>
           <li><a href="#">저자문의</a></li>
           <li><a href="#">자료요청</a></li>
           <li><a href="#">자주묻는 질문</a></li>
        </ul>
     </li>
  </ul>
  <p id="total_btn">
      <a href="#">
        <img src="images/allmenu_btn_out.gif" alt="전체 메뉴" />
      </a>
  </p>
  <div id="total_menu">
     <dl>
        <dt><img src="images/allmenu_title_1.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">홈으로이동</a></li>
           </ul>
        </dd>
     </dl>
     <dl>
        <dt><img src="images/allmenu_title_2.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">회사소개</a></li>
              <li><a href="#">출간분야</a></li>
              <li><a href="#">찾아오시는 길</a></li>
           </ul>
        </dd>
     </dl>
     <dl>
        <dt><img src="images/allmenu_title_1.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">신간도서</a></li>
              <li><a href="#">인기도서</a></li>
              <li><a href="#">추천도서</a></li>
           </ul>
        </dd>
     </dl>
     <dl>
        <dt><img src="images/allmenu_title_1.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">고객문의</a></li>
              <li><a href="#">저자문의</a></li>
              <li><a href="#">자료요청</a></li>
              <li><a href="#">자주묻는 질문</a></li>
           </ul>
        </dd>
     </dl>
     <p id="total_close">
        <a href="#">
            <img src="images/allmenu_close_btn.gif" alt="전체메뉴 닫기" />
        </a>
     </p>
  </div>
  <p id="date_wrap">
      <span class="year">0000</span> 년
      <span class="month">00</span> 월
      <span class="date">00</span>일
   </p>
</div>
<hr />
<div id="visual">
 <div id="mySwipe"  class='swipe'>
    <ul class="touch_banner swipe-wrap"> <!-- 배너 목록 -->
      <li><a href="#"><img src="images/visual_img_1.jpg" alt="" /></a></li>
      <li><a href="#"><img src="images/visual_img_2.jpg" alt="" /></a></li>
      <li><a href="#"><img src="images/visual_img_3.jpg" alt="" /></a></li>
   </ul>
  </div>
  <ul class="touch_bullet"> <!-- 배너 위치 표시 -->
     <li><img src="images/visual_bullet_on.png" class="active" alt="" /></li>
     <li><img src="images/visual_bullet_off.png" alt="" /></li>
     <li><img src="images/visual_bullet_off.png" alt="" /></li>
  </ul>
  <p class="touch_left_btn"> <!-- 이전 버튼 -->
     <a href="#">
     <img src="images/visual_btn_left.png" alt="이전 배너" />
     </a>
  </p>
  <p class="touch_right_btn"> <!-- 다음 버튼 -->
     <a href="#">
     <img src="images/visual_btn_right.png" alt="다음 배너" />
     </a>
  </p>
</div>
<hr />
<div id="contents">
 <div id="contents_top">
   <div id="roll_banner_wrap">
     <h3><img src="images/pop_title.gif" alt="알림판" /></h3>
     <dl>
       <dt class="roll_btn1">
         <a href="#" class="active">
         <img src="images/pop_btn_1_over.gif" alt="버튼1" />
         </a>
       </dt>
       <dd>
          <a href="#"><img src="images/pop_banner_1.gif" alt="배너1" /></a>
       </dd>
       <dt class="roll_btn2">
          <a href="#"><img src="images/pop_btn_2_out.gif" alt="버튼2" /></a>
       </dt>
       <dd>
          <a href="#"><img src="images/pop_banner_2.gif" alt="배너2" /></a>
       </dd>
       <dt class="roll_btn3">
          <a href="#"><img src="images/pop_btn_3_out.gif" alt="버튼3" /></a>
       </dt>
       <dd>
          <a href="#"><img src="images/pop_banner_3.gif" alt="배너3" /></a>
       </dd>
       <dt class="roll_btn4">
          <a href="#"><img src="images/pop_btn_4_out.gif" alt="버튼4" /></a>
       </dt>
       <dd>
          <a href="#"><img src="images/pop_banner_4.gif" alt="배너4" /></a>
       </dd>
     </dl>
     <p class="ctl_btn">
       <a href="#" class="playBtn">
        <img src="images/pop_btn_play_on.gif" alt="재생 버튼" />
       </a> 
       <a href="#" class="stopBtn">
        <img src="images/pop_btn_stop_off.gif" alt="정지 버튼" />
       </a>
     </p>
   </div>
   <dl id="tabmenu">
     <dt class="tab_btn1">
        <a href="#"><img src="images/tab_btn_1_over.gif" alt="공지사항" /></a>
     </dt>
     <dd>
       <ul>
         <li>
         <a href="#">공지사항 관련된 내용입니다.</a><span>2014-03-01</span>
         </li>
         <li>
         <a href="#">공지사항 관련된 내용입니다.</a><span>2014-03-01</span>
         </li>
         <li>
         <a href="#">공지사항 관련된 내용입니다.</a><span>2014-03-01</span>
         </li>
         <li>
         <a href="#">공지사항 관련된 내용입니다.</a><span>2014-03-01</span>
         </li>
         <li>
         <a href="#">공지사항 관련된 내용입니다.</a><span>2014-03-01</span>
         </li>
       </ul>
       <p>
          <a href="#"><img src="images/tab_more_btn.gif" alt="더보기" /></a>
       </p>
     </dd>
     <dt class="tab_btn2">
        <a href="#"><img src="images/tab_btn_2_out.gif" alt="질문과답변" /></a>
     </dt>
     <dd>
       <ul>
         <li>
           <a href="#">질문과 답변 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">질문과 답변 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">질문과 답변 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">질문과 답변 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">질문과 답변 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
       </ul>
       <p>
          <a href="#"><img src="images/tab_more_btn.gif" alt="더보기" /></a>
       </p>
     </dd>
     <dt class="tab_btn3">
      <a href="#"><img src="images/tab_btn_3_out.gif" alt="저자문의" /></a>
     </dt>
     <dd>
       <ul>
         <li>
           <a href="#">저자문의 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">저자문의 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">저자문의 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">저자문의 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
         <li>
           <a href="#">저자문의 관련된 내용입니다.</a>
           <span>2014-03-01</span>
         </li>
       </ul>
       <p>
        <a href="#"><img src="images/tab_more_btn.gif" alt="더보기" /></a>
       </p>
     </dd>
   </dl>
   <ul id="consult_wrap">
     <li>
      <img src="images/banner_consult.gif" alt="출판 상담 문의 02-3235-1722" />
     </li>
     <li>
     <img src="images/banner_support.gif" alt="원고 양식 다운받기 및 지원 easy@easypub.co.kr" usemap="#support" />
       <map name="support" id="support">
         <area shape="rect" coords="9,29,126,53" href="#" alt="원고 양식 다운 받기" />
       </map>
     </li>
   </ul>
 </div>
 <div id="bestbook_zone">
   <h3>
      <img src="images/bestbook_title.gif" alt="이지스퍼블리싱 베스트 책" />
   </h3>
   <div id="best_bg">
      <ul>
        <li><a href="#"><img src="images/bestbook_list_1.png" alt="" /><span>
              <strong>책 제목</strong>책 저자
            </span></a></li>
        <li><a href="#"><img src="images/bestbook_list_2.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_3.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_4.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_5.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_6.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_7.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_8.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span></a>
        </li>
        <li><a href="#"><img src="images/bestbook_list_9.png" alt="" />
              <span><strong>책 제목</strong>책 저자</span>
              </a>
       </li>
        <li><a href="#">
             <img src="images/bestbook_list_10.png" alt="" />
             <span><strong>책 제목</strong>책 저자</span></a>
        </li>
      </ul>
      <p class="prev_btn">
         <a href="#">
         <img src="images/bestbook_btn_left.png" alt="이전으로 이동" />
         </a>
      </p>
      <p class="next_btn">
         <a href="#">
         <img src="images/bestbook_btn_right.png" alt="다음으로 이동" />
         </a>
      </p>
   </div>
 </div> <!-- close of bestbook_zone -->
 <div id="contents_bottom">
   <div id="facebook_wrap">
     <h3><img src="images/facebook_title.gif" alt="페이스북" /></h3>
     <p>
     <iframe src="http://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2FFacebookDevelopers&amp;width=285&amp;height=258&amp;colorscheme=light&amp;show_faces=true&amp;header=false&amp;stream=false&amp;show_border=false" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:100%; height:258px;" allowTransparency="true"></iframe>
     </p>
   </div>
   <div id="marketing_wrap">
     <h3><img src="images/maket_title.gif" alt="마케팅" /></h3>
     <dl class="first">
       <dt>
          <a href="#">Do it! HTML5+CSS3 웹 표준의 정석 동영상 강좌</a>
       </dt>
       <dd class="img_wrap">
          <a href="#"><img src="images/maket_img_1.gif" alt="" /></a>
       </dd>
       <dd>
          <a href="#">기초부터 반응형 웹까지! HTMl5 권위자에게 정석으로...</a>
       </dd>
     </dl>
     <dl>
       <dt><a href="#">Do it! 안드로이드 진도표와 동영상 강좌</a></dt>
       <dd class="img_wrap">
          <a href="#"><img src="images/maket_img_2.gif" alt="" /></a>
       </dd>
       <dd>
          <a href="#">처음부터 끝까지 보기 힘든 초보자를 위해 
          섹션별 난이도를 표시해 놓았습니다.</a>
       </dd>
     </dl>
   </div>
   <div id="online_wrap">
     <h3><img src="images/online_title.gif" alt="온라인 서점" /></h3>
     <ul>
       <li>
          <a href="#"><img src="images/online_banner_1.gif" alt="배너1" /></a>
       </li>
       <li class="fl_r">
          <a href="#"><img src="images/online_banner_2.gif" alt="배너2" /></a>
       </li>
       <li>
          <a href="#"><img src="images/online_banner_3.gif" alt="배너3" /></a>
       </li>
       <li class="fl_r">
        <a href="#"><img src="images/online_banner_4.gif" alt="배너4" /></a>
       </li>
       <li>
        <a href="#"><img src="images/online_banner_5.gif" alt="배너5" /></a>
       </li>
       <li class="fl_r">
         <a href="#"><img src="images/online_banner_6.gif" alt="배너6" /></a>
       </li>
     </ul>
   </div>
 </div> <!-- close of contents_bottom -->
 <div id="quick_menu">
   <h3><img src="images/quick_title.png" alt="퀵 메뉴" /></h3>
   <ul>
     <li><a href="#"><img src="images/quick_list_1.png" 
     alt="저자지원" /></a></li>
     <li><a href="#"><img src="images/quick_list_2.png"
     alt="교재/강의 요청" /></a></li>
     <li><a href="#"><img src="images/quick_list_3.png"
     alt="신간도서" /></a></li>
     <li><a href="#"><img src="images/quick_top_btn.png" 
     alt="상단으로 이동" /></a></li>
   </ul>
 </div>
 <p id="pop_wrap">
  <img src="images/popup.jpg" alt="검색이 잘 되는 키워드는 따로 있다!" usemap="#pop" />
  <map name="pop" id="pop">
   <area shape="rect" coords="255,332,290,345" href="#" alt="창닫기" />
   <area shape="rect" coords="95,332,215,345" href="#" alt="하루동안 창 닫기" />
  </map>
 </p>
</div> <!-- close of contents -->
</div> <!-- close of wrap -->
<hr />
<div id="footer_wrap">
<div id="inner_footer">
 <h3 class="footer_logo">
    <a href="#"><img src="images/footer_logo.gif" alt="이지스퍼블리싱" /></a>
 </h3>
 <dl id="bottom_menu">
   <dt class="hide">하단메뉴</dt>
   <dd><a href="#"><img src="images/bttom_menu_1.gif" alt="" /></a></dd>
   <dd><a href="#"><img src="images/bttom_menu_2.gif" alt="" /></a></dd>
   <dd><a href="#"><img src="images/bttom_menu_3.gif" alt="" /></a></dd>
   <dd><a href="#"><img src="images/bttom_menu_4.gif" alt="" /></a></dd>
   <dd><a href="#"><img src="images/bttom_menu_5.gif" alt="" /></a></dd>
   <dd><a href="#"><img src="images/bttom_menu_6.gif" alt="" /></a></dd>
 </dl>
 <div id="relSite_wrap">
   <h3><img src="images/rel_site_title.gif" alt="관련 사이트 이동하기" /></h3>
   <form action="#" method="get" name="rel_f">
     <fieldset>
       <legend>관련 사이트 이동</legend>
       <select name="rel_select">
         <option value="http://www.nl.go.kr">국립 중앙 도서관</option>
         <option value="http://www.nanet.go.kr">국회 도서관</option>
         <option value="http://www.dlibrary.go.kr">국가 전자 도서관</option>
       </select>
       <input type="image" src="images/rel_site_btn.gif" alt="관련 사이트 이동" />
     </fieldset>
   </form>
 </div>
 <address>
 <img src="images/address.gif" alt="서울시 마포구 서교동 375-13 성지빌딩 301호, 
 121-894 대표전화 (02) 325-1755 / 326-1723 이메일 easy@easypub.co.kr Copyright &copy; 
 2011-2012 이지스퍼블리싱. All Rights Reserved" />
 </address>
</div>
</div>
</body>
</html>