package edu.study.net.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {

	private DatagramSocket socket = null;

	private String msgFrom;

	public TalkReceive(int port, String msgFrom) {
		this.msgFrom = msgFrom;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);

				socket.receive(packet);

				byte[] data = packet.getData();
				String receiveData = new String(data).trim();
				if (receiveData.equals("/QUIT")) {
					break;
				}
				System.out.println(msgFrom + ":" + receiveData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}
