package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

/**
 * データベースとのやりとりをおこなうクラス
 */
public class AccountDAO {
    private final String JDBC_URL =
        "jdbc:h2:tcp://localhost/~/sukkiriShop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public boolean createTable() {
        try (Connection conn =
             DriverManager.getConnection (JDBC_URL, DB_USER, DB_PASS)) {
            String sql =
                "create table if not exists account (" +
                "user_id char(10) not null primary key, " +
                "pass varchar(10) not null, " +
                "mail varchar(100) not null, " +
                "name varchar(40) not null, " +
                "age int not null)";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            int result = pStmt.executeUpdate();

            if (result > 0) {
                System.out.println("テーブルを作成しました");
            } else {
                System.out.println("テーブルを作成できませんでした");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("createTableで、例外が発生しました。");
            e.printStackTrace();
            return false;
        } 
        return true;
    }

    /**
     * ユーザー名とパスワードをクラス(構造体)で受け取って照合する
     * @return:
     *   account -- ユーザー名とパスワードがデータベースに存在するならば
     *          そのユーザーの情報を返す(Accountクラス)
     *   null -- もし存在しないならば account には null が入る
     */
    public Account findByLogin (Login login) {
        Account account = null;

        try (Connection conn =
              DriverManager.getConnection (JDBC_URL, DB_USER, DB_PASS)) {

            String sql =
                "select user_id, pass, mail, name, age from account" +
                " where user_id = ? and pass = ?";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            pStmt.setString( 1, login.getUserId() );
            pStmt.setString( 2, login.getPass() );

            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("user_id");
                String pass = rs.getString("pass");
                String mail = rs.getString("mail");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                account = new Account( userId, pass, mail, name, age);
            }
        } catch (SQLException e) {
            System.out.println("findByLoginで例外が発生しました。");
            e.printStackTrace();
            return null;
        }
        return account;
    }

    /**
     * アカウントを登録する
     * @param:
     *   account - クラス(構造体データ) userId, pass, mail, name, age
     * @return:
     *   true -- 登録成功
     *   false -- 登録失敗
     */
    public boolean registerAccount (Account account) {
        try (Connection conn =
              DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS )) {

            String sql =
                "insert into account ( user_id, pass, mail, name, age )" +
                " values ( ?, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            pStmt.setString( 1, account.getUserId() );
            pStmt.setString( 2, account.getPass() );
            pStmt.setString( 3, account.getMail() );
            pStmt.setString( 4, account.getName() );
            pStmt.setInt( 5, account.getAge() );

            int result = pStmt.executeUpdate();
            if (result < 1) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("registerAccountで例外が発生しました。");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * アカウントを削除する
     * @param: userId -- String ユーザーID
     * @return: boolean
     */
    public boolean deleteAccount ( String userId ) {
        try (Connection conn =
              DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS )) {

            String sql =
                "delete from account where user_id = ?";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            pStmt.setString( 1, userId );
            int result = pStmt.executeUpdate();
            if (result < 1) {
                System.out.println(userId + " を削除できませんでした");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("deleteAccountで例外が発生しました");
            e.printStackTrace();
        }
        return true;
    }

    /**
     * ユーザー情報を提供する
     * @param:
     *   userId -- String
     * @return:
     *   account -- ユーザー名とパスワードがデータベースに存在するならば
     *          そのユーザーの情報を返す(Accountクラス)
     *   null -- もし存在しないならば account には null が入る
     */
    public Account getAccountInfo (String userId) {
        Account account = null;

        try (Connection conn =
              DriverManager.getConnection (JDBC_URL, DB_USER, DB_PASS)) {

            String sql =
                "select user_id, pass, mail, name, age from account" +
                " where user_id = ?";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            pStmt.setString( 1, userId );

            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                userId = rs.getString("user_id");
                String pass = rs.getString("pass");
                String mail = rs.getString("mail");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                account = new Account( userId, pass, mail, name, age);
            }
        } catch (SQLException e) {
            System.out.println("getAccountInfoで例外が発生しました。");
            e.printStackTrace();
            return null;
        }
        return account;
    }
}

// 修正時刻： Fri Jul 10 20:08:51 2020
