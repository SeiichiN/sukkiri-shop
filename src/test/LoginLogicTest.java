package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
    public static void main (String [] args) {
        // ログイン成功
        testExecute1();

        // ログイン失敗
        testExecute2();
    }

    public static void testExecute1 () {
        Login login = new Login("minato", "1234");
        // LoginLogic bo = new LoginLogic ();
        boolean result = LoginLogic.execute( login );
        if (result) {
            System.out.println("testExecute1: 成功しました");
        } else {
            System.out.println("testExecute1: 失敗しました");
        }
    }

    public static void testExecute2 () {
        Login login = new Login("minato", "12345");
        // LoginLogic bo = new LoginLogic ();
        boolean result = LoginLogic.execute( login );
        if (!result) {
            System.out.println("testExecute2: 成功しました");
        } else {
            System.out.println("testExecute2: 失敗しました");
        }
    }
}

// 修正時刻： Wed Jul  8 18:32:40 2020
