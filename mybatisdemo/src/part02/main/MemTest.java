package part02.main;

import java.util.List;

import part02.dao.MemDAO;
import part02.dto.MemDTO;

public class MemTest {
	 public static void main(String[] args) {
	      MemDAO dao = new MemDAO();

	      //dao.insertMethod(new MemDTO("박사랑", 30, "평야"));
	      
	      //dao.insertMethod(new MemDTO("유대리",20));
	      
	      /*num 컬럼의 값이 3 일때 l
	       * oc컬럼의 값을 '제주'로 수정
	         HashMap<String, Object> map = new HashMap<>();
	         map.put("num", 18);
	         map.put("loc", "제주");
	         dao.updateMethod(map);*/
	      
	      /*int cnt = dao.deleteMethod(18);
	      System.out.println("delete count : " + cnt);*/
	       
	      //flushCache 이 값을 true 로 셋팅하면 구문이 호출될때마다 로컬, 2nd 레벨 캐시가 지워질것이다(flush). 디폴트는 false이다.
	      /*List<MemDTO> alist = new ArrayList<>();
	      alist.add(new MemDTO(dao.keyMethod(),"jsp",18,"summary"));
	      alist.add(new MemDTO(dao.keyMethod(),"java",17,"toronto"));
	      dao.multiInsertMethod(alist);*/
	      
	      /*Integer[] array = new Integer[3];
	      array[0] = 20;
	      array[1] = 21;
	      array[2] = 22;
	      System.out.println("total 삭제 : " + dao.multiDeleteMethod(array));*/
	      
	      
	/*      MemDTO mt = new MemDTO();
	      mt.setAge(30);
	      List<MemDTO> list = dao.searchMethod(mt);*/
	      
	     /* MemDTO mt = new MemDTO();
	      mt.setAge(50);
	      mt.setNum(23);
	      dao.multiUptMethod(mt);*/
	      
	      
	      //MemDTO mm = new MemDTO("방섬이", 40, "경주");
	      MemDTO mm = new MemDTO("돌돌이", 60);
	      dao.locInsMethod(mm);
	      
	      
	      List<MemDTO> list = dao.allMethod();
	      for (MemDTO dto : list)
	         System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());

	   } // end main()

	
	
}
