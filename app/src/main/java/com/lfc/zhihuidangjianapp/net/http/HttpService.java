package com.lfc.zhihuidangjianapp.net.http;

import com.lfc.zhihuidangjianapp.ui.activity.model.AliPay;
import com.lfc.zhihuidangjianapp.ui.activity.model.AppConfigLists;
import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dept;
import com.lfc.zhihuidangjianapp.ui.activity.model.DeptDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.Depts;
import com.lfc.zhihuidangjianapp.ui.activity.model.DynamicDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.FriendList;
import com.lfc.zhihuidangjianapp.ui.activity.model.MailList;
import com.lfc.zhihuidangjianapp.ui.activity.model.PartyOrganiza;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyDynamicList;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyPayment;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseStudyStrong;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyCraftTrainingList;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyStrongBureauDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.UserInfo;
import com.lfc.zhihuidangjianapp.ui.activity.model.WechatPay;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface HttpService {
    @POST(ApiConstant.LOGIN)
    Observable<String> LOGIN(@QueryMap Map<String, String> map);

    @GET(ApiConstant.queryHomeNoticeAnnouncementPageList)
    Observable<String> queryHomeNoticeAnnouncementPageList(@Header("token") String token);

    @POST(ApiConstant.queryAppConfigList)
    Observable<BaseResponse<AppConfigLists>> queryAppConfigList(@Header("token") String token);

    @POST(ApiConstant.queryNoticeAnnouncementDetail)
    Observable<String> queryNoticeAnnouncementDetail(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.queryNoticeAnnouncementPageList)
    Observable<String> queryNoticeAnnouncementPageList(@Header("token") String token);

    @POST(ApiConstant.queryLeadDemonstrationPageList)
    Observable<String> queryLeadDemonstrationPageList(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.queryMyPartyPaymentHisPageList)
    Observable<String> queryMyPartyPaymentHisPageList(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.queryJoinPartyStageDeatil)
    Observable<String> queryJoinPartyStageDeatil(@Header("token") String token);


    @POST(ApiConstant.queryPartyPaymentHisPageList)
    Observable<String> queryPartyPaymentHisPageList(@QueryMap Map<String, String> map, @Header("token") String token);

    /**
     * app-Banner
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.queryAppConfigList)
    Observable<String> queryAppConfigList(@QueryMap Map<String, String> map, @Header("token") String token);

    /**
     * 党建矩阵
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptList")
    Observable<BaseResponse<Depts>> queryDeptList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 党支部详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptDetail")
    Observable<BaseResponse<DeptDetail>> queryDeptDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询党建动态信息
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryPartyDynamicPageList")
    Observable<BaseResponse<ResponsePartyDynamicList>> queryPartyDynamicPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 党建动态详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryPartyDynamicDetail")
    Observable<BaseResponse<DynamicDetail>> queryPartyDynamicDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 学习强局首页
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauVideoPageList")
    Observable<BaseResponse<ResponseStudyStrong>> queryStudyStrongBureauVideoPageList(@Header("token") String token);

    /**
     * 学习心得详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauDetail")
    Observable<BaseResponse<StudyStrongBureauDetail>> queryStudyStrongBureauDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询工匠培养-林草咨询(学习心得传studyStrongBureauType=1)
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauConsultationPageList")
    Observable<BaseResponse<StudyCraftTrainingList>> queryStudyStrongBureauConsultationPageList(@Header("token") String token);

    /**
     * 微信支付订单
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.ROOT_URL + "weiXin2Pay/wxPayToApp")
    Observable<BaseResponse<WechatPay>> wxPayToApp(@Header("token") String token);

    /**
     * 支付宝订单
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.ROOT_URL + "alipay/alipayToApp")
    Observable<BaseResponse<AliPay>> alipayToApp(@Header("token") String token);

    /**
     * 党员信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.queryJoinPartyStageDeatil)
    Observable<BaseResponse<UserInfo>> queryJoinPartyInfo(@Header("token") String token);

    /**
     * 通讯录
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptListToAddressBook")
    Observable<BaseResponse<MailList>> queryDeptListToAddressBook(@Header("token") String token);

    /**
     * 好友列表
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryUserListByFirstPinYin")
    Observable<BaseResponse<FriendList>> queryUserListByFirstPinYin(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 新增党组织关系转移信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertTransferOrganizationalRelations")
    Observable<BaseResponse<Object>> insertTransferOrganizationalRelations(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 查看党组织关系转移详情信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryTransferOrganizationalRelationsDetail")
    Observable<BaseResponse<Object>> queryTransferOrganizationalRelationsDetail(@Header("token") String token);

    /**
     * 是否转移党组织
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyTransferOrganizationalRelationsDetail")
    Observable<BaseResponse<PartyOrganiza>> queryMyTransferOrganizationalRelationsDetail(@Header("token") String token);

    /**
     * 我的党费（待缴党费信息+党费缴纳列表）
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyPartyPaymentHisPageList")
    Observable<BaseResponse<ResponsePartyPayment>> queryMyPartyPaymentHisPageList(@Header("token") String token);


}