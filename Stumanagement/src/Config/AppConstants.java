package Config;

/**
 * 模块说明： 常量
 * 
 */
public class AppConstants {
	// jdbc
	public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/stumangemant?useUnicode=true&amp;characterEncodeing=UTF-8&useSSL=false";
	public static final String JDBC_USERNAME = "root";
	public static final String JDBC_PASSWORD = "000000";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//学号，姓名，性别，院系，专业，班级，籍贯，邮箱，电话
	// student field
	public static final String STUDENT_NAME = "姓名";
	public static final String STUDENT_SNO = "学号";
	public static final String STUDENT_SEX = "性别";
	public static final String STUDENT_DEPARTMETN = "院系";
	public static final String STUDENT_DEPART="专业";
	public static final String STUDENT_CLASS="班级";
	public static final String STUDENT_HOMETOWN = "籍贯";
	public static final String STUDENT_EMAIL = "电子邮件";
	public static final String STUDENT_TEL = "电话";
	public static final String STUDENT_MARK = "学分";

	// login view
	public static final String LOGIN_TITLE = "登录界面";
	public static final String LOGIN_USERNAME = "用户名";
	public static final String LOGIN_PASSWORD = "密码";
	public static final String LOGIN = "登录";
	public static final String RESET = "重置";

	// main view
	public static final String MAINVIEW_TITLE = "学生信息管理系统";
	
	public static final String MAINVIEW_PAGENUM_JLABEL_DI = "第 ";
	public static final String MAINVIEW_PAGENUM_JLABEL_YE = "/99 页";
	public static final String MAINVIEW_FIND_JLABEL = "查询结果";
	public static final String MAINVIEW_FIRST = "首页";
	public static final String MAINVIEW_LAST = "末页";
	public static final String MAINVIEW_PRE = "上一页";
	public static final String MAINVIEW_NEXT = "下一页";
	public static final String PARAM_FIND_CONDITION = "";
	public static final String PARAM_FIND = "查找";
	public static final String PARAM_ADD = "添加";
	public static final String PARAM_DELETE = "删除";
	public static final String PARAM_UPDATE = "更新";
	
	//score view
	    public static final String SCOREVIEW_TITLE = "学生成绩信息";
		public static final String STUDENT_CSNO = "学号";
		public static final String STUDENT_CNAME = "姓名";
		public static final String STUDENT_JAVA = "Java程序设计";
		public static final String STUDENT_CHINESE= "语文";
		public static final String STUDENT_ENGLISH = "体育";
		public static final String STUDENT_MATH="数学";
		public static final String STUDENT_MySQL="数据库";
		public static final String STUDENT_C= "C语言程序设计";
		

	// add view
	public static final String ADDVIEW_TITLE = "添加学生信息";
	public static final String ADDVIEW_ADDBUTTON = "添加";
	public static final String EXITBUTTON = "退出";

	// delete view
	public static final String DELETEVIEW_TITLE = "删除学生信息";
	public static final String DELETEVIEW_DELETEBUTTON = "删除";

	// update view
	public static final String UPDATEVIEW_TITLE = "更新学生信息";
	public static final String UPDATEVIEW_UPDATEBUTTON = "更新";

}
