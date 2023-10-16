package gr.opap.bet.repository;


import gr.opap.bet.entity.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {

    List<Bet> findAll();
}
