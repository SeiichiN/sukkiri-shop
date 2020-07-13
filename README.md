# sukkiri-shop
すっきりわかるJSP&amp;サーブレット入門第13章に追加する

ここでは、Eclipse を使わずに、pleiadesをインストールしたときにいっしょにインストールされるJava開発環境とTomcatを使って、好みのエディタを用いて開発することとする。

プロジェクトフォルダは、ドキュメントフォルダに sukkiri-shop というフォルダを作成して、それを指定する。

# 環境設定

Pleiades をフルセット(all in one)でインストールすると、Java開発環境とTomcatもインストールされる。

[Eplipse 2020] (https://mergedoc.osdn.jp/#pleiades.html)

ここでは、Pleiades が C:\pleiades にインストールされたものとする。

そして、Pleiadesの中にインストールされた Java と Tomcat を使うこととする。

JAVA_HOME = C:\pleiades\java\11

CATALINA_HOME = C:\pleiades\tomcat\9

CLASSPATH = C:\pleiades\tomcat\9\lib\servlet-api.jar;C:\pleiades\tomcat\9\lib\jsp-api.jar

## Antのインストール

Ant もインストールすると便利である。

[Antのダウンロード] (https://ant.apache.org/bindownload.cgi)

1.10.8 .zip archive: apache-ant-1.10.8-bin.zip 

これをダウンロードし、解凍して、現れたフォルダを ホームディレクトリに配置する。

そして、システム環境変数を設定する。

ANT_HOME = C:\Users\user\apache-ant-1.10.8

システム環境変数の PATH を設定する。

PATHに入れるディレクトリ
```
%JAVA_HOME%\bin
%CATALINA_HOME%\bin
%ANT_HOME%\bin
```

## H2のインストール

[H2 Donwnloads] (http://www.h2database.com/html/download.html)

Version 1.4.200 の Windows Installer か、もしくは
Version 1.4.199 Last Stable の Windows Installer をダウンロード。

C:\Program Files (x86)\H2 にインストールされる。

# H2データベースの使い方

h2コンソールを起動して、ブラウザにH2のログイン画面が表示される。

そこの「保存済設定」を Generic H2 (Embedded) とする。

「JDBC URL」を jdbc:h2:~/sukkiriShop として、「接続」。

これでデータベースが作成される。

もし、エラーが出て、sukkiriShop not found とか言われたら、
ユーザーのホームフォルダをエクスプローラで開いて、
「sukkiriShop.mv.db」というファイル名で、中身が空のファイルを作成すると、
うまくいくはず。

いったんログアウトして、今度は
「保存済設定」を Generic H2 (Server) にする。  
「JDBC URL」が jdbc:h2:tcp://localhost/~/sukkiriShop
となっていることを確認して、「接続」。

テーブルの作成は、プログラムの中でおこなっているので、これだけでよい。


# Tomcat の起動

C:\pleiades\tomcat\9\bin\startup.bat のショートカットをデスクトップにつくる。

そのショートカットを Tomcat-start とする。

Tomcat-start をダブルクリックすることで、コマンドプロンプトの画面が開いて、何やら文字化けした文字がいろいろ表示されるが、しばらくすると画面が落ち着く。
これで Tomcat が起動している。

http://localhost:8080/ にアクセスして、Tomcatのページが表示されていればＯＫ。

## Tomcat Webアプリケーションマネージャーの起動

アプリケーションマネージャーは、初期設定では起動できない。ユーザー名とパスワードを登録する必要がある。

C:\pleiades\tomcat\9\conf フォルダの中に tomcat-users.xml があるので、それを好みのエディタで開く。

末尾の </tomcat-users> のすぐ上に、以下の2行を追加する。
```
  <role rolename="manager-gui"/>
  <user username="tomcat" password="tomcat" roles="manager-gui"/>
</tomcat-users> <!-- この上に追加する -->
```

ユーザー名とパスワードを同じにしておいた。

## Tomcatへのプロジェクトフォルダの登録。

C:\pleiades\tomcat\9\conf フォルダの中に Catalina フォルダを作成し、その中に locakhost フォルダを作成する。

その中に、sukkiriShop.xml というファイルを作成し、内容を以下とする。

```
<?xml version='1.0' encoding='utf-8'?>
<Context path="/sukkiriShop" docBase="C:\Users\user\Documents\sukkiri-shop" />
```

sukkiri-shop フォルダは以下のようにする。

```
./
├── WEB-INF
│   ├── classes
│   ├── jsp
│   └── lib
├── index.html
└── src
```

index.html の内容は以下とする。

```
<!doctype html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>すっきり</title>
</head>
<body>
  <h1>すっきり</h1>
</body>
</html>
```

デスクトップにある Tomcat-start というショートカットをダブルクリックして Tomcat を起動する。
以下のURLにアクセスして、「すっきり」のページが表示されれば、フォルダがTomcatに登録されていることが確認できたことになる。

```http://localhost:8080/sukkiriShop```

