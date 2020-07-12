// accountEdit.js

const html =
      '<!doctype html><html lang="ja"/>' +
      '<head><meta charset="utf-8"/>' +
      '<title>アカウント編集 - スッキリ商店</title>' +
      '<link ref="stylesheet" href="sukkiri.css"' +
      '</head><body/>' +
      '<h1>アカウント編集</h1>' +
      '<form action="" method="post"' +
      'ユーザーID:<input type="text" name="userId" value="' + userId + '"><br/>' +
      'パスワード:<input type="password" name="pass" value="' + pass + '"><br/>' +
      'メールアドレス:<input type="email" name="mail" value="' + mail + '"><br/>' +
      '名前:<input type="text" name="name" value="' + name + '"><br/>' +
      '年齢:<input type="text" name="age" value="' + age + '"><br/>' +
      '</form></body></html>'

const newBody = document.createElement('html');
newBody.addChild(html);

// 修正時刻： Sun Jul 12 12:08:08 2020
