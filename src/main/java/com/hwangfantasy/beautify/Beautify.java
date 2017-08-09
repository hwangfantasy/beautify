package com.hwangfantasy.beautify;

import com.hwangfantasy.beautify.enums.Source;
import com.hwangfantasy.beautify.impl.*;

/**
 * Created by hwangfantasy on 2017/8/9.
 */
public class Beautify {
    public Beautify() {
    }

    /**
     * @param source 待格式化字符串
     * @param type   {@link com.hwangfantasy.beautify.enums.Source}
     * @param extend 拓展字段，比如sql的type
     * @return
     */
    public static String beautify(String source, Source type, String extend) {
        String output = "";
        switch (type) {
            case HTML:
                output = BeautifyHtml.beautifyHtml(source);
                break;
            case JAVA:
                output = BeautifyJava.beautifyJava(source);
                break;
            case JSON:
                output = BeautifyJson.beautifyJson(source);
                break;
            case SQL:
                output = BeautifySql.beautifySql(source,extend);
                break;
            case XML:
                output = BeautifyXml.beautifyXml(source);
                break;
            case CSS:
                break;
            case JS:
                break;
            default:
                break;
        }
        return output;
    }
}
