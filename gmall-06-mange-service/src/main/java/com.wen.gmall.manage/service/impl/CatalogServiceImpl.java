package com.wen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wen.gmall.bean.PmsBaseCatalog1;
import com.wen.gmall.bean.PmsBaseCatalog2;
import com.wen.gmall.bean.PmsBaseCatalog3;
import com.wen.gmall.manage.mapper.Catalog1Mapper;
import com.wen.gmall.manage.mapper.Catalog2Mapper;
import com.wen.gmall.manage.mapper.Catalog3Mapper;
import com.wen.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private Catalog1Mapper catalog1Mapper;

    @Autowired
    private Catalog2Mapper catalog2Mapper;

    @Autowired
    private Catalog3Mapper catalog3Mapper;


    /**
     *列出一級catalog1
     * @return
     */
    @Override
    public List<PmsBaseCatalog1> getAllCatalog1() {
        return catalog1Mapper.selectAll();
    }

    /**
     * 列出二級catalog2
     * @param catalog1Id
     * @return
     */
    @Override
    public List<PmsBaseCatalog2> getAllCatalog2(String catalog1Id) {

        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();

        pmsBaseCatalog2.setCatalog1Id(catalog1Id);

        return catalog2Mapper.select(pmsBaseCatalog2);
    }

    /**
     * 列出三級catalog3
     */
    @Override
    public List<PmsBaseCatalog3> getAllCatalog3(String catalog2Id) {

        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();

        pmsBaseCatalog3.setCatalog2Id(catalog2Id);

        return catalog3Mapper.select(pmsBaseCatalog3);
    }


}
