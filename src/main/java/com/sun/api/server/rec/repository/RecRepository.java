package com.sun.api.server.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sun.api.server.vo.RecVo;

public interface RecRepository extends JpaRepository<RecVo, Long>{
	
	@Query(value = "SELECT * FROM rec_vo order by trade_date DESC limit 1", nativeQuery = true)
	RecVo findBySearchLastRecData();
	
	@Query(value = "SELECT * FROM rec_vo order by trade_date DESC limit 1", nativeQuery = true)
	RecVo findBySearchLastJejuRecdData();
	
	@Query(value = "SELECT count(1) FROM rec_vo WHERE trade_date_string =:tradeDateString", nativeQuery = true)
	int findByTradeDateCheck(@Param("tradeDateString") String tradeDateString);
}
