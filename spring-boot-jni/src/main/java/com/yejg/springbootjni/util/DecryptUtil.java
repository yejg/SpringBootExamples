package com.yejg.springbootjni.util;

import com.yejg.springbootjni.bean.DecryptResult;
import tk.DecryptLib;
import tk.Token;

/**
 * @author yejg
 * @since 2020-07-01
 */
public class DecryptUtil {

    private static DecryptLib instance = DecryptLib.INSTANCE;

    public static DecryptResult decrypt(String token) {

        Token.ByReference t = new Token.ByReference();

        int code = instance.decryptToken(token, token.length(), t);

        return new DecryptResult(code, t.sFundAccount, t.sPassword);
    }

}
