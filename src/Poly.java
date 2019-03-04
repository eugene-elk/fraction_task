public class Poly {
    private FractionList coeffs;

    Poly(FractionList coeffs) {
        this.coeffs = coeffs;
    }

    Poly(Fraction... fs) {
        this.coeffs = new FractionList(fs);
    }

    public int length() {
        return coeffs.size();
    }

    public void print() {
        coeffs.print();
    }

    public static Poly sumTwoPolys(Poly polyOne, Poly polyTwo) {

        if (polyTwo.length() > polyOne.length()) {
            Poly t = polyOne;
            polyOne = polyTwo;
            polyTwo = t;
        }

        for(int i = 0; i < polyTwo.length(); i++) {
            polyOne.coeffs.sumWithAnotherFraction(i, polyTwo.coeffs.getFraction(i));
        }

        return polyOne;
    }
}
