package com.wen.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wen.gmall.bean.PmsBaseAttrInfo;
import com.wen.gmall.bean.PmsBaseAttrValue;
import com.wen.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.wen.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.wen.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    /**
     * 根據三級分類id獲取  屬性值
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();

        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        return pmsBaseAttrInfos;
    }


    /**
     * 根據屬性id查找屬性值
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();

        pmsBaseAttrValue.setAttrId(attrId);

        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);

        return pmsBaseAttrValues;
    }


    /**
     * 保存 修改 屬性信息（屬性表  屬性值表）
     */
    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        //獲取屬性attrId
        String attrId = pmsBaseAttrInfo.getId();

        //如果屬性attrId爲空，保存
        if(StringUtils.isBlank(attrId)){

            //保存到屬性表
            pmsBaseAttrInfoMapper.insertSelective( pmsBaseAttrInfo );

            //獲取返回的主鍵，用於保存 屬性值
            attrId = pmsBaseAttrInfo.getId();

        }else{//如果屬性attrId不爲空，修改，根據id修改

//            //創建修改的條件
//            Example example = new Example(PmsBaseAttrInfo.class);
//            Example.Criteria criteria = example.createCriteria();
//            criteria.andEqualTo(pmsBaseAttrInfo.getId(),attrId);

            //根據attrId修改
            pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);

            //創建刪除的條件attrid = attrId
            Example example = new Example(PmsBaseAttrValue.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("attrId",attrId);

            //將屬性值全刪
            pmsBaseAttrValueMapper.deleteByExample(example);

        }

        //取出屬性值list
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

        //遍歷屬性值列表
        for (PmsBaseAttrValue pmsBaseAttrValue: attrValueList) {

            //設置attrid
            pmsBaseAttrValue.setAttrId(attrId);

            //保存到屬性值 表
            pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

        }

    }
}
