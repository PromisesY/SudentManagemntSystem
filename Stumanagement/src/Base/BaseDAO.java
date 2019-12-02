package Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import DBDao.AdminDao;
import DBDao.ScoreDao;
import DBDao.StudentDAO;
import DBUtil.DBUtil;
/**
 * 模块说明： DAO基类
 * 
 */
public abstract class BaseDAO {
	protected final DBUtil db = DBUtil.getDBUtil();
	protected ResultSet rs;
	private static BaseDAO baseDAO;

	public BaseDAO() {
		init();
	}

	private void init() {
		// buildAbilityDAO();
	}

	// protected abstract void buildAbilityDAO();

	public static synchronized BaseDAO getAbilityDAO(DAO dao) {
		switch (dao) {
		case AdminDAO:
			if (baseDAO == null || baseDAO.getClass() != AdminDao.class) {
				baseDAO = AdminDao.getInstance();
			}
			break;
		case StudentDAO:
			if (baseDAO == null || baseDAO.getClass() != StudentDAO.class) {
				baseDAO = StudentDAO.getInstance();
			}
			break;
		case ScoreDao:
			if (baseDAO == null || baseDAO.getClass() != ScoreDao.class) {
				baseDAO = ScoreDao.getInstance();
			}
			break;
		default:
			break;
		}
		return baseDAO;
	}

	protected void destroy() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			db.close();
		}
	}
}