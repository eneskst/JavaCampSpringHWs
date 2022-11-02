package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
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

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {

		return programmingLanguageRepository.getById(id);
	}

	@Override
	public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception {

		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == programmingLanguage.getId() || language.getProgrammingLanguageName()
					.equalsIgnoreCase(programmingLanguage.getProgrammingLanguageName())) {
				throw new Exception("Language or ID is exisist" + programmingLanguageRepository.getAll()
						+ "\n Please add different item from above. ");
			} else if (programmingLanguage.getProgrammingLanguageName().isEmpty()) {
				throw new Exception("Programming Name could not be empty.");
			} else {
			}
			programmingLanguageRepository.addProgrammingLanguage(programmingLanguage);
		}
	}

	@Override
	public void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == programmingLanguage.getId()) {
				programmingLanguageRepository.updateProgrammingLanguage(programmingLanguage);
			} else if (programmingLanguage.getProgrammingLanguageName().isEmpty()) {
				throw new Exception("Programming Name could not be empty.");
			} else {
				throw new Exception("Programming Language Id is not exist");
			}
		}

	}

	@Override
	public void deleteProgrammingLanguage(int id) throws Exception {
		if (isIdExist(id)) {
					programmingLanguageRepository.deleteProgrammingLanguage(id);
		} else {
				throw new Exception(
					programmingLanguageRepository.getById(id)+ "could not found.");
		}

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

}
