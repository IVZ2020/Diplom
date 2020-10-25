package service;

import dao.FieldsDao;
import entity.Fields;

import java.lang.reflect.Field;
import java.util.List;

public class FieldsService {

    FieldsDao fieldsDao = new FieldsDao();

    public List<Fields> getAdminFields () {
        return fieldsDao.getAdminFields();

    }
}
