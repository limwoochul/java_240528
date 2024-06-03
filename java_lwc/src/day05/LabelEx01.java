package day05;

public class LabelEx01 {

	public static void main(String[] args) {
		int i, j;
		
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.print(i*j + " ");
			}
			System.out.println();
		}
		//한 줄에 숫자를 3개씩으로 수정 break문을 활용
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.print(i*j + " ");
				if(j == 3) {
					break;
				}
			}
			System.out.println();
		}
		//라벨 이름 A
		A:	for(i = 1; i <= 5; i++) {
				for(j = 1; j <= 5; j++) {
					System.out.print(i*j + " ");
					if(j == 3) {
						break A;
					}
				}
				System.out.println();
		}
	}

}
