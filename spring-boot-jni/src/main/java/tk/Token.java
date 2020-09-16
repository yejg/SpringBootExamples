package tk;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * @author yejg
 * @since 2020-07-01
 */
public class Token extends Structure {

    public String sFundAccount = "";
    public String sPassword = "";

    public static class ByReference extends Token implements Structure.ByReference {
    }

    public static class ByValue extends Token implements Structure.ByValue {
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("sFundAccount", "sPassword");
    }
}
