package work3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	
	public static void main(String[] args) {
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		//新建2个学生对象
		Student stu1 = new Student(1001, "Lee", 21, "西北农林");
		Student stu2 = new Student(1003, "Zhang", 22, "西安交大");
		
		//新建文件
		File file = new File(".\\student.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try {
			//新建对象输出流
			outputStream = new ObjectOutputStream(new FileOutputStream(file));
			//对象写入文件
			outputStream.writeObject(stu1);
			outputStream.writeObject(stu2);
			System.out.println("对象流写入文件完成");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//从文件读入对象
		try {
			inputStream = new ObjectInputStream(new FileInputStream(file));
			Student stu3 = (Student)inputStream.readObject();
			Student stu4 = (Student)inputStream.readObject();
			
			System.out.println(stu3);
			System.out.println(stu4);
			stu4.school.setName("西工大");
			System.out.println(stu2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
