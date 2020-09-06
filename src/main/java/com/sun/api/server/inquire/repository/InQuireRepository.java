package com.sun.api.server.inquire.repository;

import com.sun.api.server.inquire.vo.InQuireVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InQuireRepository extends JpaRepository<InQuireVo, Long> {
}
