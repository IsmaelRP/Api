package hello;

public class ContieneDTO {
	
	private int idcalendario;
	
	private String idusuariocalendario;
	
	private String fecha;
	
	private int idcomida;
	
	private String tipocomida;

	public ContieneDTO(int idcalendario, String idusuariocalendario, String fecha, int idcomida, String tipocomida) {
		this.idcalendario = idcalendario;
		this.idusuariocalendario = idusuariocalendario;
		this.fecha = fecha;
		this.idcomida = idcomida;
		this.tipocomida = tipocomida;
	}
	
	public ContieneDTO() {
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
	
	

}
