package domain.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import org.hibernate.validator.constraints.NotEmpty;
import domain.users.PersonaP;

@Entity
public class InfoPersonal {
	
	@Id
    @Column(name = "id")
    @NotEmpty(message = "Por favor ingrese id") 
	private int id;
	
	@Column(name = "categoria")
    @NotEmpty(message = "Por favor ingrese categoria") 
	private String categoria;
	
	@Column(name = "descripcion")
    @NotEmpty(message = "Por favor ingrese descripcion") 
	private String descripcion;
	
	
	@ManyToMany(mappedBy = "publishers")
	private Set<PersonaP> persona;
	

	public Set<PersonaP> getPersona() {
		return persona;
	}

	public void setPersona(Set<PersonaP> persona) {
		this.persona = persona;
	}

	public InfoPersonal() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
