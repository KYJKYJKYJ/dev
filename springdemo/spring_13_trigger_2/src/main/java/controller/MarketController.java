package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.SalesDTO;
import dto.WarehouseDTO;
import service.MarketService;

//http://localhost:8090/mytrigger/itemList.do

@Controller
public class MarketController {
	private MarketService service;

	public MarketController() {

	}

	public void setService(MarketService service) {
		this.service = service;
	}

	@RequestMapping("/itemList.do")
	public ModelAndView itemSelectList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.itemSelectProcess());
		
		mav.setViewName("itemList");
		return mav;
	}//itemSelectList()
	
	@RequestMapping("/productIns.do")
	public ModelAndView inputForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.pnameSelectProcess());
		
		mav.setViewName("productForm");
		return mav;
	}
	
	@RequestMapping("/productPro.do")
	public String inputProcess(WarehouseDTO dto) {
		service.insertProcess(dto);
		
		return "redirect:itemList.do";
	}
	
	@RequestMapping("/salesIns.do")
	public ModelAndView salseFrom() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.pnameSelectProcess());
		
		mav.setViewName("salesForm");
		return mav;
	}
	
	@RequestMapping("/salesPro.do")
	public String salesProcess(SalesDTO dto, HttpServletResponse resp) {
		String path = "redirect:itemList.do";
		try {
			service.salesInsertProcess(dto);
		} catch(Exception e) {
			System.out.println(e.toString());
			
			try {
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				out.println("<script language='javascript'>");
				out.println("alert('재고가 부족합니다2');");
				out.println("location.href='salesIns.do';");
				out.println("</script>");
				out.flush();
				path = "salesForm";
			} catch (IOException e1) {
				//e1.printStackTrace();
				System.out.println("이러지마 제발");
			} 
		}
		
		return path;
	}
	
}// end class









