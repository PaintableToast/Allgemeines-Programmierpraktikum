package app.excercise.testing;

import app.excercise.algebra.Rational;

import java.util.Scanner;

/**
 * RationalTesting
 *
 * Klasse zum Testen von Aufgabe 1
 *
 * @Author Ramon Cemil Kimyon
 * @Universitöt Georg-August-Universität Göttingen
 * @Modul Allgemeines Programmierpraktikum
 */
public class RationalTesting {
    public final static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie oft willst du es testen\n");
        int duration = scanner.nextInt();
        Rational rational;
        for (int i = 0; i < duration; i++) {
            rational = new Rational(scanner.nextLong(), scanner.nextLong());
            System.out.println("\ntoString():");
            System.out.println(rational.toString());

            System.out.println("\ngetN():\n" + rational.getN());
            System.out.println("\ngetD():\n" + rational.getD());

            System.out.println("\nequals(Object object):");
            System.out.println(rational.equals(new Rational(scanner.nextLong(), scanner.nextLong())));

            System.out.println("\nadd(Fractional fraction):");
            rational.add(new Rational(scanner.nextLong(), scanner.nextLong()));
            System.out.println(rational.toString());

            System.out.println("\nsub(Fractional fraction):");
            rational.sub(new Rational(scanner.nextLong(), scanner.nextLong()));
            System.out.println(rational.toString());

            System.out.println("\nmul(Fractional fraction):");
            rational.mul(new Rational(scanner.nextLong(), scanner.nextLong()));
            System.out.println(rational.toString());

            System.out.println("\ndiv(Fractional fraction):");
            rational.div(new Rational(scanner.nextLong(), scanner.nextLong()));
            System.out.println(rational.toString());

            System.out.println("\nnegation():");
            System.out.println(rational.negation().toString());

            System.out.println("\nreciprocal():");
            System.out.println(rational.reciprocal().toString());

            System.out.println("\nhashCode():");
            System.out.println(rational.hashCode());
        }
    }
}
