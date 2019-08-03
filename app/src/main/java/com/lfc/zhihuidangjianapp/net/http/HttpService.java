package com.lfc.zhihuidangjianapp.net.http;

import com.lfc.zhihuidangjianapp.ui.activity.model.AppConfigLists;
import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;
import com.lfc.zhihuidangjianapp.ui.activity.model.Depts;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
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
    @POST(ApiConstant.queryUserListByFirstPinYin)
    Observable<String> queryUserListByFirstPinYin(@QueryMap Map<String, String> map,@Header("token") String token);

    @POST(ApiConstant.queryLeadDemonstrationPageList)
    Observable<String> queryLeadDemonstrationPageList(@QueryMap Map<String, String> map,@Header("token") String token);

    @POST(ApiConstant.queryMyPartyPaymentHisPageList)
    Observable<String> queryMyPartyPaymentHisPageList(@QueryMap Map<String, String> map,@Header("token") String token);

    @POST(ApiConstant.queryJoinPartyStageDeatil)
    Observable<String> queryJoinPartyStageDeatil(@Header("token") String token);


    @POST(ApiConstant.queryPartyPaymentHisPageList)
    Observable<String> queryPartyPaymentHisPageList(@QueryMap Map<String, String> map,@Header("token") String token);

    /**
     * app-Banner
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.queryAppConfigList)
    Observable<String> queryAppConfigList(@QueryMap Map<String, String> map,@Header("token") String token);

    /**
     * 党建矩阵
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API+"/queryDeptList")
    Observable<BaseResponse<Depts>> queryDeptList(@QueryMap Map<String, Object> map, @Header("token") String token);

}