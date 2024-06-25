package day20.socketself1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSelf01 {

	public static void main(String[] args) {
		
		//1. 포트 번호 설정
		int port = 5001;
		
		Scanner scan = new Scanner(System.in);
		
		//2. 서버용 소켓 객체 생성
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			System.out.println("대기중");
			
			//3. 대기
			//4. 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			System.out.println("연결 성공");
			
			Thread receiveThread = new Thread(()->{
				ObjectInputStream ois;
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					while(true) {
						String receive = ois.readUTF();
						if(receive.equals("-1")) break;
						System.out.println("클라이언트 : " + receive);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			receiveThread.start();
			
			Thread sendThread = new Thread(()->{
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(socket.getOutputStream());
					while(true) {
						System.out.print("내용 : ");
						String send = scan.nextLine();
						oos.writeUTF(send);
						oos.flush();
						if(send.equals("-1")) break;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
			});
			sendThread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
