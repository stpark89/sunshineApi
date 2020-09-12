package com.sun.api.server.packageProduct.repository;

import com.sun.api.server.packageProduct.vo.PackageProductVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageProductRepository extends JpaRepository<PackageProductVo, Long> {
}
