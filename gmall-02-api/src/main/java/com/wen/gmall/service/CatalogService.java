package com.wen.gmall.service;

import com.wen.gmall.bean.PmsBaseCatalog1;
import com.wen.gmall.bean.PmsBaseCatalog2;
import com.wen.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    List<PmsBaseCatalog1> getAllCatalog1();

    List<PmsBaseCatalog2> getAllCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getAllCatalog3(String catalog1Id);

}
