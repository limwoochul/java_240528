package day20.socketself2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExSelf02 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.189";
		
		try {
			Socket socket = new Socket(ip, port);
			ClientSelf clientSelf = new ClientSelf(socket);
			clientSelf.receive();
			clientSelf.send();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
