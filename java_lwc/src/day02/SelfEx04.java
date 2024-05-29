package day02;

public class SelfEx04 {

	public static void main(String[] args) {

		int floor = 5;
		String store = null;
		
		switch(floor) {
		case 1 : store = "약국";
		break;
		case 2 : store = "정형외과";
		break;
		case 3 : store = "피부과";
		break;
		case 4 : store = "치과";
		break;
		case 5 : store = "헬스 클럽";
		break;
		default :
			System.out.println("가게가 없습니다.");
			break;
		}
		
		System.out.println(floor + "층 " + store + "입니다.");
	}

}
