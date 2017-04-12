package learn.cn.com.happytolearn.impl;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 基础请求接口
 * Created by LOVE on 2015/12/25.
 */
public interface AppService {
    @Multipart
    @POST
    Observable<String> loadData(@Url String url,
                                @QueryMap HashMap<String, Object> params,//参数
                                @PartMap HashMap<String, RequestBody> files//文件参数

    );

    @POST
    Observable<String> loadData(@Url String url,
                                @QueryMap HashMap<String, Object> params//参数
    );

    @Headers("Content-Type: application/json")
    @POST
    Observable<String> loadData(@Url String url);

    @GET
    Call<ResponseBody> fileDownload(@Url String url);

    @POST
    Call<ResponseBody> update(@Url String url,
                              @Header("did") String did,//加密参数
                              @Header("version") String version,//版本
                              @Header("headers") String headers,//标题
                              @Header("headerk") String headerk,
                              @QueryMap HashMap<String, Object> params//参数

    );

}
