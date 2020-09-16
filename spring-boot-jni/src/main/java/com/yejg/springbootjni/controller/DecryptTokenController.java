package com.yejg.springbootjni.controller;

import com.yejg.springbootjni.bean.DecryptResult;
import com.yejg.springbootjni.util.DecryptUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yejg
 * @since 2020-07-01
 */
@RestController
public class DecryptTokenController {

    @RequestMapping("/decrypt")
    public DecryptResult decryptToken(String token) {
        DecryptResult result = DecryptUtil.decrypt(token);
        return result;
    }

}
