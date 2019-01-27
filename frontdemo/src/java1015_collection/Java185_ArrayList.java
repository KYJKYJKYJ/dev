package java1015_collection;

import java.util.Arrays;
import java.util.List;

public class Java185_ArrayList {

	public static void main(String[] args) {
		String[] arr = { "oracle", "mysql", "mssql" };
		//배열 -> 컬렉션
		//static <T> List<T>	asList(T... a)
		//Returns a fixed-size list backed by the specified array. (지정된 배열이 지원하는 고정 크기 목록을 반환합니다.)
		
		List<String> list = Arrays.asList(arr);
		for(String sn : list)
			System.out.println(sn);

	}

}
