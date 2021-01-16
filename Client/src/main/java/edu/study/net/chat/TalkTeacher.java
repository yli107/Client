package edu.study.net.chat;

public class TalkTeacher {
	public static void main(String[] args) {
		// 开启两个线程；
		new Thread(new TalkSend(8888, "localhost", 5555)).start();
		new Thread(new TalkReceive(9999, "student")).start();
	}
}  
