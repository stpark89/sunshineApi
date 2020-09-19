package com.sun.api.server.rec.repository;

import com.sun.api.server.vo.RecVo;
import com.sun.api.server.vo.SmpVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmpRepository extends JpaRepository<SmpVo, Long> {

    @Query(value = "SELECT * FROM rec_vo where division = 0 order by trade_date", nativeQuery = true)
    List<RecVo> findBySearchSmpData();

    @Query(value = "SELECT * FROM rec_vo where division = 1 order by trade_date", nativeQuery = true)
    List<RecVo> findBySearchJejuSmpData();

}
