package work1;
import java.util.Arrays;

public class CompareTest {

	public static void main(String[] args) {
		Country []arr = new Country [9];
		arr[0] = new Country("GRE", 10, 11, 16);
		arr[1] = new Country("JPN", 27, 14, 17);
		arr[2] = new Country("GBR", 22, 21, 22);
		arr[3] = new Country("CHN", 38, 32, 18);
		arr[4] = new Country("USA", 39, 41, 33);
		arr[5] = new Country("RUS", 20, 28, 23);
		arr[6] = new Country("AUS", 17,  7, 22);
		arr[7] = new Country("HOL", 10, 12, 14);
		arr[8] = new Country("FRA", 10, 12, 11);
		Arrays.sort(arr);
		for(Country i:arr) {
			System.out.println(i);
		}
	}

}
