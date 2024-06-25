package day20.socketself2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExSelf02 {

	public static void main(String[] args) {
		int port = 5001;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			ClientSelf clientSelf = new ClientSelf(socket);
			clientSelf.send();
			clientSelf.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
