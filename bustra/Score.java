package bustra;

public class Score {

    //-- フィールド
    private int point;

    //-- コンストラクタ
    public Score() {

        point = 0;

    }

    //--メソッド
    // pointを返却する
    public int getPoint() {

	return point;

    }

    // 実際の得点の計算
    private int calcPoint(int erasedBlockCount, int erasingCount) {

	// pointは100点刻みで、
	// コンボ数(消えたブロックの個数×消した回数)の半分

	point = erasedBlockCount * erasingCount / 2 * 100;
	return point;

    }

}
