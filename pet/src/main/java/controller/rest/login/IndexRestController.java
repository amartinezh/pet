package controller.rest.login;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.login.User;
import domain.session.session;
import service.adm.CompanyService;
import service.adm.CurrencyService;
import service.adm.TypeUserService;
import service.login.UserManager;

@RestController
@RequestMapping(value = "/rest")
@SessionAttributes({ "user_inicio" })
public class IndexRestController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager userManager;

	@Autowired
	private TypeUserService typeUserService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CurrencyService currencyService;
		

	/*
	 * @Autowired private PermisoManager permisoManager;
	 */

	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	 public String addEmployee(@RequestParam ("id") String id,@RequestParam ("pass") String pass) {
		User use = new User();
		use.setId(id);
		use.setPass(pass);
		User uss = userManager.val(use.getId(),use.getPass());
			if (uss != null) {
				session ses=new session(use.getId());
				return ses.toString();
			} else {
				return "bad credentials";
			}
	}
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Model model, SessionStatus status) {
		status.setComplete();
		model.addAttribute("user_inicio", new session() );
		return "redirect:/index/ingreso";
	}

	public void setuserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

}
