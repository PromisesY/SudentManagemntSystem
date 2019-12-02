package View;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Base.BaseDAO;
import Base.DAO;
import DBDao.AdminDao;

@SuppressWarnings("serial")
public class LoginView extends JFrame {
	
	JPanel panel=new JPanel();
	
	JLabel name=new JLabel("  用户名  :");
	JLabel pwd=new JLabel("  密     码  :");
	JTextField input_name=new JTextField(18);
	JPasswordField input_pwd=new JPasswordField(18);
	JButton login=new JButton("登录");
	JButton regist=new JButton("注册");
	JButton seset=new JButton("重置");
	public LoginView() {
		this.setTitle("登录");
		panel.setPreferredSize(new Dimension(100, 100));
		//panel.setLayout(new GridLayout(4, 2));
		panel.add(name);
		panel.add(input_name);
		panel.add(pwd);
		panel.add(input_pwd);
		
		panel.add(new JLabel("***************************"));
		panel.add(new JLabel("***************************"));
		
		panel.add(login);
		panel.add(regist);
		panel.add(seset);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String Aname = input_name.getText();
				String Apassword=String.valueOf(input_pwd.getPassword());
				 BaseDAO bd=BaseDAO.getAbilityDAO(DAO.AdminDAO);
				
				try {
					if(((AdminDao)bd).queryByName(Aname,Apassword)==1){
						JOptionPane.showMessageDialog(null, "登录成功");
						new MainView();
					}else{
						JOptionPane.showMessageDialog(null, "登录失败，用户名或者密码错误");
					}
				} catch (HeadlessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				
			}
				//selcet *from admin where name = 'username' and pwd='userpwd'; 
		});
		
		regist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				 new RegistView();
			}
		});
		seset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
			    input_name.setText(null);
				input_pwd.setText(null);
			}
		});
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(800, 400,300, 180);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
       new LoginView();
	}

}
