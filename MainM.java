import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class MainM extends JFrame {
	
    // 로봇 변수
	public static Robot robot = null;
    
	public MainM() {
		// 로봇 생성
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
			
        // 프레임 생성
        JFrame frm = new JFrame("스윙워커를 사용해야한다");
 
        // 프레임 크기 설정
        frm.setSize(350, 300);
 
        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
 
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 레이아웃 설정
        frm.getContentPane().setLayout(null);
 
        
    	// 동작 테스트용 라벨 설정
        JLabel lbl = new JLabel();
        lbl.setBounds(30, 200, 274, 50);
        lbl.setText("테스트용 라벨");
        lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
        frm.getContentPane().add(lbl);
        
		// 시작 버튼 생성
		JButton btn1 = new JButton("시작");

		btn1.addActionListener(new ActionListener()                                  
		{                                                                               
		    public void actionPerformed(ActionEvent e)                                  
		    {                                                                           
		        SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>()              
		        {                                                                       
		            @Override                                                           
		            protected Void doInBackground() throws Exception                    
		            {                       
		            	try {     	
			                Robot robot = new Robot();                                      
			                                                                  
			                System.out.println("Pressed");                                  

		    				robot.delay(1250);
		    				
		    				robot.keyPress(16); // Shift
			                
			                while (true)                                                   
			                {                                                               
//			                	robot.keyPress(37); // Left
//		    					robot.delay(80);
//		    					robot.keyRelease(37); // Left  
//		    					robot.delay(800);
		    					// 37 -- Left
		    					// 38 -- Up
		    					// 39 -- Right
		    					// 40 -- Down
		    					// 18 -- Alt
		    					// 54 -- 6
		    					// 16 -- Shift
		    					// 17 -- Ctrl
		    						    					
		    					robot.keyPress(39); // Right
		    					robot.delay(80);
		    					robot.keyRelease(39); // Right
		    					robot.keyPress(39); // Right
		    					robot.delay(80);
		    					robot.keyRelease(39); // Right
		    					robot.delay(900);
		   
		    					robot.keyPress(37); // Left
		    					robot.delay(80);
		    					robot.keyRelease(37); // Left
		    					robot.keyPress(37); // Left
		    					robot.delay(80);
		    					robot.keyRelease(37); // Left  
		    					robot.delay(900);
			                }   
		            	} catch (Exception e) {
		            		e.printStackTrace();
		            	}
		                return null;                                                    
		            }                                                                   
		        };                                                                      
		        sw.execute();                                                           
		    }                                                                           
		});
		
        
		// 종료 버튼 생성
		
		JButton btn2 = new JButton("종료");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent aEv) {
				robot.keyRelease(37);
				robot.keyRelease(39);
				robot.keyRelease(16); // 종료 시 Release 해주어야할 키
		 		System.exit(0); // 프로세스 종료
			}
		});
			
		// ★ 버튼 위치와 크기 설정
        btn1.setBounds(30, 170, 122, 30);
        btn2.setBounds(182, 170, 122, 30);
 
        // ★ 프레임에다가 버튼 추가
        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
 
        // 프레임이 보이도록 설정
        frm.setVisible(true);
	}

}
