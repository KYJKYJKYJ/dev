package java1015_collection.prob;

import java.util.ArrayList;


public class BookManager {
	public static int getRentalPrice(ArrayList<BookDTO> bookList, String kind) {
		// 구현하세요.
		int totalPrice = 0;
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getKind().equals(kind))
				totalPrice += bookList.get(i).getRentalPrice();
		}
		
		return totalPrice;
	}//end getRentalPrice()
}//end class






