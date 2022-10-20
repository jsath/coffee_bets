package com.project.cofeebets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cofeebets.models.Bet;





@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
	Optional<Bet> findById(int id);
	
	
	 @Query(value = "SELECT SUM(payout) FROM bets WHERE team = ?1 AND apiId = ?2 AND user_id = ?3" , nativeQuery=true)
	 Integer findBetsBy(@Param("team") String team, @Param("apiId") Long apiId, @Param("user_id") Long user_id);
	 
	 
	 @Query(value = "SELECT * FROM bets WHERE user_id = ?1 AND status = 0 ORDER BY created_at desc", nativeQuery=true)
	 Iterable<Bet> getUserBets(@Param("user_id") Long user_id);
	 
	 
	 @Query(value = "SELECT * FROM bets WHERE status = 1 ORDER BY created_at desc LIMIT 10", nativeQuery=true)
	 Iterable<Bet> getdashBets();

}

