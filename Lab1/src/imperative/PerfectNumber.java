package imperative;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;
import java.util.Scanner;

public class PerfectNumber {
	enum STATE {
		ERROR,
		DEFICIENT,
		PERFECT,
		ABUNDANT
	}

	public static STATE process(int n) {
		// A perfect number is a positive integer, and there's no real way to check whether 
		// a number's positive without doing anything stupid, so we _have_ to have an if here.
		return (n>0) ? STATE.values()[detect(n)+2] : STATE.ERROR;
	}

	public static Set<Integer> divisors(Integer n) {
		// Without the optimisation
		// return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().collect(Collectors.toSet());

		// With the optimisation
		Integer sqr = (int)Math.ceil(Math.sqrt(n));
		Set<Integer> set = new HashSet<Integer>();
		//TODO: is there a way to do this within a single addAll instead of 2?
		set.addAll(IntStream.rangeClosed(2, sqr).filter(i -> n % i == 0).boxed().collect(Collectors.toSet()));
		set.addAll(set.stream().map( i -> (int)( n / i )).collect(Collectors.toSet()));
		set.add(1);
		set.add(n);
		return set;
	}

	public static Integer detect(Integer n) {
		// Since enum integer values is the order in which its values are declared in, we can use signum
		// to get the sign and then add an offset to get the enum entry without using if-else.
		return Integer.signum(divisors(n).stream().filter(i -> i != n).collect(Collectors.summingInt(Integer::intValue)).compareTo(n));
	}

	public static void main(String[] args) {
		Integer num;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number: ");
		while (!s.hasNextInt()) s.next();
		num = s.nextInt();
		s.close();

		Consumer<STATE> output = (state) -> System.out.println("The entered number is " + state.toString().toLowerCase() + ".");
		output.accept(process(num));
	}
}
