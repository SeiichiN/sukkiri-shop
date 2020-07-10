<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>アカウント情報 - スッキリ商店</title>
  </head>
  <body>
    <h1>アカウント情報</h1>
    ユーザーID: ${account.userId}<br/>
    パスワード: ${account.pass}<br/>
    メールアドレス: ${account.mail}<br/>
    名前: ${account.name}<br/>
    年齢: ${account.age}<br/>
    <p><a href="/sukkiriShop/EditAccount">編集</a></p>
    <p><a href="/sukkiriShop/WelcomeServlet">もどる</a></p>
  </body>
</html>

<!-- 修正時刻： Fri Jul 10 20:23:57 2020 -->
