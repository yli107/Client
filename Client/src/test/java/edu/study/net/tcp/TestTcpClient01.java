package edu.study.net.tcp;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TestTcpClient01 {

	private TcpClientIO clientIO;

	@Before
	public void setUp() {
		clientIO = new TcpClientIO("10.1.15.113");
	}

	@Test
	public void test() {
		clientIO.send("String");
		clientIO.send("String1");
		clientIO.send("String2");
		clientIO.send("String3");
		clientIO.send("~!@#$%^&*()_+|}{:?><,./;'[]\'");
		clientIO.send("1234567890");
		assertEquals("10.1.15.113",clientIO.getHostAddress());
	}

}
