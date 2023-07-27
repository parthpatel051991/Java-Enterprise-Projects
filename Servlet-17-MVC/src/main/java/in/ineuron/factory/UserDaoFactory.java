package in.ineuron.factory;

import in.ineuron.dao.IUserDao;
import in.ineuron.dao.UserDaoImpl;

public class UserDaoFactory {

	private UserDaoFactory() {}
	
	
	private static IUserDao dao=null;
	
	public static IUserDao getUserDao() {
		
		if (dao==null) {
			dao=new UserDaoImpl();
		}
		
		return dao;
	}
}
