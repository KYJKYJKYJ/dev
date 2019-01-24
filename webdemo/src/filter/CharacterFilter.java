package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//새로 프로젝트를 할 때에는 이 필터 패키지는 가지고 가서 넣어놔야 포스트 방식에서 처리할 때 인코딩하는 작업이 필요 없게 된다/!!!

//Filter는 클라이언트에서 요청한 페이지를 수행하기 전후로 처리한다.
//@WebFilter(filterName="flow2") // 만약 필터를 등록하여 사용할 경우 //web.xml에서 수정..
//새로 프로젝트를 만들때 Generate xml 체크 칸이 있는데 그걸 해야지 xml이 생성된다...
@WebFilter("/*")
public class CharacterFilter implements Filter{

   //필터가 웹컨테이너에서 삭제될 때 호출한다.
   @Override
   public void destroy() {
      
   }

   //체인을 따라 다음에 존재하는 필터로 이동한다.
   //체인의 가장 마지막에는 클라이언트가 요청한 최종 자원이 위치한다.
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      request.setCharacterEncoding("UTF-8");
      chain.doFilter(request, response);
   }

   //필터가 웹 컨테이너에 생성한 후 초기화할 때 호출한다.
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      
   }
   
}//end class