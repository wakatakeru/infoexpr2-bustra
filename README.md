# 情報環境実験２ 班「止まるんじゃねえぞ…」 Bustra

## このプロジェクトについて
情報環境実験２の作成課題です

## ゲーム概要
制限時間3分以内で多くのブロックを消してスコアを稼ぐパズルゲームです。  
同じ色のブロックを横に3つ並べることでブロックを消すことができます。  
一回のブロック操作で消えたブロックの数と消した回数に応じてスコアにボーナスが付きます。  
> 消えたブロックの数 × 1度の操作で消えた連の数 / 2 * 100 という計算式でスコアは計算されます。  

ゲーム終了後にスコアサーバにスコアを送信することで、他のプレイヤーとランキングで競うことができます。  

## Runnable JAR ファイルの作成
以下の動作はディレクトリ infoexpr2-bustra 下で行います。

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

  - コマンドライン上での起動  
    ディレクトリ infoexpr2-bustra 下で以下のコマンドを実行する  
    `java bustra.Main`
 
## 操作方法  
メニュー画面  
  - マウス操作
    - クリック   : ボタンを押す/テキストフィールドの選択
  - キーボード操作
    - 文字キー : 文字の入力

ゲーム画面  
  - キーボード操作  
    - 矢印キー   : 該当方向への移動
    - スペースキー : ブロック掴む/ブロックを離す

## スコアサーバ
本ゲームではスコアランキングを表示するため、スコアサーバを実装しています。  
bustra/Constants.java にスコアサーバのアドレスが記載されており、標準ではlocalhostの3000番ポートとなっています。  
必要に応じて bustra/Constants.java 13,14行目を以下の形で書き換えしてください。  
`protecred static final String URL = "http://<スコアサーバのアドレス>/scores/create"`  
protected static final String ROOT_URL = "http://<スコアサーバのアドレス>/";  
(スコアを送信しない場合は、変更しなくても問題なく遊ぶことができます。)  

## リポジトリ
本ゲーム   : <https://github.com/wakatakeru/infoexpr2-bustra>  
スコアサーバ : <https://github.com/wakatakeru/infoexpr2-bustra-score_server>  

## 素材元
CMAN       : <https://sozai.cman.jp/>  

## 参考
Bustra.java <http://guppy.eng.kagawa-u.ac.jp/2017/InfoEnvExp2/Programs2/Bustra.java>  
