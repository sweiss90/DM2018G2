package test_Datenbank;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rechtsform")
public class Rechtsform {
	@Id
	@GeneratedValue
	private Integer id;
	private String rechtsform;
	
	@OneToMany(mappedBy="rechtsform")
	private Set<Geschäftskunde> geschäftskunden;
	
	public Rechtsform(Integer id, String rechtsform) {
		this(rechtsform);
		this.id = id;
	}
	public Rechtsform(String rechtsform){
		this.rechtsform=rechtsform;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRechtsform() {
		return rechtsform;
	}
	public void setRechtsform(String rechtsform) {
		this.rechtsform = rechtsform;
	}
	@Override
	public String toString(){
		return "{ ID= "+getId()+", Rechtsform= "+getRechtsform()+" }";
	}
	
	
	

}
