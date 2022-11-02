package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception;
	void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception;
	void deleteProgrammingLanguage(int id) throws Exception;
	boolean isIdExist(int id);
	boolean isNameExist(ProgrammingLanguage programmingLanguage);
}
