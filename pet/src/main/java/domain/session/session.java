package domain.session;

import java.io.Serializable;

@SuppressWarnings("serial")
public class session implements Serializable{

	private String usuario;
	
	public session(){
		
	}

	public session(String usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		session other = (session) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "session [usuario=" + usuario + "]";
	}
	
	
}
