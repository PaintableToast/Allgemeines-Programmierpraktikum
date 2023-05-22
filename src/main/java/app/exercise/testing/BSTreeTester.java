package app.exercise.testing;

import app.exercise.algebra.CompRational;
import app.exercise.adt.*;
import java.util.Random;

/**
 * This class is a testing class for the classes BSTree, BSTreeIterator and Node
 */
public class BSTreeTester {
	public static void main(String[] args) {
		if (args.length % 2 == 1) {
			System.out.println("Error: Keine gerade Anzahl an Argumenten");
			return;
		}
		if (args.length == 0) {
			System.out.println("Empty tree.");
			return;
		}
		
		BSTree<Double> primary = new BSTree<Double>();

		Double rationalList[] = new Double[args.length/2];
		for (int i=0; i < args.length; i += 2) {
			rationalList[i/2] = Double.parseDouble(
			(new CompRational(Long.parseLong(args[i]), Long.parseLong(args[i+1]))).toString()
			);
		}

		for (Double i : rationalList)
			primary.add(i);
		
		// testing size()
		System.out.println(primary.size());
		// testing toArray()
		Object[] arr = primary.toArray();
		for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
		System.out.println();
		
		BSTree<Double> secondary1 = new BSTree<Double>();
		BSTree<Double> secondary2 = new BSTree<Double>();		
		
		for(int i = 0; i < arr.length; i++) {
			if(i % 2 != 0)	secondary1.add(rationalList[i]);
			else secondary2.add(rationalList[i]);
		}
		//secondary2.add(new Double(13.2356435));
		System.out.println(secondary1);
		System.out.println(secondary2);
		
		for(Object val : primary) System.out.print(val + " ");
		System.out.println();
		for(Object val : secondary1) System.out.print(val + " ");
		System.out.println();
		for(Object val : secondary2) System.out.print(val + " ");
		System.out.println();
		
		// testing containsAll(Collection<?> c)
		System.out.println("primary containsAll(secondary1)? " + primary.containsAll(secondary1));
		System.out.println("primary containsAll(secondary2)? " + primary.containsAll(secondary2));
		
		// testing contains(Object o)
		int len = args.length/2;
		// wenn ich die vertausche bekomme ich stackoverflow?? wieso
		System.out.println("Tree contains " + rationalList[0] + "? " + primary.contains(rationalList[0]));
		System.out.println("Tree contains " + rationalList[len-1] + "? " + primary.contains(rationalList[len-1]));

		Double[] randomRationals = new Double[100];
		for(int i = 0; i < randomRationals.length; i++)
			randomRationals[i] = Math.random() * (primary.getBiggest() - primary.getSmallest()) + primary.getSmallest();
		for(int i = 0; i < randomRationals.length; i++) {
			if(primary.contains(randomRationals[i])); // remove
		}
	}
}
