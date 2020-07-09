package model;

/**
 * ログイン処理をするためのデータを保持するクラス
 * Cにおける構造体の代用
 */
public class Login {
    private String userId;
    private String pass;

    public Login (String userId, String pass) {
        this.userId = userId;
        this.pass = pass;
    }

    public String getUserId () { return userId; }
    public String getPass () { return pass; }
}

// 修正時刻： Wed Jul  8 17:28:08 2020
