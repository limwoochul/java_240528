package day05;


public class SelfEx17 {

	public static void main(String[] args) {
		//    *		i=0		공백=4	별=1
		//   ***	i=1		공백=3	별=3
		//  *****	i=2		공백=2	별=5
		// *******	i=3		공백=1	별=7
		//*********	i=4		공백=0	별=9
		// *******	i=5		공백=1	별=7
		//  *****	i=6		공백=2	별=5
		//   ***	i=7		공백=3	별=3
		//    *		i=8		공백=4	별=1

		int star = 7;
		for(int i=0; i<9; i++) {
			if(i<5) {
				for(int j=0; j<4-i; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<i*2+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			else {
				for(int j=0; j<i-4; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<star; j++) {
					System.out.print("*");
				}
				star -= 2;
				System.out.println();
			}
		}
		
		
		
	}

}

