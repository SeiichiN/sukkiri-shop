package model;

import dao.AccountDAO;

public class CreateTableLogic {
    public static boolean execute () {
        AccountDAO dao = new AccountDAO ();
        return dao.createTable ();
    }
}
