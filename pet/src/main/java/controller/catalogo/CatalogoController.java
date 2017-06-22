package controller.catalogo;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/catalogo")
@SessionAttributes({ "user_inicio" })

public class CatalogoController {
	
	@RequestMapping(value = "/catalogo", method = RequestMethod.GET)
	public String catalogoPage() {
		return "key/catalogo";
	}
}
