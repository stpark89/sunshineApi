package com.sun.api.server.rec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sun.api.server.vo.RecVo;

public interface RecRepository extends JpaRepository<RecVo, Long>{
	
	@Query(value = "SELECT * FROM rec_vo where division = 0 order by trade_date DESC limit 1", nativeQuery = true)
	RecVo findBySearchLastRecData();
	
	@Query(value = "SELECT * FROM rec_vo where division = 1 order by trade_date DESC limit 1", nativeQuery = true)
	RecVo findBySearchLastJejuRecdData();
	
	@Query(value = "SELECT * FROM rec_vo where division = 0 order by trade_date", nativeQuery = true)
	List<RecVo> findBySearchRecData();
	
	@Query(value = "SELECT * FROM rec_vo where division = 1 order by trade_date", nativeQuery = true)
	List<RecVo> findBySearchJejuRecdData();
	
	@Query(value = "SELECT count(1) FROM rec_vo WHERE trade_date_string =:tradeDateString", nativeQuery = true)
	int findByTradeDateCheck(@Param("tradeDateString") String tradeDateString);
}
