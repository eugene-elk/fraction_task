public class Poly {
    private FractionList coeffs;

    Poly(FractionList coeffs) {
        this.coeffs = coeffs;
    }

    Poly(Fraction... fs) {
        this.coeffs = new FractionList(fs);
    }

    private int length(){
        return coeffs.size();
    }

    public Poly sum(Poly anotherPoly) {
        if (length() < anotherPoly.length()) {

        }
    }
}
