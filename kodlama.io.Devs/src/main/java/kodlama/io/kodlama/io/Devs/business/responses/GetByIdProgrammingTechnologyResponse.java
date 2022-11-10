package kodlama.io.kodlama.io.Devs.business.responses;

import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProgrammingTechnologyResponse {

	private int id;
	private String technologyName;
	private ProgrammingLanguage languageName;
}
