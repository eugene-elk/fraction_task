import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class FractionList {
    private List<Fraction> fractions;

    public int size() {
        return fractions.size();
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
            return cachedMin;
        }
    }

    public int countBiggerThan(Fraction toCompare) {
        // TODO: нужно заменить equals на равенство дробей
        if (toCompare.equals(cachedBiggerValue) && cachedBiggerBoolean) {
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
        // TODO: нужно заменить equals на равенство дробей
        if (toCompare.equals(cachedSmallerValue) && cachedSmallerBoolean) {
            return cachedSmallerCount;
        }
        else {
            int result = 0;
            for (Fraction fraction : fractions) {
                if (fraction.isBigger(toCompare)) {
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


