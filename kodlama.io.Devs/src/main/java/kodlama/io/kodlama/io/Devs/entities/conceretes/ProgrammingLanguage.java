package kodlama.io.kodlama.io.Devs.entities.conceretes;

public class ProgrammingLanguage {

	private int id;
	private String programmingLanguageName;

	public ProgrammingLanguage() {
		super();
	}

	public ProgrammingLanguage(int id, String programmingLanguageName) {
		super();
		this.id = id;
		this.programmingLanguageName = programmingLanguageName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgrammingLanguageName() {
		return programmingLanguageName;
	}

	public void setProgrammingLanguageName(String programmingLanguageName) {
		this.programmingLanguageName = programmingLanguageName;
	}



}
