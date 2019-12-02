
package DBDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Base.BaseDAO;
import Model.Score;

/**
 * 模块说明： 学生成绩
 * 
 */
public class ScoreDao extends BaseDAO {
	private final int fieldNum = 9;
	private final int showNum = 15;
	private static ScoreDao sd = null;
    private ScoreDao() {
		// TODO 自动生成的构造函数存根
	}
	public static synchronized ScoreDao getInstance() {
		if (sd == null) {
			sd = new ScoreDao();
		}
		return sd;
	}

		
	// query by name
	public String[][] queryByName(String name) {
		String[][] result = null;
		if (name.length() < 0) {
			return result;
		}
		List<Score> stus = new ArrayList<Score>();
		int i = 0;
		String sql = "select * from score where sname like ?";
		String[] param = { "%" + name + "%" };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				buildList(rs, stus, i);
				i++;
			}
			if (stus.size() > 0) {
				result = new String[stus.size()][fieldNum];
				for (int j = 0; j < stus.size(); j++) {
					buildResult(result, stus, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}
	
	// query by Sno
		public String[][] queryBySnumber(String sno) {
			String[][] result = null;
			if (sno.length() < 0) {
				return result;
			}
			List<Score> stus = new ArrayList<Score>();
			int i = 0;
			String sql = "select * from score where sno like ?";
			String[] param = { "%" + sno + "%" };
			rs = db.executeQuery(sql, param);
			try {
				while (rs.next()) {
					buildList(rs, stus, i);
					i++;
				}
				if (stus.size() > 0) {
					result = new String[stus.size()][fieldNum];
					for (int j = 0; j < stus.size(); j++) {
						buildResult(result, stus, j);
					}
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				destroy();
			}
			return result;
		}

	// query
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<Score> stus = new ArrayList<Score>();
		int i = 0;
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from score limit ?,?";
		Integer[] param = { beginNum, showNum };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				buildList(rs, stus, i);
				i++;
			}
			if (stus.size() > 0) {
				result = new String[stus.size()][fieldNum];
				for (int j = 0; j < stus.size(); j++) {
					buildResult(result, stus, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}

	// 将rs记录添加到list中
	private void buildList(ResultSet rs, List<Score> list, int i) throws SQLException {
		Score sc = new Score();
		sc.setSno(rs.getString("sno"));
		sc.setName(rs.getString("sname"));
		sc.setJava(rs.getString("Java"));
		sc.setChinese(rs.getString("Chinese"));
		sc.setPE(rs.getString("PE"));
		sc.setMath(rs.getString("Math"));
		sc.setMySQL(rs.getString("MySQL"));
		sc.setC(rs.getString("C"));
		list.add(sc);
	}

	// 将list中记录添加到二维数组中
	private void buildResult(String[][] result, List<Score> stus, int j) {
		Score sc = stus.get(j);
		result[j][0] = sc.getSno();
		result[j][1] = sc.getName();
		result[j][2] = sc.getJava();
		result[j][3] = sc.getChinese();
		result[j][4] = sc.getPE();
		result[j][5] = sc.getMath();
		result[j][6] = sc.getMySQL();
		result[j][7] = sc.getC();
	}

	// query by sno
	private int queryBySno(String sno) throws SQLException {
		int result = 0;
		if ("".equals(sno) || sno == null) {
			return result;
		}
		String checkSql = "select * from student where sno=?";
		String[] checkParam = { sno };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
	}

}
