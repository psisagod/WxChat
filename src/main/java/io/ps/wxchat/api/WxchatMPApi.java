package io.ps.wxchat.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wechatmp", url = "https://api.weixin.qq.com/sns/sns/oauth2")
public interface WxchatMPApi {

    @GetMapping("/access_token")
    JSONObject getTokenByCode(@RequestParam String appid,
                              @RequestParam String secret,
                              @RequestParam String code,
                              @RequestParam String grant_type);


}
