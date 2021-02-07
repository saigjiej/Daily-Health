package health;

// import
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class CustomerDisplay extends JFrame{
	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}

	JPanel customerPanel;
	
	public static JLabel nameLabel;
	public static JLabel idLabel;
	public static JLabel addressLabel;
	public static JLabel phoneLabel;
	public static JLabel ageLabel;
	public static JLabel heightLabel;
	public static JLabel bmiLabel;
	public static JLabel bmrLabel;
	public static JLabel remainDaysLabel;
	public static JButton attendBtn;
	public static JLabel info;
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
		remainDaysLabel.setBounds(480, 50, 160, 100);
		remainDaysLabel.setFont(new Font("맑은 고딕", Font.BOLD, 52));
		remainDaysLabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		remainDaysLabel.setBackground(Color.pink);
		
		// 출석 Button
		attendBtn = new JButton("사용");
		customerPanel.add(attendBtn);
		attendBtn.setBounds(655, 70, 70, 60);
		attendBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		attendBtn.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		attendBtn.setBackground(Color.pink);
		attendBtn.setBorderPainted(false);
		attendBtn.setFocusPainted(false);
		attendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(remainDaysLabel.getText()) > 0 && attend(idLabel.getText()) == true) {
					SimpleDateFormat custom_format = new SimpleDateFormat ( "yyyy년 MM월 dd일");
					Date time = new Date();
					String today = custom_format.format(time);
					JOptionPane.showMessageDialog(null, idLabel.getText() + "님, " + today + "에 정기권이 사용되었습니다", "출석체크", JOptionPane.PLAIN_MESSAGE);
					remainDaysLabel.setText(String.valueOf(Integer.parseInt(remainDaysLabel.getText()) -1));
				}else if(Integer.parseInt(remainDaysLabel.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "<html>" + idLabel.getText() + "님, 남은 이용일이 없습니다<br>계속 이용을 원하시면 추가 결제를 해주세요</html>", "출석체크", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		// 출석체크 설명
		info = new JLabel("출석체크", JLabel.LEFT);
		customerPanel.add(info);
		info.setBounds(745, 50, 270, 100);
		info.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		info.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		info.setForeground(new Color(136,150,159));
		info.setText("<html>사용 버튼을 누르면 남은 일수가 차감됩니다<br>사용 버튼을 누르면 출입문이 열립니다<br>추가 결제 => 카운터로 문의</html>");
		
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
				BmiFrame bmi = new BmiFrame();
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
				BmrFrame bmr = new BmrFrame();
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
	
	// 출석체크 메서드
	public boolean attend(String id) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set remain_days=? where id=?");

            pst.setDouble(1, Integer.parseInt(remainDaysLabel.getText()) - 1);
            pst.setString(2, id);

            int numRows = pst.executeUpdate();

            System.out.format("출석체크 : %d개의 행이 바꼈습니다.", numRows);

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
class BmiFrame extends JFrame{
	JFrame frame;
	JPanel bmiPanel;
	
	JTextField WeightField;
	JTextField HeightField;
	JLabel BmiResult;
	JButton BmiUpdate;
	
	double bmi;
	
	BmiFrame() {
		frame = new JFrame(); //frame 생성
		frame.setResizable(false); //frame이 보이도록 설정
		frame.setBounds(470, 200, 1000, 600); //frame의 크기 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫도록 지정
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setTitle("Daily Health - bmi 계산"); //타이틀 설정
		
		//툴킷을 사용하여 이미지 만들기
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png 형식의 이미지 파일만 지원
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		bmiPanel = new JPanel();
		bmiPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(bmiPanel);
		bmiPanel.setLayout(null);

		JLabel WeightLabel = new JLabel("\uBAB8\uBB34\uAC8C : ");
		WeightLabel.setBounds(48, 109, 113, 34);
		WeightLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		bmiPanel.add(WeightLabel);
		
		WeightField = new JTextField();
		WeightField.setBounds(162, 109, 172, 35);
		bmiPanel.add(WeightField);
		WeightField.setColumns(10);
		WeightField.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		WeightField.setText(CustomerDisplay.currentWeightLabel.getText());
		
		JLabel lblkg = new JLabel("(kg\uB2E8\uC704)");
		lblkg.setBounds(337, 109, 104, 34);
		lblkg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		bmiPanel.add(lblkg);
		
		JLabel HeightLabel = new JLabel("\uD0A4 : ");
		HeightLabel.setBounds(48, 158, 113, 34);
		HeightLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		bmiPanel.add(HeightLabel);
		
		HeightField = new JTextField();
		HeightField.setBounds(162, 158, 172, 35);
		HeightField.setColumns(10);
		HeightField.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		HeightField.setText(CustomerDisplay.heightLabel.getText());
		bmiPanel.add(HeightField);
		
		JLabel lblcm = new JLabel("(cm\uB2E8\uC704)");
		lblcm.setBounds(337, 158, 104, 34);
		lblcm.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		bmiPanel.add(lblcm);
		
		BmiUpdate = new JButton();
		
		JButton BmiButton = new JButton("BMI \uC9C0\uC218 \uACC4\uC0B0");
		BmiButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		BmiButton.setBackground(new Color(151, 201, 210));
		BmiButton.setBounds(468, 112, 180, 85);
		BmiButton.setBorderPainted(false);
		BmiButton.setFocusPainted(false);
		bmiPanel.add(BmiButton);
		BmiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(BmiResult != null) {
						BmiResult.setVisible(false);
					}
					double weight = Double.parseDouble(WeightField.getText()); //입력받은 몸무게를 변수 weight에 넣어준다
					double height = Double.parseDouble(HeightField.getText()); //입력받은 키를 변수 height에 넣어준다
					double var = weight/((height*(0.01))*(height*(0.01))); //Bmi지수를 구하는 공식이다
					if(0<var && var<18.5) { //조건성립시
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 저체중입니다"); //레이블을 이용해 출력
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI 등록하기");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmi) + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(18.5<=var && var<23) {//조건성립시
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 정상체중입니다");//레이블을 이용해 출력
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI 등록하기");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmi) + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(23<=var && var<25) {//조건성립시
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 과체중입니다");//레이블을 이용해 출력
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI 등록하기");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmi) + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(25<=var && var<30) { //조건성립시
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 경도비만입니다");//레이블을 이용해 출력
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI 등록하기");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmi) + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else if(var<=30 && var<40) {//조건성립시
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 고도비만입니다");//레이블을 이용해 출력
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);		
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI 등록하기");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmi) + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									
								}
							}
						});
					}else {//조건들 외 일 시에
						BmiResult = new JLabel(Math.round(var*100)/100.0 + " , 초고도비만입니다");
						bmiPanel.add(BmiResult);
						BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
						BmiResult.setBounds(48, 261, 874, 43);
						BmiResult.setVisible(true);	
						BmiResult.setForeground(Color.BLACK);
						
						BmiUpdate = new JButton("BMI 등록하기");
						bmiPanel.add(BmiUpdate);
						BmiUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmiUpdate.setBounds(468, 240, 180, 80);
						BmiUpdate.setVisible(true);
						BmiUpdate.setForeground(Color.BLACK);
						BmiUpdate.setBackground(new Color(223,161,158));
						BmiUpdate.setBorderPainted(false);
						BmiUpdate.setFocusPainted(false);
						
						bmi = Math.round(var*100)/100.0;
						
						BmiUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmi) + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
									JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmiLabel.setText(String.valueOf(bmi));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
								}
							}
						});
					}//end of if~else if~else문
				// bmi db에 추가하는 코드
				}catch(NumberFormatException num) {
					BmiResult = new JLabel("숫자를 입력해주세요");
					BmiResult.setForeground(Color.RED);
					bmiPanel.add(BmiResult);
					BmiResult.setFont(new Font("맑은 고딕", Font.PLAIN, 27));
					BmiResult.setBounds(48, 261, 874, 43);
					BmiResult.setVisible(true);	
				}
			}
		});
		
		BmiUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel + "님, " + BmiResult.getText() + "를 bmi 지수로 등록하시겠습니까?", "bmi 등록하기", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION && updateBmi(bmi) == true) {
					JOptionPane.showMessageDialog(null, "bmi 지수가 등록되었습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
					CustomerDisplay.bmiLabel.setText(BmiResult.getText());
				}else if(option == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "bmi 지수 등록을 취소하셨습니다", "bmi 등록하기", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		// bmi에 따른 비만도 이미지
		JButton bmiImage = new JButton("");
		bmiImage.setBounds(139, 378, 742, 110);
		bmiImage.setIcon(new ImageIcon("./image/bmi.png")); //bmi지수에 따른 비만도를 보여주는 사진
		bmiPanel.add(bmiImage);
		bmiImage.setBorderPainted(false);
		bmiImage.setFocusPainted(false);
		
		// 메인으로 화면
		JButton gotoMain_bmi = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmi.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		gotoMain_bmi.setBackground(new Color(218, 226, 234));
		gotoMain_bmi.setBounds(863, 12, 105, 27);
//		bmiPanel.add(gotoMain_bmi);
		
		JLabel lblBmi = new JLabel("BMI 지수 구하기");
		lblBmi.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblBmi.setBounds(48, 31, 239, 47);
		bmiPanel.add(lblBmi);
		bmiImage.setBorderPainted(false);
		bmiImage.setFocusPainted(false);
		
		// bmi 설명 Label
		JLabel bmiInfo = new JLabel("<html>BMI는 자신의 몸무게(kg)를 키의 제곱(m)으로 나눈 값입니다<br>"
				+ "*주의 : 근육량, 유전적 원인 등 개인차 반영하지 못할 수 있습니다</html>", JLabel.LEFT);
		bmiInfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bmiInfo.setForeground(new Color(136,150,159));
		bmiInfo.setBounds(300, 15, 410, 80);
		bmiPanel.add(bmiInfo);
		
		// 초기화 버튼
		JButton new_bmi = new JButton("\uB2E4\uC2DC\uACC4\uC0B0");
		new_bmi.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		new_bmi.setBackground(new Color(218, 226, 234));
		new_bmi.setBorderPainted(false);
		new_bmi.setFocusPainted(false);
		new_bmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BmiResult != null) {
					BmiResult.setVisible(false);
				}
				WeightField.setText("");
				HeightField.setText("");
			}
		});
		new_bmi.setBackground(new Color(200,222,228));
		new_bmi.setBounds(845, 49, 120, 30);
		
		bmiPanel.add(new_bmi);
		
		gotoMain_bmi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	public boolean updateBmi(double bmi) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set bmi=? where id=?");

            pst.setDouble(1, Math.round(bmi));
            pst.setString(2, CustomerDisplay.idLabel.getText());

            int numRows = pst.executeUpdate(); //insert, delete, 

            System.out.format("bmi 등록 : %d개의 행이 바꼈습니다.", numRows);

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

class BmrFrame extends JFrame{
	JFrame frame;
	JPanel bmrPanel;
	
	JTextField Weight_t;
	JTextField Height_t;
	JTextField Age_t;
	
	JLabel BmrResult;
	JButton BmrUpdate;
	
	double bmr;
	
	BmrFrame() {
		frame = new JFrame(); //frame 생성
		frame.setResizable(false); //frame이 보이도록 설정
		frame.setBounds(470, 200, 1000, 600); //frame의 크기 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫도록 지정
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setTitle("Daily Health - bmr 계산"); //타이틀 설정
		
		//툴킷을 사용하여 이미지 만들기
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png 형식의 이미지 파일만 지원
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		bmrPanel = new JPanel();
		bmrPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(bmrPanel);
		bmrPanel.setLayout(null);
		
		JRadioButton Man = new JRadioButton("\uB0A8\uC790");
		Man.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Man.setBounds(159, 140, 77, 27);
		bmrPanel.add(Man);
		
		JRadioButton Woman = new JRadioButton("\uC5EC\uC790");
		Woman.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Woman.setBounds(159, 171, 77, 27);
		bmrPanel.add(Woman);
		
		JLabel Gender = new JLabel("\uC131\uBCC4 : ");
		Gender.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Gender.setBounds(61, 140, 69, 27);
		bmrPanel.add(Gender);
		
		JLabel Weight = new JLabel("\uCCB4\uC911 : ");
		Weight.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Weight.setBounds(61, 236, 69, 27);
		bmrPanel.add(Weight);
		
		JLabel Height = new JLabel("\uD0A4(cm) : ");
		Height.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Height.setBounds(61, 312, 91, 27);
		bmrPanel.add(Height);
		
		JLabel Age = new JLabel("\uB098\uC774 : ");
		Age.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Age.setBounds(61, 381, 69, 27);
		bmrPanel.add(Age);
		
		Weight_t = new JTextField();
		Weight_t.setBounds(159, 236, 137, 29);
		bmrPanel.add(Weight_t);
		Weight_t.setColumns(10);
		Weight_t.setText(CustomerDisplay.currentWeightLabel.getText());
		Weight_t.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		Height_t = new JTextField();
		Height_t.setColumns(10);
		Height_t.setBounds(159, 312, 137, 29);
		bmrPanel.add(Height_t);
		Height_t.setText(CustomerDisplay.heightLabel.getText());
		Height_t.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		Age_t = new JTextField();
		Age_t.setColumns(10);
		Age_t.setBounds(159, 381, 137, 29);
		bmrPanel.add(Age_t);
		Age_t.setText(CustomerDisplay.ageLabel.getText());
		Age_t.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		JPanel ChoicePanel = new JPanel();
		ChoicePanel.setBackground(new Color(240, 237, 240));
		ChoicePanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(ChoicePanel);
		ChoicePanel.setLayout(null);
		
		JButton gotoMain_bmr = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		gotoMain_bmr.setBounds(863, 12, 105, 27);
		gotoMain_bmr.setBackground(new Color(218, 226, 234));
		gotoMain_bmr.setBackground(new Color(218, 226, 234));
//		bmrPanel.add(gotoMain_bmr);
		gotoMain_bmr.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JButton BmrButton = new JButton("\uACC4\uC0B0\uD558\uAE30");
		BmrButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		BmrButton.setBackground(new Color(102, 159, 175));
		BmrButton.setBounds(61, 463, 235, 55);
		BmrButton.setBorderPainted(false);
		BmrButton.setFocusPainted(false);
		bmrPanel.add(BmrButton);
		gotoMain_bmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoicePanel.setVisible(true);
				bmrPanel.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel.setBounds(381, 220, 515, 69);
		bmrPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uCD08\uB300\uC0AC\uB7C9 \uAD6C\uD558\uAE30");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_1.setBounds(61, 46, 259, 47);
		bmrPanel.add(lblNewLabel_1);
		
		gotoMain_bmr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoicePanel.setVisible(true);
				bmrPanel.setVisible(false);
			}
		});
		
		BmrButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bmrPanel.setVisible(true);
				ChoicePanel.setVisible(false);
				BmrResult = new JLabel();
				//BmrResult.setVisible(false);
				bmrPanel.setVisible(true);
				int num;
				if(Man.isSelected()==true) { //남성이 선택될 때
					num = 1;//num = 1이다
				}else if(Woman.isSelected()==true) {//여성이 선택될 때
					num = 2;//num = 2이다
				}else {
					num = 0;
				}
				try {
					if(BmrResult != null) {
						BmrResult.setVisible(false);
					}
					switch(num) {
					case 1 : //num이 1일때
						double Weight_m = Double.parseDouble(Weight_t.getText());
						double Height_m = Double.parseDouble(Height_t.getText());
						int Age_m = Integer.parseInt(Age_t.getText());
						double Bmr_m = 66.47 + (13.75*Weight_m) + (5*Height_m) - (6.76*Age_m); //남성일 때의 기초대사량 공식
						BmrResult = new JLabel("기초대사량은 " + Math.round(Bmr_m*100)/100.0 + "kcal입니다");
						bmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
						BmrResult.setBounds(370, 230, 600, 50);
						BmrResult.setVisible(true);//레이블을 이용해 기초대사량 계산결과 출력해준다
						
						bmr = Math.round(Bmr_m*100)/100.0;
						
						BmrUpdate = new JButton("bmr 등록하기");
						bmrPanel.add(BmrUpdate);
						BmrUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmrUpdate.setBounds(370, 300, 200, 60);
						BmrUpdate.setVisible(true);
						BmrUpdate.setForeground(Color.BLACK);
						BmrUpdate.setBackground(new Color(223,161,158));
						BmrUpdate.setBorderPainted(false);
						BmrUpdate.setFocusPainted(false);
											
						BmrUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmr) + "를 bmr 지수로 등록하시겠습니까?", "bmr 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updatebmr(bmr) == true) {
									JOptionPane.showMessageDialog(null, "bmr 지수가 등록되었습니다", "bmr 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmrLabel.setText(String.valueOf(bmr));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmr 지수 등록을 취소하셨습니다", "bmr 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "bmr 지수 등록을 취소하셨습니다", "bmr 등록하기", JOptionPane.PLAIN_MESSAGE);
								}
							}
						});
						
						break;//동작그만
					case 2 : //num이 2일때
						double Weight_w = Double.parseDouble(Weight_t.getText());
						double Height_w = Double.parseDouble(Height_t.getText());
						int Age_w = Integer.parseInt(Age_t.getText());
						double Bmr_w = 655.1 + (9.56*Weight_w) + (1.85*Height_w) - (4.68*Age_w); //여성일 때의 기초대사량 공식
						BmrResult.setLocation(1300, 600);
						BmrResult = new JLabel("기초대사량은 " + Math.round(Bmr_w*100)/100.0 + "kcal입니다");
						bmrPanel.add(BmrResult);
						BmrResult.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
						BmrResult.setBounds(370, 230, 600, 50);
						BmrResult.setVisible(true); //레이블을 이용해 기초대사량 계산결과 출력해준다
						
						bmr = Math.round(Bmr_w*100)/100.0;
						
						BmrUpdate = new JButton("bmr 등록하기");
						bmrPanel.add(BmrUpdate);
						BmrUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 22));
						BmrUpdate.setBounds(370, 300, 200, 60);
						BmrUpdate.setVisible(true);
						BmrUpdate.setForeground(Color.BLACK);
						BmrUpdate.setBackground(new Color(223,161,158));
						BmrUpdate.setBorderPainted(false);
						BmrUpdate.setFocusPainted(false);
											
						BmrUpdate.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int option = JOptionPane.showConfirmDialog(null, CustomerDisplay.idLabel.getText() + "님, " + String.valueOf(bmr) + "를 bmr 지수로 등록하시겠습니까?", "bmr 등록하기", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.YES_OPTION && updatebmr(bmr) == true) {
									JOptionPane.showMessageDialog(null, "bmr 지수가 등록되었습니다", "bmr 등록하기", JOptionPane.PLAIN_MESSAGE);
									CustomerDisplay.bmrLabel.setText(String.valueOf(bmr));
									frame.dispose();
								}else if(option == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "bmr 지수 등록을 취소하셨습니다", "bmr 등록하기", JOptionPane.PLAIN_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "bmr 지수 등록을 취소하셨습니다", "bmr 등록하기", JOptionPane.PLAIN_MESSAGE);
								}
							}
						});
						
						break;//동작그만
					}
				}catch(NumberFormatException ex) {
					BmrResult = new JLabel("숫자를 입력해주세요");
					bmrPanel.add(BmrResult);
					BmrResult.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
					BmrResult.setBounds(370, 230, 600, 50);
					BmrResult.setVisible(true); 
					BmrResult.setForeground(Color.RED);
				}
			}
		});
		JButton new_bmr = new JButton("초기화");
		new_bmr.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		new_bmr.setBackground(new Color(218, 226, 234));
		new_bmr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BmrResult != null) {
					BmrResult.setVisible(false);
				}
				Weight_t.setText("");
				Height_t.setText("");
				Age_t.setText("");
			}
		});
		new_bmr.setBounds(863, 51, 105, 27);
		new_bmr.setBorderPainted(false);
		new_bmr.setFocusPainted(false);
		bmrPanel.add(new_bmr);
	}
	public boolean updatebmr(double bmr) {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            PreparedStatement pst=conn.prepareStatement("update jiyoon set bmr=? where id=?");

            pst.setDouble(1, Math.round(bmr));
            pst.setString(2, CustomerDisplay.idLabel.getText());

            int numRows = pst.executeUpdate(); //insert, delete, 

            System.out.format("bmr 등록 : %d개의 행이 바꼈습니다.", numRows);

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
