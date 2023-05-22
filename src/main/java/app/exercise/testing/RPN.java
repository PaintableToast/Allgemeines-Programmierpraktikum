package app.exercise.testing;

import app.exercise.algebra.Rational;

import java.util.Stack;

/**
 * RPN
 *
 * Polnische Notation umgekehrt Aufgabe ist hier drin
 *
 * @Author Ramon Cemil Kimyon
 * @Universitöt Georg-August-Universität Göttingen
 * @Modul Allgemeines Programmierpraktikum
 */
public class RPN {
    public final static void main(final String[] args) {
        final Stack<Rational> inputs = new Stack<>();
        Rational rational;
        for (final String argument : args)
            switch (argument) {
                case "*":
                    rational = inputs.pop();
                    rational.mul(inputs.pop());
                    inputs.push(rational);
                    break;
                case "-":
                    rational = (Rational) inputs.pop().negation();
                    rational.add(inputs.pop());
                    inputs.push(rational);
                    break;
                case "+":
                    rational = inputs.pop();
                    rational.add(inputs.pop());
                    inputs.push(rational);
                    break;
                case "/":
                    rational = (Rational) inputs.pop().reciprocal();
                    rational.mul(inputs.pop());
                    inputs.push(rational);
                    break;
                default:
                    try {
                        inputs.push(new Rational(Long.parseLong(argument), 1));
                    } catch (final Exception error) {
                        System.out.println("Der Ausdruck: " + argument + " ist nicht zulässig! Es wird eine positive ganze Zahl erwartet.");
                    }
            }
        if (!inputs.empty()) System.out.println(inputs.pop().getN());
    }
}
