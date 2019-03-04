public class task1 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(24, 12);
        Fraction f2 = new Fraction(6, 18);

        f1 = Fraction.fractionReduction(f1);
        f2 = Fraction.fractionReduction(f2);

        f1.print();
        f2.print();
    }
}
