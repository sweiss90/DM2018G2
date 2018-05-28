package test_Datenbank;

import java.io.Serializable;
import java.util.Objects;

public class RechnungspositionsId implements Serializable {
	
	private Integer rechnung;
	private Integer positionsNr;
	
	public RechnungspositionsId(){
		//notwendig wegen JPA
	}
	
	public RechnungspositionsId(Integer rechnungNr, Integer positionsNr) {
		this.rechnung = rechnungNr;
		this.positionsNr = positionsNr;
	}
	public Integer getRechnung() {
		return rechnung;
	}
	public Integer getPositionsNr() {
		return positionsNr;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(this==obj) return true;
		if(this.getClass()!=obj.getClass()) return false;
		RechnungspositionsId o=(RechnungspositionsId) obj;
		return (this.getPositionsNr()==o.getPositionsNr() && this.getRechnung()==o.getRechnung());
	}
	@Override
	public int hashCode(){
		return Objects.hash(rechnung, positionsNr);
	}
	
	
	

}
