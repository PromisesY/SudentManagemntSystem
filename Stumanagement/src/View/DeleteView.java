package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.BaseDAO;
import Base.DAO;
import DBDao.StudentDAO;
import Model.Student;

public class DeleteView extends JFrame{
	JPanel panel =new JPanel();//创一个面板对象
	
	JLabel sno=new JLabel("学号");
	JLabel name=new JLabel("姓名");
	
	JTextField input_sno=new JTextField(20);
	JTextField input_name=new JTextField(20);
	
	JButton tijiao=new JButton("提交");
	JButton back=new JButton("返回");
	public DeleteView() {
		
		this.setTitle("删除学生信息");
		panel.setPreferredSize(new Dimension(100, 100));
		//panel.setLayout(new GridLayout(4,2));//设置窗体网格布局
		panel.add(sno);
		panel.add(input_sno);
		panel.add(name);
		panel.add(input_name);
		panel.add(new JLabel("**********************************************"));
		panel.add(tijiao);
		panel.add(back);
		
		tijiao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String sno=input_sno.getText();
				String name=input_name.getText();
				Student stu=new Student();
				stu.setName(name);
				stu.setSno(sno);
				BaseDAO bd=BaseDAO.getAbilityDAO(DAO.StudentDAO);
				
				((StudentDAO)bd).delete(stu);	
			}	
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
		      new MainView();
			}	
		});
		
		this.add(panel);//指向当前类对象，把面板放在加载的框架中
		this.setVisible(true);//设置窗体可见
		this.setBounds(800,500,280,180);//设置横纵坐标宽和高
		//设置当窗体关闭时，默认关闭整个程序运行。关闭的时候结束运行
	}
}
