package work3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


public class Client {
	Socket socket = null;
	Triangle triangle = null;
	String result;
	public Client() {
		
	}
	void initSocket() {
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 2018);
		socket = new Socket();
		try {
			socket.connect(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void initTriangle(int a, int b, int c) {
		triangle = new Triangle(a, b, c);
	}
	void sendTriange() {
		DataInputStream dis = null;
		ObjectOutputStream oos = null;
		try {
			dis = new DataInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(triangle);
			
			result = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	String getSocketInfo() {
		if(!socket.isConnected()) {
			return "连接服务器失败。\n";
		}
		return "连接服务器成功,当前socket地址："+socket.getLocalSocketAddress()+"\n";
	}
}
