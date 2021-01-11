package entity;

import java.util.Date;

public class MoneyEvent extends EventMoneyAbstract {
    public MoneyEvent(int id, Date date, double summ, String cathegory, int idUser, String type) {
        super(id, date, summ, cathegory, idUser, type);
    }

    public MoneyEvent(double summ, String cathegory, int idUser, String type) {
        super(summ, cathegory, idUser, type);
    }
}
