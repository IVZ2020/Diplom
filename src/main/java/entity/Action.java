package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Action {

    private long num1;
    private long num2;
    private long res;
    private String action;

    public void result(long num1, long num2, String action) {
        switch (action) {
            case "sum":
                res = num1 + num2;
            case "mult":
                res = num1 * num2;
            case "div":
                res = num1 / num2;
            case "minus":
                res = num1 - num2;
        }
    }
}