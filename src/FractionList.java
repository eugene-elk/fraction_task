import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class FractionList {
    private List<Fraction> fractions;

    private boolean cachedMinBoolean, cachedMaxBoolean;
    private Fraction cachedMin, cachedMax;

    FractionList(Fraction... fs) {
        this.fractions = new ArrayList<>(Arrays.asList(fs));
        cachedMinBoolean = false;
        cachedMaxBoolean = false;
    }

    FractionList(String filename) {
        this.fractions = new ArrayList<>();
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
        cachedMinBoolean = false;
        cachedMaxBoolean = false;
    }

    public void addFraction(Fraction newFraction) {
        fractions.add(newFraction);
        cachedMinBoolean = false;
        cachedMaxBoolean = false;
    }

    public void addFraction(int numerator, int denominator) {
        Fraction newFraction = new Fraction(numerator, denominator);
        addFraction(newFraction);
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


