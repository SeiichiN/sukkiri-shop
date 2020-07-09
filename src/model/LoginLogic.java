package model;

import dao.AccountDAO;

/**
 * ログイン処理を行うクラス
 * @Return:
 *   true -- accountがきちんと返れば null ではないから
 *   false -- accountが null の場合
 *
 * しかし、このクラス、インスタンス化する必要あるのかな？
 * execute は static でいいんじゃない？
 *
 * ---> ということで、staticメソッドにしてみた。
 */
public class LoginLogic {
    public static boolean execute (Login login) {
        AccountDAO dao = new AccountDAO();
        Account account = dao.findByLogin( login );
        return account != null;
    }
}

// public class LoginLogic {
//     public boolean execute (Login login) {
//         AccountDAO dao = new AccountDAO();
//         Account account = dao.findByLogin( login );
//         return account != null;
//     }
// }


// 修正時刻： Wed Jul  8 19:57:33 2020
