package bustra;

public class Score {

    //-- フィールド
    private int point;

    //-- コンストラクタ
    public Score() {

        point = 0;

    }

    //--メソッド
    // calcPointを呼び出す
    public int getPoint() {

        return calcPoint();

    }

    // 実際の得点の計算
    private int calcPoint() {

	// pointは100点刻み(?)としたいと思いますがどうでしょうか？
	// 今はこういう感じのイメージです↓
	// pointはコンボ数(消えたブロックの個数×消した回数)の半分
	// 100点刻み
	point = getErasedBlockCount() * getErasingCount() / 2 * 100;
	return point;

    }

}
