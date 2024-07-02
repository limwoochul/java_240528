package day24.socket;

import java.net.InetAddress;
import java.net.Socket;

public class client {

	public static void main(String[] args) {
		int port = 3000;
		String serverIP;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIP, port);
			System.out.println("연결 성공");
		} catch (Exception e) {
			System.out.println("예외 발생");
		}

	}

}
