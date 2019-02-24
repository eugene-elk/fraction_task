public class Fraction {
    private int numerator;
    private int denominator;

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


}
