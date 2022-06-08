package work4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPA {
	DatagramSocket dSocket = null;
	public static void main(String[] args) {
		new UDPA();
	}
	public UDPA() {
		initDatagramSocket();
		sendDatagramPacket();
		dSocket.close();
	}
	void initDatagramSocket() {
		try {
			dSocket = new DatagramSocket(2020);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("端口被占用");
		}
		System.out.println("接收端口2020启动成功");
		
	}
	void sendDatagramPacket() {
		System.out.println("你要发送的信息是：");
		Scanner scanner = new Scanner(System.in);
		String sendString = null;
		if(scanner.hasNext()) {
			sendString = scanner.next();
		}
		byte[] buffer = sendString.getBytes();
		InetSocketAddress desSocketAddress = new InetSocketAddress("127.0.0.1", 2021);
		DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, desSocketAddress);
		try {
			dSocket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
		if(sendString.equals("TIME")) {
			receiveDatagramPacket();
		}
	}
	void receiveDatagramPacket() {
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, 1024);
		try {
			dSocket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = new String(buffer, 0, receivePacket.getLength());
		System.out.println(msg);
	}
}
