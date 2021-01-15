package edu.study.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 不需要连接服务器
 * 
 * @author Leo Li
 *
 */
public class UdpClientDemo01 {
	public static void main(String[] args) throws IOException {
		// 建立一个Socket
		DatagramSocket socket = new DatagramSocket();

		// 建个包
		String msg = "Surprise motherfucker";
		InetAddress localhost = InetAddress.getByName("localhost");
		int port = 8080;

		// 数据，数据的长度起始，要发送给谁
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
    
		//发送包
		socket.send(packet);
		
		//关闭流
		socket.close();
	}
}
