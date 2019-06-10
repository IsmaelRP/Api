package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class IncluyeId implements Serializable {
	
	@NotNull
	private String idtramo;
	
	@NotNull
	private String idusuario;
	
	@NotNull
	private int idsemana;
	
	@NotNull
	private int idcomidaprincipal;
	
	@NotNull
	private int secuencialidad;
	
	public IncluyeId(@NotNull String idtramo, @NotNull String idusuario, @NotNull int idsemana,
			@NotNull int idcomidaprincipal, @NotNull int secuencialidad) {
		this.idtramo = idtramo;
		this.idusuario = idusuario;
		this.idsemana = idsemana;
		this.idcomidaprincipal = idcomidaprincipal;
		this.secuencialidad = secuencialidad;
	}

	public IncluyeId() {
		
	}
	
	public String getIdtramo() {
		return idtramo;
	}

	public void setIdtramo(String idtramo) {
		this.idtramo = idtramo;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdsemana() {
		return idsemana;
	}

	public void setIdsemana(int idsemana) {
		this.idsemana = idsemana;
	}

	public int getIdcomidaprincipal() {
		return idcomidaprincipal;
	}

	public void setIdcomidaprincipal(int idcomidaprincipal) {
		this.idcomidaprincipal = idcomidaprincipal;
	}

	public int getSecuencialidad() {
		return secuencialidad;
	}

	public void setSecuencialidad(int secuencialidad) {
		this.secuencialidad = secuencialidad;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncluyeId that = (IncluyeId) o;

        if (!(idsemana == that.idsemana && idcomidaprincipal == that.idcomidaprincipal)) return false;
        return idusuario.equals(that.idusuario) && idtramo.equals(that.idtramo) && secuencialidad == that.secuencialidad;
    }

    @Override
    public int hashCode() {
        int result = idsemana;
        result = 31 * result + idusuario.hashCode() + idtramo.hashCode() + idsemana + idcomidaprincipal + secuencialidad;
        return result;
    }

}
