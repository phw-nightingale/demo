package xyz.frt.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.frt.demo.common.JsonResult;

/**
 * @author phw
 * @date Created in 04-09-2018
 * @description
 */
@RestController
public class NotFoundController extends BaseController {

    @GetMapping("/401")
    public JsonResult contentNotFound() {
        return JsonResult.error("认证失败.");
    }

}
