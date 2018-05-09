package test_Datenbank;

public class Rechtsform {
	private String id;
	private String rechtsform;
	
	public Rechtsform(String id, String rechtsform) {
		this(rechtsform);
		this.id = id;
	}
	public Rechtsform(String rechtsform){
		this.rechtsform=rechtsform;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
