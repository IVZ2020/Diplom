package service;

import dao.PrintDao;

public class PrintService {


    PrintDao printDao = new PrintDao();
    public void printStringService(String stringToPrint) {
        printDao.printStringService(stringToPrint);
    }
}
