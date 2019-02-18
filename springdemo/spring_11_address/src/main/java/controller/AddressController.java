package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myaddress/address.do
@Controller
public class AddressController {
	public AddressController() {
	
	}
	
	@RequestMapping("/address.do")
	public String addressForm() {
		return "addressjuso";
	}
	
	@RequestMapping("/popup.do")
	public String popupForm() {
		return "jusoPopup";
	}
}
