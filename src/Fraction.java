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
        fractionOne = fractionReduction(fractionOne);
        fractionTwo = fractionReduction(fractionTwo);

        int new_denominator = fractionOne.denominator * fractionTwo.denominator;
        int new_numerator = (fractionOne.numerator * fractionTwo.denominator) + (fractionTwo.numerator * fractionOne.denominator);

        return fractionReduction(new_numerator, new_denominator);
    }

    // Наибольший общий делитель (для сокращения)
    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b,a % b);
    }

    // Сокращение
    public static Fraction fractionReduction(int numerator, int denominator) {
        int divider = gcd(numerator, denominator);
        numerator /= divider;
        denominator /= divider;
        return new Fraction(numerator, denominator);
    }

    public static Fraction fractionReduction(Fraction toReduce) {
        return fractionReduction(toReduce.numerator, toReduce.denominator);
    }
}