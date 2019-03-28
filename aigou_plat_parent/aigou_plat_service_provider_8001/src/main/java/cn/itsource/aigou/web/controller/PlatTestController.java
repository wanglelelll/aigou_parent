package cn.itsource.aigou.web.controller;

import cn.itsource.aigou.common.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/plat")
public class PlatTestController {

    @RequestMapping("/a")
    public AjaxResult test(){
        Map<String,String> map =new HashMap<>();
        map.put("color","aaa");
      return    AjaxResult.me().setSuccess(false).setMsg("操作失败").setObject(map);

    }
}
