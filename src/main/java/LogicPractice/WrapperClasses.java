package LogicPractice;

public class WrapperClasses {

	public static void main(String[] args) {
		// String to primitive data type
		String s = "2";
		System.out.println(Integer.parseInt(s));
		
		System.out.println(Byte.parseByte(s));
		System.out.println(Short.parseShort(s));
		System.out.println(Long.parseLong(s));
		System.out.println(Double.parseDouble(s));
		System.out.println(Float.parseFloat(s));
		System.out.println(Boolean.parseBoolean(s));
		//System.out.println(Character.parseChar(s));  Not supported
		
		// Primitive data type to String
		
		int a = 10;
		char c = 'a';
		boolean bool = true;
		
		System.out.println(String.valueOf(bool));
		System.out.println(String.valueOf(c));
		System.out.println(String.valueOf(a));

	}

}
