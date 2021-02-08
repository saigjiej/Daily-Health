// 메인창 : 회원리스트 출력
package health;

import java.awt.BorderLayout; // 동서남북(상하좌우)과 가운데를 배치할 수 있으며, 기본값입니다.
import java.awt.Color; //이 Color클래스는 기본 sRGB색상 공간에서 색상을 캡슐화하거나으로 식별되는 임의 색상 공간의 색상을 캡슐화하는 데 사용됩니다 
import java.awt.Component; // Abstract Window Toolkit 구성요소의 추상 수퍼 클래스, 가벼운 구성요소를 만들기 위해 클래스를 직접 확장할 수도 있습니다. 
import java.awt.Font; //자바에서 입력한 글자에 효과를 줄 때 Font 클래스를 활용한다.
import java.awt.Image; //자바에서 이미지는 java.awt.Image 클래스의 객체로 표현
import java.awt.Toolkit; //툴킷은 java.awt.Toolkit 클래스로 제작 가능 / 프레임을 만들면 자동으로 생성
import java.awt.event.*; //이벤트 구현은 생성자 구현부 마지막부에서 주로 위치시킨다.
import java.util.*; //java.util 패키지의 모든 클래스를 불러오는 것
import javax.swing.*; //java에서 gui를 구현하기 위해 jdk에서 기본적으로 제공하는 것
import javax.swing.table.DefaultTableModel;  //DefaultTableModel 사용 => JTable 객체를 생성할 때 DefaultTableModel이라는 리모콘을 세팅해주는 것과 같음
import java.awt.FlowLayout; //Button 만들기의 연장선으로 FlowLayout클래스를 사용하고 있다. 여러 개의 버튼을 만들고 순서대로 배치하는 클래스이다.
import java.sql.*;

public class CustomerLoginDisplay extends JFrame implements MouseListener,ActionListener{
	private JFrame frame;
	JTextField idField;
	JPasswordField pwField;
	
	String name = "";
	String id = "";
	String address = "";
	String phone = "";
	String age = "";
	String height = "";
	String bmi = "";
	String bmr = "";
	String remain_days = "";
	String current_weight = "";
	String target_weight = "";
	
	//생성자 메소드
	public CustomerLoginDisplay() { 
		frame = new JFrame(); //frame 생성
		frame.setResizable(false); //frame이 보이도록 설정
		frame.setBounds(470, 200, 1000, 600); //frame의 크기 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫도록 지정
		frame.getContentPane().setLayout(null);
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setTitle("Daily Health - 회원 로그인 페이지"); //타이틀 설정
		
		//툴킷을 사용하여 이미지 만들기
		Toolkit toolkit = frame.getToolkit();
		//jpg, gif, png 형식의 이미지 파일만 지원
		Image image = toolkit.createImage("./image/gym.png");
		Image img = Toolkit.getDefaultToolkit().getImage("./image/icon.png");
		frame.setIconImage(img); 
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 982, 553);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("로그인", JLabel.CENTER);
		loginPanel.add(loginLabel);
		loginLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		loginLabel.setBounds(350, 90, 300, 60);
		
		// 아이디 라벨
		JLabel idLabel = new JLabel("아이디");
		loginPanel.add(idLabel);
		idLabel.setBounds(290, 200, 70, 60);
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		// 아이디 textfield
		idField = new JTextField();
		loginPanel.add(idField);
		idField.setBounds(390, 200, 300, 60);
		idField.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		
		
		// 비밀번호 textfield
		JLabel pwLabel = new JLabel("비밀번호");
		loginPanel.add(pwLabel);
		pwLabel.setBounds(290, 285, 70, 60);
		pwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		// 비밀번호 라벨
		pwField = new JPasswordField();
		loginPanel.add(pwField);
		pwField.setBounds(390, 285, 300, 60);
		pwField.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		
		// 로그인 확인 버튼
		JButton loginBtn = new JButton("로그인");
		loginPanel.add(loginBtn);
		loginBtn.setBounds(360, 380, 130, 70);
		loginBtn.setBackground(new Color(240, 237, 240));
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		
		// 로그인 확인 버튼 클릭 이벤트
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CustomerLogin() == true) {
					idField.setText("");
					pwField.setText("");
					frame.setVisible(false);
					new CustomerDisplay();
					CustomerDisplay.nameLabel.setText(name);
                	CustomerDisplay.idLabel.setText(id);
                	CustomerDisplay.addressLabel.setText(address);
                	CustomerDisplay.phoneLabel.setText(phone);
                	CustomerDisplay.ageLabel.setText(age);
                	CustomerDisplay.currentWeightLabel.setText(current_weight);
                	CustomerDisplay.targetWeightLabel.setText(target_weight);
                	CustomerDisplay.heightLabel.setText(height);
                	CustomerDisplay.remainDaysLabel.setText(remain_days);
                	CustomerDisplay.bmiLabel.setText(bmi);
                	CustomerDisplay.bmrLabel.setText(bmr);
				}else {
					idField.setText("");
					pwField.setText("");
				}
			}
		});
		
		// 로그인 취소 버튼
		JButton loginExitBtn = new JButton("취소");
		loginPanel.add(loginExitBtn);
		loginExitBtn.setBounds(520, 380, 130, 70);
		loginExitBtn.setBackground(new Color(218, 226, 234));
		loginExitBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		
		// 로그인 취소 버튼 클릭 이벤트
		loginExitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LogoChoice();
			}
		});
		
	}//end of MainDisplay(and 생성자)
		
	public static void main(String[] args) {
		new CustomerLoginDisplay(); //Member-List 클래스 실행
	}//end of main

	public boolean CustomerLogin() {
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daily_health?serverTimezone=UTC", "root", "password");
            
            query = "SELECT id, pwd, name, homeAddress, phone, age, CurrentWeight, TargetWeight, height, period, remain_days, bmi, bmr FROM jiyoon";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
             
			boolean result = true;
			
//			CustomerDisplay c = new CustomerDisplay();
			
            while (result = rset.next()) {
                if(rset.getString("id").equals(idField.getText()) && rset.getString("pwd").equals(pwField.getText())){
                	JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                	
                	name = rset.getString("name");
                	id = rset.getString("id");
                	address = rset.getString("homeAddress");
                	phone = rset.getString("phone");
                	age = rset.getString("age");
                	current_weight = rset.getString("CurrentWeight");
                	target_weight = rset.getString("TargetWeight");
                	height = rset.getString("height");
                	remain_days = rset.getString("remain_days");
                	bmi = rset.getString("bmi");
                	bmr = rset.getString("bmr");
                	
                	return true;
                }
            }
            
            //로그인 실패 시
            if(result == false) {
            	JOptionPane.showMessageDialog(null, "아이디, 비밀번호가 잘못입력되었습니다.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
	
	//MouseListener 인터페이스의 나머지 4개 메소드도 모두 구현을 하여야 실행이 됨
	@Override
	public void mouseEntered(MouseEvent e) { //마우스가 해당 컴포넌트 영역 안으로 들어올 때 발생	
	}
	@Override
	public void mouseExited(MouseEvent e) { //마우스가 해당 컴포넌트 영역 밖으로 나갈 때 발생	
	}
	@Override
	public void mousePressed(MouseEvent e) { //마우스 버튼을 누를 때 발생
	
	}
	@Override
	public void mouseReleased(MouseEvent e) { //눌러진 마우스를 놓을 때 발생
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
}//end of MainDisplay