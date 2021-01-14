package edu.study.net.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.regex.Pattern;

/**
 * Clinet客户端IO
 * 
 * @author Leo
 *
 */
public class TcpClientIO {
	private static final int DEFAULT_PORT = 2077;

	private int port;

	private String ip;

	public TcpClientIO(String ip, int port) {
		setServerIp(ip);
		setPort(port);
	}

	public TcpClientIO(String ip) {
		this(ip, DEFAULT_PORT);
	}

	public String send(String s) {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		String info = null;
		try {
			socket = new Socket(ip, port);
			os = socket.getOutputStream();
			os.write(s.getBytes());

			//  告诉服务器发送结束
			socket.shutdownOutput();
			
			// 回调服务器发回的信息
			is = socket.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while((len = is.read(buffer)) != -1) {
				baos.write(buffer,0,len);
			}
			info = baos.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return info;
	}

	public void setServerIp(String ip) {
		String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(ip).matches()) {
			throw new IllegalArgumentException("The ip is Invalid");
		}
		this.ip = ip;
	}

	public void setPort(int port) {
		if (port > 65535 || port < 0) {
			throw new IndexOutOfBoundsException("The port must be in range of 0 - 65535");
		}
		this.port = port;

	}

	public int getPort() {
		return port;
	}

	public String getIp() {
		return ip;
	}
}
