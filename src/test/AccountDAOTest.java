package test;

import model.Account;
import model.Login;
import dao.AccountDAO;

/**
 * AccountDAOクラスの findByLoginメソッドがちゃんと動くか
 * どうかをテストする
 */
public class AccountDAOTest {
    public static void main (String[] args) {
        // ユーザーが見つかる場合のテスト
        testFindByLogin1();
        
        // ユーザーが見つからない場合のテスト
        testFindByLogin2();
    }

    // 正しいデータを渡した場合
    public static void testFindByLogin1 () {
        Login login = new Login ("minato", "1234");
        AccountDAO dao = new AccountDAO ();
        Account result = dao.findByLogin( login );

        if (result != null &&
            result.getUserId().equals("minato") &&
            result.getPass().equals("1234") &&
            result.getMail().equals("minato@sukkiri.com") &&
            result.getName().equals("湊 雄輔") &&
            result.getAge() == 23) {
            System.out.println("testFindByLogin1: 成功しました");
        } else {
            System.out.println("testFindByLogin1: 失敗しました");
        }
    }

    // 間違ったデータを渡した場合
    public static void testFindByLogin2 () {
        Login login = new Login ("minato", "12345");
        AccountDAO dao = new AccountDAO ();
        Account result = dao.findByLogin( login );

        if (result == null) {
            System.out.println("testFindByLogin2: 成功しました");
        } else {
            System.out.println("testFindByLogin2: 失敗しました");
        }
    }
}

// 修正時刻： Wed Jul  8 17:45:29 2020
