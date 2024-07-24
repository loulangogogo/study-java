package io.github.loulangogogo;

import com.yeepay.yop.sdk.exception.YopClientException;
import com.yeepay.yop.sdk.service.aggpay.AggpayClient;
import com.yeepay.yop.sdk.service.aggpay.AggpayClientBuilder;
import com.yeepay.yop.sdk.service.aggpay.request.PayLinkRequest;
import com.yeepay.yop.sdk.service.aggpay.request.PrePayRequest;
import com.yeepay.yop.sdk.service.aggpay.response.PayLinkResponse;
import com.yeepay.yop.sdk.service.aggpay.response.PrePayResponse;
import com.yeepay.yop.sdk.service.mer.MerClient;
import com.yeepay.yop.sdk.service.mer.MerClientBuilder;
import com.yeepay.yop.sdk.service.sys.SysClient;
import com.yeepay.yop.sdk.service.sys.SysClientBuilder;
import io.gitee.loulan_yxq.owner.core.tool.IdTool;
import io.gitee.loulan_yxq.owner.json.tool.JsonTool;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/*********************************************************
 ** 订单测试
 ** <br><br>
 ** Date: Created in 2024/7/17 16:15
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class OrderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantTest.class);
    private static final MerClient merclient = MerClientBuilder.builder().build();
    private static final SysClient sysClient = SysClientBuilder.builder().build();
    // 该Client线程安全，请使用单例模式，多次请求共用
    private static final AggpayClient api = AggpayClientBuilder.builder().build();
    @Test
    public void orderApply() {
        PrePayRequest request = new PrePayRequest();
        // 10090423999
        request.setParentMerchantNo("10090439828");
        request.setMerchantNo("10090439828");
        request.setOrderId("TEST-"+ IdTool.simpleUUID());
        request.setOrderAmount(new BigDecimal("0.01"));
//        request.setNotifyUrl("https://notify.merchant.com/xxx");
        request.setMemo("测试数据");
        request.setGoodsName("测试交易");
        request.setFundProcessType("REAL_TIME");
        request.setPayWay("USER_SCAN");
        request.setChannel("WECHAT");
        request.setScene("OFFLINE");
//        request.setAppId("appId12345");
//        request.setUserId("userId12345");
        request.setUserIp("127.0.0.1");
//        request.setChannelPromotionInfo("channelPromotionInfo_example");
//        request.setIdentityInfo("{\"identityVerifyType\":\"Y\",\"payerIdType\":\"IDENTITY_CARD\",\"payerNumber\":\"234512198006252456\",\"payerName\":\"名字\"}");
//        request.setLimitCredit("N");
//        request.setToken("83BCDF29CFACB4411533080B67864EF8C907CCDC5E10A707C285FEA10CDB8221");
//        request.setUniqueOrderNo("1012202101070000001989946571");
//        request.setCsUrl("csUrl_example");
//        request.setAccountLinkInfo("{accountProvider\":\"BOL\",\"token\":\"xxx\"}");
//        request.setYpPromotionInfo("自定义支付立减：[{\"amount\":\"0.01\",\"type\":\"CUSTOM_REDUCTION\"}],自定义补贴商户[{\"type\":\"CUSTOM_ALLOWANCE\"}]");
//        request.setBankCode("BOC");
//        request.setBusinessInfo("businessInfo_example");
//        request.setUserAuthCode("userAuthCode_example");
//        request.setChannelActivityInfo("channelActivityInfo_example");
//        request.setTerminalId("terminalId_example");
//        request.setTerminalSceneInfo("{\"storeId\":\"门店id\",\"storeName\":\"门店名称\",\"operatorId\":\"商户操作员编号\",\"alipayStoreId\":\"支付宝的店铺编号\",\"areaCode\":\"门店行政区划码\",\"address\":\"门店详细地址\"}");
//        request.setYpAccountBookNo("ypAccountBookNo_example");
//        request.setTerminalInfo("{\"shopName\":\"网点名称\",\"shopCustomerNumber\":\"网点编号\"}");
//        request.setProductInfo("[{\"id\":\"1234\"}]");
//        request.setDivideDetail("divideDetail_example");
//        request.setDivideNotifyUrl("divideNotifyUrl_example");
//        request.setFeeSubsidyInfo("[{\"subsidyMerchantNo\":\"10080009498\",\"subsidyAccountType\":\"FEE_ACCOUNT\",\"subsidyType\":\"ABSOLUTE\",\"subsidyProportion\":\"\",\"subsidyCalculateType\":\"SINGLE_PERCENT\",\"subsidyPercentFee\":\"0.6\",\"subsidyFixedFee\":\"\",\"subsidySingleMaxFee\":\"\"}]");
//        request.setAgreementId("agreementId_example");
//        request.setCreditOrderId("creditOrderId_example");
        try {
            PrePayResponse response = api.prePay(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling AggpayClient#prePay, ex:", e);
        }
    }

    @Test
    public void orderApply2() {
        PayLinkRequest request = new PayLinkRequest();
        request.setParentMerchantNo("10090439828");
        request.setMerchantNo("10090439828");
        request.setOrderId("TEST-"+ IdTool.simpleUUID());
        request.setOrderAmount(new BigDecimal("0.01"));
        request.setExpiredTime("2024-07-23 19:52:21");
//        request.setNotifyUrl("127.0.0.1");
        request.setMemo("测试数据");
        request.setGoodsName("测试支付");
        request.setFundProcessType("REAL_TIME");
        request.setScene("{\"WECHAT\":\"OFFLINE\",\"ALIPAY\":\"OFFLINE\"}");
//        request.setAppId("appId12345");
//        request.setChannelSpecifiedInfo("{\"hbFqNum\":\"3\",\"hbFqSellerPercent\":\"0\",\"sysServiceProviderId\":\"\",\"isEnterprisePay\":\"N\"}");
//        request.setChannelPromotionInfo("channelPromotionInfo_example");
//        request.setIdentityInfo("{\"identityVerifyType\":\"Y\",\"payerIdType\":\"IDENTITY_CARD\",\"payerNumber\":\"234512198006252456\",\"payerName\":\"名字\"}");
//        request.setLimitCredit("N");
//        request.setCsUrl("csUrl_example");
//        request.setYpPromotionInfo("自定义支付立减：[{\"amount\":\"0.01\",\"type\":\"CUSTOM_REDUCTION\"}],自定义补贴商户[{\"type\":\"CUSTOM_ALLOWANCE\"}]");
//        request.setBusinessInfo("businessInfo_example");
//        request.setToken("83BCDF29CFACB4411533080B67864EF8C907CCDC5E10A707C285FEA10CDB8221");
//        request.setYpAccountBookNo("ypAccountBookNo_example");
//        request.setProductInfo("[{\"id\":\"1234\"}]");
//        request.setDivideDetail("divideDetail_example");
//        request.setDivideNotifyUrl("divideNotifyUrl_example");
//        request.setFeeSubsidyInfo("[{\"subsidyMerchantNo\":\"10080009498\",\"subsidyAccountType\":\"FEE_ACCOUNT\",\"subsidyType\":\"ABSOLUTE\",\"subsidyProportion\":\"\",\"subsidyCalculateType\":\"SINGLE_PERCENT\",\"subsidyPercentFee\":\"0.6\",\"subsidyFixedFee\":\"\",\"subsidySingleMaxFee\":\"\"}]");
        try {
            PayLinkResponse response = api.payLink(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling AggpayClient#payLink, ex:", e);
        }
    }
}
