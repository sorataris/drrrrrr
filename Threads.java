package Ch08;
/*
 * ���,�������̽�(��� ���߻�� �Ұ� -> �������̽��� �̿��ϸ� �ذ�)
 * extends, implements
 * ��ü,Ŭ����: = �ʵ�+������+�޼���
 * ��ü�� ���� ���� �Ǿ��ִ�. --> ��ü ȣ�� �� ���� ������ (public,private,protected)
 * ��ü�� �ִ� �ʵ� �ٷ� ���� �� ��� ���� ����Ǵ� ��� �߻�
 * �̸� �����ϱ� ���� ��ü�� ȣ�߶� �ʵ忡 ���� �ҋ��� �����ڸ� �̿��Ͽ� �ʵ��� ���� ����ȣ �ϴ� ��� ����
 * �����ڿ� �޼����� ����: �����ڴ� ���� Ÿ��x, �޼���� ���� Ÿ�� o
 * �ڹ��� ��������:
 *  1. �⺻�� 
 *  2. ������: �迭 ,Ŭ����,�������̽�,����
 * 
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class Threads extends JFrame implements Runnable {

		/*
		 * �����ϴ� ������ ���α׷���
		 * runnable �� �޾Ƽ� �����带 �ۼ��ϰ�
		 * �������� �����ϵ��� ���α׷��� �ۼ�
		 * ����Ʈ �濡 ���콺�� Ŭ���ϸ� �����带 �����ϵ��� ����
		 */
	
	//�ʵ� ����
	Thread th;
	
	//������ ����
	Threads(){
		setTitle("�����ϴ� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		
		
		//�̺�Ʈ �ص鷯 ����
		getContentPane().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return;
				th.interrupt();
				//���ͷ�Ʈ �ͼ���
				
			}
			
			//�̺�Ʈ ó��  
			
		
		
		});
			th = new Thread(this);
			th.start();//������ ����
			
			
		}
	
	//�޼��� ����
	public void run() { //20 ms���� ������ ��ġ�� �����ϰ� �̵�
		
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
