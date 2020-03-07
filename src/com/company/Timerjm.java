package com.company;

import org.omg.Messaging.SyncScopeHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author
 */
public class Timerjm {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                String url = "http://localhost/log/doFindPageObjects?pageCurrent=1";
//                try {
//                    URL oracle = new URL(url);
//                    URLConnection conn = oracle.openConnection();//或HttpURLConnection connect = (HttpURLConnection) connection.openConnection();
//                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                    String inputLine = null;
//                    while((inputLine = br.readLine()) != null){
//                        System.out.println(inputLine);
//                    }
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (UnsupportedEncodingException e) {
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
                String address = "http://localhost/log/doFindPageObjects?pageCurrent=1";
                int status = 404;
                try {
//                    long time =System.currentTimeMillis();
                    URL urlObj = new URL(address);
                    HttpURLConnection oc = (HttpURLConnection) urlObj.openConnection();
                    oc.setUseCaches(false);
                    oc.setConnectTimeout(3000); // 设置超时时间
                    status = oc.getResponseCode();// 请求状态
                    if (200 == status) {
                        // 200是请求地址顺利连通。。
                        System.out.println(urlObj+"连接正常");
                    }
                } catch (Exception e) {
                    System.out.println(address+"连接失败");
                    e.printStackTrace();
                    String fpath="C:/Users/17978/Desktop/test2.bat";
//                    String cmd = "cmd /c "+fpath;
//                    String cmd = "cmd /k "+fpath;
                    String cmd = "cmd /c start "+fpath;
//                    String cmd = "cmd /k start "+fpath;
                    System.out.println(cmd);
                    //String cmd = "cmd /c start F:/mysqlbackup/guohua/backup.bat";

                    try {
                        Runtime.getRuntime().exec(cmd);
                    } catch(IOException ioe) {
                        ioe.printStackTrace();
                    }

                }
            }

        },1000,10000);
//        Thread.sleep(2000);
//        timer.cancel();
        System.out.println("123");
//123
    }

}

