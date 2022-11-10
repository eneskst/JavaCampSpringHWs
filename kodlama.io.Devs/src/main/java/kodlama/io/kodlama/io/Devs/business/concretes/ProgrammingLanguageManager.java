package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama.io.Devs.business.request.CreateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.request.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.request.GetByIdProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.request.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	List<ProgrammingLanguage> programmingLanguages;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getProgrammingLanguageName() == programmingLanguage.getProgrammingLanguageName()) {
				return true;
			}
		}
		return false;
	}

	public boolean isIdExist(int id) {
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == id) {
				return true;
			}
		}
		return false;
	}


	@Override
	public GetByIdProgrammingLanguageResponse getByLanguageId(
			GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage = programmingLanguageRepository.findById(getByIdProgrammingLanguageRequest.getId()).get();
		
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		getByIdProgrammingLanguageResponse.setId(programmingLanguage.getId());
		getByIdProgrammingLanguageResponse.setName(programmingLanguage.getProgrammingLanguageName());
		return getByIdProgrammingLanguageResponse;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> languagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage language : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getProgrammingLanguageName());
			languagesResponse.add(responseItem);

		}

		return languagesResponse;
	}

	@Override
	public void addProgrammingLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setProgrammingLanguageName(createProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void deleteProgrammingLanguage(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());

	}

	@Override
	public void updateProgrammingLanguage(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		UpdateProgrammingLanguageRequest languageRequest = new UpdateProgrammingLanguageRequest();
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == updateProgrammingLanguageRequest.getId()) {
				languageRequest.setId(updateProgrammingLanguageRequest.getId());
				languageRequest.setName(updateProgrammingLanguageRequest.getName());
				programmingLanguageRepository.findById(languageRequest.getId());
			}

		}

	}

}
