package xyz.frt.demo.controller;

import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.common.UnauthorizedException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author phw
 * @date Created in 04-13-2018
 * @description 统一处理框架异常类
 */
@RestControllerAdvice
public class ExceptionController extends BaseController {

    /**
     * 捕获Shiro异常
     * @param se
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public JsonResult handleShiroException(ShiroException se) {
        return JsonResult.error(401, se.getMessage());
    }

    /**
     * 捕获自定义异常
     * @param ue
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public JsonResult handleUnauthorizedException(UnauthorizedException ue) {
        return JsonResult.error(401, ue.getMessage());
    }

    /**
     * 捕获其他异常
     * @param req
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public JsonResult handlerException(HttpServletRequest req, Throwable e) {
        return JsonResult.error(getStatus(req).value(), e.getMessage());
    }

    /**
     * 获取网络状态码
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}
