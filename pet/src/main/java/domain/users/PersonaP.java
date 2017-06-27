package domain.users;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonaP {
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String departamento;
	
	private String municipio;
	
	private int genero;
	
	private int edad;
	
	private ArrayList<String> sobreti;
	
	private ArrayList<String> servicios;
	
	private ArrayList<String> bsmd;
	
	private ArrayList<String> masajes;
	
	private ArrayList<Byte> videos;
	
	private ArrayList<Byte> fotos;
	
	
	
}
