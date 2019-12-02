package View;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import Model.Admin;

public class RegistView extends JFrame{
	
JPanel panel=new JPanel();
	
	JLabel name=new JLabel("用  户  名：");
	JLabel pwd=new JLabel("密        码：");
	JLabel ac_pwd=new JLabel("确认密码：");
	JLabel email=new JLabel("邮        箱：");
	JLabel phone=new JLabel("手机号码：");
	JTextField input_name=new JTextField(15);
	JPasswordField input_pwd=new JPasswordField(15);
	JPasswordField input_ac_pwd=new JPasswordField(15);
	JTextField input_email=new JTextField(15);
	JTextField input_phone=new JTextField(15);
	JButton commit=new JButton("提交");
	JButton cancel=new JButton("取消");
	public RegistView() {
		// TODO 自动生成的构造函数存根
		this.setTitle("注册");
		panel.setPreferredSize(new Dimension(100, 100));
		//panel.setLayout(new GridLayout(7, 2));
		panel.add(name);
		panel.add(input_name);
		panel.add(pwd);
		panel.add(input_pwd);
		panel.add(ac_pwd);
		panel.add(input_ac_pwd);
		panel.add(email);
		panel.add(input_email);
		panel.add(phone);
		panel.add(input_phone);
		
		panel.add(new JLabel("**************************"));
		panel.add(new JLabel("**************************"));
		
		panel.add(commit);
		panel.add(cancel);
		
		commit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//insert into admin values();
				String username=input_name.getText();
				String pwd1=String.valueOf(input_pwd.getPassword());
				String pwd2=String.valueOf(input_ac_pwd.getPassword());
				String email=input_name.getText();
			    if(username.equals("")||pwd1.equals("")||pwd2.equals("")||email.equals(""))
			    {
			    	JOptionPane.showMessageDialog(null, "请完整填写所有的信息！","提示",JOptionPane.WARNING_MESSAGE,null);	
			    	return ;			
			    }	
			    else {
			    	if(!pwd1.equals(pwd2))
			        {
			    		JOptionPane.showMessageDialog(null, "两次输入的密码不同，请您重新输入！",null, JOptionPane.WARNING_MESSAGE);		
			    	    return;			
			        }
			    	JOptionPane.showMessageDialog(null, "注册成功！",null, JOptionPane.WARNING_MESSAGE);
			    }
			    Admin adm=new Admin();
			    adm.setName(input_name.getText());
			    adm.setpwd(String.valueOf(input_pwd.getPassword()));
			    adm.setEmail(input_email.getText());
			    adm.setTel(input_phone.getText());
			    BaseDAO bd=BaseDAO.getAbilityDAO(DAO.AdminDAO);
			    ((AdminDao)bd).add(adm);
			    
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}

		});
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(800, 400,300, 260);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
           new RegistView();
	}

}
