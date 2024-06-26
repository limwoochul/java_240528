package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	public static void main(String[] args) {
		int port = 5001;
		String fileName = "src/day21/socket2/server.txt";
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Socket socket = serverSocket.accept();
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				String type = ois.readUTF();
				
				switch(type) {
				case "save":
					receive(ois, fileName);
					break;
				case "load":
					send(oos, fileName);
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	private static void send(ObjectOutputStream oos, String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream fois = new ObjectInputStream(fis)){
			List<Contact> list = (List<Contact>)fois.readObject();
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			try {
				oos.writeObject(new ArrayList<Contact>());
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		System.out.println("[클라이언트가 불러오기를 했습니다.]");
		
	}

	@SuppressWarnings("unchecked")
	private static void receive(ObjectInputStream ois, String fileName) {
		List<Contact> list = null;
		try {
			list = (List<Contact>) ois.readObject();
		} catch (Exception e) {
			//클라이언트가 저장할 리스트를 전송하지 않으면
			//(강제 종료 등의 예외가 발생해서)
			//저장할 리스트가 없기 때문에 종료
			return;
		}		
		//가져온 리스트를 파일에 저장
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream foos = new ObjectOutputStream(fos)){
			foos.writeObject(list);
		} catch (Exception e) {
		}
		System.out.println("[서버에 저장했습니다.]");
	}

}
