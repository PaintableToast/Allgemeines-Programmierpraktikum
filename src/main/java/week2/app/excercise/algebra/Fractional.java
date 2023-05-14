package week2.app.excercise.algebra;

/**
 * Fractional Interface
 *
 * Die Schnittstelle enthält mehrere arithmetische Methoden für einen Bruch
 *
 * @Author Ramon Cemil Kimyon
 * @Universitöt Georg-August-Universität Göttingen
 * @Modul Allgemeines Programmierpraktikum
 */
public interface Fractional {
    /**
     * Getter für den Zähler des Bruchs
     * @return Numerator
     */
    long getN();

    /**
     * Getter für den Nenner des Bruchs
     * @return Denominator
     */
    long getD();

    /**
     * Addition des Bruchs
     * @param operand
     */
    void add(Fractional operand);
    /**
     * Subtraktion des Bruchs
     * @param operand
     */
    void sub(Fractional operand);
    /**
     * Multiplikation des Bruchs
     * @param operand
     */
    void mul(Fractional operand);

    /**
     * Division des Bruchs
     * @param operand
     */
    void div(Fractional operand);

    /**
     * Der Bruch wird negiert
     * @return Negation des Bruches
     */
    Fractional negation();

    /**
     * Kehrwert
     * @return Kehrwert des Bruches
     */
    Fractional reciprocal();
}
