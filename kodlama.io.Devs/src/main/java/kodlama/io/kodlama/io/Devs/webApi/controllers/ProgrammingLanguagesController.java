package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) {
		return programmingLanguageService.getById(id);
	}

	@PostMapping("/add-programming-language/{id}")
	public void addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.addProgrammingLanguage(programmingLanguage);

	}

	@PutMapping("/update-programming-language/{id}")
	public void updateProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.updateProgrammingLanguage(programmingLanguage);

	}

	@DeleteMapping("/delete-programming-language/{id}")
	public void deleteProgrammingLanguage(@PathVariable int id) throws Exception {
		programmingLanguageService.deleteProgrammingLanguage(id);

	}

}
