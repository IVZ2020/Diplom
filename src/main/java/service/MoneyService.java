package service;

import dao.MoneyDao;
import entity.MoneyEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoneyService {

    MoneyDao moneyDao = new MoneyDao();

    public void addMoneyEvent(MoneyEvent moneyEvent) {
        moneyDao.addMoneyEvent(moneyEvent);
    }

    public void updateUserBalanceById(int id, double balance) {
        moneyDao.updateUserBalanceById(id, balance);
    }

    public void updateUserDebtById(int id, double debt) {
        moneyDao.updateUserDebtById(id, debt);
    }
}
