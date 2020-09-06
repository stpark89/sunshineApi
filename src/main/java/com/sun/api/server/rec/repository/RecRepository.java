	package com.sun.api.server.rec.repository;

import java.util.List;
import java.util.Map;

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
	
	@Query(value = "select (select max(rec_Highest_Price) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as recHighestPrice , (select min(rec_Lowest_Price) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as recLowestPrice     , (select max(trading_Volume) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as maxTradingVolume     , (select min(trading_Volume) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as minTradingVolume , (select max(sell_Order_Volume) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as maxSellOrderVolume , (select min(sell_Order_Volume) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as minSellOrderVolume , (select max(purchase_Order_Volume) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as maxPurchaseOrderVolume    , (select min(purchase_Order_Volume) from rec_vo where division=0 and date_add(now(), INTERVAL -1 year) )as minPurchaseOrderVolume from dual" , nativeQuery = true)
	Map<String, Object> findIndicators();

	@Query(value = "select (select max(rec_Highest_Price) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as recHighestPrice , (select min(rec_Lowest_Price) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as recLowestPrice     , (select max(trading_Volume) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as maxTradingVolume     , (select min(trading_Volume) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as minTradingVolume , (select max(sell_Order_Volume) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as maxSellOrderVolume , (select min(sell_Order_Volume) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as minSellOrderVolume , (select max(purchase_Order_Volume) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as maxPurchaseOrderVolume    , (select min(purchase_Order_Volume) from rec_vo where division=1 and date_add(now(), INTERVAL -1 year) )as minPurchaseOrderVolume from dual" , nativeQuery = true)
	Map<String, Object> findJejuIndicators();
    
    
    

    
}
