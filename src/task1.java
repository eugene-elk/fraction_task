public class task1 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(6, 18);

        FractionList fractionList = new FractionList("input.txt");

        Poly polyOne = new Poly(fractionList);
        Poly polyTwo = new Poly(f1, f2);

        polyOne.print();
        polyTwo.print();

        polyOne = Poly.sumTwoPolys(polyTwo, polyOne);

        polyOne.print();
    }
}
