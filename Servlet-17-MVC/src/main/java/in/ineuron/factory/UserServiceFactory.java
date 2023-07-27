package in.ineuron.factory;

import in.ineuron.service.IUserService;
import in.ineuron.service.UserServiceImpl;

public class UserServiceFactory {

	private UserServiceFactory() {}
	
	private static IUserService service;
	
	public static IUserService getUserService()
	{
		if (service==null) {
			service = new UserServiceImpl();
		}
		
		return service;
	}
}
