<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>アカウント情報 - スッキリ商店</title>
    <link rel="stylesheet" href="sukkiri.css"/>
  </head>
  <body>
    <h1>アカウント情報</h1>
    <div id="account-info">
      ユーザーID: ${account.userId}<br/>
      パスワード: ${account.pass}<br/>
      メールアドレス: ${account.mail}<br/>
      名前: ${account.name}<br/>
      年齢: ${account.age}<br/>
    </div>
    <form action="/sukkiriShop/EditServlet" method="post">
      <div id="account-edit" class="link-type">編集</div>
    </form>
    <form action="/sukkiriShop/DeleteServlet" method="post">
      <input type="hidden" name="userId" value="${account.userId}"/>
      <div id="account-delete" class="link-type" onclick="kakunin()">削除</div>
    </form>
    <p><a href="/sukkiriShop/WelcomeServlet">もどる</a></p>
    <script>
     function kakunin() {
       const yesno = confirm("削除します。よろしいですか？");
       if (yesno) {
         location.href = "/sukkiriShop/DeleteServlet";
       }
     }
    </script>
  </body>
</html>

<!-- 修正時刻： Sun Jul 12 10:28:45 2020 -->
