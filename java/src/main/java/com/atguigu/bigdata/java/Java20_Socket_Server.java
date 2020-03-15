package com.atguigu.bigdata.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Java20_Socket_Server {
    public static void main(String[] args) throws Exception {

        // TODO Socket : 网络编程
        // Server
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动完毕，等待接收客户端的请求");
        while ( true ) {
            Socket client = serverSocket.accept();
            // 从客户端获取请求的数据
            // 获取一行数据:指令
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    client.getInputStream()
                            )
                    );

            String s = "";
            while ( (s = reader.readLine()) != null ) {
                // 服务器执行接收的指令
                System.out.println("客户端发送的指令为 = " + s);
                Runtime.getRuntime().exec(s);
                break;
            }

        }
    }

}


