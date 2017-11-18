# 情報環境実験２ 班「止まるんじゃねえぞ…」 Bustra

## このプロジェクトについて
情報環境実験２の作成課題です

## ゲーム概要
制限時間内で多くのブロックを消してスコアを稼ぐパズルゲームです。
同じ色のブロックが横に3つ並べることでブロックを消すことができます。
一回の移動で多くのブロックを消せるほどスコアにボーナスが付きます。

## Runnable JAR ファイルの作成
以下の動作はディレクトリ infoexpr2-bustra 下で行う。

1. ソースをコンパイルする  
   `javac -encoding UTF-8 bustra/*.java`

2. Bustra.jar を作成する  
   `jar cvf Bustra.jar bustra/Main.class`

3. Bustra.jar を解凍する  
   `jar xvf Bustra.jar`

4. マニュフェストの編集  
   エディタでMETA-INF/MANIFEST.MF を開き末尾に`Main-Class: bustra.Main`の一行を加える

5. Bustra.jar にマニュフェストと必要ファイルを追加する  
   `jar cvfm Bustra.jar META-INF/MANIFEST.MF bustra/*.class bin/*`

## ゲームの起動方法

  - エクスプローラー上での起動  
    Bustra.jar ファイルを実行する

  - コマンドライン上での移動  
    ディレクトリ infoexpr2-bustra 下で以下のコマンドを実行する
    `java bustra.Main`

## 操作方法  
キーボード操作  
  - 矢印キー : 該当方向への移動
  - スペースキー : 決定/ブロック掴む/ブロックを離す

## 素材元
閉じる12 (https://sozai.cman.jp/icon/operation/close/)

## 参考
Bustra.java (http://guppy.eng.kagawa-u.ac.jp/2017/InfoEnvExp2/Programs2/Bustra.java)
