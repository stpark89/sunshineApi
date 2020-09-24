package com.sun.api.server.fs.repository;

import com.sun.api.server.fs.vo.FsInQuireVo;
import com.sun.api.server.inquire.vo.InQuirePlantVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsRepository extends JpaRepository<FsInQuireVo, Long> {
}
