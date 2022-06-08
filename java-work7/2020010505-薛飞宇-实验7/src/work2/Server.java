package work2;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket sSocket = null;
	Socket socket = null;
	File file = null;
	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	public Server() {
		initSocketSystem();
		initFileSystem();
	}
	
	//连接socket
	void initSocketSystem() {
		try {
			sSocket = new ServerSocket(2018);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("端口被占用，请重新指定端口。");
		}
		System.out.println("服务器端启动成功。");
		try {
			socket = sSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("连接客户端异常。");
		}
		System.out.println("客户端"+socket.getPort()+"连接成功。");
	}
	
	//初始化文件系统
	void initFileSystem() {
		try {
			//用数据流接收文件信息
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String fileName = dis.readUTF();
			
			file = new File(".\\source", fileName);
			System.out.println("客户端需要下载的文件是："+file.getPath());
			
			//创建指向文件的输入流
			bis = new BufferedInputStream(new FileInputStream(file));
			//创建指向socket的输出流
			bos = new BufferedOutputStream(socket.getOutputStream());
			//创建字节数组的缓冲区
			byte [] buffer = new byte[1024];
			int n = 0;
			//循环读写
			while((n = bis.read(buffer, 0, 1024))!=-1) {
				bos.write(buffer, 0, n);
			}
			System.out.println("文件："+fileName+"上传完毕。");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		new Server();
	}

}
