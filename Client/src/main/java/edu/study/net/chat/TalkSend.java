package edu.study.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TalkSend implements Runnable {

	DatagramSocket socket = null;
	BufferedReader reader = null;

	private int fromPort;
	private int toPort;
	private String toIP;

	public TalkSend(int fromPort, String toIP, int toPort) {
		this.fromPort = fromPort;
		this.toIP = toIP;
		this.toPort = toPort;

		try {
			socket = new DatagramSocket(fromPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 从console读入数据
		reader = new BufferedReader(new InputStreamReader(System.in));

		// 整合packet

		try {
			while (true) {
				String data = reader.readLine();
				byte[] buf = data.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(toIP), toPort);
				socket.send(packet);
				if (data.equals("/QUIT")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
