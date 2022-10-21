package com.project.coffeebets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.coffeebets.models.Bet;





@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
	Optional<Bet> findById(int id);
	
	
	 @Query(value = "SELECT SUM(payout) FROM bets WHERE team = ?1 AND apiId = ?2 AND user_id = ?3" , nativeQuery=true)
	 Integer findBetsBy(@Param("team") String team, @Param("apiId") Long apiId, @Param("user_id") Long user_id);
	 
	 
	 @Query(value = "SELECT * FROM bets WHERE user_id = ?1 AND status = 0 ORDER BY created_at desc", nativeQuery=true)
	 Iterable<Bet> getUserBets(@Param("user_id") Long user_id);
	 
	 
	 @Query(value = "SELECT * FROM bets WHERE status = 1 and payout > 200 ORDER BY created_at desc LIMIT 10", nativeQuery=true)
	 Iterable<Bet> getdashBets();
	 
	 
	 @Query(value = "SELECT SUM(Payout) FROM bets INNER JOIN games ON bets.game_id=games.id where team = games.winner and is_closed = 1 and user_id = ?1", nativeQuery=true)
	 Double userProfit(@Param("user_id")Long user_id);
	 

	 @Query(value = "SELECT SUM(amount) FROM bets where user_id = ?1", nativeQuery=true)
	 Double userTotalBet(@Param("user_id")Long user_id);
	 
	 @Query(value = "SELECT SUM(amount) FROM bets", nativeQuery=true)
	 Double totalBet();
	 
	 @Query(value = "SELECT SUM(payout) FROM bets INNER JOIN games ON bets.game_id=games.id where team = games.winner and is_closed = 1", nativeQuery=true)
	 Double totalProfit();
	 
	 
	 @Query(value = "SELECT * FROM bets INNER JOIN games ON bets.game_id=games.id where team = games.winner and is_closed = 1 and user_id = ?1 limit 25", nativeQuery=true)
	 Iterable<Bet> recentWins(@Param("user_id")Long user_id);
	 
	 @Query(value = "SELECT * FROM bets where user_id = ?1 order by created_at desc;", nativeQuery=true)
	 Iterable<Bet> betsOrdered(@Param("user_id")Long user_id);
	 
	 

	 

	 


	 
	 

}

