package day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex14 {

	public static void main(String[] args) {
		List<PointD> list = new ArrayList<PointD>();
		list.add(new PointD(1,1));
		list.add(new PointD(1, 10));
		/* 리스트에 좌표를 저장하려고 했다.
		 * 원인 : List는 PointD 클래스의 객체 담고있기 때문에 PointD 객체를 넣어야 함
		 * 해결방안 : 객체 생성 후 추가
		 * */
		
		//list.add("1,1");
		list.add(new PointD(1,1));
		//list.add(1,0);
		list.add(new PointD(1,0));
		

	}

}

class PointD{
	int x,y;
	public PointD(int x, int y) {
		this.x = x;
		this.y = y;
	}
}