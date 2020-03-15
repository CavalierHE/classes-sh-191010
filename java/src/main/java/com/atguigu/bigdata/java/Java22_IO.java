package com.atguigu.bigdata.java;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Java22_IO {
    public static void main(String[] args) throws Exception {

        // TODO IO
        // Client
        Socket client = new Socket("localhost", 9999);

        PrintWriter out = new PrintWriter(
            new OutputStreamWriter(
                   client.getOutputStream(),
                    "UTF-8"
            )
        );

        out.println("CMD /c notepad");
        out.flush();
        out.close();

    }

}


