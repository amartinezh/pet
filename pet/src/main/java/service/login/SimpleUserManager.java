package service.login;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.login.User;
import repository.login.UserDao;

@Component
public class SimpleUserManager implements UserManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao UserDao) {
        this.userDao = UserDao;
    }
    
    public List<User> getUsers() {
    	return userDao.getUserList();
    }

	public User val(String k, String p) {
		return userDao.val(k,p);
	}

	public boolean addUser(User user) {
		return userDao.addUser(user);
	}
	
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	public User getUser(User user) {
		return userDao.getUser(user);
	}
	
	public boolean editUser(User user) {
		return userDao.editUser(user);
	}
	
	public Map<String, String> obtenerDatos() {
		return userDao.obtenerDatos();
	}
}