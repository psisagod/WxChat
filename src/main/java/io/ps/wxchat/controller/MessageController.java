package io.ps.wxchat.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import io.ps.wxchat.service.WxchatMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
@RequestMapping("/message")
@RestController
@CrossOrigin
public class MessageController {
    @Autowired
    private WxchatMPService wxchatMPService;

    @GetMapping("/getTokenByCode")
    public String getTokenByCode(@RequestParam String code){
        String token = wxchatMPService.getTokenByCode(code);
        return token;
    }
    @GetMapping("/getUserByToken")
    public String getUserByToken(@RequestParam String token){
        String openid = wxchatMPService.getUserByToken(token);
        return openid;
    }

    /**
     * 发送短信验证码
     * @param/number接收手机号码
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public Object sendSms(HttpServletRequest hrequest, String number) {
        JSONObject json = null;
        //生成6位验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);

        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIR0fK3E2hRBIV", "UPtToCBCYaYTZd5jiCjG29qGQNf7GP");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", number);
        request.putQueryParameter("SignName", "psisagod");
        request.putQueryParameter("TemplateCode", "SMS_169641822");
        json = new JSONObject();
        json.put("code", verifyCode);
        String jsonString =json.toJSONString();
        request.putQueryParameter("TemplateParam", jsonString);
        //request.putQueryParameter("AccessKeyId", "LTAIR0fK3E2hRBIV");
        //将验证码存入SESSION
        hrequest.getSession().setAttribute("verifyCode", json);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
