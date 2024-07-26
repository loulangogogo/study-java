package io.github.loulangogogo;

import com.yeepay.yop.sdk.exception.YopClientException;
import com.yeepay.yop.sdk.service.account.AccountClient;
import com.yeepay.yop.sdk.service.account.AccountClientBuilder;
import com.yeepay.yop.sdk.service.account.request.TransferB2bOrderRequest;
import com.yeepay.yop.sdk.service.account.response.TransferB2bOrderResponse;
import com.yeepay.yop.sdk.service.aggpay.AggpayClient;
import com.yeepay.yop.sdk.service.aggpay.AggpayClientBuilder;
import com.yeepay.yop.sdk.service.aggpay.request.PayLinkRequest;
import com.yeepay.yop.sdk.service.aggpay.request.PrePayRequest;
import com.yeepay.yop.sdk.service.aggpay.response.PayLinkResponse;
import com.yeepay.yop.sdk.service.aggpay.response.PrePayResponse;
import com.yeepay.yop.sdk.service.divide.DivideClient;
import com.yeepay.yop.sdk.service.divide.DivideClientBuilder;
import com.yeepay.yop.sdk.service.divide.request.ApplyRequest;
import com.yeepay.yop.sdk.service.divide.response.ApplyResponse;
import com.yeepay.yop.sdk.service.mer.MerClient;
import com.yeepay.yop.sdk.service.mer.MerClientBuilder;
import com.yeepay.yop.sdk.service.promtion.PromtionClient;
import com.yeepay.yop.sdk.service.promtion.PromtionClientBuilder;
import com.yeepay.yop.sdk.service.promtion.request.SubsidyApplyRequest;
import com.yeepay.yop.sdk.service.promtion.response.SubsidyApplyResponse;
import com.yeepay.yop.sdk.service.sys.SysClient;
import com.yeepay.yop.sdk.service.sys.SysClientBuilder;
import io.gitee.loulan_yxq.owner.core.tool.IdTool;
import io.gitee.loulan_yxq.owner.json.tool.JsonTool;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 该Client线程安全，请使用单例模式，多次请求共用
    private static final DivideClient divideClient = DivideClientBuilder.builder().build();

    private static final PromtionClient promtionClient = PromtionClientBuilder.builder().build();
    // 该Client线程安全，请使用单例模式，多次请求共用
    private static final AccountClient accountClient = AccountClientBuilder.builder().build();

    /**
     * 商户之间的转账，包括营销账户和手续费账户
     * @param       
     * @return
     * @exception  
     * @author     :loulan
     * */
    @Test
   public void b2bApply() {
        TransferB2bOrderRequest request = new TransferB2bOrderRequest();
        request.setParentMerchantNo("10090423999");
        request.setRequestNo("B2B-"+ IdTool.simpleUUID());
        request.setFromMerchantNo("10090423999");
        request.setToMerchantNo("10090423999");
        request.setToAccountType("MARKET_ACCOUNT");
        request.setOrderAmount("0.01");
        request.setUsage("测试转账");
//        request.setFeeChargeSide("当商户承担且计费方式为预付实扣或后收时，不支持转入方承担；当平台商或服务商承担时无需指定此手续费承担方；");
//        request.setNotifyUrl("notifyUrl_example");
//        request.setRiskInfo("riskInfo_example");
//        request.setToAccountNo("toAccountNo_example");
        try {
            TransferB2bOrderResponse response = accountClient.transferB2bOrder(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling AccountClient#transferB2bOrder, ex:", e);
        }
   }

    /**
     * 聚合支付消费申请统一下单
     * @param       
     * @return
     * @exception  
     * @author     :loulan
     * */
    @Test
    public void orderApply() {
        PrePayRequest request = new PrePayRequest();
        // 10090423999
        request.setParentMerchantNo("10090423999");
        request.setMerchantNo("10090439828");
        request.setOrderId("TEST-"+ IdTool.simpleUUID());
        request.setOrderAmount(new BigDecimal("0.01"));
//        request.setNotifyUrl("https://notify.merchant.com/xxx");
        request.setMemo("测试数据");
        request.setGoodsName("测试交易");
        request.setFundProcessType("DELAY_SETTLE");
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
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> promotion = new HashMap<>();
        promotion.put("type", "CUSTOM_ALLOWANCE");
        list.add(promotion);

        request.setYpPromotionInfo(JsonTool.toJson(list));
        try {
            PrePayResponse response = api.prePay(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling AggpayClient#prePay, ex:", e);
        }
    }

    /**
     * 聚合支付生成聚合订单码
     * @param       
     * @return
     * @exception  
     * @author     :loulan
     * */
    @Test
    public void orderApply2() {
        PayLinkRequest request = new PayLinkRequest();
        request.setParentMerchantNo("10090423999");
        request.setMerchantNo("10090439828");
        request.setOrderId("TEST-"+ IdTool.simpleUUID());
        request.setOrderAmount(new BigDecimal("0.03"));
        request.setExpiredTime("2024-07-24 23:52:21");
//        request.setNotifyUrl("127.0.0.1");
        request.setMemo("测试数据");
        request.setGoodsName("测试支付");
        request.setFundProcessType("DELAY_SETTLE");
        request.setScene("{\"WECHAT\":\"OFFLINE\",\"ALIPAY\":\"OFFLINE\"}");
//        request.setAppId("appId12345");
//        request.setChannelSpecifiedInfo("{\"hbFqNum\":\"3\",\"hbFqSellerPercent\":\"0\",\"sysServiceProviderId\":\"\",\"isEnterprisePay\":\"N\"}");
//        request.setChannelPromotionInfo("channelPromotionInfo_example");
//        request.setIdentityInfo("{\"identityVerifyType\":\"Y\",\"payerIdType\":\"IDENTITY_CARD\",\"payerNumber\":\"234512198006252456\",\"payerName\":\"名字\"}");
//        request.setLimitCredit("N");
//        request.setCsUrl("csUrl_example");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> promotion = new HashMap<>();
        promotion.put("type", "CUSTOM_ALLOWANCE");
        list.add(promotion);

        request.setYpPromotionInfo(JsonTool.toJson(list));
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

    /**
     * 营销补贴
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Test
    public void subsidy() {
        SubsidyApplyRequest request = new SubsidyApplyRequest();
        request.setOrderId("TEST-36649cdd72fc49ee84b702052bca7da0");
        request.setUniqueOrderNo("1013202407240000013143941851");
        request.setSubsidyRequestId("SUB-"+IdTool.simpleUUID());
        request.setSubsidyAmount("0.01");
        request.setAssumeMerchantNo("10090423999");
        request.setMemo("测试补贴");
        request.setParentMerchantNo("10090423999");
        request.setMerchantNo("10090439828");
        try {
            SubsidyApplyResponse response = promtionClient.subsidyApply(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling PromtionClient#subsidyApply, ex:", e);
        }
    }

    /**
     * 分账申请
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Test
    public void divide01() {
        ApplyRequest request = new ApplyRequest();
        request.setParentMerchantNo("10090423999");
        request.setMerchantNo("10090439828");
        request.setOrderId("TEST-750ab05a40ef4f05b5dcf2bc66b583c6");
        request.setUniqueOrderNo("1013202407240000013143747940");
        request.setDivideRequestId("DIVI-"+IdTool.simpleUUID());

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("ledgerNo", "10090423999");
        map.put("amount", 0.01);
        map.put("divideDetailDesc", "分账测试");
        map.put("ledgerType", "MERCHANT2MERCHANT");
        list.add(map);

        request.setDivideDetail(JsonTool.toJson(list));
//        request.setAccountLinkInfo("{\"serviceProvider\":\"YEEPAY\",\"ipAddress\":\"192.168.1.1\",\"divideType\":\"1\",\"token\":\"token\"}");
//        request.setIsUnfreezeResidualAmount("isUnfreezeResidualAmount_example");
        try {
            ApplyResponse response = divideClient.apply(request);
            System.out.println(JsonTool.toJson(response));
        } catch (YopClientException e) {
            LOGGER.error("Exception when calling DivideClient#apply, ex:", e);
        }
    }
}
