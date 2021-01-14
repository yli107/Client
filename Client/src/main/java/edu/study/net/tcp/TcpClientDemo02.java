package edu.study.net.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo02 {
	public static void main(String[] args) throws IOException {
		InetAddress inetAddress = InetAddress.getByName("localhost");
		Socket socket = new Socket(inetAddress, 8888);
		File path = new File("lib/pic/iPhone12(1).jpg");
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(path);
		int len;
		byte[] buffer = new byte[1024];
		while ((len = fis.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		
		fis.close();
		os.close();
		socket.close();

	}
}
