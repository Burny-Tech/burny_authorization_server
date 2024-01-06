package tech.burny.security.controller.sms;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//8 短信验证码
@RestController
@RequestMapping("/getSmsCaptcha")
public class SmsController {
    @ResponseBody
    @GetMapping("/getSmsCaptcha")
    public Map<String, Object> getSmsCaptcha(String phone, HttpSession session) {
        // 这里应该返回一个统一响应类，暂时使用map代替
        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.OK.value());
        result.put("success", true);
        result.put("message", "获取短信验证码成功.");
        // 固定1234
        result.put("data", "1234");
        // 存入session中
        session.setAttribute(phone, "1234");
        return result;
    }

}
