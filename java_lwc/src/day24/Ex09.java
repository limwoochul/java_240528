package day24;

public class Ex09 {

	public static void main(String[] args) {
		PointA p1 = new PointA(10,20);
		p1.print();
		
		/* x값을 100, y의 값을 200으로 수정하려 했다
		 * 원인 : 접근제어자가 private 이어서
		 * 해결방법 : 접근 제어자를 public 선언 or setter 생성
		 * */
		
		p1.setX(100);
		p1.setY(200);
		
		//p1.x = 100;
		//p1.y = 200;
		
		p1.print();
		/* 기본 생성자를 이용해서 객체를 생성하려 했다
		 * 원인 : 다른 생성자가 선언이 되어있는상태라서 기본생성자가 자동으로 추가되지 않음
		 * 해결방법 : 기본생성자 추가
		 * */
		PointA p2 = new PointA();
		p2.print();

	}

}

class PointA{
	private int x, y;
	
	public PointA(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public PointA() {
		// TODO Auto-generated constructor stub
	}

	public void print() {
		System.out.println(x + "," + y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}