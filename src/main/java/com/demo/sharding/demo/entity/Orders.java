package com.demo.sharding.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String ORDER_NO = "order_no";
    public static final String OUT_ORDER_NO = "out_order_no";
    public static final String ORDER_STATUS = "order_status";
    public static final String BUYER_ID = "buyer_id";
    public static final String BUYER_NAME = "buyer_name";
    public static final String BUYER_NAME_ALIAS = "buyer_name_alias";
    public static final String SUPPLY_ID = "supply_id";
    public static final String SUPPLY_NAME = "supply_name";
    public static final String SUPPLY_NAME_ALIAS = "supply_name_alias";
    public static final String ORDER_TYPE = "order_type";
    public static final String PRODUCT_NAME = "product_name";
    public static final String MODEL_CODE = "model_code";
    public static final String WEATHER = "weather";
    public static final String LINK_NAME = "link_name";
    public static final String LINK_ID_CARD = "link_id_card";
    public static final String LINK_MOBILE = "link_mobile";
    public static final String CERTIFICATE_TYPE = "certificate_type";
    public static final String PERFORM_DATE = "perform_date";
    public static final String PERFORM_TIME = "perform_time";
    public static final String PRODUCT_NUM = "product_num";
    public static final String PRODUCT_USE_NUM = "product_use_num";
    public static final String REFUND_NUM = "refund_num";
    public static final String CLOSE_SUM = "close_sum";
    public static final String SAVE_SUM = "save_sum";
    public static final String NET_SELLING_PRICE = "net_selling_price";
    public static final String SETTLEMENT_PRICE = "settlement_price";
    public static final String MARKET_PRICE = "market_price";
    public static final String PAY_TIME = "pay_time";
    public static final String PAY_HOUR = "pay_hour";
    public static final String WAY_TYPE = "way_type";
    public static final String PAY_TYPE = "pay_type";
    public static final String ONLY_YEAR = "only_year";
    public static final String ONLY_MONTH = "only_month";
    public static final String ONLY_DAY = "only_day";
    public static final String QUARTER = "quarter";
    public static final String FORWARD_DAY = "forward_day";
    public static final String FORWARD_HOUR = "forward_hour";
    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String SEX_ALIAS = "sex_alias";
    public static final String ORDER_CHECK = "order_check";
    public static final String CHECK_HOUR = "check_hour";
    public static final String SALESMAN = "salesman";
    public static final String TAG_NAME = "tag_name";
    public static final String DEALER_ID = "dealer_id";
    public static final String DEALER_NAME = "dealer_name";
    public static final String CREATE_TIME = "create_time";
    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;


    public static final String ID = "id";
    /**
     * 外部订单号
     */
    private String outOrderNo;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 购买人ID
     */
    private Long buyerId;
    /**
     * 购买人名称
     */
    private String buyerName;
    /**
     * 购买人别名
     */
    private String buyerNameAlias;
    /**
     * 供应商ID
     */
    private Long supplyId;
    /**
     * 供应商名称
     */
    private String supplyName;
    /**
     * 供应商别名
     */
    private String supplyNameAlias;
    /**
     * 业务类型
     */
    private String orderType;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编码
     */
    private String modelCode;
    /**
     * 天气
     */
    private String weather;
    /**
     * 联系人名称
     */
    private String linkName;
    /**
     * 证件号码
     */
    private String linkIdCard;
    /**
     * 联系人手机号码
     */
    private String linkMobile;
    /**
     * 证件类型
     */
    private String certificateType;
    /**
     * 游玩日期
     */
    private LocalDate performDate;
    /**
     * 演出场次
     */
    private String performTime;
    /**
     * 订单人数
     */
    private Integer productNum;
    /**
     * 订单使用人数
     */
    private Integer productUseNum;
    /**
     * 订单退单人数
     */
    private Integer refundNum;

    /**
     * 订单金额
     */
    private BigDecimal finalSum;

    /**
     * 订单结算金额
     */
    private BigDecimal closeSum;
    /**
     * 订单优惠金额
     */
    private BigDecimal saveSum;
    /**
     * 网销价
     */
    private BigDecimal netSellingPrice;
    /**
     * 采购价
     */
    private BigDecimal settlementPrice;
    /**
     * 门市价
     */
    private BigDecimal marketPrice;
    /**
     * 付款时间
     */
    private LocalDateTime payTime;
    /**
     * 付款时间只要小时
     */
    private Integer payHour;
    /**
     * 订单来源
     */
    private String wayType;
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 年
     */
    private String onlyYear;
    /**
     * 月
     */
    private String onlyMonth;
    /**
     * 日
     */
    private String onlyDay;
    /**
     * 季度
     */
    private Integer quarter;
    /**
     * 提前购买天数
     */
    private Integer forwardDay;
    /**
     * 提前购买小时
     */
    private Integer forwardHour;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 性别
     */
    private String sexAlias;
    /**
     * 检票时间
     */
    private LocalDateTime orderCheck;
    /**
     * 检票小时
     */
    private Integer checkHour;
    /**
     * 业务员
     */
    private String salesman;
    /**
     * 分销商类型
     */
    private String tagName;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    /**
     * 经销商ID
     */
    private BigDecimal dealerId;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 星期几
     */
    private String weekday;

    /**
     * 身份证前6位
     */
    private String provinceCode;


}
