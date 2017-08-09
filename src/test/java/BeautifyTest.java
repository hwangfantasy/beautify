import com.hwangfantasy.beautify.impl.*;
import org.junit.Test;

/**
 * Created by hwangfantasy on 2017/8/9.
 */
public class BeautifyTest {
    @Test
    public void beautifyJsonTest(){
        String str1 = "{'a':1,'b':2}";
        // 无嵌套
        String out1 = BeautifyJson.beautifyJson(str1);
        System.out.println(out1);

        // 一层嵌套
        String str2 = "{'a':1,'b':2,'c':{'d':4,'e':5}}";
        String out2 = BeautifyJson.beautifyJson(str2);
        System.out.println(out2);

        // 二层嵌套
        String str3 = "{'a':1,'b':2,'c':{'d':4,'e':5,'f':{'g':7,'h':8}}}";
        String out3 = BeautifyJson.beautifyJson(str3);
        System.out.println(out3);

        // 数组
        String str4 = "{[ { 'firstName':'Bill' , 'lastName':'Gates' }, { 'firstName':'George' , 'lastName':'Bush' }, { 'firstName':'Thomas' , 'lastName': 'Carter' } ]}";
        String out4 = BeautifyJson.beautifyJson(str4);
        System.out.println(out4);
    }

    @Test
    public void beautifyJavaTest(){
        String source = "package com.hwangfantasy.beautify;\n" +
                "\n" +
                "import com.alibaba.druid.sql.SQLUtils;\n" +
                "/**\n" +
                " * Created by hwangfantasy on 2017/8/9.\n" +
                " * 采用alibaba 的druid 的sqlutils\n" +
                " */\n" +
                "public class BeautifySql {\n" +
                "\n" +
                "    public BeautifySql() {}\n" +
                "    public static String beautifySql(String sourceSql, String sqlType){return SQLUtils.format(sourceSql,sqlType);}}\n";

        String output = BeautifyJava.beautifyJava(source);
        System.out.println(output);
    }

    @Test
    public void beautifyHtmlTest(){
        String source1 = "2132ewdsdaasda";
        String output1 = BeautifyHtml.beautifyHtml(source1);
        System.out.println(output1);

        String source2 = "<html> <head></head> <body><p>你好</p><a/></body></html>";
        String output2 = BeautifyHtml.beautifyHtml(source2);
        System.out.println(output2);
    }

    @Test
    public void beautifyXmlTest(){
        String str = "<RequestData><HeadData><UserCode>sh1_admin</UserCode><UserName>sh1_admin</UserName><UserCompanyCode>3107</UserCompanyCode><UserCompanyName>上海分公司一部</UserCompanyName><RequestType>03</RequestType></HeadData><BodyData><ReportId>113100000033</ReportId><Insurant>a5rfg87</Insurant><NumberPlate>沪E78612</NumberPlate><EngineModel></EngineModel><CarVin></CarVin><AccidentDate>2011-02-25 15:07:00</AccidentDate><ReportDate>2011-02-25 15:07:00</ReportDate><Province>310000</Province><City>310100</City><District></District><AccidentPlace>1</AccidentPlace><AccidentLongitude></AccidentLongitude><AccidentLatitude></AccidentLatitude><SurveyLongitude></SurveyLongitude><SurveyLatitude></SurveyLatitude><SceneReportFlag></SceneReportFlag><Reporter></Reporter><ReporterTel></ReporterTel><SurveyPlace></SurveyPlace><OperatorId>3525</OperatorId><OperatorName>sh_admin</OperatorName><ReportDealId>30000800</ReportDealId><ReportDealName>江苏分公司</ReportDealName><CompanyName></CompanyName><CustomerTypeCode></CustomerTypeCode><ForcePolicyId>a5rfg87a5rfg87a5rfg87</ForcePolicyId><BizPolicyId></BizPolicyId><Index>0</Index><FieldName>5</FieldName></BodyData></RequestData>";
        String output = BeautifyXml.beautifyXml(str);
        System.out.println(output);
    }

    @Test
    public void beautifyJs(){
        String str =
                "/**\n" +
                " * 车险用于将input域中的值转成json的方法\n" +
                " * @returns\t当前页面input域中所有的值组成的ajax中调用的data\n" +
                " */\n" +
                "function inputToJSON() {var jsondata = \"{\\\"a\\\":\\\"1\\\"\"; //为了让json更好拼将第一个“,”前的值设置一个不用的参数a:1\n" +
                "    $(\"input\").each(function(i) {if ($(this).attr(\"name\") != \"carCodex\" && $(this).attr(\"name\") != \"carInfo.EADJson\" //name=carInfo.EADJson的值是个json串会影响json生成，需要过滤掉\n" +
                "            && $(this).attr(\"name\") != undefined) { //name=carCodex的值是个json串会影响json生成，需要过滤掉 \n" +
                "            jsondata = jsondata + \",\\\"\" + $(this).attr(\"name\") + \"\\\":\\\"\" + $(this).val() + \"\\\"\";\n" +
                "        }});jsondata = jsondata + \"}\";jsondata = jsondata.replace(/\\s/g, \"\");return $.parseJSON(jsondata);}function configJQ(data) {if (\"1\" == data.startDateJqFlag) {$(\"#jqType\").parent().hide();$(\"#jqTimeLable\").show();} else if (\"0\" == data.startDateJqFlag) {$(\"#jqType\").parent().show();$(\"#jqTimeLable\").hide();}}";
        String output = BeautifyJs.beautifyJs(str);
        System.out.println(output);
    }
}
