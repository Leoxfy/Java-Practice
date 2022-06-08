package work2;

import java.net.Socket;

public class ServerThread implements Runnable{
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		while(true) {
			
		}
	}

}
