package work1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = new Socket();
		//新建一个socket对象
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",2018);
		//新建一个Server的socket地址的对象
		try {
			socket.connect(isa);
			//将socket连接Server的地址
			System.out.println("服务器ip："+socket.getInetAddress());
			//获取服务器的ip地址
			System.out.println("服务器端口："+socket.getPort());
			//获取服务器的端口
			System.out.println("客户端socket："+socket.getLocalSocketAddress());
			//获取客户端的socket
			System.out.println("客户端端口："+socket.getLocalPort());
			//获取客户端的端口
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("连接服务器异常。");
		}
	}

}
