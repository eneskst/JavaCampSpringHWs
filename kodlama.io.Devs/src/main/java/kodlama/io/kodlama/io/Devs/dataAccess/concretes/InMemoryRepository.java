package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;


import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;

@Repository
public class InMemoryRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;

	public InMemoryRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "C"));
		programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(4, "C++"));
		programmingLanguages.add(new ProgrammingLanguage(5, "Python"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage language : programmingLanguages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;

	}

	@Override
	public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage){
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void updateProgrammingLanguage(ProgrammingLanguage programmingLanguage){
		for(ProgrammingLanguage language:programmingLanguages) {
			if(language.getId()==programmingLanguage.getId()){
				language.setId(programmingLanguage.getId());
				language.setProgrammingLanguageName(programmingLanguage.getProgrammingLanguageName());
				
			}
		}
	}

	@Override
	public void deleteProgrammingLanguage(int id){
		programmingLanguages.remove(getById(id));
	}

}
