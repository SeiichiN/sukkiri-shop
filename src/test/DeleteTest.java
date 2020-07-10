package test;

import dao.AccountDAO;

/**
 * AccountDAOクラスの DeleteAccountメソッドがちゃんと動くか
 * どうかをテストする
 */
public class DeleteTest {
    public static void main (String[] args) {
        // ちゃんとデータを渡した場合
        testDelete1();
        
        // 存在しないデータを渡した場合
        testDelete2();
    }

    // ちゃんとデータを渡した場合
    public static void testDelete1 () {
        String userId = "yukiko";
        AccountDAO dao = new AccountDAO ();
        boolean result = dao.deleteAccount( userId );

        if (result) {
            System.out.println("testDelete1: 成功しました");
        } else {
            System.out.println("testDelete1: 失敗しました");
        }
    }

    // 存在しないデータを渡した場合
    public static void testDelete2 () {
        String userId = "sasuke";
        AccountDAO dao = new AccountDAO ();
        boolean result = dao.deleteAccount( userId );

        if (!result) {
            System.out.println("testDelete2: 成功しました");
        } else {
            System.out.println("testDelete2: 失敗しました");
        }
    }
}

// 修正時刻： Fri Jul 10 10:11:39 2020
