package day20.socketself1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSelf01 {

	public static void main(String[] args) {
		String ip = "192.168.30.189"; //서버 IP
		int port = 5001; //서버 포트

		Scanner scan = new Scanner(System.in);

		//1. 소켓 생성 후 대기
		System.out.println("서버연결요청");

		try {
			Socket socket = new Socket(ip, port);
			System.out.println("서버 연결 완료");

			Thread sendThread = new Thread(()->{
				//문자열 전송
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

			Thread receiveThread = new Thread(()->{
				ObjectInputStream ois;
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					while(true) {
						String receive = ois.readUTF();
						if(receive.equals("-1")) break;
						System.out.println("서버 : " + receive);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			});
			receiveThread.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
