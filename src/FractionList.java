import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class FractionList {
    private List<Fraction> fractions;

    public Fraction getFraction(int fractionNum) {
        return fractions.get(fractionNum);
    }

    public void setFraction(int fractionNum, Fraction newValue) {
        deleteCachedValues();
        fractions.set(fractionNum, newValue);
    }

    // Прибавить дробь к элементу массива по его номеру
    public void sumWithAnotherFraction(int fractionNum, Fraction valueToAdd) {
        setFraction(fractionNum, Fraction.sumTwoFractions(fractions.get(fractionNum), valueToAdd));
    }

    public int size() {
        return fractions.size();
    }

    public void print() {
        System.out.println("Fractions: ");
        for (int i = 0; i < fractions.size(); i++) {
            fractions.get(i).print();
        }
    }

    // кеширование
    private boolean cachedMinBoolean, cachedMaxBoolean;
    private Fraction cachedMin, cachedMax;

    private boolean cachedBiggerBoolean, cachedSmallerBoolean;
    private int cachedBiggerCount, cachedSmallerCount;
    private Fraction cachedBiggerValue, cachedSmallerValue;

    private void deleteCachedValues() {
        cachedMinBoolean = false;
        cachedMaxBoolean = false;
        cachedBiggerBoolean = false;
        cachedSmallerBoolean = false;
    }

    private FractionList() {
        this.fractions = new ArrayList<>();
        deleteCachedValues();
    }

    FractionList(Fraction... fs)  {
        this();
        this.fractions = Arrays.asList(fs);
    }

    FractionList(String filename) {
        this();
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            //чтение построчно
            String stringWithFraction;
            while((stringWithFraction = br.readLine()) != null) {
                // выделение из строки числителя и знаменателя
                String[] splittedString = stringWithFraction.split(" ");
                int[] rawFraction = new int[2];
                rawFraction[0] = Integer.parseInt(splittedString[0]);
                rawFraction[1] = Integer.parseInt(splittedString[1]);
                addFraction(rawFraction[0], rawFraction[1]);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Добавление дробей в лист
    public void addFraction(Fraction newFraction) {
        fractions.add(newFraction);
        deleteCachedValues();
    }

    public void addFraction(int numerator, int denominator) {
        Fraction newFraction = new Fraction(numerator, denominator);
        fractions.add(newFraction);
        deleteCachedValues();
    }

    public Fraction findMax() {
        if (!cachedMaxBoolean) {
            Fraction result = fractions.get(0);
            for (Fraction fraction : fractions) {
                if (fraction.isBigger(result)) {
                    result = fraction;
                }
            }
            cachedMax = result;
            cachedMaxBoolean = true;
            return result;
        }
        else {
            System.out.println("Get value from cache");
            return cachedMax;
        }
    }

    public Fraction findMin() {
        if (!cachedMinBoolean) {
            Fraction result = fractions.get(0);
            for (Fraction fraction : fractions) {
                if (fraction.isSmaller(result)) {
                    result = fraction;
                }
            }
            cachedMin = result;
            cachedMinBoolean = true;
            return result;
        }
        else {
            System.out.println("Get value from cache");
            return cachedMin;
        }
    }

    public int countBiggerThan(Fraction toCompare) {
        if (cachedBiggerBoolean && toCompare.isEqual(cachedBiggerValue)) {
            System.out.println("Get value from cache");
            return cachedBiggerCount;
        }
        else {
            int result = 0;
            for (Fraction fraction : fractions) {
                if (fraction.isBigger(toCompare)) {
                    result += 1;
                }
            }
            cachedBiggerValue = toCompare;
            cachedBiggerCount = result;
            cachedBiggerBoolean = true;
            return result;
        }
    }

    public int countSmallerThan(Fraction toCompare) {
        if (cachedSmallerBoolean && toCompare.isEqual(cachedSmallerValue)) {
            System.out.println("Get value from cache");
            return cachedSmallerCount;
        }
        else {
            int result = 0;
            for (Fraction fraction : fractions) {
                if (fraction.isSmaller(toCompare)) {
                    result += 1;
                }
            }
            cachedSmallerValue = toCompare;
            cachedSmallerCount = result;
            cachedSmallerBoolean = true;
            return result;
        }
    }
}