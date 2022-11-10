package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.request.CreateProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.DeleteProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.GetByIdProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.UpdateProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllProgrammingTechnologyResponse;
import kodlama.io.kodlama.io.Devs.business.responses.GetByIdProgrammingTechnologyResponse;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguageTechnology;

public interface ProgrammingTechnologyService {

	boolean isIdExist(int id) throws Exception;
	boolean isNameExist(ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception;
	
	List<GetAllProgrammingTechnologyResponse> getAll();
	GetByIdProgrammingTechnologyResponse getByTechnologyId(GetByIdProgrammingTechnologyRequest getByIdProgrammingTechnologyRequest);
	
	void addProgrammingTechnology(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest);
	void deleteProgrammingTechnology(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest);
	void updateProgrammingTechnology(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest);

}
