package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.DrinkDTO;

public class DrinkDAO {

	private SqlSessionFactory getSqlSessionFactory() {
		String resource = "config/configuration.xml";
		SqlSessionFactory factory = null;

		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return factory;
	}

	public List<DrinkDTO> selectDrink() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);

		return session.selectList("drink.showallDrink");
	}

	public DrinkDTO searchDrink(String name) {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);

		return session.selectOne("drink.searchName", name);
	}

	public List<DrinkDTO> moneyMethod(HashMap<String, Integer> map) {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);

		return session.selectList("drink.searchPrice", map);
	}

	public void insertMethod(DrinkDTO dto) {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		
		session.insert("drink.insertDrink", dto);
	}

	public void updateMethod(HashMap<String, Object> map) {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		
		session.update("drink.updateDrink", map);
	} // end updateMethod()

	public int deleteMethod(int num) {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		
		return session.delete("drink.deleteDrink", num);
	}

}
