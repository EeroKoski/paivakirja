package p.kirja.paivakirja.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface NoteRepo extends CrudRepository<Note, Long> {
	
	Optional<Note> findById(Long noteid);

}