package io.github.loulangogogo.test04;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import io.gitee.loulan_yxq.owner.core.collection.CollTool;
import io.gitee.loulan_yxq.owner.core.io.IoTool;
import io.gitee.loulan_yxq.owner.core.stream.CollectorTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import io.gitee.loulan_yxq.owner.poi.excel.ExcelTool;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class ExcelTest {

    /**
     * 该方法计算用户重复使用优惠券的金额
     * @param
     * @return
     * @exception
     * @author     :loulan
     * */
    @Test
    public void test01() throws IOException {
        // 这个sql是获取同一个用户同一张优惠券在不同订单中重复使用的数据
        /*select od_3.uuid,od_3.order_id, od_3.coupon_id, od_3.user_id, od_3.amount,ocw.type,od_3.phone from (
           select od_2.uuid,od_2.order_id, od_2.coupon_id, od_2.user_id, oc.amount ,oc.warp_id,od_2.phone from (
                  select * from (
                                    select ooc.uuid,oo.phone, oo.uuid as order_id,unnest(string_to_array(ooc.od_coupon_id,',')) as coupon_id,oo.user_id as user_id
                                    from od_order oo
                                        left join od_order_coupon ooc on ooc.od_order_id=oo.uuid and ooc.del_flag=1
                                    where oo.del_flag=1
                                      and oo.order_status in (10,21,22,23,24)
                                      and ooc.od_coupon_id is not null
                                ) od_1
              ) od_2 left join od_coupon oc on oc.uuid=od_2.coupon_id and oc.del_flag=1
       ) od_3 left join od_coupon_warp ocw on ocw.uuid=od_3.warp_id and del_flag=1*/

        ExcelReader reader = ExcelUtil.getReader(new FileInputStream("a.xlsx"));

        List<List<Object>> read = reader.read(1);
        List<OdData> odDatas = new ArrayList<>();
        for (List<Object> objects : read) {
            OdData odData = new OdData();
            odData.setId(String.valueOf(objects.get(0)));
            odData.setOrderId(String.valueOf(objects.get(1)));
            odData.setCouponId(String.valueOf(objects.get((2))));
            odData.setUserId(Integer.valueOf(String.valueOf(objects.get(3))));
            odData.setAmount(Integer.valueOf(String.valueOf(objects.get(4))));

            String type = String.valueOf(objects.get(5));
            if (StrTool.isNotEmpty(type)) {
                odData.setType(Integer.valueOf(type));
            }

            String phoneEntr = String.valueOf(objects.get(6));
            if (StrTool.isNotEmpty(phoneEntr)) {
                odData.setPhone(EncryptAndDecryptTool.tryDecrypt(phoneEntr));
            }

            odDatas.add(odData);
        }

        // 去掉重复数据
        List<OdData> datas = CollTool.removeRepeat(odDatas, o -> {
            return o.getId()+o.getCouponId();
        });

        // 所有错误数据
        List<OdData> errDatas = new ArrayList<>();
        for (OdData odData : datas) {
            for (OdData data : datas) {
                if (data.getUserId().equals(odData.getUserId())
                        && data.getCouponId().equals(odData.getCouponId())
                        && !data.getOrderId().equals(odData.getOrderId())) {
                    errDatas.add(odData);
                    break;
                }
            }
        }

        // 去掉正常数据
        List<OdData> normalDatas = new ArrayList<>();
        List<OdData> myDatas = errDatas.stream().filter(o -> {
            for (OdData normalData : normalDatas) {
                if (o.getCouponId().equals(normalData.getCouponId())) {
                    return true;
                }
            }
            normalDatas.add(o);
            return false;
        }).toList();

        String couponStr = myDatas.stream().map(OdData::getCouponId).collect(CollectorTool.toStr("','"));

        int sum = 0;
        for (OdData myData : myDatas) {
            sum += myData.getAmount();
        }

        int typeSum = 0;
        for (OdData myData : myDatas) {
            if (myData.getType() != null && myData.getType() == 10) {
                typeSum += myData.getAmount();
            }
        }
        System.out.println(sum);
        System.out.println(typeSum);
        System.out.println(couponStr);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("phone", "手机号码");
        map.put("userId", "用户");
        map.put("orderId", "订单号");
        map.put("couponId", "优惠券");
        map.put("amount", "优惠券金额");
        map.put("type", "优惠券类型");
        ExcelTool.export(new FileOutputStream("错误数据.xlsx"),map,"错误数据",errDatas);
        ExcelTool.export(new FileOutputStream("多出来的金额数据.xlsx"),map,"错误数据",myDatas);
    }
}
