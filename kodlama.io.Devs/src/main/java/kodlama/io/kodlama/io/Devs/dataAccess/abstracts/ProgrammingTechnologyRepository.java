package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.entities.conceretes.ProgrammingLanguageTechnology;
@Repository
public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Integer>{

}
