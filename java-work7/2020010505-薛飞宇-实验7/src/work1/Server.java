package work1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket sSocket  = null;
		Socket socket = null;
		
		try {
			sSocket = new ServerSocket(2018);
			//将服务器端程序设置端口为2018
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("端口已被占用。");
		}
		try {
			socket = sSocket.accept();
			//等待客户端的连接请求，建立相应的socket
			System.out.println("客户端ip："+socket.getInetAddress());
			//获取客户端的ip地址
			System.out.println("客户端端口："+socket.getPort());
			//获取客户端程序的端口
			System.out.println("服务器端socket："+socket.getLocalSocketAddress());
			//获取服务器端的socket
			System.out.println("服务器端端口："+socket.getLocalPort());
			//获取服务器端的端口
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("连接客户端异常。");
		}
		
	}

}
