package com.zhouqi.service.impl;

import com.zhouqi.dto.OrderDTO;
import com.zhouqi.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhouqi on 2017/12/8.
 */
@Service
@Slf4j
public class PushMessageServiceImp implements PushMessageService {
    @Autowired
    private WxMpService wxMpService;
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("test");
        templateMessage.setToUser("openid");

        List<WxMpTemplateData> date = Arrays.asList(
                new WxMpTemplateData("first","记得收货"),
                new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","18659863259"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","$"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎下次光临")
        );

        try{
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }catch (WxErrorException e){
            log.error("[微信消息模板] 发送失败,{}", e);
        }
    }
}
