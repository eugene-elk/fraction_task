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


    /*
    public void addOneMoreCoeff(Fraction coeff) {
        coeffs.addFraction(coeff);
    }
    */

    /*
    public void sumWithAnotherPoly(Poly anotherPoly) {

        // уравнивание размеров
        if (length() > anotherPoly.length()) {
            Fraction zero = new Fraction(0, 1);
            for (int i = 0; i < length() - anotherPoly.length(); i++) {
                anotherPoly.addOneMoreCoeff(zero);
            }
        }
        else if (length() < anotherPoly.length()) {
            Fraction zero = new Fraction(0, 1);
            for (int i = 0; i < anotherPoly.length() - length(); i++) {
                addOneMoreCoeff(zero);
            }
        }

        // само сложение
        for (int i = 0; i < anotherPoly.length(); i++) {
            coeffs.sumWithAnotherFraction(i, anotherPoly.coeffs.getFraction(i));
        }
    }
    */
}
