public class task1 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 5);
        Fraction f3 = new Fraction(6, -3);

        FractionList fList = new FractionList(f1, f2, f3);
        //FractionList fList = new FractionList("input.txt");

        Fraction fCompare = new Fraction(1, 4);

        fCompare.print();

        System.out.println(fList.countBiggerThan(fCompare));
        System.out.println(fList.countSmallerThan(fCompare));
    }
}
