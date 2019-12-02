package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Base.BaseDAO;
import Base.DAO;
import Config.AppConstants;
import DBDao.ScoreDao;;


public class ScoreView extends JFrame {

	private static final long serialVersionUID = 5870864087464173884L;

	private final int maxPageNum = 99;

	private JPanel jPanelNorth, jPanelSouth, jPanelCenter;
	private JButton jButtonFirst, jButtonLast, jButtonNext, jButtonPre, jButtonAdd, jButtonDelete, jButtonUpdate,
			jButtonFind;
	private static JLabel currPageNumJLabel;
	private static JTextField condition;
	public static JTable jTable;
	private JScrollPane jScrollPane;
	private DefaultTableModel myTableModel;

	public static String[] column = { AppConstants.STUDENT_CSNO, AppConstants.STUDENT_CNAME,
			AppConstants.STUDENT_JAVA, AppConstants.STUDENT_CHINESE, AppConstants.STUDENT_ENGLISH ,
			AppConstants.STUDENT_MATH, AppConstants.STUDENT_MySQL, AppConstants.STUDENT_C};
	public static int currPageNum = 1;

	public static void main(String[] arge) {
		// TODO 自动生成的方法存根
		//new ScoreView();
	}

	public ScoreView() {
		init();
	}

	private void init() {
		setTitle(AppConstants.SCOREVIEW_TITLE);

		// north panel
		jPanelNorth = new JPanel();
		jPanelNorth.setLayout(new GridLayout(1, 9));
		condition = new JTextField(AppConstants.PARAM_FIND_CONDITION);
		//condition.addKeyListener(new FindListener());
		//jPanelNorth.add(condition);
		// query by name
		jButtonFind = new JButton(AppConstants.PARAM_FIND);
		// center panel
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(1, 1));

		// init jTable

		String[][] result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).list(currPageNum);
		myTableModel = new DefaultTableModel(result, column);
		jTable = new JTable(myTableModel);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		cr.setHorizontalAlignment(JLabel.CENTER);
		jTable.setDefaultRenderer(Object.class, cr);
		initJTable(jTable, result);
		jScrollPane = new JScrollPane(jTable);
		jPanelCenter.add(jScrollPane);
		// south panel
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 5));

		jButtonFirst = new JButton(AppConstants.MAINVIEW_FIRST);
		jButtonFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum = 1;
				String[][] result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).list(currPageNum);
				initJTable(jTable, result);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});
		jButtonPre = new JButton(AppConstants.MAINVIEW_PRE);
		jButtonPre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum--;
				if (currPageNum <= 0) {
					currPageNum = 1;
				}
				String[][] result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).list(currPageNum);
				initJTable(jTable, result);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});
		jButtonNext = new JButton(AppConstants.MAINVIEW_NEXT);
		jButtonNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum++;
				if (currPageNum > maxPageNum) {
					currPageNum = maxPageNum;
				}
				String[][] result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).list(currPageNum);
				initJTable(jTable, result);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});
		jButtonLast = new JButton(AppConstants.MAINVIEW_LAST);
		jButtonLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum = maxPageNum;
				String[][] result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).list(currPageNum);
				initJTable(jTable, result);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});

		currPageNumJLabel = new JLabel(
				AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum + AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
		currPageNumJLabel.setHorizontalAlignment(JLabel.CENTER);

		jPanelSouth.add(jButtonFirst);
		jPanelSouth.add(jButtonPre);
		jPanelSouth.add(currPageNumJLabel);
		jPanelSouth.add(jButtonNext);
		jPanelSouth.add(jButtonLast);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);

		setBounds(400, 200, 726, 340);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void initJTable(JTable jTable, String[][] result) {
		((DefaultTableModel) jTable.getModel()).setDataVector(result, column);
		jTable.setRowHeight(30);
		TableColumn firsetColumn = jTable.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(90);
		firsetColumn.setMaxWidth(90);
		firsetColumn.setMinWidth(90);
		TableColumn secondColumn = jTable.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(90);
		secondColumn.setMaxWidth(90);
		secondColumn.setMinWidth(90);
		TableColumn thirdColumn = jTable.getColumnModel().getColumn(2);
		thirdColumn.setPreferredWidth(90);
		thirdColumn.setMaxWidth(90);
		thirdColumn.setMinWidth(90);
		TableColumn fourthColumn = jTable.getColumnModel().getColumn(3);
		fourthColumn.setPreferredWidth(90);
		fourthColumn.setMaxWidth(90);
		fourthColumn.setMinWidth(90);
		TableColumn fifthColumn = jTable.getColumnModel().getColumn(4);
		fifthColumn.setPreferredWidth(90);
		fifthColumn.setMaxWidth(90);
		fifthColumn.setMinWidth(90);
		TableColumn sixthColumn = jTable.getColumnModel().getColumn(5);
		sixthColumn.setPreferredWidth(90);
		sixthColumn.setMaxWidth(90);
		sixthColumn.setMinWidth(90);
		TableColumn seventhColumn = jTable.getColumnModel().getColumn(6);
		seventhColumn.setPreferredWidth(90);
		seventhColumn.setMaxWidth(90);
		seventhColumn.setMinWidth(90);
		TableColumn eighthColumn = jTable.getColumnModel().getColumn(7);
		eighthColumn.setPreferredWidth(90);
		eighthColumn.setMaxWidth(90);
		eighthColumn.setMinWidth(90);
	}

	public static void find(String stu) {
		String[][] result = null;
		currPageNum = 0;
		String param = stu;//condition.getText();
		if ("".equals(param) || param == null) {
			initJTable(ScoreView.jTable, null);
			currPageNumJLabel.setText(AppConstants.MAINVIEW_FIND_JLABEL);
			return;
		}
		String ce="^[A-Za-z\u4e00-\u9fa5]+$";
		String se="^[0-9A-Za-z]+$";
		if (param.matches(ce)) {
		    result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).queryByName(param);
		    condition.setText("");
		}
		else if(param.matches(se)){
			result = ((ScoreDao) BaseDAO.getAbilityDAO(DAO.ScoreDao)).queryBySnumber(param);
		    condition.setText("");
		    
		} 
		initJTable(ScoreView.jTable, result);
		currPageNumJLabel.setText(AppConstants.MAINVIEW_FIND_JLABEL);
	}
}
