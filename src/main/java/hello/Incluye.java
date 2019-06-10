package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="incluye")
public class Incluye {

	@EmbeddedId
	private IncluyeId incluyeid;
		
	public Incluye(IncluyeId incluyeid) {
		this.incluyeid = incluyeid;
	}
	
	public Incluye() {
	}

	public IncluyeId getIncluyeid() {
		return incluyeid;
	}

	public void setIncluyeid(IncluyeId incluyeid) {
		this.incluyeid = incluyeid;
	}
	
}
