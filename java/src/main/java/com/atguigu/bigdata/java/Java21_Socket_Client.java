package com.atguigu.bigdata.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Java21_Socket_Client {
    public static void main(String[] args) throws Exception {

        // TODO Socket : 网络编程
        // Client
        Socket client = new Socket("localhost", 9999);

        PrintWriter out = new PrintWriter(
            new OutputStreamWriter(
                   client.getOutputStream()
            )
        );

        out.println("CMD /c notepad");
        out.flush();
        out.close();

    }

}


