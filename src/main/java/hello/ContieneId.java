package hello;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class ContieneId implements Serializable{

	@NotNull
	private int idcalendario;
	
	@NotNull
	private String idusuariocalendario;
	
	@NotNull
	private String fecha;
	
	@NotNull
	private int idcomida;
	
	@NotNull
	private String tipocomida;
	
	public ContieneId() {
	}

	public ContieneId(@NotNull int idcalendario, @NotNull String idusuariocalendario, @NotNull String fecha,
			@NotNull int idcomida, @NotNull String tipocomida) {
		this.idcalendario = idcalendario;
		this.idusuariocalendario = idusuariocalendario;
		this.fecha = fecha;
		this.idcomida = idcomida;
		this.tipocomida = tipocomida;
	}

	public int getIdcalendario() {
		return idcalendario;
	}

	public void setIdcalendario(int idcalendario) {
		this.idcalendario = idcalendario;
	}

	public String getIdusuariocalendario() {
		return idusuariocalendario;
	}

	public void setIdusuariocalendario(String idusuariocalendario) {
		this.idusuariocalendario = idusuariocalendario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdcomida() {
		return idcomida;
	}

	public void setIdcomida(int idcomida) {
		this.idcomida = idcomida;
	}

	public String getTipocomida() {
		return tipocomida;
	}

	public void setTipocomida(String tipocomida) {
		this.tipocomida = tipocomida;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContieneId that = (ContieneId) o;

        if (!(idcalendario == that.idcalendario)) return false;
        return idusuariocalendario.equals(that.idusuariocalendario) && fecha.equals(that.fecha) 
        		&& idcomida == that.idcomida && tipocomida.equals(that.tipocomida);
    }

    @Override
    public int hashCode() {
        int result = idcalendario;
        result = 31 * result + idusuariocalendario.hashCode() + fecha.hashCode() + idcomida + tipocomida.hashCode();
        return result;
    }
	
	
}
