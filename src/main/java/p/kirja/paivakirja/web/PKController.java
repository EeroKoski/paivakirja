package p.kirja.paivakirja.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import p.kirja.paivakirja.domain.Note;
import p.kirja.paivakirja.domain.NoteRepo;
import p.kirja.paivakirja.domain.TypeRepo;
import p.kirja.paivakirja.domain.Wine;
import p.kirja.paivakirja.domain.WineRepo;


@Controller
public class PKController {
	
	@Autowired
	private WineRepo wirepo;
	
	
	@Autowired
	private TypeRepo tyrepo;
	
	
	@Autowired
	private NoteRepo norepo;
	
	@RequestMapping(value= {"/", "/main"})
	public String wineList(Model model) {
		model.addAttribute("wines", wirepo.findAll());
		return "main";
	}
	
	@RequestMapping(value= "/add")
	public String addWine(Model model) {
		model.addAttribute("wine", new Wine());
		model.addAttribute("types", tyrepo.findAll());
		model.addAttribute("note", new Note());

		return "addwine";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Wine wine){
        wirepo.save(wine);
        return "redirect:main";
	}
	
	@RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public String save(Note note){
        norepo.save(note);
        return "redirect:main";
	}
        
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWine(@PathVariable("id") Long Id, Model model) {
    	wirepo.deleteById(Id);
        return "redirect:../main";
    }
    
    
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editWine(@PathVariable("wineid") Long Id, Model model){
    	model.addAttribute("wine", wirepo.findById(Id));
		model.addAttribute("types", tyrepo.findAll());
		model.addAttribute("notes", norepo.findAll());
        return "editwine";
    }         
    
    
    @RequestMapping(value="/wines", method = RequestMethod.GET)
    public @ResponseBody List<Wine> wineListRest() {	
        return (List<Wine>) wirepo.findAll();
    }
	
    @RequestMapping(value="/wine/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Wine> findWineRest(@PathVariable("wineid") Long Id) {	
    	return wirepo.findById(Id);
    }       
    
    
}
