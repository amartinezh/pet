package controller.catalogo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/geo")
@SessionAttributes({ "user_inicio" })
public class GeolocationController {
	
	@RequestMapping(value = "/geo", method = RequestMethod.GET)
	public String catalogoPage() {
		return "key/geolocation-test";
	}
}
