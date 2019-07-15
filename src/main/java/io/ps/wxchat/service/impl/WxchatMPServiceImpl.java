package io.ps.wxchat.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.ps.wxchat.api.WxchatMPSNSApi;
import io.ps.wxchat.service.WxchatMPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WxchatMPServiceImpl implements WxchatMPService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wechatmp.appId}")
    private String appId;

    @Value("${wechatmp.appSecret}")
    private String appSecret;

    @Value("${wechatmp.grant_type}")
    private String grant_type;

    @Value("${wechatmp.lang}")
    private String lang;
    @Autowired
    private WxchatMPSNSApi wxchatMPSNSApi;

    @Override
    public String getTokenByCode(String code) {
        logger.info("ready to renew wechatmp code to access token");
        String string = wxchatMPSNSApi.getTokenByCode(appId, appSecret,code,grant_type);
        JSONObject jsonObject = JSONObject.parseObject(string);

        String access_token = jsonObject.getString("access_token");
        return access_token;
    }

    @Override
    public String getUserByToken(String token) {
        logger.info("ready to renew wechatmp get user by access token");
        String string = wxchatMPSNSApi.getUserByToken(token,appId,lang);
        JSONObject jsonObject = JSONObject.parseObject(string);

        String openid = jsonObject.getString("openid");

        return openid;
    }



}
