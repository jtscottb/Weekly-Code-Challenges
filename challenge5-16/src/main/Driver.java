package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num1 = new LinkedList<Integer>(Arrays.asList(6, 1, 7));
		List<Integer> num2 = new LinkedList<>(Arrays.asList(2, 9, 5));
		System.out.println(add(num1, num2));
		num1 = reverseNumber(num1);
		num2 = reverseNumber(num2);
		System.out.println(reverseAdd(num1, num2));
	}
	
	public static List<Integer> reverseAdd(List<Integer> num1, List<Integer> num2) {
		List<Integer> answer = new LinkedList<>();
		
		if(num1.size() > num2.size()) {
			num2 = reverseAdjust(num1.size() - num2.size(), num2);
		} else if(num1.size() < num2.size()) {
			num1 = reverseAdjust(num2.size() - num1.size(), num1);
		}
		
		int ten = 0;
		for(int i = 0; i < num1.size(); i++) {
			int result = num1.get(i) + num2.get(i) + ten;
			if(result > 9) {
				result -= 10;
				ten = 1;
			} else {
				ten = 0;
			}
			answer.add(result);
		}
		if(ten == 1) {
			answer.add(ten);
		}
		
		return answer;
	}
	
	public static List<Integer> reverseAdjust(int diff, List<Integer> list) {
		List<Integer> newList = list;
		for(int i = 0; i < diff; i++) {
			newList.add(0);
		}
		return newList;
	}
	
	public static List<Integer> reverseNumber(List<Integer> num) {
		List<Integer> newNum = new LinkedList<>();
		
		for(int i = 0; i < num.size(); i++) {
			newNum.add(0, num.get(i));
		}
		
		return newNum;
	}
	
	public static List<Integer> add(List<Integer> num1, List<Integer> num2) {
		List<Integer> answer = new LinkedList<>();
		
		if(num1.size() > num2.size()) {
			num2 = adjust(num1.size() - num2.size(), num2);
		} else if(num1.size() < num2.size()) {
			num1 = adjust(num2.size() - num1.size(), num1);
		}
		
		for(int i = 0; i < num1.size(); i++) {
			answer.add(num1.get(i) + num2.get(i));
		}
		for(int i = answer.size(); i > 0; i--) {
			if(answer.get(i-1) > 9) {
				answer.set(i-1, answer.get(i-1)-10);
				if(i-2 >= 0) {
					answer.set(i-2, answer.get(i-2)+1);
				} else {
					answer.add(0, 1);
				}
			}
		}
		
		return answer;
	}
	
	public static List<Integer> adjust(int diff, List<Integer> list) {
		List<Integer> newList = list;
		for(int i = 0; i < diff; i++) {
			newList.add(i, 0);
		}
		return newList;
	}

}
