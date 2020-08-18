package com.sun.api.server.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sun.api.server.map.vo.ZoneSunshine;

public interface ZoneSunshineRepository extends JpaRepository<ZoneSunshine, Long>{
	
    @Query(value = "SELECT * FROM zone_sunshine WHERE sgg_nm =:sggNm AND si_nm =:siNm", nativeQuery = true)
	ZoneSunshine findBySearchZoneSunshine(@Param("sggNm") String sggNm, @Param("siNm") String siNm);
}
