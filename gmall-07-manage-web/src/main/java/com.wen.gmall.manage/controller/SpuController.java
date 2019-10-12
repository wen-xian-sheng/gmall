package com.wen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wen.gmall.bean.*;
import com.wen.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class SpuController {

    @Reference
    private SpuService spuService;

    /**
     * 根據catalog3Id查找PmsProductInfo
     * @param catalog3Id
     * @return
     */
    @ResponseBody
    @RequestMapping("spuList")
    public List<PmsProductInfo> getSpuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos = spuService.getSpuList(catalog3Id);

        return pmsProductInfos;
    }

    /**
     * 查找銷售屬性
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = spuService.getBaseSaleAttrList();

        return pmsBaseSaleAttrs;
    }

}
