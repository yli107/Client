package edu.study.net.tcp;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestTcpClient01 {

	private TcpClientIO clientIO;

	@Before
	void setUp() {
		clientIO = new TcpClientIO("10.1.15.113");
	}

	@Test
	void test() {
		clientIO.send("String");
		clientIO.send("String1");
		clientIO.send("String2");
		clientIO.send("String3");
		clientIO.send("~!@#$%^&*()_+|}{:?><,./;'[]\'");
		clientIO.send("1234567890");
	}

}
