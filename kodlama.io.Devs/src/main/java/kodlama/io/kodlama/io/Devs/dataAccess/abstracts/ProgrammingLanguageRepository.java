package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;


import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void addProgrammingLanguage(ProgrammingLanguage programmingLanguage);
	void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage);
	void deleteProgrammingLanguage(int id);
}
