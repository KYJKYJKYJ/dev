package part06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8090/myweb/orderList.htm
@Controller
public class OrderListController {
	private OrderDAO dao;

	public OrderListController() {
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/orderList.htm")
	public ModelAndView process() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("aList",dao.selectMethod());
		mav.setViewName("view/part06/list");
		return mav;
	}//end process()
}// end class





