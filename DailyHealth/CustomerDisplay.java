package health;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class CustomerDisplay extends JFrame{
	private JFrame frame;
	JPanel customerPanel;
	
	public static JLabel nameLabel;
	public static JLabel idLabel;
	public static JLabel addressLabel;
	public static JLabel phoneLabel;
	public static JLabel ageLabel;
	public static JLabel heightLabel;
	public static JLabel bmiLabel;
	public static JLabel bmrLabel;
	public static JLabel  remainDaysLabel;
	public static JLabel currentWeightLabel;
	public static JLabel targetWeightLabel;
	
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
		
		customerPanel = new JPanel();
		customerPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(customerPanel);
		customerPanel.setLayout(null);
		
		// 이름 label
		nameLabel = new JLabel("임시이름", JLabel.CENTER);
		customerPanel.add(nameLabel);
		nameLabel.setBounds(60, 35, 200, 70);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		nameLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		nameLabel.setBackground(Color.pink);
		
		// 아이디 label
		idLabel = new JLabel("임시아이디", JLabel.CENTER);
		customerPanel.add(idLabel);
		idLabel.setBounds(60, 115, 200, 40);
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		idLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		idLabel.setBackground(Color.pink);
		
		// 주소  label
		addressLabel = new JLabel("임시주소입니당당당당", JLabel.CENTER);
		customerPanel.add(addressLabel);
		addressLabel.setBounds(60, 205, 250, 40);
		addressLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		addressLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		addressLabel.setBackground(Color.pink);
		
		// 전화번호 label
		phoneLabel = new JLabel("01051354735", JLabel.CENTER);
		customerPanel.add(phoneLabel);
		phoneLabel.setBounds(60, 255, 250, 40);
		phoneLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		phoneLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		phoneLabel.setBackground(Color.pink);
		
		// 나이  label
		ageLabel = new JLabel("18세", JLabel.CENTER);
		customerPanel.add(ageLabel);
		ageLabel.setBounds(60, 305, 120, 40);
		ageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		ageLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		ageLabel.setBackground(Color.pink);
		
		// 키 label
		heightLabel = new JLabel("height", JLabel.CENTER);
		customerPanel.add(heightLabel);
		heightLabel.setBounds(60, 385, 120, 40);
		heightLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		heightLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		heightLabel.setBackground(Color.pink);
		
		// bmi label
		bmiLabel = new JLabel("bmi", JLabel.CENTER);
		customerPanel.add(bmiLabel);
		bmiLabel.setBounds(60, 435, 120, 40);
		bmiLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		bmiLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		bmiLabel.setBackground(Color.pink);
		
		// bmr label
		bmrLabel = new JLabel("bmr", JLabel.CENTER);
		customerPanel.add(bmrLabel);
		bmrLabel.setBounds(60, 485, 120, 40);
		bmrLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		bmrLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		bmrLabel.setBackground(Color.pink);
		
		// 남은 일자  label
		remainDaysLabel = new JLabel("90일", JLabel.CENTER);
		customerPanel.add(remainDaysLabel);
		remainDaysLabel.setBounds(600, 50, 160, 100);
		remainDaysLabel.setFont(new Font("맑은 고딕", Font.BOLD, 52));
		remainDaysLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		remainDaysLabel.setBackground(Color.pink);
		
		// 현재 몸무게 label
		currentWeightLabel = new JLabel("Current", JLabel.CENTER);
		customerPanel.add(currentWeightLabel);
		currentWeightLabel.setBounds(480, 190, 150, 70);
		currentWeightLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 36));
		currentWeightLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		currentWeightLabel.setBackground(Color.pink);
		
		// 현재 몸무게 변경 Button
		JButton changeCurrentWeightBtn = new JButton("현재 몸무게 변경");
		customerPanel.add(changeCurrentWeightBtn);
		changeCurrentWeightBtn.setBounds(480, 260, 150, 30);
		changeCurrentWeightBtn.setBackground(Color.green);
		changeCurrentWeightBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		changeCurrentWeightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newCurrentWeightStr = JOptionPane.showInputDialog(null, "현재 몸무게를 새로 입력해주세요", "현재 몸무게 변경", JOptionPane.QUESTION_MESSAGE);
				if(Current(newCurrentWeightStr) && newCurrentWeightStr != null) {
					JOptionPane.showMessageDialog(null, "현재 몸무게가 변경되었습니다", "현재 몸무게 변경", JOptionPane.PLAIN_MESSAGE);
					currentWeightLabel.setText(newCurrentWeightStr);
				}else if(Current(newCurrentWeightStr) == false){
					JOptionPane.showMessageDialog(null, "현재 몸무게를 변경하지 못했습니다", "현재 몸무게 변경", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// 화살표 버튼
		JButton arrow = new JButton("");
		arrow.setBounds(650, 215, 50, 50);
		customerPanel.add(arrow);
		arrow.setIcon(new ImageIcon("./image/weight_arrow.png"));
		arrow.setBorderPainted(false);
		arrow.setContentAreaFilled(false);
		arrow.setFocusPainted(false);
		
		// 목표 몸무게  label
		targetWeightLabel = new JLabel("Target", JLabel.CENTER);
		customerPanel.add(targetWeightLabel);
		targetWeightLabel.setBounds(720, 190, 150, 70);
		targetWeightLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 36));
		targetWeightLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		targetWeightLabel.setBackground(Color.pink);
		
		// 목표 몸무게 변경 Button
		JButton changeTargetWeightBtn = new JButton("목표 몸무게 변경");
		customerPanel.add(changeTargetWeightBtn);
		changeTargetWeightBtn.setBounds(720, 260, 150, 30);
		changeTargetWeightBtn.setBackground(Color.green);
		changeTargetWeightBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		changeTargetWeightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newTargetWeightStr = JOptionPane.showInputDialog(null, "목표 몸무게를 새로 입력해주세요", "목표 몸무게 변경", JOptionPane.QUESTION_MESSAGE);
				if(Target(newTargetWeightStr) && newTargetWeightStr != null) {
					JOptionPane.showMessageDialog(null, "목표 몸무게가 변경되었습니다", "목표 몸무게 변경", JOptionPane.PLAIN_MESSAGE);
					targetWeightLabel.setText(newTargetWeightStr);
				}else if(Current(newTargetWeightStr) == false){
					JOptionPane.showMessageDialog(null, "목표 몸무게를 변경하지 못했습니다", "목표 몸무게 변경", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// bmi 계산 버튼
		JButton bmiBtn = new JButton("bmi 지수 계산");
		bmiBtn.setBounds(480, 385, 250, 50);
		customerPanel.add(bmiBtn);
		bmiBtn.setBackground(Color.green);
		bmiBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		bmiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		arrow.setIcon(new ImageIcon("./image/weight_arrow.png"));
//		arrow.setBorderPainted(false);
//		arrow.setContentAreaFilled(false);
//		arrow.setFocusPainted(false);
		
		// bmr 계산 버튼
		JButton bmrBtn = new JButton("기초대사량(bmr) 계산");
		bmrBtn.setBounds(480, 455, 250, 50);
		customerPanel.add(bmrBtn);
		bmrBtn.setBackground(Color.green);
		bmrBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		bmrBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		arrow.setIcon(new ImageIcon("./image/weight_arrow.png"));
//		arrow.setBorderPainted(false);
//		arrow.setContentAreaFilled(false);
//		arrow.setFocusPainted(false);
		
		// 로그아웃 버튼
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(870, 510, 105, 35);
		customerPanel.add(logoutBtn);
		logoutBtn.setBackground(Color.green);
		logoutBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LogoChoice();
			}
		});
	}
	public static void main(String[] args) {
		new CustomerDisplay();
	}
	
	// 현재 몸무게 변경 메서드
	public boolean Current(String cw) {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set CurrentWeight=? where id=?");

            pst.setString(1, cw);
            pst.setString(2, idLabel.getText());

            int numRows = pst.executeUpdate(); //insert, delete, 

            System.out.format("%d개의 행이 바꼈습니다.", numRows);

            pst.close();
            conn.close();
			
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	// 목표 몸무게 변경 메서드
	public boolean Target(String tg) {		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
	        
	        PreparedStatement pst=conn.prepareStatement("update jiyoon set TargetWeight=? where id=?");
	
	        pst.setString(1, tg);
	        pst.setString(2, idLabel.getText());
	
	        int numRows = pst.executeUpdate(); //insert, delete, 
	
	        System.out.format("%d개의 행이 바꼈습니다.", numRows);
	
	        pst.close();
	        conn.close();
			
	        return true;
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}