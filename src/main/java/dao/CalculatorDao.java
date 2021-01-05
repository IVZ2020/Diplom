package dao;

public class CalculatorDao {

    public boolean checkDoubleOnZero (double digit) {
        if (digit != 0) return true;
        else return false;
    }

    public boolean conditionsForCalculator (String a, String b) {
        return (RegExDao.isDouble(a) && RegExDao.isDouble(b));
    }

    public boolean conditionsForCalculatorDivision (String b) {
        return (RegExDao.isDoubleNotZero(b));
    }

    public double calculatorSimple (String a, String b, String operator) {
        double aDouble = Double.parseDouble(a);
        double bDouble = Double.parseDouble(b);
        switch (operator) {
            case "summ":
                return aDouble + bDouble;
            case "minus":
                return aDouble - bDouble;
            case "div":
                if (!RegExDao.isDoubleNotZero(b)) return aDouble / bDouble;
            case "mult":
                return aDouble * bDouble;
            default:
                return 0;
        }
    }
}
