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
	public @ResponseBody IncluyeDTO add (String idtramo, String idusuario, int idsemana, boolean escategoria,
			int idcomidaprincipal, int idcomidasecundaria) {
		Incluye incluye = new Incluye();
		IncluyeId id = new IncluyeId();
		Iterable<Incluye> list = new ArrayList<>();
		Iterator<Incluye> iterator;
		Incluye aux;
		IncluyeDTO dto = new IncluyeDTO();
		
		int sec = 1;
		
		id.setIdcomidaprincipal(idcomidaprincipal);
		id.setIdcomidasecundaria(idcomidasecundaria);
		id.setIdsemana(idsemana);
		id.setIdtramo(idtramo);
		id.setIdusuario(idusuario);
		
		list = incluyeRepository.findAll();
		
		iterator = list.iterator();
		
		while (iterator.hasNext()) {
			aux = iterator.next();
			if (aux.getSecuencialidad() >= sec) {
				sec = aux.getSecuencialidad() +1;
			}
		}
		
		incluye.setSecuencialidad(sec);
		
		incluye.setEscategoria(escategoria);
		incluye.setIncluyeid(id);
		
		incluyeRepository.save(incluye);
		
		dto.setIdtramo(idtramo);
		dto.setIdusuario(idusuario);
		dto.setIdsemana(idsemana);
		dto.setSecuencialidad(sec);
		dto.setEscategoria(escategoria);
		dto.setIdcomidaprincipal(idcomidaprincipal);
		dto.setIdcomidasecundaria(idcomidasecundaria);
		
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
				listDTO.add(new IncluyeDTO(aux.getIncluyeid().getIdtramo(), aux.getIncluyeid().getIdusuario(), aux.getIncluyeid().getIdsemana(), aux.getSecuencialidad(), aux.isEscategoria(), aux.getIncluyeid().getIdcomidaprincipal(), aux.getIncluyeid().getIdcomidasecundaria()));
			}
		}
		
		return listDTO;
	}

}
