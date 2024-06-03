package day05;

public class SelfEx13 {

	public static void main(String[] args) {

		//배열에 랜덤한 수 할당하고 최대값과 최소값 찾기
		
		int[] arr = new int[10];
		int min = 1, max = 100;
		
		System.out.print("랜덤 숫자 10개 : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		int arrMax = arr[0];
		int arrMin = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arrMax < arr[i]) {
				arrMax = arr[i];
			}
			if(arrMin > arr[i]) {
				arrMin = arr[i];
			}
		}
		
		System.out.println("최대값 : " + arrMax);
		System.out.println("최소값 : " + arrMin);
		
	}

}
