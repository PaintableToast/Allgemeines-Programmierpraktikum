package week2.app.excercise.algebra;// This class was created by PaintableToast

public interface Fractional {
    long getN();
    long getD();
    void add(Fractional operand);
    void sub(Fractional operand);
    void mul(Fractional operand);
    void div(Fractional operand);
    Fractional negation();
    Fractional reciprocal();
}
