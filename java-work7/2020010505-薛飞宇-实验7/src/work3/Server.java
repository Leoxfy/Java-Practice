package work3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket sSocket = null;
	Socket socket = null;
	Triangle triangle = null;
	public static void main(String[] args) {
		Server server = new Server();
		server.initSocket();
		server.procTriange();
	}
	void initSocket() {
		try {
			sSocket = new ServerSocket(2018);
			System.out.println("端口2018启动监听。。。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("端口已被占用。");
		}
		try {
			socket = sSocket.accept();
			System.out.println("客户端"+socket.getRemoteSocketAddress()+"连接成功。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("客户端连接失败。");
		}
	}
	
	void procTriange() {
		ObjectInputStream ois = null;
		DataOutputStream dos = null;
		
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			triangle = (Triangle) ois.readObject();
			if(triangle.isLegal()) {
				dos.writeUTF("三角形合法，面积为："+triangle.calculateArea()+"\n");
			}else {
				dos.writeUTF("三角形不合法。\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
