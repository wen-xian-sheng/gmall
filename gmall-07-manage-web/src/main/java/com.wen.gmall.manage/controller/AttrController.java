package com.wen.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wen.gmall.bean.PmsBaseAttrInfo;
import com.wen.gmall.bean.PmsBaseAttrValue;
import com.wen.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class AttrController {

    @Reference
    private AttrService attrService;


    /**
     * 根據三級分類的id查找  屬性
     */
    @ResponseBody
    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id){

        List<PmsBaseAttrInfo> attrInfoList = attrService.getAttrInfoList(catalog3Id);

        return attrInfoList;
    }


    /**
     * 根據屬性id查找屬性值
     */
    @ResponseBody
    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){

        List<PmsBaseAttrValue> attrValueList = attrService.getAttrValueList(attrId);

        return attrValueList;
    }


    /**
     * 保存 修改 屬性信息（屬性表  屬性值表）
     */
    @ResponseBody
    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

       attrService.saveAttrInfo(pmsBaseAttrInfo);


        return "success";
    }

}
