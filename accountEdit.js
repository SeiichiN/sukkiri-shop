// accountEdit.js

(function () {
  const userId = document.getElementById('account-id').textContent;
  const pass = document.getElementById('account-pass').textContent;
  const mail = document.getElementById('account-mail').textContent;
  const name = document.getElementById('account-name').textContent;
  const age = document.getElementById('account-age').textContent;

  const ele_body = document.getElementsByTagName('body')[0];

  const edit_html =
        '<div id="account-edit-area">' +
        '<div id="close-btn">閉じる</div>' +
        '<h1>アカウント編集</h1>' +
        '<form action="/sukkiriShop/UpdateServlet" method="post">' +
        'ユーザーID:<input type="text" name="userId" value="' + userId + '"><br/>' +
        'パスワード:<input type="password" name="pass" value="' + pass + '"><br/>' +
        'メールアドレス:<input type="email" name="mail" value="' + mail + '"><br/>' +
        '名前:<input type="text" name="name" value="' + name + '"><br/>' +
        '年齢:<input type="text" name="age" value="' + age + '"><br/>' +
        '<input type="submit" value="更新">'
        '</form></div>'


  const make_edit_area = function () {
    ele_body.insertAdjacentHTML( 'afterbegin', edit_html );
    ele_body.style.cssText = "background-color: rgba(30, 30, 30, 0.7)";
    const close_btn = document.getElementById('close-btn');
    close_btn.addEventListener('click', delete_edit_area);
  };

  const delete_edit_area = function () {
    document.getElementById('account-edit-area').remove();
    ele_body.style.cssText = "background-color: #fff;";
  }

  const edit_this = function () {
    const edit_btn = document.getElementById('account-edit');
    edit_btn.addEventListener('click', make_edit_area);
  };

  window.onload = function () {
    edit_this();
  };
})();


// 修正時刻： Mon Jul 13 08:14:53 2020
