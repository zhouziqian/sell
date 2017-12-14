package com.zhouqi.conntroller;

import com.lly835.bestpay.model.PayResponse;
import com.zhouqi.dto.OrderDTO;
import com.zhouqi.enums.ResultEnum;
import com.zhouqi.exception.SellException;
import com.zhouqi.service.OrderService;
import com.zhouqi.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author zhouqi on 2017/12/5.
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDERNOTEXIST);
        }
        //2.发起支付
        PayResponse payResponse=payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);

        return new ModelAndView("pay/create",map);
    }

    @PostMapping("notify")
    public ModelAndView notify(@RequestBody String notifyData){
        PayResponse payResponse=payService.notify(notifyData);

        //返回微信处理结果
        return new ModelAndView("pay/success");
    }
}
