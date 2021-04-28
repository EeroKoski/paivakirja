package p.kirja.paivakirja.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface WineRepo extends CrudRepository<Wine, Long> {
	
	List<Wine> findByProducer(String producer);
}
