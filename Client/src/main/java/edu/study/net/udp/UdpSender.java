package edu.study.net.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(6666);

		// 准备数据：控制台读取System.in
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String data = reader.readLine();
			byte[] buffer = data.getBytes();

			InetAddress localhost = InetAddress.getByName("localhost");
			int port = 8888;
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, localhost, port);

			socket.send(packet);
			if (data.equals("/QUIT")) {
				break;
			}
		}
		socket.close();
		reader.close();
	}
}
