package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx03 {

	/* 배열에 랜덤으로 1~9사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드를 작성하세요.
	 * 단 메서드 이용
	 * day08.homework.MethodEx01, day08.homework.MethodEx02, day08.MethodEx05를 합친 예제 
	 * */
	
	public static void main(String[] args) {
		
		int num, min, max;
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 크기, 최소값, 최대값 입력 : ");
		num = scan.nextInt();
		min = scan.nextInt();
		max = scan.nextInt();
		
		int[] arr = createRandomArray(num, min, max);
		
		if(arr==null) {
			System.out.println("잘못된 입력입니다.");
		}
		else {
			System.out.println(Arrays.toString(arr));			
		}
		
	}
	
	/**기능 : 최소값과 최대값 사이의 랜덤한 정수를 생성해서 알려주는 메서드
	 * 매개변수 : 최소값과 최대값 => int min, int max
	 * 리턴타입 : 랜덤한 정수 => int
	 * 메서드명 : random
	 * */
	public static int random(int min, int max) {
		
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		
		
		return (int)(Math.random()*(max-min+1)+min);
	}
	
	/**기능 : 배열에 0번지부터 count-1번지까지 확인하려는 정수가 있는지 확인해서 있는지 없는지를 알려주는 메서드
	 * 매개변수 : 배열, 확인할 갯수 count, 확인하려는 정수 => int[] arr, int count, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메서드명 contains
	 * */
	public static boolean contains(int[] arr, int count, int num) {
		//배열이 null인 경우
		if(arr ==null) {
			return false;
		}
		//count가 배열의 크기보다 큰 경우
		if(count > arr.length) {
			count = arr.length;
		}
		
		for(int i=0; i<count; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	/**기능 : 배열의 크기와 최소값과 최대값이 주어졌을 때, 중복되지 않은 랜덤한 배열을 만들어서 알려주는 메서드
	 * 매개변수 : 배열의 크기, 최소값과 최대값 => int num, int min, int max
	 * 리턴타입 : 중복되지 않은 랜덤한 정수가 들어있는 배열 => int[]
	 * 메서드명 : createRandomArray
	 * */
	public static int[] createRandomArray(int num, int min, int max) {
		if(num<0) return null;
		
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(num>max-min+1) return null;
		
		int[] arr = new int[num];
		int count = 0, random;
		while(count < num) {
			random = random(min, max);
			
			if(!contains(arr, count, random)) {
				arr[count++] = random;
			}
		}
		
		return arr;
	}

	
	
	
	/**기능 : 배열의 크기를 입력받아 1~9 사이의 중복되지 않은 수들을 배열에 저장하기
	 * 매개변수 : int num
	 * 리턴타입 : int[]
	 * 매서드명 : list
	 * */
	
	public static int[] list(int num) {
		
		if(num>9 || num<=0) {
			return null;
		}
		
		int[] list = new int[num];
		int min=1, max=9, count=0, random, i;
		
		while(count<list.length) {
			random = (int)(Math.random()*(max-min+1)+min);
			
			for(i=0; i<count; i++) {
				if(list[i] == random) {
					break;
				}
			}
			
			if(i == count) {
				list[count++] = random;
			}
		}
		
		
		return list;
	}
}
