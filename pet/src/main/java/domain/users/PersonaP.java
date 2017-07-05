package domain.users;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PersonaP {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "email")
    @NotEmpty(message = "Por favor ingrese correo") 
	private String email;
	
	
	@Column(name = "nombre")
    @NotEmpty(message = "Por favor ingrese nombre") 
	private String nombre;
	
	@Column(name = "apellido")
    @NotEmpty(message = "Por favor ingrese apellido") 
	private String apellido;
	
	@Column(name = "departamento")
    @NotEmpty(message = "Por favor ingrese departamento") 
	private String departamento;
	
	@Column(name = "municipio")
    @NotEmpty(message = "Por favor ingrese municipio") 
	private String municipio;
	
	@Column(name = "genero")
    @NotEmpty(message = "Por favor ingrese genero") 
	private int genero;
	
	@Column(name = "edad")
    @NotEmpty(message = "Por favor ingrese edad") 
	private int edad;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rel_personap_infopersonal", joinColumns = @JoinColumn(name = "fk_persona_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fk_info_id", referencedColumnName = "id"))
	private Set<InfoPersonal> info;
	
	@OneToMany
	private ArrayList<Byte> videos;
	
	@OneToMany
	private ArrayList<Byte> fotos;
	
	public PersonaP(){
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<InfoPersonal> getInfo() {
		return info;
	}

	public void setInfo(Set<InfoPersonal> info) {
		this.info = info;
	}

	public ArrayList<Byte> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<Byte> videos) {
		this.videos = videos;
	}

	public ArrayList<Byte> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<Byte> fotos) {
		this.fotos = fotos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
