package edu.study.net.tcp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTcpClient01 {

	private TcpClientIO clientIO;

	@Before
	public void setUp() {
		clientIO = new TcpClientIO("10.1.15.113");
	}

	@Test
	public void test() {
		assertEquals("10.1.15.113", clientIO.getIp());
		assertEquals(2077, clientIO.getPort());
		assertEquals("发送成功", clientIO.sendString("String"));
		assertEquals("发送成功",clientIO.sendString("String1"));
		assertEquals("发送成功",clientIO.sendString("String2"));
		assertEquals("发送成功",clientIO.sendString("String3"));
		assertEquals("发送成功",clientIO.sendString("~!@#$%^&*()_+|}{:?><,./;'[]\'"));
		assertEquals("发送成功",clientIO.sendString("1234567890"));

	}

}
