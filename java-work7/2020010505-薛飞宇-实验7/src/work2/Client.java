package work2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket socket = null;
	InetSocketAddress address = null;
	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	Scanner scanner = null;
	String fileName = null;
	public Client() {
		initSocket();
		initFileSystem();
	}
	
	void initSocket () {
		address = new InetSocketAddress("127.0.0.1", 2018);
		socket = new Socket();
		try {
			socket.connect(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器连接失败");
		}
		System.out.println("成功连接到服务器。");
	}
	
	void initFileSystem() {
		System.out.println("请输入你要下载的文件名：");
		scanner = new Scanner(System.in);
		if(scanner.hasNext()) {
			fileName = scanner.nextLine();
		}
		
		try {
			File file = new File(".\\destination", fileName);
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("文件："+fileName+"创建成功!");
			}
			//将文件的信息先发送给server
			//server创建输出流
			
			//这里做的好像不对
			//filename已经在内存中了，直接把文件名输出
			//记得改一下
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			//接收文件
			bis = new BufferedInputStream(socket.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buffer = new byte[1024];
			int n = 0;
			while((n = bis.read(buffer, 0, 1024))!=-1) {
				bos.write(buffer, 0, n);
			}
			System.out.println("文件："+fileName+"下载成功。");
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		new Client();
	}
}
