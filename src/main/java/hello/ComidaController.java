package hello;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/food")
public class ComidaController {
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	@PostMapping("/add")
	public @ResponseBody Comida add (@RequestBody Comida c) {
		
		comidaRepository.save(c);
		return c;
	}
	
	@PostMapping("/all")
	public @ResponseBody Iterable<Comida> all (String idusuario) {

		Iterable<Comida> list = new ArrayList<>();
		Iterator<Comida> iterator;
		
		list = comidaRepository.findAll();
		
		iterator = list.iterator();
		
		while (iterator.hasNext()) {
			if (!iterator.next().getIdusuario().equals(idusuario)) {
				iterator.remove();
			}
		}
		return list;
	}
	
	@PostMapping("/delete")
	public @ResponseBody Comida delete (@RequestBody Comida c) {
		
		comidaRepository.delete(c);
		return c;
	}
	
	@PostMapping("/edit")
	public @ResponseBody Comida edit (@RequestBody Comida c) {
		
		comidaRepository.save(c);
		return c;
	}
	
	@PostMapping("/get")
	public @ResponseBody Comida edit (int idcomida) {
		Comida c = null;
		
		if (comidaRepository.findById(idcomida).isPresent()) {
			c = comidaRepository.findById(idcomida).get();
		}
		return c;
	}

}
