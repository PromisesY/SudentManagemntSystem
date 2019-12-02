package DBDao;

import java.sql.SQLException;
import Base.BaseDAO;
import Model.Admin;

public class AdminDao extends BaseDAO{
	
	private static AdminDao ad = null;
	private AdminDao() {
			// TODO 自动生成的构造函数存根
	}
	public static synchronized AdminDao getInstance() {
		if (ad == null) {
			ad = new AdminDao();
		}
		return ad;
	}
	// delete
	public boolean delete(Admin adm) {
		boolean result = false;
		if (adm == null) {
			return result;
		}
		String sql = "delete from student where username=? and pwd=?";
		String[] param = { adm.getName(), adm.getpwd() };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}
	// add
	public boolean add(Admin adm) {
		boolean result = false;
		if (adm == null) {
			return result;
		}
		try {
			// check
			if (queryByName(adm.getName(),adm.getpwd()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into admin(Aname,Apassword,Aemail,Aphone) values(?,?,?,?)";
			String[] param = {adm.getName(),adm.getpwd(), adm.getEmail(), adm.getTel() };
			if (db.executeUpdate(sql, param) == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}
	// query by name
	public int queryByName(String name,String pwd) throws SQLException {
		int result = 0;
		if (name.equals("")||pwd.equals("")) {
			return result;
		}
		String checkSql = "select * from Admin where Aname=? and Apassword=? ";
		String[] checkParam = {name,pwd};
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
