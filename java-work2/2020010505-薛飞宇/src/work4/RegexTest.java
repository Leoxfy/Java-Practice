package work4;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		//test1();
		test2();
	}
	static void test1() {
		Person [] person = new Person [4];
		
		String str = "�����13754897852�Ƿ�18412345612����15828737890������13047586950";

		Pattern pat = Pattern.compile("([\\u4e00-\\u9fa5]{2,3})(\\d{11})");
		Matcher mat = pat.matcher(str);
		int i = 0;
		while(mat.find()) {
			person[i] = new Person(mat.group(1), mat.group(2));
			i++;
		}
		for(int j=0;j<4;j++) {
			System.out.println(person[j]);
		}
	}
	static void test2() {
		Person [] person = new Person [6];
		
		String str = "�����13754897852�Ƿ�18412345612����15828737890������13047586950�����ܲ�1939-3275648˼����993-27685954";

		Pattern pat = Pattern.compile("([\\u4e00-\\u9fa5]{2,4})(\\d{11}|\\d{3,4}-\\d{7,8})");
		Matcher mat = pat.matcher(str);
		int i = 0;
		while(mat.find()) {
			person[i] = new Person(mat.group(1), mat.group(2));
			i++;
		}
		for(int j=0;j<i;j++) {
			System.out.println(person[j]);
		}
	}
}
