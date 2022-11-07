package Ch08;
/*
 * 상속,인터페이스(상속 다중상속 불가 -> 인터페이스를 이용하면 해결)
 * extends, implements
 * 객체,클래스: = 필드+생성자+메서드
 * 객체는 서로 연결 되어있다. --> 객체 호출 시 접근 제어자 (public,private,protected)
 * 객체에 있는 필드 바로 접근 할 경우 없이 변경되는 경우 발생
 * 이를 방지하기 위해 객체를 호추라여 필드에 접근 할떄는 생성자를 이용하여 필드의 값을 포기호 하는 방법 수행
 * 생성자와 메서드의 구분: 생성자는 리턴 타입x, 메서드는 리턴 타입 o
 * 자바의 데이터형:
 *  1. 기본형 
 *  2. 참조형: 배열 ,클래스,인터페이스,열거
 * 
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class Threads extends JFrame implements Runnable {

		/*
		 * 진동하는 윈도우 프로그래밍
		 * runnable 을 받아서 스레드를 작성하고
		 * 프레임이 진동하도록 프로그램을 작성
		 * 컨텐트 펜에 마우스를 클릭하면 스레드를 중지하도록 구현
		 */
	
	//필드 선언
	Thread th;
	
	//생성자 선언
	Threads(){
		setTitle("진동하는 프레임 위젯");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		
		//이벤트 해들러 동작
		getContentPane().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return;
				th.interrupt();
				//인터럽트 익셉션
				
			}
			
			//이벤트 처리  
			
		
		
		});
			th = new Thread(this);
			th.start();//쓰레드 동작
			
			
		}
	
	//메서드 선언
	public void run() { //20 ms마다 프레임 위치를 랜덤하게 이동
		
		Random r = new Random();
		while(true) {
			try {
				Thread.sleep(20);
				
			}
			
			catch(InterruptedException e) {
				return;
			}
			int x = getX()+ r.nextInt()%80;
			int y = getY() + r.nextInt()%80;
			setLocation(x,y);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		new Threads();
	}

}
