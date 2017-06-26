package controller.rest;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import domain.login.User;
import service.login.UserManager;

@RestController
public class LoginRestController {

	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private  UserManager estudianteService;

	
	@RequestMapping(value = "/todo/login", method = RequestMethod.GET)
	public List<User> devolverEstudiante1() {
		List<User> uss = estudianteService.getUsers();
		return uss;
	}
	
	@RequestMapping(value = "/todo/addEstudiante", method = RequestMethod.POST)
	public boolean addEstudiante(@RequestParam("id") String id,@RequestParam("pass") String pass,@RequestParam ("nombre") String nombre) {
		User user = new User();
		user.setId(id);
		user.setPass(pass);
		boolean uss = estudianteService.addUser(user);
		return uss;
	}
	
	@RequestMapping(value = "/todo/updateEstudiante", method = RequestMethod.PUT)
	public boolean updateEstudiante(@RequestParam("id") String id,@RequestParam("pass") String pass,@RequestParam ("nombre") String nombre) {
		User user = new User();
		user.setId(id);
		user.setPass(pass);
		boolean uss = estudianteService.editUser(user);
		return uss;
	}
	
	@RequestMapping(value = "/todo/deleteEstudiante", method = RequestMethod.DELETE)
	public void deleteEstudiante(@RequestParam("id") String id) {
		estudianteService.deleteUser((id));	
	}
	
	@RequestMapping(value = "/todo/login/{id}/{pass}", method = RequestMethod.GET)
	public User devolverEstudianteget(@PathVariable("id") String id,@PathVariable("pass") String pass) {
		User uss = estudianteService.val(id, pass);
		return uss;
	}
	
	
	
	
	
	
}
