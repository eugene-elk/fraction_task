import java.lang.Math;

public class Fraction {
    private int numerator;
    private int denominator;

    private final double Eps = 0.00001;

    Fraction (int numerator, int denominator) {
        // переносим минус в numerator, или же избавляемся от двух минусов
        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public void print() {
        System.out.println(numerator + " / " + denominator);
    }

    public Boolean isBigger(Fraction anotherFraction) {
        double first = (double)this.numerator / this.denominator;
        double second = (double)anotherFraction.numerator / anotherFraction.denominator;
        return first > second;
    }

    public Boolean isSmaller(Fraction anotherFraction) {
        double first = (double)this.numerator / this.denominator;
        double second = (double)anotherFraction.numerator / anotherFraction.denominator;
        return first < second;
    }

    public Boolean isEqual(Fraction anotherFraction) {
        double first = (double)this.numerator / this.denominator;
        double second = (double)anotherFraction.numerator / anotherFraction.denominator;
        return Math.abs(first - second) < Eps;
    }

    public static Fraction sumTwoFractions(Fraction fractionOne, Fraction fractionTwo) {
        int new_denominator = fractionOne.denominator * fractionTwo.denominator;
        int new_numerator = (fractionOne.numerator * fractionTwo.denominator) + (fractionTwo.numerator * fractionOne.denominator);

        return new Fraction(new_numerator, new_denominator);

        //TODO дописать сокращение дроби
    }
}
