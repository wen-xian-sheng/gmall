package com.wen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wen.gmall.bean.*;
import com.wen.gmall.service.AttrService;
import com.wen.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class CatalogController {

    @Reference
    private CatalogService catalogService;

    @Reference
    private AttrService attrService;

    /**
     * 一級分類
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getAllCatalog1(){

        return catalogService.getAllCatalog1();
    }


    /**
     * 二級分類
     * @param catalog1Id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getAllCatalog2(String catalog1Id){

        return catalogService.getAllCatalog2(catalog1Id);
    }

    /**
     * 三級分類
     * @param catalog2Id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getAllCatalog3(String catalog2Id){

        return catalogService.getAllCatalog3(catalog2Id);
    }

    /**
     * 根據三級分類的id查找  屬性
     */
    @ResponseBody
    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id){

        List<PmsBaseAttrInfo> attrInfoList = attrService.getAttrInfoList(catalog3Id);

        return attrInfoList;
    }

}
