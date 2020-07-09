package test;

import model.Account;
import dao.AccountDAO;

/**
 * AccountDAOクラスの RegisterAccountメソッドがちゃんと動くか
 * どうかをテストする
 */
public class RegisterTest {
    public static void main (String[] args) {
        // ユーザーが見つかる場合のテスト
        testRegister1();
        
        // ユーザーが見つからない場合のテスト
        testRegister2();
    }

    // 正しいデータを渡した場合
    public static void testRegister1 () {
        Account account = new Account ("yukiko", "qwer", "yukkie@higashi.jp", "東山 友紀子", 28);
        AccountDAO dao = new AccountDAO ();
        boolean result = dao.registerAccount( account );

        if (result) {
            System.out.println("testRegister1: 成功しました");
        } else {
            System.out.println("testRegister1: 失敗しました");
        }
    }

    // 間違ったデータを渡した場合
    public static void testRegister2 () {
        Account account = new Account ("tomoko", "1234", "", "田中 智子", 32);
        AccountDAO dao = new AccountDAO ();
        boolean result = dao.registerAccount( account );

        if (!result) {
            System.out.println("testRegister2: 成功しました");
        } else {
            System.out.println("testRegister2: 失敗しました");
        }
    }
}

// 修正時刻： Wed Jul  8 22:17:54 2020
