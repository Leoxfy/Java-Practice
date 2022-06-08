package work2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers{
	ServerSocket sSocket = null;
	Socket socket = null;
	int count = 0;
	public Servers() throws IOException {
		try {
			sSocket = new ServerSocket(2018);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器端口被占用");
		}
		System.out.println("服务器启动成功");
		while(true) {
			socket = sSocket.accept();
			Thread serverThread = new Thread(new ServerThread(socket));
			serverThread.start();
			count++;
			System.out.println("客户端的数量："+count);
			System.out.println("当前客户端的地址："+socket.getLocalSocketAddress());
		}
	}
	public static void main(String[] args) {
		try {
			new Servers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
