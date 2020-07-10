package model;

import dao.AccountDAO;

/**
 * アカウントの削除を行うクラス
 * 静的メソッド execute
 * @param:
 *   userId -- String
 * @return:
 *   true -- 削除成功
 *   false -- 削除失敗
 */
public class DeleteLogic {
    public static boolean execute (String userId) {
        AccountDAO dao = new AccountDAO ();
        return dao.deleteAccount( userId );
    }
}

// 修正時刻： Fri Jul 10 10:23:08 2020
