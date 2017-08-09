package com.hwangfantasy.beautify.impl;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * 格式化xml
 * Created by hwangfantasy on 2017/8/9.
 *
 * @link http://www.oschina.net/code/snippet_17793_4733
 */
public class BeautifyXml {
    public BeautifyXml() {
    }

    public static String beautifyXml(String sourceXml) {
        String output = "";
        try {
            SAXReader reader = new SAXReader();
            // 创建一个串的字符输入流
            StringReader in = new StringReader(sourceXml);
            Document doc = reader.read(in);
            // 创建输出格式
            OutputFormat formater = OutputFormat.createPrettyPrint();
            // 设置xml的输出编码
            formater.setEncoding("utf-8");
            // 创建输出(目标)
            StringWriter out = new StringWriter();
            // 创建输出流
            XMLWriter writer = new XMLWriter(out, formater);
            // 输出格式化的串到目标中，执行后。格式化后的串保存在out中。
            writer.write(doc);

            writer.close();
            output = out.toString();
        } catch (Exception e) {
            System.out.println("exception：" + e.getMessage());
        }
        //返回我们格式化后的结果
        return output;
    }
}
