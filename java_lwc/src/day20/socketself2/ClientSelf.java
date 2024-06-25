package day20.socketself2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientSelf {

	private Socket socket;
	public final static String EXIT = "-1";
	
	
	public void receive() {
		Thread t = new Thread(()->{
			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				while(true) {
					String chat = ois.readUTF();
					if(chat.equals(EXIT)) {
						break;
					}
					System.out.println("내용 : " + chat);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	public void send() {
		Thread t = new Thread(()->{
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				Scanner scan = new Scanner(System.in);
				while(true) {
					String str = scan.nextLine();
					oos.writeUTF(str);
					oos.flush();
					if(str.equals(EXIT)) {
						break;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		t.start();
	}
	
}
