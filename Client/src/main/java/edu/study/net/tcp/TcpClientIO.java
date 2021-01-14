package edu.study.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class TcpClientIO {
	private static final int DEFAULT_PORT = 2077;

	private InetAddress inetAddress;

	private Socket socket;

	public TcpClientIO(String ip, int port) {
		setServerIp(ip);
		setPort(port);
	}

	public TcpClientIO(String ip) {
		this(ip, DEFAULT_PORT);
	}

	public void send(String s) {
		OutputStream os = null;
		if (socket != null) {
			try {
				os = socket.getOutputStream();
				os.write(s.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setServerIp(String ip) {
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(ip).matches()) {
			throw new IllegalArgumentException("The ip is Invalid");
		}
		try {
			inetAddress = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void setPort(int port) {
		if (inetAddress == null) {
			throw new IllegalArgumentException("The host ip is empty");
		}
		if (port > 65535 || port < 0) {
			throw new IndexOutOfBoundsException("The port must be in range of 0 - 65535");
		}
		try {
			socket = new Socket(inetAddress, port);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getPort() {
		return socket.getPort();
	}

	public String getHostAddress() {
		return inetAddress.getHostAddress();
	}

	protected void finallize() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
