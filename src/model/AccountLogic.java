package model;

import dao.AccountDAO;

/**
 * アカウントの登録を行うクラス
 * 静的メソッド execute
 * @param:
 *   account -- Accountクラス
 * @return:
 *   true -- 登録成功
 *   false -- 登録失敗
 */
public class AccountLogic {
    public static boolean execute (Account account) {
        AccountDAO dao = new AccountDAO();
        return dao.registerAccount( account );
    }
}

// 修正時刻： Wed Jul  8 20:53:31 2020
