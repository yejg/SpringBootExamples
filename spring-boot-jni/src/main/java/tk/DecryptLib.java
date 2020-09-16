package tk;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author yejg
 * @since 2020-07-01
 */
public interface DecryptLib extends Library {

    //DecryptLib INSTANCE = (DecryptLib) Native.loadLibrary("token", DecryptLib.class);
    DecryptLib INSTANCE = (DecryptLib) Native.loadLibrary("/usr/local/runtime_config_root/yejgTest/libtoken.so", DecryptLib.class);

    // String getFundAccount();
    // String getPassword();
    // int decryptToken(String encrptyToken, int length);

    int decryptToken(String encrptyToken, int length, Token.ByReference token);
}
