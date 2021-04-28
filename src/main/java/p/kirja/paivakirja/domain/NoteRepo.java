package p.kirja.paivakirja.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface NoteRepo extends CrudRepository<Type, Long> {
	
	List<Type> findByName(Long noteid);

}