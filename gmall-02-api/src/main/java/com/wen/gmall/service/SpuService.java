package com.wen.gmall.service;

import com.wen.gmall.bean.PmsBaseSaleAttr;
import com.wen.gmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> getSpuList(String catalog3Id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();
}
