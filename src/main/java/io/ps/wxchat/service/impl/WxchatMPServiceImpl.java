package io.ps.wxchat.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.ps.wxchat.api.WxchatMPApi;
import io.ps.wxchat.service.WxchatMPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WxchatMPServiceImpl implements WxchatMPService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wechatmp.appId}")
    private String appId;

    @Value("${wechatmp.appSecret}")
    private String appSecret;

    @Value("${wechatmp.grant_type}")
    private String grant_type;

    @Autowired
    private WxchatMPApi wxchatMPApi;

    @Override
    public String getTokenByCode(String code) {
        logger.info("ready to renew wechatmp access token");
        JSONObject jsonObject = wxchatMPApi.getTokenByCode(appId, appSecret,code,grant_type);
        String access_token = jsonObject.getString("access_token");
        return access_token;
    }

}
