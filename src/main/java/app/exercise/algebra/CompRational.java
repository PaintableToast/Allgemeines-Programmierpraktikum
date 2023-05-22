package app.exercise.algebra;// This class was created by PaintableToast

public class CompRational extends Rational implements Comparable{


    public CompRational(long numerator, long denominator) {
        super(numerator, denominator);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Fractional) {
            final Fractional fraction = (Fractional) o;
            if (this.equals(fraction))
                return 0;
            return (this.getN() / this.getD()) < fraction.getN() / fraction.getD() ? 1 : -1;
        }
        return 1;
    }
}
