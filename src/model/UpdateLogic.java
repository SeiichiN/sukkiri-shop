package model;

import dao.AccountDAO;
import model.Account;

/**
 * アカウントの情報をデータベースに問い合わせる
 * 静的メソッド execute
 * @param:
 *   account -- Account
 * @return:
 *   boolean
 */
public class UpdateLogic {
    public static boolean execute (Account account) {
        AccountDAO dao = new AccountDAO();
        return dao.updateAccount( account );
    }
}

// 修正時刻： Mon Jul 13 08:10:04 2020
