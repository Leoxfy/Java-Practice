package work3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Student implements Comparable<Student>{
	String name;
	int number;
	String gender;
	int age;
	
	public Student(String na, int nu, String ge, int ag) {
		name = na;
		number = nu;
		gender = ge;
		age = ag;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", gender=" + gender + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		TreeMap<Student, String>stuMap = new TreeMap<>();
		stuMap.put(new Student("李明", 1001, "男", 19), "上海");
		stuMap.put(new Student("张帆", 1002, "女", 19), "广州");
		stuMap.put(new Student("胡青", 1003, "女", 20), "上海");
		stuMap.put(new Student("王利军", 1004, "男", 19), "成都");
		stuMap.put(new Student("陈小兵", 1005, "男", 20), "西安");
		stuMap.put(new Student("姚华芝", 1006, "女", 18), "西安");
		stuMap.put(new Student("唐秀", 1007, "女", 19), "青岛");
		stuMap.put(new Student("吴洪", 1008, "男", 19), "成都");
		
		//遍历所有学生的信息，输出学号、姓名、城市
		Set<Map.Entry<Student, String>>entrySet = stuMap.entrySet();
		for(Map.Entry<Student, String>entry : entrySet) {
			Student key = entry.getKey();
			String value = entry.getValue();
			System.out.println("学号："+key.number+"\t姓名："+key.name+"\t城市："+value);
		}
		
		//根据学号搜索学生信息，输出
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		System.out.println("请输入要搜索的学号：");
		if(scanner.hasNextInt()) {
			number = scanner.nextInt();
		}
		//用迭代器遍历
		boolean flag1 = false;
		Iterator<Entry<Student, String>>iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<Student, String>entry = iterator.next();
			if(number==entry.getKey().number) {
				flag1 = true;
				System.out.println(entry.getKey()+entry.getValue());
				break;
			}
		}
		if(flag1==false) {
			System.out.println("没有该学生");
		}
		
		
		//添加学生
		System.out.println("请输入要添加学生的(姓名 学号 性别 年龄 城市):");
		String nameAdd = scanner.next();
		int numberAdd = scanner.nextInt();
		String genderAdd = scanner.next();
		int ageAdd = scanner.nextInt();
		String cityAdd = scanner.next();
		stuMap.put(new Student(nameAdd, numberAdd, genderAdd, ageAdd), cityAdd);
		for(Map.Entry<Student, String>entry : entrySet) {
			Student key = entry.getKey();
			String value = entry.getValue();
			System.out.println("学号："+key.number+"\t姓名："+key.name+"\t城市："+value);
		}
		
		
		//删除学生
		System.out.println("请输入要删除学生的学号：");
		int numberDel = scanner.nextInt();
		boolean flagDel = false;
		for(Map.Entry<Student, String>entry : entrySet) {
			if(numberDel==entry.getKey().number) {
				System.out.print(entry.getKey().name);
				stuMap.remove(entry.getKey());
				System.out.println("删除成功");
				flagDel = true;
				break;
			}
		}
		if(flagDel==false) {
			System.out.println("没有该学生");
		}
		for(Map.Entry<Student, String>entry : entrySet) {
			Student key = entry.getKey();
			String value = entry.getValue();
			System.out.println("学号："+key.number+"\t姓名："+key.name+"\t城市："+value);
		}
		
		
		
		
		//建立一个hashMap key是城市 value是Student的列表
		HashMap<String, ArrayList<Student>> cityMap = new HashMap<>();
		
		for(Map.Entry<Student, String>entry : entrySet) {
			if(!cityMap.containsKey(entry.getValue())) {
				cityMap.put(entry.getValue(), new ArrayList<Student>());
				cityMap.get(entry.getValue()).add(entry.getKey());
			}else {
				cityMap.get(entry.getValue()).add(entry.getKey());
			}
		}
		
		
		Set<String> keySet = cityMap.keySet();
		Iterator<String> iterator2 = keySet.iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.print(key);
			System.out.println(":"+cityMap.get(key));
		}
		scanner.close();
	}

	
	
	@Override
	public int compareTo(Student o) {
		return this.number - o.number;
	}
}
