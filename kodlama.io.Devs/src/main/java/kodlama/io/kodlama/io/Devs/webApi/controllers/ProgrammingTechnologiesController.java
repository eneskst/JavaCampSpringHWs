package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.kodlama.io.Devs.business.request.CreateProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.DeleteProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.GetByIdProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.UpdateProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllProgrammingTechnologyResponse;
import kodlama.io.kodlama.io.Devs.business.responses.GetByIdProgrammingTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programmingtechnologies")
@AllArgsConstructor
public class ProgrammingTechnologiesController {
	private ProgrammingTechnologyService service;

	@GetMapping("/getall")
	List<GetAllProgrammingTechnologyResponse> getAll() {
		return service.getAll();
	}

	@GetMapping("getbyid/{id}")
	GetByIdProgrammingTechnologyResponse getById(
			GetByIdProgrammingTechnologyRequest getByIdProgrammingTechnologyRequest) {
		return service.getByTechnologyId(getByIdProgrammingTechnologyRequest);
	}
	
	@PostMapping(value = "/add")
	public void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) {
		service.addProgrammingTechnology(createProgrammingTechnologyRequest);
	}
	
	@DeleteMapping(value = "delete")
	public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		service.deleteProgrammingTechnology(deleteProgrammingTechnologyRequest);
	}
	
	@PutMapping(value = "/update")
	public void update(UpdateProgrammingTechnologyRequest programmingTechnologyRequest) {
		service.updateProgrammingTechnology(programmingTechnologyRequest);
	}
	

}
