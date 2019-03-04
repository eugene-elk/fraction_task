public class Poly {
    private FractionList coeffs;

    Poly(FractionList coeffs) {
        this.coeffs = coeffs;
    }

    Poly(Fraction... fs) {
        this.coeffs = new FractionList(fs);
    }

    public int length(){
        return coeffs.size();
    }

    private void addOneMoreCoeff(Fraction coeff) {
        coeffs.addFraction(coeff);
    }

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

        System.out.println(length() + " " + anotherPoly.length());

        // само сложение
        for (int i = 0; i < anotherPoly.length(); i++) {
            coeffs.sumWithAnotherFraction(i, anotherPoly.coeffs.getFraction(i));
        }
    }
}
