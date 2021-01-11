package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class EventMoneyAbstract {

    private int id;
    private Date date;
    private double summ;
    private String cathegory;
    private int idUser;
    private String type;

    public EventMoneyAbstract(Date date, double summ, String cathegory, int idUser, String type) {
        this.date = date;
        this.summ = summ;
        this.cathegory = cathegory;
        this.idUser = idUser;
        this.type = type;
    }

    public EventMoneyAbstract(double summ, String cathegory, int idUser, String type) {
        this.summ = summ;
        this.cathegory = cathegory;
        this.idUser = idUser;
        this.type = type;
    }
}
