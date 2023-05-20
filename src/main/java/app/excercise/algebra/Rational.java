package app.excercise.algebra;

/**
 * Rational Klasse
 *
 * Die Klasse intialisiert Numerator und Denominator
 *
 * @Author Ramon Cemil Kimyon
 * @Universitöt Georg-August-Universität Göttingen
 * @Modul Allgemeines Programmierpraktikum
 */
public class Rational extends BasisFraction{
    private long numerator, denominator;
    public Rational(double rational) {
        long denominator = 1;
        while (rational != (double) (long) rational ) {
            denominator *= 10;
            rational *= 10;
        }
        setND((long) rational, denominator);                         // casting rational numbers to a Fraction number:
    }
    public Rational(long numerator, long denominator) {
        setND(numerator, denominator);
    }
    @Override
    protected void setND(long numerator, long denominator) {
        final long divider = findGCD(numerator, denominator);
        numerator /= divider;
        denominator /= divider;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    // Find GCD of 2 Numbers;
    private long findGCD(long num1, long num2) {
        if (num2 == 0) return num1;
        return findGCD(num2, num1 % num2);
    }
    @Override
    public long getN() {
        return numerator;
    }
    @Override
    public long getD() {
        return denominator;
    }
    // negation of numerator
    @Override
    public Fractional negation() {
        return new Rational(getN() * -1, getD());
    }
    // Change numerator and denominator N / D --> D / N
    @Override
    public Fractional reciprocal() {
        return new Rational(getD(), getN());
    }
    @Override
    public String toString() {
        return getN() + "/" + getD();
    }
    @Override
    public Rational clone() {
        return new Rational(numerator, denominator);
    }
    @Override
    public int hashCode() {
        return Integer.valueOf( (getN() + "") + (getD() + "") + String.valueOf(getN()).length() + "");
    }
    @Override
    public boolean equals(Object object) {
        if (object instanceof Fractional) {
            Fractional fractional = (Fractional) object;
            return numerator == fractional.getN() && denominator == fractional.getD();
        }
        return false;
    }
}

