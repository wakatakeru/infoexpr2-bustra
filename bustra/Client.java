package bustra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLConnection;
 
public class Client {

  private String userName;
  private int score;
  
  public Client(String userName, int score) {
    this.userName = userName;
    this.score = score;
  }

  public void postData() {
    String urlStr = Constants.URL;

    try {
      URL url = new URL(urlStr);
      URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
 
      OutputStream outStream = conn.getOutputStream();
      
      String postStr =
        "username=" +
        this.userName +
        "&point=" +
        this.score +
        "&submit=OK";
      
      PrintStream printStream = new PrintStream(outStream);
      printStream.print(postStr);
      printStream.close();

      InputStream inputStream = conn.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      reader.close();
      
    } catch (MalformedURLException e) {
      System.err.println("Invalid URL format: " + urlStr);
      System.exit(-1);
    } catch (IOException e) {
      System.err.println("Can't connect to " + urlStr);
      System.exit(-1);
    }
  }
}
