<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>ログイン - スッキリ商店</title>
  </head>
  <body>
    <h1>スッキリ商店</h1>
    <p>ようこそ<c:out value="${userId}" />さん</p>
    <form action="/sukkiriShop/AccountInfo" method="post">
      <input type="hidden" name="userId" value="${userId}"/>
      <p><input type="submit" value="アカウント情報"/></p>
    </form>
    <p><a href="/sukkiriShop/WelcomeServlet">トップへ</a></p>
  </body>
</html>

<!-- 修正時刻： Fri Jul 10 18:03:55 2020 -->

