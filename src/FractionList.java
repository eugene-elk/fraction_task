import java.util.Arrays;
import java.util.List;

public class FractionList {
    private List<Fraction> fractions;

    FractionList(Fraction... fs) {
        this.fractions = Arrays.asList(fs);
    }

    public void addFraction(int numerator, int denominator) {
        Fraction newFraction = new Fraction(numerator, denominator);
    }

    public Fraction findMax() {
        Fraction result = fractions.get(0);
        for (Fraction fraction: fractions) {
            if (fraction.isBigger(result)) {
                result = fraction;
            }
        }
        return result;
    }

    public Fraction findMin() {
        Fraction result = fractions.get(0);
        for (Fraction fraction: fractions) {
            if (fraction.isBigger(result)) {
                result = fraction;
            }
        }
        return result;
    }

    public int countBiggerThan(Fraction toCompare) {
        int result = 0;
        for (Fraction fraction: fractions) {
            if (fraction.isBigger(toCompare)) {
                result += 1;
            }
        }
        return result;
    }

    public int countSmallerThan(Fraction toCompare) {
        int result = 0;
        for (Fraction fraction: fractions) {
            if (fraction.isSmaller(toCompare)) {
                result += 1;
            }
        }
        return result;
    }

}


