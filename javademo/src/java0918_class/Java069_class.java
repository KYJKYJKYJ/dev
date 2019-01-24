package java0918_class;

class MemberVar {
	//멤버변수는 기본값을 제공한다 (JVM)
	byte var_byte;
	short var_short;
	int var_int;
	long var_long; // 0L
	float var_float; //0.0F
	double var_double;
	boolean var_boolean; // false
	char var_char; // \u0000
	int[] num; // null
	//기본값이 정해짐 (0)
}

public class Java069_class {

	public static void main(String[] args) {
		MemberVar mv = new MemberVar();
		System.out.printf("var_byte: %d\n", mv.var_byte);
		System.out.printf("var_short: %d\n", mv.var_short);
		System.out.printf("var_int: %d\n", mv.var_int);
		System.out.printf("var_long: %d\n", mv.var_long);
		System.out.printf("var_float: %f\n", mv.var_float);
		System.out.printf("var_double: %f\n", mv.var_double);
		System.out.printf("var_boolean: %b\n", mv.var_boolean);
		System.out.printf("var_char: %c\n", mv.var_char);
		System.out.printf("int[]: %s\n", mv.num);
	}

}
