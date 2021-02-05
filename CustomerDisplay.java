package health;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class CustomerDisplay extends JFrame{
	private JFrame frame;
	
	public CustomerDisplay() {
		frame = new JFrame(); //frame 생성
		frame.setResizable(false); //frame이 보이도록 설정
		frame.setBounds(470, 200, 1000, 600); //frame의 크기 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫도록 지정
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setTitle("Daily Health - 회원 페이지"); //타이틀 설정
		
		//툴킷을 사용하여 이미지 만들기
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png 형식의 이미지 파일만 지원
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		JPanel customerPanel = new JPanel();
		customerPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(customerPanel);
		customerPanel.setLayout(null);
	}
	public static void main(String[] args) {
		new CustomerDisplay();
	}
}