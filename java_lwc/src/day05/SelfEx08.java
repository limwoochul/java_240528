package day05;

public class SelfEx08 {

	public static void main(String[] args) {

		SelfEx07[] dogArray = new SelfEx07[5];
		
		dogArray[0] = new SelfEx07("멍멍이", "치와와");
		dogArray[1] = new SelfEx07("뽀삐", "진돗개");
		dogArray[2] = new SelfEx07("순심이", "삽살개");
		dogArray[3] = new SelfEx07("철이", "마르티즈");
		dogArray[4] = new SelfEx07("삐쭈", "푸들");
		
		for(int i = 0; i < dogArray.length; i++) {
			System.out.println(dogArray[i].showDogInfo());
		}
		
		for(SelfEx07 dog : dogArray) {
			System.out.println(dog.showDogInfo());
		}
	}

}
