package service;

import java.util.Scanner;

public class Reader {

    Scanner scanner = new Scanner(System.in);

    public String readString () {
        String string = String.valueOf(scanner.hasNext());
        return string;
    }

    public int readInt () {
        Integer numInt = scanner.nextInt();
        return numInt;
    }

    public double readDouble () {
        Double numDouble = scanner.nextDouble();
        return numDouble;
    }
}
