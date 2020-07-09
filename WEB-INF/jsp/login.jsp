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
    <form action="/sukkiriShop/LoginServlet" method="post">
      ユーザーID: <input type="text" name="userId"/><br/>
      パスワード: <input type="password" name="pass"/><br/>
      <input type="submit" value="ログイン"/>
    </form>
  </body>
</html>

<!-- 修正時刻： Wed Jul  8 19:08:40 2020 -->
