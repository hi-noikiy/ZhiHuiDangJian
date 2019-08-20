package com.lfc.zhihuidangjianapp.net.http;

import com.lfc.zhihuidangjianapp.ui.activity.model.AliPay;
import com.lfc.zhihuidangjianapp.ui.activity.model.AppConfigLists;
import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dept;
import com.lfc.zhihuidangjianapp.ui.activity.model.DeptDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.Depts;
import com.lfc.zhihuidangjianapp.ui.activity.model.DynamicDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.ForestDistrict;
import com.lfc.zhihuidangjianapp.ui.activity.model.FriendList;
import com.lfc.zhihuidangjianapp.ui.activity.model.MailList;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLifeDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.PartyOrganiza;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseOrganizationalLife;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyDynamicList;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyPayment;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseStudyStrong;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseWorkReport;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyCraftReportList;
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
    Observable<BaseResponse<StudyCraftTrainingList>> queryStudyStrongBureauConsultationPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询工匠培养-林业技能培养
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauCraftsmanPageList")
    Observable<BaseResponse<StudyCraftTrainingList>> queryStudyStrongBureauCraftsmanPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

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
    Observable<BaseResponse<AliPay>> alipayToApp(@QueryMap Map<String, Object> map,@Header("token") String token);

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

    /**
     * 分页查询林区风采信息-通过forestDistrictType林区风采类型(0:先进基层党组织1:优秀共产党员2:优秀党务工作者3:优秀党建联络员)
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryForestDistrictPageList")
    Observable<BaseResponse<ForestDistrict>> queryForestDistrictPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询组织生活信息
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryOrganizationalLifePageList")
    Observable<BaseResponse<ResponseOrganizationalLife>> queryOrganizationalLifePageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 查看组织生活详情信息
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryOrganizationalLifeDetail")
    Observable<BaseResponse<OrganizationalLifeDetail>> queryOrganizationalLifeDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 新增周报
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertWeeklyWorkReport")
    Observable<BaseResponse<Object>> insertWeeklyWorkReport(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询精选周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportTopPageList")
    Observable<BaseResponse<Object>> queryWeeklyWorkReportTopPageList(@Header("token") String token);

    /**
     * 分页查询我的周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyWeeklyWorkReportPageList")
    Observable<BaseResponse<ResponseWorkReport>> queryMyWeeklyWorkReportPageList(@Header("token") String token);

    /**
     * 分页查询学习强局信息 -- 学习心得传studyStrongBureauType=2
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauPageList")
    Observable<BaseResponse<StudyCraftReportList>> queryStudyStrongBureauPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 新增学习强局信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertStudyStrongBureau")
    Observable<BaseResponse<Object>> insertStudyStrongBureau(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询精选周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportTopPageList")
    Observable<BaseResponse<Object>> queryWeeklyWorkReportTopPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 公告列表
     * @param token
     * @return
     */
    @POST(ApiConstant.queryNoticeAnnouncementPageList)
    Observable<String> queryNoticeAnnouncementPageList(@Header("token") String token);

    /**
     * 根据用户ID查询用户信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryUserByUserId")
    Observable<BaseResponse<UserInfo>> queryUserByUserId(@QueryMap Map<String, Object> map,@Header("token") String token);



}