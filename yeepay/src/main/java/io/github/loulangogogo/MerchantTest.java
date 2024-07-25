package io.github.loulangogogo;

import com.yeepay.yop.sdk.exception.YopClientException;
import com.yeepay.yop.sdk.service.mer.MerClient;
import com.yeepay.yop.sdk.service.mer.MerClientBuilder;
import com.yeepay.yop.sdk.service.mer.request.*;
import com.yeepay.yop.sdk.service.mer.response.*;
import com.yeepay.yop.sdk.service.sys.SysClient;
import com.yeepay.yop.sdk.service.sys.SysClientBuilder;
import com.yeepay.yop.sdk.service.sys.request.MerchantQualUploadRequest;
import com.yeepay.yop.sdk.service.sys.response.MerchantQualUploadResponse;
import io.gitee.loulan_yxq.owner.core.map.MapTool;
import io.gitee.loulan_yxq.owner.core.tool.IdTool;
import io.gitee.loulan_yxq.owner.json.tool.JsonTool;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MerchantTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantTest.class);
    private static final MerClient merclient = MerClientBuilder.builder().build();
    private static final SysClient sysClient = SysClientBuilder.builder().build();


    /**
     * 商户变更
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Test
    public void modify(){
        ProductFeeModifyV2Request request = new ProductFeeModifyV2Request();
        request.setRequestNo("FIX-"+IdTool.simpleUUID());
        request.setParentMerchantNo("10090423999");
        request.setMerchantNo("10090439828");
        request.setNotifyUrl("127.0.0.1");
//        request.setProductInfo("[{\"productCode\":\"MERCHANT_SCAN_ALIPAY_OFFLINE\",\"rateType\":\"SINGLE_PERCENT\",\"percentRate\":\"0.1\",\"undertaker\":\"PLATFORM_MERCHANT\",\"paymentMethod\":\"REAL_TIME\"}]");
//        request.setProductQualificationInfo("{\"mcc\":\"7829\",\"paymentScene\":\"RLZYFW\",\"systemScreenshotUrl\":\"https://staticres.yeepay.com/xxx.文件后缀\",\"specialPermitProcessUrl\":\"https://staticres.yeepay.com/xxx.文件后缀\",\"agreementPhotoUrl\":\"https://staticres.yeepay.com/xxx.文件后缀\"}");
//        request.setSettlementAccountInfo("{ \"settlementDirection\":\"结算方向\", \"bankCode\":\"开户总行编码\", \"bankAccountType\":\"银行账户类型\", \"bankCardNo\":\"银行账户号码\" }");
        request.setFunctionService("[\"SHARE\"]");

        Map<String, Object> map = new HashMap<>();
        map.put("shareScene", "FZ_ALL001");
//        map.put("alipayBackupCount", 20);
//        map.put("wechatBackupCount", 20);
        request.setFunctionServiceQualificationInfo(JsonTool.toJson(map));
        try {
            ProductFeeModifyV2Response response = merclient.productFeeModifyV2(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling MerClient#productFeeModifyV2, ex:", e);
        }

        // {"metadata":{"yopRequestId":"90abbe8a-4444-4b83-ae96-0350ab778061","yopSign":"r/7PjKryoRloXpqaR48AiZ0jCXeblV6w3WCEvNa6xmNa3BTjnKwQkvszS9dJcLTfvz9RdAK5ZYdVZs5JAFFSdBf488Xg7NxnI0CZkrKI+IrYmK6MSWH+bU20lwOYC/x0lBitzpH0bxINWOqRptsfZpd5i/C+jkoP8kthYbfs1FIg5DsdtS+bI03IiN4OnnqiP/INd8vhROLFM/BwmUfMAyHzh0QA+3PlElSWntCLQvTbStNpUdCz+2gVuv0bC3bZrvNfswbqesj2aR150gFiuwck9mkMbLtoQzYY0A5Lm0bIdr5QftHhvbWJQ4jdr1e5iV6bRHWnri91ziqO2nyaTw==","contentLength":269,"contentType":"application/json;charset=UTF-8","date":"2024-07-24T16:23:33.000+08:00","server":"nginx"},"result":{"returnCode":"NIG00000","returnMsg":"请求成功","requestNo":"FIX-0f873433b7db49749458e5dddab60c8e","applicationNo":"CPBGLC20240724162333260949","applicationStatus":"REVIEWING","merchantNo":"10090439828"}}
    }

    @Test
    public void modifyQuery() {
        ProductModifyQueryV2Request request = new ProductModifyQueryV2Request();
        request.setRequestNo("FIX-0f873433b7db49749458e5dddab60c8e");
        try {
            ProductModifyQueryV2Response response = merclient.productModifyQueryV2(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling MerClient#productModifyQueryV2, ex:", e);
        }
    }

    @Test
    public void register() {
        RegisterContributeMerchantV2Request request = new RegisterContributeMerchantV2Request();
        request.setRequestNo("HLTQ-TYCM-"+IdTool.simpleUUID());
        request.setBusinessRole("SETTLED_MERCHANT");

        Map<String, Object> merchantSubjectInfo = MapTool.map();
        merchantSubjectInfo.put("signType", "ENTERPRISE");
        merchantSubjectInfo.put("licenceNo", "91140109MA0M3PL64W");
        merchantSubjectInfo.put("licenceUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719386332984-a7c227cf-1d57-4ec2-b4b1-4b5152161484-yfBTAeCmXACNjjmhXVXK.jpg");
        merchantSubjectInfo.put("signName", "太原瀚才传媒有限公司");
        merchantSubjectInfo.put("shortName", "合力团气");
        merchantSubjectInfo.put("openAccountLicenceUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389596850-b742b237-e2bf-4a23-9db0-33a3dc55eed8-rKzSMsiVeHnxGSoSVWpU.jpg");
        request.setMerchantSubjectInfo(JsonTool.toJson(merchantSubjectInfo));

        Map<String, Object> merchantCorporationInfo = MapTool.map();
        merchantCorporationInfo.put("legalName", "成海兵");
        merchantCorporationInfo.put("legalLicenceType", "ID_CARD");
        merchantCorporationInfo.put("legalLicenceNo", "142326197906040119");
        merchantCorporationInfo.put("legalLicenceFrontUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389232958-493bcdbe-fd91-4d63-b461-8a7deb9dce89-wuozVLBIHlZBsfJPMgsg.jpg");
        merchantCorporationInfo.put("legalLicenceBackUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389257192-d424c29b-4ba9-4048-9a5e-2d235a233ae2-tdKFpBQPOfIsvwNKGQtW.jpg");
        request.setMerchantCorporationInfo(JsonTool.toJson(merchantCorporationInfo));

        Map<String, Object> merchantContactInfo = MapTool.map();
        merchantContactInfo.put("contactName", "张海燕");
        merchantContactInfo.put("contactLicenceNo", "142326198001170124");
        merchantContactInfo.put("contactMobile", "17835149888");
        merchantContactInfo.put("contactEmail", "597123920@qq.com ");
        merchantContactInfo.put("servicePhone", "4009997658");
        request.setMerchantContactInfo(JsonTool.toJson(merchantContactInfo));

        Map<String, Object> businessAddressInfo = MapTool.map();
        businessAddressInfo.put("province", "140000");
        businessAddressInfo.put("city", "140100");
        businessAddressInfo.put("district", "140109");
        businessAddressInfo.put("address", "小井峪街道春居南路创客大厦701室");
        request.setBusinessAddressInfo(JsonTool.toJson(businessAddressInfo));

        Map<String, Object> settlementAccountInfo = MapTool.map();
        settlementAccountInfo.put("settlementDirection", "ACCOUNT");
        settlementAccountInfo.put("bankAccountType", "ENTERPRISE_ACCOUNT");
        settlementAccountInfo.put("bankCardNo", "140521357485");
        settlementAccountInfo.put("cnapsCode", "104161004487");
        request.setSettlementAccountInfo(JsonTool.toJson(settlementAccountInfo));

        request.setNotifyUrl("http://127.0.0.1");

        Map<String, Object> productQualificationInfo = MapTool.map();
        productQualificationInfo.put("paymentScene", "GYSDK");
        productQualificationInfo.put("agreementPhotoUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719394892152-993ca505-0d3c-4647-a394-86adea3f9a79-nKktgrLnygPqPyeqtYrR.heic");

        request.setProductQualificationInfo(JsonTool.toJson(productQualificationInfo));
        try {
            System.out.println(JsonTool.toJson(request));
            RegisterContributeMerchantV2Response response = merclient.registerContributeMerchantV2(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            e.printStackTrace();
        }

        // {"headers":{},"requestNo":"HLTQ-TYCM-99ca8d228893408e80b69ccb826c52fd","businessRole":"SETTLED_MERCHANT","merchantSubjectInfo":"{\"licenceUrl\":\"http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719386332984-a7c227cf-1d57-4ec2-b4b1-4b5152161484-yfBTAeCmXACNjjmhXVXK.jpg\",\"signName\":\"太原瀚才传媒有限公司\",\"signType\":\"ENTERPRISE\",\"licenceNo\":\"91140109MA0M3PL64W\",\"shortName\":\"合力团气\",\"openAccountLicenceUrl\":\"http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389596850-b742b237-e2bf-4a23-9db0-33a3dc55eed8-rKzSMsiVeHnxGSoSVWpU.jpg\"}","merchantCorporationInfo":"{\"legalName\":\"成海兵\",\"legalLicenceNo\":\"142326197906040119\",\"legalLicenceBackUrl\":\"http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389257192-d424c29b-4ba9-4048-9a5e-2d235a233ae2-tdKFpBQPOfIsvwNKGQtW.jpg\",\"legalLicenceType\":\"ID_CARD\",\"legalLicenceFrontUrl\":\"http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389232958-493bcdbe-fd91-4d63-b461-8a7deb9dce89-wuozVLBIHlZBsfJPMgsg.jpg\"}","merchantContactInfo":"{\"contactMobile\":\"17835149888\",\"servicePhone\":\"4009997658\",\"contactEmail\":\"597123920@qq.com \",\"contactName\":\"张海燕\",\"contactLicenceNo\":\"142326198001170124\"}","businessAddressInfo":"{\"address\":\"小井峪街道春居南路食容大厦701室\",\"province\":\"140000\",\"city\":\"140100\",\"district\":\"140109\"}","settlementAccountInfo":"{\"bankAccountType\":\"ENTERPRISE_ACCOUNT\",\"bankCardNo\":\"140521357485\",\"settlementDirection\":\"ACCOUNT\",\"cnapsCode\":\"104161004487\"}","notifyUrl":"http://127.0.0.1","productQualificationInfo":"{\"paymentScene\":\"GYSDK\",\"agreementPhotoUrl\":\"http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719394892152-993ca505-0d3c-4647-a394-86adea3f9a79-nKktgrLnygPqPyeqtYrR.heic\"}","operationId":"registerContributeMerchantV2"}
        // {"metadata":{"yopRequestId":"69170eea-eae1-4e7b-bbc7-1993714d83c4","yopSign":"qXnR6YVIH1jzcLQruOCU13RoMZ5VFUXB2q85ESUxoKm9ZoQrscMFiyxfz/n2ZBx2rOrs1/SOJWwTDtTOVocYng8YR6uPbrB59e+jlYSDYeVltMLs4dxF6woqkD2SQ27HYMztB7oxzo+2rPBY2NlsbmWar0NtMR5KjQhhYISXxr9Yi8ZJqUOP6LmkEYRYz31faiOg0KQcZu/RGKHWk6Z0B/7X63evXwxCCNozY8l2YgvJS858GiptnkIn9umrfjRNwsIeSYm2VEAp/Ic7AAqUETBivqcz6c9Oa+jd/TUUWmiK9ocQWpQzw2chsejys2Sm46x8sfGoNixA4dyHGJQ2IA==","contentLength":275,"contentType":"application/json;charset=UTF-8","date":"2024-06-26T17:44:11.000+08:00","server":"elb"},"result":{"returnCode":"NIG00000","returnMsg":"请求成功","requestNo":"HLTQ-TYCM-99ca8d228893408e80b69ccb826c52fd","applicationNo":"TYSHRW20240626174411214720","applicationStatus":"REVIEWING","merchantNo":"10090439828"}}

        // {"metadata":{"yopRequestId":"53cac5d5-9eac-478a-ad13-f919001f61a6","yopSign":"NfRDf6Zv27pVonX+vb0tu46r3dfYexkI7YVDAku+B2C+vOzGQ/yYYPtVEaYwurjfcsPdfT5dz8weUXhEV5vY17rljSIC4hs4NzTncaePrKlJ1zMUqxHlHUevOtdlpyEWwgMmXTp5mNjyzstEN870cIgh0bH0Fv9wBd7adt0hqOW1EvqKwT6ZlxSuggjI784MVXCh0e2t2Cvh2ZjKW+rO8V5mMUGT9gleWrZ+S+waT1YQ/4HB7wbYS9ZodqpK3iCP0moK+X1egkrKr9vUlkvIeg3531nPjZxAp7jJFyrWTxluyKsZWMpbcI2PF3nXaN84HaLixLSqzR4A9hA/PR9qEg==","contentLength":275,"contentType":"application/json;charset=UTF-8","date":"2024-06-26T18:13:49.000+08:00","server":"nginx"},"result":{"returnCode":"NIG00000","returnMsg":"请求成功","requestNo":"HLTQ-TYCM-45292293638b42bb95dcb5e9a138645c","applicationNo":"TYSHRW20240626181349280163","applicationStatus":"REVIEWING","merchantNo":"10090439922"}}
    }

    @Test
    public void registerByPeople() {
        RegisterContributeMicroV2Request request = new RegisterContributeMicroV2Request();
        request.setRequestNo("TEST-" + IdTool.simpleUUID());
        request.setBusinessRole("SETTLED_MERCHANT");

        Map<String, Object> merchantSubjectInfo = MapTool.map();
        merchantSubjectInfo.put("signName", "测试人员");
        merchantSubjectInfo.put("shortName", "测试");
        request.setMerchantSubjectInfo(JsonTool.toJson(merchantSubjectInfo));

        Map<String, Object> merchantCorporationInfo = MapTool.map();
        merchantCorporationInfo.put("mobile", "18509376997");
        merchantCorporationInfo.put("legalLicenceType", "ID_CARD");
        merchantCorporationInfo.put("legalLicenceNo", "142326197906040119");
        merchantCorporationInfo.put("legalLicenceFrontUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389232958-493bcdbe-fd91-4d63-b461-8a7deb9dce89-wuozVLBIHlZBsfJPMgsg.jpg");
        merchantCorporationInfo.put("legalLicenceBackUrl", "http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389257192-d424c29b-4ba9-4048-9a5e-2d235a233ae2-tdKFpBQPOfIsvwNKGQtW.jpg");
        request.setMerchantCorporationInfo(JsonTool.toJson(merchantCorporationInfo));

        Map<String, Object> businessAddressInfo = MapTool.map();
        businessAddressInfo.put("province", "140000");
        businessAddressInfo.put("city", "140100");
        businessAddressInfo.put("district", "140109");
        businessAddressInfo.put("address", "小井峪街道春居南路创客大厦701室");
        request.setBusinessAddressInfo(JsonTool.toJson(businessAddressInfo));

        Map<String, Object> settlementAccountInfo = MapTool.map();
        settlementAccountInfo.put("settlementDirection", "BANKCARD");
        settlementAccountInfo.put("bankAccountType", "DEBIT_CARD");
        settlementAccountInfo.put("bankCardNo", "123456789456");
        settlementAccountInfo.put("cnapsCode", "104161004487");
        request.setAccountInfo(JsonTool.toJson(settlementAccountInfo));

        request.setNotifyUrl("http://127.0.0.1");
        try {
            RegisterContributeMicroV2Response response = merclient.registerContributeMicroV2(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            e.printStackTrace();
        }

        // TEST-524fce5b617143d0998f9f3d9cc701e4
    }

    @Test
    public void registerQuery() {
        RegisterQueryV2Request request = new RegisterQueryV2Request();
//        request.setRequestNo("HLTQ-TYCM-99ca8d228893408e80b69ccb826c52fd");
        request.setRequestNo("TEST-524fce5b617143d0998f9f3d9cc701e4");
        try {
            RegisterQueryV2Response response = merclient.registerQueryV2(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void upload() throws IOException {
        // 营业执照： http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719386332984-a7c227cf-1d57-4ec2-b4b1-4b5152161484-yfBTAeCmXACNjjmhXVXK.jpg
        // 正面: http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389232958-493bcdbe-fd91-4d63-b461-8a7deb9dce89-wuozVLBIHlZBsfJPMgsg.jpg
        // 反面：http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389257192-d424c29b-4ba9-4048-9a5e-2d235a233ae2-tdKFpBQPOfIsvwNKGQtW.jpg
        // 开户：http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719389596850-b742b237-e2bf-4a23-9db0-33a3dc55eed8-rKzSMsiVeHnxGSoSVWpU.jpg
        // 授权： http://staticres.yeepay.com/jcptb-merchant-netinjt05/2024/06/26/merchant-1719394892152-993ca505-0d3c-4647-a394-86adea3f9a79-nKktgrLnygPqPyeqtYrR.heic
        MerchantQualUploadRequest request = new MerchantQualUploadRequest();

        FileInputStream inputStream = new FileInputStream("file/tycm_zjz.jpg");
        File tempFile = File.createTempFile(IdTool.simpleUUID(), "");
        FileUtils.copyInputStreamToFile(inputStream, tempFile);

        request.setMerQual(tempFile);
        try {
            MerchantQualUploadResponse response = sysClient.merchantQualUpload(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws IOException {
        FileInputStream inputStream = new FileInputStream("file/tycm_zjz.jpg");
        File tempFile = File.createTempFile(IdTool.simpleUUID(), "");
        FileUtils.copyInputStreamToFile(inputStream, tempFile);
        FileOutputStream outputStream = new FileOutputStream("file/ss.jpg");
        FileUtils.copyFile(tempFile, outputStream);

    }
}
