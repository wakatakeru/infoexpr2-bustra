import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class Sounder implements LineListener {
  // オーディオストリーム
  private AudioInputStream audioInputStream;
  // 音声クリップ
  private Clip clip = null;
  // 音声再生中フラグ
  private boolean running = false;

  File soundFile = new File("bin//se_move01.wav");
  
  // 音声ファイルからClipを作成する
  public void init(File file) throws IOException,
      UnsupportedAudioFileException,
      LineUnavailableException, Exception {
    // オーディオ入力ストリームを取得します
    audioInputStream = AudioSystem.getAudioInputStream(soundFile);
    // オーディオ形式を取得します
    AudioFormat audioFormat = audioInputStream.getFormat();
    // データラインの情報オブジェクトを生成します
    DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
    // 指定されたデータライン情報に一致するラインを取得します
    clip = (Clip) AudioSystem.getLine(info);
    clip.open(audioInputStream);
    audioInputStream.close();
  }
  
  // 音声を鳴らす
  public void start() {
    clip.addLineListener(this);
    clip.start();
  }

  //音声を停止する
  public void stop() {
    if(clip != null){
      clip.stop();
    }
  }

  // 音声再生中かを返す
  public boolean isPlaying() {
    return running;
  }
  
  public void update(LineEvent event) {
    if (event.getType() == LineEvent.Type.STOP) {
      clip.stop();
      clip.setFramePosition(0);
      running = false;
      clip.removeLineListener(this);
    }
  }
}
