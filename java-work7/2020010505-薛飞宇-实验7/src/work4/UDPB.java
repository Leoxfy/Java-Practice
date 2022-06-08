package work4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPB {
	DatagramSocket dSocket = null;
	public static void main(String[] args) {
		new UDPB();
	}
	
	public UDPB() {
		initDatagramSocket();
		receiveDatagramPacket();
		dSocket.close();
	}
	
	void initDatagramSocket() {
		try {
			dSocket = new DatagramSocket(2021);
			System.out.println("接收端口:"+dSocket.getLocalPort()+"启动成功！");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("接收端口被占用。");
		}
	}
	
	void receiveDatagramPacket() {
		byte [] buffer = new byte[1024];
		DatagramPacket inDatagramPacket = new DatagramPacket(buffer, 1024);
		try {
			dSocket.receive(inDatagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = new String(buffer, 0, inDatagramPacket.getLength());
		System.out.println("收到的信息是："+msg);
		
		if(msg.equals("TIME")) {
			sendTime();
		}
	}
	
	void sendTime() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String msg = formatter.format(date);
		byte [] buffer = msg.getBytes();
		InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1", 2020);
		DatagramPacket sendDatagramPacket = new DatagramPacket(buffer, buffer.length, sendAddress);
		try {
			dSocket.send(sendDatagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("时间消息已发送。");
	}
}
