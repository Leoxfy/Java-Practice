package work1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileMerge {
	static File parentFolder = new File(".\\files\\poem");;
	static File [] childFiles = parentFolder.listFiles();;
	static File destFile = new File(".\\files\\李白诗集.txt");
	
	
	static void charLineTest() {
		//字符缓冲流-缓冲区为字符串
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
//		eclipse工作区使用GBK编码时
//		字符流都会出现乱码问题
//		字节流正常
		
		//创建李白诗集文件
		if(!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//
		
		try {
			//先新建缓冲流读写对象
			
			writer = new BufferedWriter(new FileWriter(destFile));
			String bufferString;
			for(int i=0;i<childFiles.length;i++) {
				reader = new BufferedReader(new FileReader(childFiles[i]));
				//逐行读取并复制
				while((bufferString = reader.readLine())!=null) {
					writer.write(bufferString);
					writer.newLine();
				}
			}
			
			System.out.println("字符流(缓冲区为行)拷贝完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭流对象
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
	
	static void byteTest() {
		//字节缓冲流-缓冲流为字节数组
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		
		if(!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			
			output = new BufferedOutputStream(new FileOutputStream(destFile));
			byte[] buffer = new byte[200];
			int n = -1;
			for (int i = 0; i < childFiles.length; i++) {
				input = new BufferedInputStream(new FileInputStream(childFiles[i]));
				while ((n = input.read(buffer, 0, 200)) != -1) {
					output.write(buffer, 0, n);
				}
				output.write('\n');
			}
			System.out.println("字节流拷贝完毕");
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static void charArrayTest() {
		//字符缓冲流-缓冲区为字符数组
		BufferedReader reader = null;
		BufferedWriter writer = null;
		

		
		//创建李白诗集文件
		if(!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//
		
		try {
			//先新建缓冲流读写对象
			
			writer = new BufferedWriter(new FileWriter(destFile));
			char [] buffer = new char[10];
			
			for(int i=0;i<childFiles.length;i++) {
				reader = new BufferedReader(new FileReader(childFiles[i]));
				int n = -1;
				while((n = reader.read(buffer,0,10))!=-1) {
					writer.write(buffer,0,n);
				}
				writer.newLine();
			}
			
			System.out.println("字符流(缓冲区为字符数组)拷贝完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭流对象
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
	public static void main(String[] args){
		byteTest();
		//charLineTest();
		//charArrayTest();
	}

}
