package com.sun.api.server.inquire.repository;

import com.sun.api.server.inquire.vo.InQuirePlantVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InQuirePlantRepository extends JpaRepository<InQuirePlantVo, Long> {
}
