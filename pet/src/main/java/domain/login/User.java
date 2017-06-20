package domain.login;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.DigestUtils;

import domain.adm.Company;
import domain.adm.Currency;
import domain.adm.TypeUser;

@Entity
@Table(name="users", schema="gestion") 
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @NotEmpty(message = "Por favor ingrese usuario") 
    private String id;

    @Column(name = "pass")
    @NotEmpty(message = "Por favor ingrese contraseña")    
    private String pass;
    
    @ManyToOne
    private TypeUser type;
     
    @ManyToOne
    private Company comp;
    
    @ManyToOne
    private Currency curr;
    
	public Currency getCurr() {
		return curr;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
        
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    } 
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) {
    	try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pass.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
			this.pass = hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
   
    public TypeUser getType() {
    	return type;
   	}
    
    public void setType(TypeUser type) {
		this.type = type;
	}
    
    public Company getComp() {
		return comp;
	}
    
    public void setComp(Company comp) {
		this.comp = comp;
	}
    
    public void setCurr(Currency curr) {
		this.curr = curr;
	}
  
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Pass: " + pass + ";");
        return buffer.toString();
    }
}