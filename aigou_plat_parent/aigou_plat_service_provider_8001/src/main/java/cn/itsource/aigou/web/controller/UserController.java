package cn.itsource.aigou.web.controller;

import cn.itsource.aigou.common.AjaxResult;
import cn.itsource.plat.domain.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plat")
public class UserController {


    /**
     * 我们学习了restful的风格：
     * Restful就是一个资源定位及资源操作的风格。
     * 不是标准也不是协议，只是一种风格。基于这个风格设计的软件可以更简洁，
     * 更有层次，更易于实现缓存等机制。
     *   地址：定位资源
     *   http动词：标识操作
     *   @RequestBody 把前台提交的body的参数封装到user对象中
     *
     *
     *   post请求：
     *     要测试：浏览器直接发送的是get请求；
     *   postman：
     *   swagger：
     * @param user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){
        //调用service和mapper：
        //模拟service层数据：
        // 通过前台的用户名和密码：作为查询条件从数据库查询：如果有数据就是对的，否则就是错误的：
        // select * from t_user u where u.name=#{name} and u.password=#{password}
        if(user!=null&& !StringUtils.isEmpty(user.getName())&&!StringUtils.isEmpty(user.getPassword())){
          if("admin".equals(user.getName())&&"wwww".equals(user.getPassword())){
              return AjaxResult.me().setMsg("登录成功");
          } else {
              return AjaxResult.me().setSuccess(false).setMsg("登录失败");
          }
        }
        return AjaxResult.me().setSuccess(false).setMsg("登录失败");
    }
}
