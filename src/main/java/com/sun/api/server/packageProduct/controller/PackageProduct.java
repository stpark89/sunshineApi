package com.sun.api.server.packageProduct.controller;

import com.sun.api.server.packageProduct.service.PackageProductService;
import com.sun.api.server.packageProduct.vo.PackageProductVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Log
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/packageProduct")
public class PackageProduct {

    @Autowired
    private PackageProductService packageProductService;

    /**
     * 리스트 조회
     * @return
     */
    @RequestMapping(value="/fetchPackageProductList")
    public List<PackageProductVo> fetchPackageProductList(){
        log.info("PackageProduct.fetchPackageProductList");
        return packageProductService.fetchPackageProductList();
    }

    @RequestMapping(value="/savePackageProduct")
    public Object savePackageProduct(PackageProductVo packageProductVo){
        log.info("savePackageProduct");
        log.info(packageProductVo.toString());
        try {
            packageProductService.savePackageProduct(packageProductVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new RedirectView("/admin/packageList");
    }
}
