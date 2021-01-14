package edu.study.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo01 {
	public static void main(String[] args) {

		Socket socket = null;
		OutputStream os = null;
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			socket = new Socket(inetAddress, 9999);
			os = socket.getOutputStream();
			os.write("Hello MFK".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
