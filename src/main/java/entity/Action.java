package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Action {

    public static double arifmetic (double num1, double num2, String action) {
        double res = 0;
        switch (action) {
            case "sum":
                res = num1 + num2;
                break;
            case "mult":
                res = num1 * num2;
                break;
            case "div":
                res = num1 / num2;
                break;
            case "minus":
                res = num1 - num2;
                break;
            default:
                break;
        }
        return res;
    }

    public static double percentFromNumber (double num1, int percent) {
        double res = 0;
            res = (num1 / 100) * percent;
            return res;
    }

    public static double percent (double num1, int pecent2) {
return pecent2;
    }
}