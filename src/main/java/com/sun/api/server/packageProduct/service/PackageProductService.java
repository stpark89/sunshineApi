package com.sun.api.server.packageProduct.service;

import com.sun.api.server.packageProduct.repository.PackageProductRepository;
import com.sun.api.server.packageProduct.vo.PackageProductVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class PackageProductService {

    @Autowired
    private PackageProductRepository packageProductRepository;

    /**
     * 패키지 상품 리스트 조회
     * @return
     */
    public List<PackageProductVo> fetchPackageProductList() {
        log.info("PackageProductServer.fetchPackageProductList");
        return packageProductRepository.findAll();
    }

    /**
     * 패키지 상품 등록
     * @param packageProductVo
     */
    public void savePackageProduct(PackageProductVo packageProductVo){
        log.info("PackageProductService.savePackageProduct");
        try {
            packageProductRepository.save(packageProductVo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
