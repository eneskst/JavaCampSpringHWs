package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.request.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.request.GetByIdProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.request.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	boolean isIdExist(int id);
	boolean isNameExist(ProgrammingLanguage programmingLanguage);
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguageResponse getByLanguageId(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest);
	
	void addProgrammingLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	void deleteProgrammingLanguage(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
	void updateProgrammingLanguage(UpdateProgrammingLanguageRequest updateProgrammingLanguage);
}
