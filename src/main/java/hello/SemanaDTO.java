package hello;

public class SemanaDTO {
	
	private int idSemana;
    private String idUsuario;
    private String nombreSemana;

    public SemanaDTO(int idSemana, String idUsuario, String nombreSemana) {
        this.idSemana = idSemana;
        this.idUsuario = idUsuario;
        this.nombreSemana = nombreSemana;
    }

    public int getIdSemana() {
		return idSemana;
	}

	public void setIdSemana(int idSemana) {
		this.idSemana = idSemana;
	}

	public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreSemana() {
        return nombreSemana;
    }

    public void setNombreSemana(String nombreSemana) {
        this.nombreSemana = nombreSemana;
    }

}
