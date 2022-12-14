package kodlama.io.kodlama.io.Devs.entities.conceretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="Programming Languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "languageId")
	private int id;
	
	@Column(name="LanguageName")
	private String programmingLanguageName;
	
	@OneToMany(mappedBy = "programmingLanguage")
	private List<ProgrammingLanguageTechnology> programmingLanguageTechnologies;


}
