package java1017_thread;

/*
 동기화                          비동기화
StringBuilder   StringBuffer
Vector          ArrayList
Hashtable       HashMap

파일 : Ms-word프로그램
프로세스: 메모리에서 실행중인 프로그램이다.
 게임프로그램-게임, 음악, 채팅
스레드(thread) : 프로세스에서 독립적으로 실행되는 단위이다.

자바에서 스레드 생성을 위해 제공해주는 2가지 방법
1. java.lang.Thread클래스
2. java.lang.Runnable 인터페이스

스케줄링
 : 스레드가 생성되어 실행될 때 시스템의 여러 자원을 해당 스레드에게  할당하는 작업

선점형 스케줄링
  :하나의 스레드가 cpu을 할당받아 실행하고 있을 때 우선순위가
     높은 다른 스레드가 cpu를 강제로 빼앗아가 사용할 수 있는 스케줄링 기법이다.
     
프로세스는 메모리맵을 각각이 따로 가지지만 - 프로세스를 2개 실행하면 독립적으로 수행됨
쓰레드는 서로 기본적으로는 메모리맵을 공유하며 스택만 따로 씀 - 동시작업 처리가 가능하다.

 */

class User extends Thread { // Thread 를 상속 받아서 쓰레드를 만드는 방법
	public User() { }
	
	@Override
	public void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.printf("%s i = %d\n", getName(), i);
		}
	}// end run()
} // end User

public class Java206_thread {
	//실행 -> main 스레드 -> main 메소드
	public static void main(String[] args) {
		User us = new User();
		//us.run(); // 이렇게 실행하면 쓰레드로 실행되는 게 아니라 그냥 메소드 호출
		us.start(); // 2개의 쓰레드가 실행됨 (main과 us.start())
		//작업을 분할해서 서로서로 작업 완료가 되면 번갈아 가면서 출력되므로 결과가 섞이는 것 - 동시에 작업이 진행된다.
		
		
		for(int j = 0; j <= 5; j++) {
			System.out.printf("%s j = %d\n", Thread.currentThread().getName(), j); // getName() 현재 실행 중인 쓰레드의 이름 출력
		}
	} // end main()

} // end class
