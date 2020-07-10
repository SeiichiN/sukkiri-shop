package model;

import dao.AccountDAO;
import model.Account;

/**
 * アカウントの情報をデータベースに問い合わせる
 * 静的メソッド execute
 * @param:
 *   userId -- String
 * @return:
 *   account -- Account
 */
public class AccountInfoLogic {
    public static Account execute (String userId) {
        Account account = null;
        AccountDAO dao = new AccountDAO();
        account =  dao.getAccountInfo( userId );
        return account;
    }
}

// 修正時刻： Fri Jul 10 20:00:21 2020
