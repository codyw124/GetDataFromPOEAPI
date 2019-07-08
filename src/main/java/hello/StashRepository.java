package hello;

import org.springframework.data.repository.CrudRepository;

public interface StashRepository extends CrudRepository<Stash, Integer> {

}