package java0920_access.part02;

import java0920_access.part01.Java087_access;

public class Java089_access extends Java087_access {
	//extends 상속 키워드

	public static void main(String[] args) {
		//java087 입력 후 crtl + space 하면 import 문 자동 생성함
		Java089_access j87 = new Java089_access();
		//System.out.println(j87.var_private);
		//System.out.println(j87.var_default);
		System.out.println(j87.var_protected);
		System.out.println(j87.var_public);
		
	}

}
