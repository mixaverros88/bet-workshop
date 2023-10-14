package gr.opap.placebet.repository;


import gr.opap.placebet.entity.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {

}
