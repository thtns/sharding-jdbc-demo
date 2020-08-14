package com.demo.sharding.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author liuyujun
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private BigDecimal id;

    /**
     * 分销商的account_info的id
     */
    @TableField("BUYER_ID")
    private BigDecimal buyerId;

    /**
     * 分销商的account_info的name
     */
    @TableField("BUYER_NAME")
    private String buyerName;

    /**
     * 分销商的account_login的id
     */
    @TableField("LOGIN_ID")
    private BigDecimal loginId;

    /**
     * 分销商的account_login的name
     */
    @TableField("LOGIN_NAME")
    private String loginName;

    @TableField("SUPPLY_ID")
    private BigDecimal supplyId;

    @TableField("SUPPLY_NAME")
    private String supplyName;

    @TableField("BUYER_ACC_TYPE")
    private String buyerAccType;

    @TableField("ORDER_NO")
    private String orderNo;

    @TableField("OUT_ORDER_NO")
    private String outOrderNo;

    @TableField("ORDER_TYPE")
    private String orderType;

    @TableField("BOOK_TYPE")
    private String bookType;

    @TableField("WAY_TYPE")
    private String wayType;

    @TableField("PAY_TYPE")
    private String payType;

    @TableField("PAY_STATUS")
    private String payStatus;

    @TableField("PAY_SUM")
    private BigDecimal paySum;

    @TableField("PAY_TIME")
    private LocalDateTime payTime;

    @TableField("CLOSE_SUM")
    private BigDecimal closeSum;

    @TableField("FINAL_SUM")
    private BigDecimal finalSum;

    @TableField("SAVE_SUM")
    private BigDecimal saveSum;

    @TableField("COUPON_CODE")
    private String couponCode;

    @TableField("ORDER_STATUS")
    private String orderStatus;

    @TableField("AUDIT_FLAG")
    private String auditFlag;

    @TableField("AUDIT_TIME")
    private LocalDateTime auditTime;

    @TableField("REFUND_TIME")
    private LocalDateTime refundTime;

    @TableField("AUDIT_LOGIN_ID")
    private BigDecimal auditLoginId;

    @TableField("HUNG_FLAG")
    private String hungFlag;

    @TableField("CLOSE_TIME")
    private LocalDateTime closeTime;

    @TableField("CLOSED")
    private String closed;

    @TableField("LINK_NAME")
    private String linkName;

    @TableField("LINK_IDCARD")
    private String linkIdcard;

    @TableField("LINK_MOBILE")
    private String linkMobile;

    @TableField("LINK_ADDR")
    private String linkAddr;

    @TableField("AREA_CODE")
    private String areaCode;

    @TableField("AREA_NAME")
    private String areaName;

    @TableField("VERSION")
    private Integer version;

    @TableField("REMARK")
    private String remark;

    @TableField("INFO")
    private String info;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @TableField("MODIFIED_TIME")
    private LocalDateTime modifiedTime;

    @TableField("DELETED")
    private String deleted;

    @TableField("IS_HANDEL")
    private String isHandel;

    @TableField("PAY_MERGE")
    private String payMerge;

    @TableField("CREATE_ORDER_USER_ID")
    private BigDecimal createOrderUserId;

    @TableField("SRC")
    private String src;

    @TableField("KFSTATUS")
    private Long kfstatus;

    /**
     * 产品名称
     */
    @TableField("PRODUCT_NAME")
    private String productName;

    /**
     * 产品id
     */
    @TableField("PRODUCT_ID")
    private BigDecimal productId;

    /**
     * 产品别名
     */
    @TableField("PRODUCT_ALIAS")
    private String productAlias;

    /**
     * 产品数量
     */
    @TableField("PRODUCT_NUM")
    private BigDecimal productNum;

    /**
     * 使用人数
     */
    @TableField("PRODUCT_USE_NUM")
    private BigDecimal productUseNum;

    /**
     * 演出场次
     */
    @TableField("PERFORMANCE")
    private LocalDateTime performance;

    /**
     * 产品的其他消息( json保存)
     */
    @TableField("PRODUCT_OTHER_INFO")
    private String productOtherInfo;

    /**
     * 主业务网销价
     */
    @TableField("NET_SELLING_PRICE")
    private BigDecimal netSellingPrice;

    /**
     * 主业务采购价
     */
    @TableField("SETTLEMENT_PRICE")
    private BigDecimal settlementPrice;

    /**
     * 业务员
     */
    @TableField("SALESMAN")
    private String salesman;

    /**
     * 证件类型
     */
    @TableField("CERTIFICATE_TYPE")
    private String certificateType;

    @TableField("MARKETPRICE")
    private BigDecimal marketprice;

    @TableField("SCORE")
    private BigDecimal score;

    /**
     * 开票同步状态0待同步1已同步
     */
    @TableField("RECEIPT_SYNC_FLAG")
    private BigDecimal receiptSyncFlag;

    /**
     * 开票状态0未开票1已开票
     */
    @TableField("RECEIPT_FLAG")
    private BigDecimal receiptFlag;

    /**
     * 经销商ID
     */
    @TableField("DEALER_ID")
    private BigDecimal dealerId;

    /**
     * 经销商名称
     */
    @TableField("DEALER_NAME")
    private String dealerName;

    public static final String ID = "ID";
    public static final String BUYER_ID = "BUYER_ID";
    public static final String BUYER_NAME = "BUYER_NAME";
    public static final String LOGIN_ID = "LOGIN_ID";
    public static final String LOGIN_NAME = "LOGIN_NAME";
    public static final String SUPPLY_ID = "SUPPLY_ID";
    public static final String SUPPLY_NAME = "SUPPLY_NAME";
    public static final String BUYER_ACC_TYPE = "BUYER_ACC_TYPE";
    public static final String ORDER_NO = "ORDER_NO";
    public static final String OUT_ORDER_NO = "OUT_ORDER_NO";
    public static final String ORDER_TYPE = "ORDER_TYPE";
    public static final String BOOK_TYPE = "BOOK_TYPE";
    public static final String WAY_TYPE = "WAY_TYPE";
    public static final String PAY_TYPE = "PAY_TYPE";
    public static final String PAY_STATUS = "PAY_STATUS";
    public static final String PAY_SUM = "PAY_SUM";
    public static final String PAY_TIME = "PAY_TIME";
    public static final String CLOSE_SUM = "CLOSE_SUM";
    public static final String FINAL_SUM = "FINAL_SUM";
    public static final String SAVE_SUM = "SAVE_SUM";
    public static final String COUPON_CODE = "COUPON_CODE";
    public static final String ORDER_STATUS = "ORDER_STATUS";
    public static final String AUDIT_FLAG = "AUDIT_FLAG";
    public static final String AUDIT_TIME = "AUDIT_TIME";
    public static final String REFUND_TIME = "REFUND_TIME";
    public static final String AUDIT_LOGIN_ID = "AUDIT_LOGIN_ID";
    public static final String HUNG_FLAG = "HUNG_FLAG";
    public static final String CLOSE_TIME = "CLOSE_TIME";
    public static final String CLOSED = "CLOSED";
    public static final String LINK_NAME = "LINK_NAME";
    public static final String LINK_IDCARD = "LINK_IDCARD";
    public static final String LINK_MOBILE = "LINK_MOBILE";
    public static final String LINK_ADDR = "LINK_ADDR";
    public static final String AREA_CODE = "AREA_CODE";
    public static final String AREA_NAME = "AREA_NAME";
    public static final String VERSION = "VERSION";
    public static final String REMARK = "REMARK";
    public static final String INFO = "INFO";
    public static final String CREATE_TIME = "CREATE_TIME";
    public static final String MODIFIED_TIME = "MODIFIED_TIME";
    public static final String DELETED = "DELETED";
    public static final String IS_HANDEL = "IS_HANDEL";
    public static final String PAY_MERGE = "PAY_MERGE";
    public static final String CREATE_ORDER_USER_ID = "CREATE_ORDER_USER_ID";
    public static final String SRC = "SRC";
    public static final String KFSTATUS = "KFSTATUS";
    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String PRODUCT_ID = "PRODUCT_ID";
    public static final String PRODUCT_ALIAS = "PRODUCT_ALIAS";
    public static final String PRODUCT_NUM = "PRODUCT_NUM";
    public static final String PRODUCT_USE_NUM = "PRODUCT_USE_NUM";
    public static final String PERFORMANCE = "PERFORMANCE";
    public static final String PRODUCT_OTHER_INFO = "PRODUCT_OTHER_INFO";
    public static final String NET_SELLING_PRICE = "NET_SELLING_PRICE";
    public static final String SETTLEMENT_PRICE = "SETTLEMENT_PRICE";
    public static final String SALESMAN = "SALESMAN";
    public static final String CERTIFICATE_TYPE = "CERTIFICATE_TYPE";
    public static final String MARKETPRICE = "MARKETPRICE";
    public static final String SCORE = "SCORE";
    public static final String RECEIPT_SYNC_FLAG = "RECEIPT_SYNC_FLAG";
    public static final String RECEIPT_FLAG = "RECEIPT_FLAG";
    public static final String DEALER_ID = "DEALER_ID";
    public static final String DEALER_NAME = "DEALER_NAME";
    public static final String SYNC = "sync";
    /**
     * 产品编码
     */
    private String modelCode;
    /**
     * 分销商类型
     */
    private String tagId;
    /**
     * 分销商
     */
    private String tagName;
    /**
     * 退单数量
     */
    private String refundNum;
    /**
     * 检票时间
     */
    private LocalDateTime orderCheck;
    /**
     * 是否同步了
     */
    private Boolean sync;
    private String startDate;

}
