package users;

import java.util.List;

public class UsersService {
	private UsersDao usersDao = new UsersDao();
	
	public void addUsers(Users users)throws UsersException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Users u = usersDao.findByUsersId(users.getID());
		if(u !=null && u.getID()==users.getID()) throw new UsersException("This user has been registered!");
		
		usersDao.insertUsers(users);		
	}
	
	public void updateUsers(Users users)throws UsersException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Users u = usersDao.findByUsersId(users.getID());
		if(u == null) throw new UsersException("There's no user with this id");
		
		usersDao.updateUsers(users);	
	}
	
	public void deleteUsers(int ID) throws UsersException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Users u = usersDao.findByUsersId(ID);
		if(u == null) throw new UsersException("There's no user item with this id");
		usersDao.deleteUsers(ID);
	}
	
	public Users getUsers(String ID) throws UsersException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Users u = usersDao.findByUsersId(Integer.parseInt(ID));
		if(u == null) throw new UsersException("There's no user  item with this id");
		
		return u;
	}
	
	public List<Users> getAll() throws UsersException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return usersDao.findAll();
	}
	
}
