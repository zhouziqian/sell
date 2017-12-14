package com.zhouqi.handler;

import com.zhouqi.exception.ResponseBankException;
import com.zhouqi.exception.SellException;
import com.zhouqi.exception.SellerAuthorizeException;
import com.zhouqi.utils.ResultVOUtil;
import com.zhouqi.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhouqi on 2017/12/7.
 */
@ControllerAdvice
public class SellExceptionHandler {
    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        //TODO
        return new ModelAndView("redirect:".concat("http://localhost:8080/sell/wechat/qrAuthorize"));
    }


    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handlerResponseBankException(){

    }
}
