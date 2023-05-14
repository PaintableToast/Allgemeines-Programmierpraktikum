package week2.app.excercise.algebra;

/**
 * abstrakte Klasse BasisFraction
 *
 * Die abstrakte Klasse Basisfraction intialsiert, die arithmetischen Methoden des Fractional Interfaces. (Sie erbt von Fractional)
 *
 * @Author Ramon Cemil Kimyon
 * @Universitöt Georg-August-Universität Göttingen
 * @Modul Allgemeines Programmierpraktikum
 */
public abstract class BasisFraction extends Object implements Fractional{
    protected abstract void setND(long numerator, long denominator);
    public void add(Fractional operand) {
        setND(this.getN() * operand.getD() + operand.getN() * this.getD(), this.getD() * operand.getD());
    }
    public void sub(Fractional operand) {
        this.add(operand.negation());
    }
    public void mul(Fractional operand) {
        setND(getN() * operand.getN(), getD() * operand.getD());
    }
    public void div(Fractional operand) {
        mul(operand.reciprocal());
    }
}
