package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/contains")
public class ContieneController {
	
	@Autowired
	private ContieneRepository contieneRepository;
	
	@PostMapping("/add")
	public @ResponseBody ContieneDTO add (ContieneDTO c) {		
		
		Contiene contiene = new Contiene();
		ContieneId id = new ContieneId();
		
		id.setFecha(c.getFecha());
		id.setIdcalendario(c.getIdcalendario());
		id.setIdcomida(c.getIdcomida());
		id.setIdusuariocalendario(c.getIdusuariocalendario());
		id.setTipocomida(c.getTipocomida());
		
		contiene.setContieneid(id);
		
		contieneRepository.save(contiene);
		
		return c;
	}
	
	@PostMapping("/all")
	public @ResponseBody ArrayList<ContieneDTO> all (String idusuario, int idcalendario) {

		Iterable<Contiene> list = new ArrayList<>();
		
	    ArrayList<ContieneDTO> listDTO = new ArrayList<>(); 
		
		list = contieneRepository.findAll();
		
		list.forEach(contiene -> {
			if (contiene.getContieneid().getIdusuariocalendario().equals(idusuario) &&
					contiene.getContieneid().getIdcalendario() == idcalendario) {
				listDTO.add(new ContieneDTO(idcalendario, idusuario, contiene.getContieneid().getFecha(),
						contiene.getContieneid().getIdcomida(), contiene.getContieneid().getTipocomida()));
			}
		});
		return listDTO;
	}
	
	@PostMapping("/delete")
	public @ResponseBody ArrayList<ContieneDTO> delete (String idusuario, int idcalendario) {

		Iterable<Contiene> list = new ArrayList<>();
		
	    ArrayList<ContieneDTO> listDTO = new ArrayList<>(); 
		
		list = contieneRepository.findAll();
		
		list.forEach(contiene -> {
			if (contiene.getContieneid().getIdusuariocalendario().equals(idusuario) &&
					contiene.getContieneid().getIdcalendario() == idcalendario) {
				contieneRepository.delete(contiene);
				listDTO.add(new ContieneDTO(idcalendario, idusuario, contiene.getContieneid().getFecha(),
						contiene.getContieneid().getIdcomida(), contiene.getContieneid().getTipocomida()));
			}
		});
		return listDTO;
	}

}
