package imperative;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class PerfectNumber {
	enum STATE {
		ABUNDANT,
		PERFECT,
		DEFICIENT,
		ERROR
	}

	public static STATE process(int n) {
		switch(detect(n)) {
			case 0: return STATE.DEFICIENT;
			case 1: return STATE.PERFECT;
			case 2: return STATE.ABUNDANT;
			default: return STATE.ERROR;
		}
	}

	public static Set<Integer> divisors(Integer n) {
		Set<Integer> set = new HashSet<Integer>();

		// We also need to include the number 1 and the number we need to divide in the set due to test's requirements.
		set.add(1);
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) set.add(i);
		}

		return set;
	}

	public static Integer detect(Integer n) {
		if (n <= 0) return -1;

		Set<Integer> set = divisors(n);
		int sum = 0;

		for (int i : set) {
			if ( i != n ) sum += i; // The set must include all of the divisors, but we don't need to add the number that was passed.
		}

		// The return codes are arbitrary but the requirement was to have a separate process function...
		if (sum < n) return 0;
		else if (sum == n) return 1;
		else return 2;
	}

	public static void main(String[] args) {
		Integer num;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number:");
		while (!s.hasNextInt()) s.next();
		num = s.nextInt();
		s.close();

		switch(process(num)) {
			case ABUNDANT: System.out.println("Number " + num.toString() + " Is abundant."); break;
			case DEFICIENT: System.out.println("Number " + num.toString() + " Is deficient."); break;
			case PERFECT: System.out.println("Number " + num.toString() + " Is perfect."); break;
			default: System.out.println("Invalid input.");
		}
	}
}
