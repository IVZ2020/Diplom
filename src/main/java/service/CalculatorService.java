package service;

import dao.CalculatorDao;

public class CalculatorService {

    CalculatorDao calculatorDao = new CalculatorDao();

    public boolean conditionsForCalculator(String a, String b) {
        return calculatorDao.conditionsForCalculator(a,b);
    }

    public boolean checkDoubleOnZero (double digit) {
        return calculatorDao.checkDoubleOnZero(digit);
    }

    public double calculatorSimple (String a, String b, String operation) {
        return calculatorDao.calculatorSimple(a, b, operation);
    }

    public boolean conditionsForCalculatorDivision(String b) {
        return calculatorDao.conditionsForCalculatorDivision(b);
    }
}
