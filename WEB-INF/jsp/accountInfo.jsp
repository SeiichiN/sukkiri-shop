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
    <div id="account-info">
      ユーザーID: ${account.userId}<br/>
      パスワード: ${account.pass}<br/>
      メールアドレス: ${account.mail}<br/>
      名前: ${account.name}<br/>
      年齢: ${account.age}<br/>
    </div>
    <div id="account-edit"><a href="/sukkiriShop/EditServlet">編集</a></div>
    <div id="account-delete" onclick="kakunin()">削除</div>
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

<!-- 修正時刻： Sat Jul 11 07:48:31 2020 -->
