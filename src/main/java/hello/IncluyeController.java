package hello;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/include")
public class IncluyeController {

	@Autowired
	private IncluyeRepository incluyeRepository;
	
	@PostMapping("/add")
	public synchronized @ResponseBody IncluyeDTO add (String idtramo, String idusuario, int idsemana,
			int idcomidaprincipal) {
		Incluye incluye = new Incluye();
		IncluyeId id;
		Iterable<Incluye> list = new ArrayList<>();
		Iterator<Incluye> iterator;
		Incluye aux;
		IncluyeDTO dto = new IncluyeDTO();
		
		int sec = 1;
		
		list = incluyeRepository.findAll();
		
		iterator = list.iterator();
		
		while (iterator.hasNext()) {
			aux = iterator.next();
			if (aux.getIncluyeid().getSecuencialidad() >= sec) {
				sec = aux.getIncluyeid().getSecuencialidad() +1;
			}
		}
		
		id = new IncluyeId(idtramo, idusuario, idsemana, idcomidaprincipal, sec);
		
		incluye.setIncluyeid(id);
		
		incluyeRepository.save(incluye);
		
		dto.setIdtramo(idtramo);
		dto.setIdusuario(idusuario);
		dto.setIdsemana(idsemana);
		dto.setSecuencialidad(sec);
		dto.setIdcomidaprincipal(idcomidaprincipal);
		
		return dto;
	}
	
	@PostMapping("/get")
	public @ResponseBody Iterable<IncluyeDTO> all (String idusuario, int idsemana) {
		
		Iterable<Incluye> list = new ArrayList<>();
		ArrayList<IncluyeDTO> listDTO = new ArrayList<>();
		
		Iterator<Incluye> iterator;
		Incluye aux;
		
		list = incluyeRepository.findAll();
		
		iterator = list.iterator();
		
		while (iterator.hasNext()) {
			aux = iterator.next();
			if (aux.getIncluyeid().getIdusuario().equals(idusuario) && aux.getIncluyeid().getIdsemana() == idsemana) {
				listDTO.add(new IncluyeDTO(aux.getIncluyeid().getIdtramo(), aux.getIncluyeid().getIdusuario(), aux.getIncluyeid().getIdsemana(), aux.getIncluyeid().getSecuencialidad(), aux.getIncluyeid().getIdcomidaprincipal()));
			}
		}
		
		return listDTO;
	}
	
	@PostMapping("/delete")
	public @ResponseBody ArrayList<IncluyeDTO> delete (String idusuario, int idsemana) {

		Iterable<Incluye> list = new ArrayList<>();
		
	    ArrayList<IncluyeDTO> listDTO = new ArrayList<>(); 
		
		list = incluyeRepository.findAll();
		
		list.forEach(incluye -> {
			if (incluye.getIncluyeid().getIdusuario().equals(idusuario) &&
					incluye.getIncluyeid().getIdsemana() == idsemana) {
				incluyeRepository.delete(incluye);
				listDTO.add(new IncluyeDTO(incluye.getIncluyeid().getIdtramo(), idusuario, 
						idsemana, incluye.getIncluyeid().getSecuencialidad(), incluye.getIncluyeid().getIdcomidaprincipal()));
			}
		});
		return listDTO;
	}

}
