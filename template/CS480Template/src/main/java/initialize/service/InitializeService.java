package initialize.service;

import java.io.InputStream;

import initialize.dao.InitializeDao;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class InitializeService {
	private InitializeDao initializeDao = new InitializeDao();
	

	public void init(InputStream input) throws InitializeException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		initializeDao.initialize(input);
		
	}
}
