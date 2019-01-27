package main;

import java.util.HashMap;
import java.util.List;

import dao.DrinkDAO;
import dto.DrinkDTO;

public class DrinkTest {
	public static void main(String[] args) {
		DrinkDAO dao = new DrinkDAO();
		
		List<DrinkDTO> alllist = dao.selectDrink();
		for(DrinkDTO dto : alllist)
			System.out.printf("%d %s %d %d\n", dto.getNum(), dto.getName(), dto.getPrice(), dto.getAlcohol());
		
		System.out.println("=============================");
		
		DrinkDTO searchlist = dao.searchDrink("soju");
		System.out.printf("%d %s %d %d\n", searchlist.getNum(), searchlist.getName(), searchlist.getPrice(), searchlist.getAlcohol());
		
		System.out.println("=============================");
		
		HashMap<String, Integer> drinkMap = new HashMap<String, Integer>();
		drinkMap.put("lowPrice", 1000);
		drinkMap.put("highPrice", 1500);
		List<DrinkDTO> dlist = dao.moneyMethod(drinkMap);
		
		for(DrinkDTO dto : dlist)
			System.out.printf("%d %s %d %d\n", dto.getNum(), dto.getName(), dto.getPrice(), dto.getAlcohol());
		
		System.out.println("=============================");
		
		dao.insertMethod(new DrinkDTO("whisky", 40000, 40));
	}
}
