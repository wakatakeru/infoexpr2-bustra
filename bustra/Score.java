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
    public static int getPoint() {

        return calcPoint();

    }

    // 実際の得点の計算
    private static int calcPoint() {

	// pointは100点刻み(?)としたいと思いますがどうでしょうか？
	point = getErasedBlockCount() * getErasingCount() * 1/2 * 100;
	return point;

    }
}
