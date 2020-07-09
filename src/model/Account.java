package model;

/**
 * アカウント情報を保持するためのクラス
 * データベースから読み出したデータをこれに格納する
 */
public class Account {
    private String userId;
    private String pass;
    private String mail;
    private String name;
    private int age;

    public Account (String userId, String pass, String mail, String name, int age) {
        this.userId = userId;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
        this.age = age;
    }

    public String getUserId () { return userId; }
    public String getPass () { return pass; }
    public String getMail () { return mail; }
    public String getName () { return name; }
    public int getAge () { return age; }
}

// 修正時刻： Wed Jul  8 17:30:39 2020
