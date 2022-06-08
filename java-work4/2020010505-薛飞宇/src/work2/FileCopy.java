package work2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {

	public static void main(String[] args) {
		File desDir = new File(".\\filescopy");
		File desFile = null;
		File srcFile = null;
		Scanner reader = new Scanner(System.in);
		String filename;
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		
		
		//新建目录
		if(!desDir.exists()) {
			desDir.mkdir();
		}
		
		//用户选择文件
		System.out.println("请选择要复制的文件：");
		System.out.println("1) 李白诗集.txt");
		System.out.println("2) 将进酒.txt");
		System.out.println("3) 五古·咏苎萝山.txt");
		
		int mode = reader.nextInt();
		switch (mode) {
		case 1:
			srcFile = new File(".\\files\\李白诗集.txt");
			break;
		case 2:
			srcFile = new File(".\\files\\poem\\将进酒.txt");
			break;
		case 3:
			srcFile = new File(".\\files\\poem\\五古·咏苎萝山.txt");
			break;
		default:
			break;
		}
		
		//新建文件
		filename = ".\\filescopy\\" + srcFile.getName();
		desFile = new File(filename);
		if(!desFile.exists()) {
			try {
				desFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//拷贝文件
		try {
			fileInputStream = new FileInputStream(srcFile);
			fileOutputStream = new FileOutputStream(desFile);
			byte [] buffer = new byte[100];
			int n = -1;
			while((n=fileInputStream.read(buffer, 0, 100))!=-1){
				fileOutputStream.write(buffer, 0, n);
			}
			System.out.println(filename + "文件字节流拷贝完毕");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭文件字节流
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		reader.close();
	}

}
