package kodlama.io.kodlama.io.Devs.entities.conceretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Programming Technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingLanguageTechnology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technologyId")
	private int id;
	
	@Column(name="programmingTechnologyName")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="languageId")
	private ProgrammingLanguage language;

}
