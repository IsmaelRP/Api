package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contiene")
public class Contiene {

	@EmbeddedId
	private ContieneId contieneid;

	public Contiene(ContieneId contieneid) {
		this.contieneid = contieneid;
	}
	
	public Contiene() {
	}

	public ContieneId getContieneid() {
		return contieneid;
	}

	public void setContieneid(ContieneId contieneid) {
		this.contieneid = contieneid;
	}
	
}
