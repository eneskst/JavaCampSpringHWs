package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.kodlama.io.Devs.business.request.CreateProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.DeleteProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.GetByIdProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.request.UpdateProgrammingTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.GetAllProgrammingTechnologyResponse;
import kodlama.io.kodlama.io.Devs.business.responses.GetByIdProgrammingTechnologyResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;
import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

	ProgrammingTechnologyRepository programmingTechnologyRepository;
	ProgrammingLanguageRepository programmingLanguageRepository;

	List<ProgrammingLanguageTechnology> programmingLanguageTechnologies;

	public ProgrammingTechnologyManager(ProgrammingTechnologyRepository programmingTechnologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingTechnologyRepository = programmingTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public boolean isIdExist(int id) throws Exception {
		for (ProgrammingLanguageTechnology technology : programmingLanguageTechnologies) {
			if (technology.getId() == id) {
				throw new Exception("ID is valid.");
			}
		}
		return false;
	}

	@Override
	public boolean isNameExist(ProgrammingLanguageTechnology programmingLanguageTechnology) throws Exception {
		for (ProgrammingLanguageTechnology technology : programmingLanguageTechnologies) {
			if (technology.getName().equalsIgnoreCase(programmingLanguageTechnology.getName())) {
				throw new Exception("Technology is already in use.");
			} else {

				return false;
			}
		}
		return false;
	}

	@Override
	public List<GetAllProgrammingTechnologyResponse> getAll() {
		List<ProgrammingLanguageTechnology> technologies = programmingTechnologyRepository.findAll();
		List<GetAllProgrammingTechnologyResponse> technologyResponse = new ArrayList<>();

		for (ProgrammingLanguageTechnology technology : technologies) {
			GetAllProgrammingTechnologyResponse response = new GetAllProgrammingTechnologyResponse();
			response.setId(technology.getId());
			response.setName(technology.getName());
			technologyResponse.add(response);
		}

		return technologyResponse;
	}

	@Override
	public GetByIdProgrammingTechnologyResponse getByTechnologyId(
			GetByIdProgrammingTechnologyRequest getByIdProgrammingTechnologyRequest) {

		ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
		programmingLanguageTechnology = programmingTechnologyRepository
				.findById(getByIdProgrammingTechnologyRequest.getId()).get();

		GetByIdProgrammingTechnologyResponse getByIdProgrammingTechnologyResponse = new GetByIdProgrammingTechnologyResponse();
		getByIdProgrammingTechnologyResponse.setId(programmingLanguageTechnology.getId());
		getByIdProgrammingTechnologyResponse.setTechnologyName(programmingLanguageTechnology.getName());
		getByIdProgrammingTechnologyResponse.setLanguageName(programmingLanguageTechnology.getLanguage());

		return getByIdProgrammingTechnologyResponse;
	}

	@Override
	public void addProgrammingTechnology(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) {

		ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
		programmingLanguageTechnology.setName(createProgrammingTechnologyRequest.getName());

		ProgrammingLanguage programmingLanguage = programmingLanguageRepository
				.findById(createProgrammingTechnologyRequest.getLanguageId()).get();

		programmingLanguageTechnology.setLanguage(programmingLanguage);

	}

	@Override
	public void deleteProgrammingTechnology(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		programmingTechnologyRepository.deleteById(deleteProgrammingTechnologyRequest.getId());
	}

	@Override
	public void updateProgrammingTechnology(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest) {
		
		for (ProgrammingLanguageTechnology technology : programmingLanguageTechnologies) {
			if(technology.getId()==updateProgrammingTechnologyRequest.getTechnologyId()) {
				technology.setName(updateProgrammingTechnologyRequest.getName());
				technology.setLanguage(programmingLanguageRepository.findById(updateProgrammingTechnologyRequest.getLanguageId()).get());
				programmingTechnologyRepository.save(technology);
			}		
		}
	}

}
