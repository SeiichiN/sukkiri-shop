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
      <dl class="clearfix">
        <dt>ユーザーID</dt> <dd id="account-id">${account.userId}<br/></dd>
        <dt>パスワード</dt> <dd id="account-pass">${account.pass}<br/></dd> 
        <dt>メールアドレス</dt> <dd id="account-mail">${account.mail}<br/></dd>
        <dt>名前</dt> <dd id="account-name">${account.name}<br/></dd>
        <dt>年齢</dt> <dd id="account-age">${account.age}<br/></dd>
      </dl>
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
    <script src="accountEdit.js"></script>
  </body>
</html>

<!-- 修正時刻： Sun Jul 12 12:08:51 2020 -->
