package work2;

import java.util.ArrayList;
import java.util.Collections;

public class City implements Comparable<City>{
	String name;
	int GDP;
	int population;
	double area;
	double density;
	double averageGDP;
	
	
	public City(String n, int g, int p, double a) {
		name = n;
		GDP = g;
		population = p;
		area = a;
		density = population/area;
		averageGDP = (double)GDP/(double)population;
	}
	
	@Override
	public int compareTo(City o) {
		return o.GDP - this.GDP;
	}
	@Override
	public String toString() {
		return "City [name=" + name + ", GDP=" + GDP + ", population=" + population + ", area=" + area + ", density="
				+ density + ", averageGDP=" + averageGDP + "]";
	}

	public static void main(String[] args) {
		ArrayList<City> cityList = new ArrayList<>();
		cityList.add(new City("北京", 28000, 2171, 16410));
		cityList.add(new City("上海", 30133, 2418, 6340.5));
		cityList.add(new City("深圳", 22286, 1090, 1997.47));
		cityList.add(new City("广州", 21500, 1404, 7434.4));
		cityList.add(new City("重庆", 19530, 3372, 82400));
		cityList.add(new City("苏州", 17000, 1065, 8488.42));
		cityList.add(new City("杭州", 12556, 919, 16853.57));
		cityList.add(new City("南京", 11715, 827, 6622.45));
		cityList.add(new City("常州", 6620, 471, 4385));
		cityList.add(new City("长春", 6613, 880, 20565));
		cityList.add(new City("哈尔滨", 6609, 1063, 53100));
		cityList.add(new City("郑州", 9003, 1001, 7446));
		
		Collections.sort(cityList);
		for(City i:cityList) {
			System.out.println(i);
		}
		
	}
}
