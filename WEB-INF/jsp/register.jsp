<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>スッキリ商店</title>
  </head>
  <body>
    <h1>スッキリ商店</h1>
    <form action="/sukkiriShop/RegisterServlet" method="POST">
      ユーザーID: <input type="text" name="userId"/><br/>
      パスワード: <input type="password" name="pass"/><br/>
      メールアドレス: <input type="email" name="mail"/><br/>
      名前: <input type="text" name="name"/><br/>
      年齢: <input type="text" name="age"/><br/>
      <input type="submit" value="登録"/>
    </form>
    <p><a href="/sukkiriShop/WelcomeServlet">もどる</a></p>
  </body>
</html>

<!-- 修正時刻： Wed Jul  8 20:52:30 2020 -->
