# makasete-choice

## 概要

チームブラックの成果物である、`まかせてチョイス`のリメイク

## 環境

- `Vue.js`
- `Docker`
- `Android`
- `Kotlin`

## ブランチ運用

[ブランチ運用ルール](https://github.com/RyuseiNomi/makasete-choice/wiki/%E3%83%96%E3%83%A9%E3%83%B3%E3%83%81%E9%81%8B%E7%94%A8%E3%83%AB%E3%83%BC%E3%83%AB)を参照。



## Vue環境構築手順

プロジェクトのルートディレクトリに移動して以下を実行

```
$ docker-compose build
$ docker-compose up -d
```

vueコンテナが立ち上がっていることを確認

webコンテナとdbコンテナも立ち上がりますが、今はまだ使いません。

```
$ docker ps | awk '{print $NF}'
NAMES
db
vue
nginx
```

vueコンテナが立ち上がっていることを確認出来たら、sshでコンテナに入ってvue-projectに移動してください。

移動が出来たら、npmコマンドを使ってサーバを立ち上げます。(サーバの立ち上げは少し時間がかかります)

```
$ docker exec -it vue sh
# cd vue-project
# npm run serve
```

以下のような表示が出たらサーバ立ち上げ成功です。

localhost://9000 にアクセスしてページが表示されることを確認しましょう。

```
 DONE  Compiled successfully in 12820ms                       10:59:11


  App running at:
  - Local:   http://localhost:8080/

  It seems you are running Vue CLI inside a container.
  Access the dev server via http://localhost:<your container's external mapped port>/

  Note that the development build is not optimized.
  To create a production build, run npm run build.
```







