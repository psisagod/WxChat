package io.ps.wxchat.service;

import com.alibaba.fastjson.JSONObject;

public interface WxchatMPService {

    String getTokenByCode(String code);


    String getUserByToken(String token);
}
