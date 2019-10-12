package com.wen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wen.gmall.bean.PmsBaseSaleAttr;
import com.wen.gmall.bean.PmsProductInfo;
import com.wen.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.wen.gmall.manage.mapper.SpuMapper;
import com.wen.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    /**
     * 根據catalog3Id查找PmsProductInfo
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {

        //設置catalog3Id
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);

        //查找
        List<PmsProductInfo> pmsProductInfos = spuMapper.select(pmsProductInfo);

        return pmsProductInfos;
    }

    /**
     * 查找銷售屬性
     * @return
     */
    @Override
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsProductSaleAttrValueMapper.selectAll();

        return pmsBaseSaleAttrs;
    }
}
