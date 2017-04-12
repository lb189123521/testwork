package learn.cn.com.happytolearn.impl;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import learn.cn.com.happytolearn.model.ResponseData;
import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import xyz.yhsj.easynet.EasyNet;


/**
 * 接口实现
 */
public class AppImpl {
    private Context context;

    private AppService appService;

    private Gson gson;
    private final String PRO_URL = "pro/";
    private final String PROMYGROUPHXK_URL = "ProMyGroupHXK/";

    public AppImpl(Context context) {
        this.context = context;
        appService = EasyNet.getInstance().create(AppService.class);

        gson = new GsonBuilder().
                registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                    @Override
                    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                        if (src == src.longValue())
                            return new JsonPrimitive(src.longValue());
                        return new JsonPrimitive(src);
                    }
                }).create();
    }


    /**
     * 登陆
     *
     * @param params 参数
     * @return
     */
   /* public Observable<ResponseData<UserEntity>> login(HashMap<String, Object> params) {
        return loadData(PRO_URL + "Login", params, new TypeToken<ResponseData<UserEntity>>() {
        }.getType());
    }*/



    /**
     * 基础数据请求
     *
     * @param url    接口地址
     * @param params 请求参数
     * @return
     */
    private <T> Observable<ResponseData<T>> loadData(String url, HashMap<String, Object> params, final Type typeToken) {
        return loadData(url, params, new HashMap<String, RequestBody>(), typeToken);
    }

//    /**
//     * 基础数据请求
//     *
//     * @param url
//     * @param params
//     * @return
//     */
//    private <T> Observable<ResponseData<T>> loadData(String url, HashMap<String, Object> params, ArrayList<File> files) {
//
//        //文件参数
//        HashMap<String, RequestBody> fileParams = new HashMap<>();
//
////        //封装文件参数
////        if (files != null) {
////            for (File file : files) {
////                fileParams.put("file\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("Accept: text/html, application/xhtml+xml, image/jxr, */*"), file));
////            }
////        }
//
//        return loadData(url, params, fileParams);
//    }


    /**
     * 基础数据请求
     *
     * @param url
     * @param params
     * @return
     */
    private <T> Observable<ResponseData<T>> loadData(String url, HashMap<String, Object> params, HashMap<String, RequestBody> fileParams, final Type typeToken) {

        //Rx被观测者
        Observable<String> observable;
        //参数key
       // params.put("key", ResponseCode.UNIFIED_KEY);
        //判断是否包含文件，fileParams为空时会抛异常，所以分开来写
        if (fileParams.size() > 0) {
            observable = appService.loadData(url, params, fileParams);
        } else if (params.size() > 0) {
            observable = appService.loadData(url, params);
        } else {
            observable = appService.loadData(url);
        }

        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<String, Observable<ResponseData<T>>>() {
                    @Override
                    public Observable<ResponseData<T>> call(String strResponse) {
                        Log.w(">>>>>>返回后的数据>>>>>>>>>", strResponse);
                        ResponseData<T> lastResult = gson.fromJson(strResponse, typeToken);
                        Log.w(">>>>>>解析后的数据>>>>>>>>>", lastResult.toString());
                        return Observable.just(lastResult);
                    }
                })
                //错误处理，防止错误返回导致数据链断裂
                .onErrorReturn(new Func1<Throwable, ResponseData<T>>() {
                    @Override
                    public ResponseData<T> call(Throwable throwable) {

                        Log.w("call: ", throwable.getMessage());

                        throwable.printStackTrace();
                        ResponseData<T> errorData = new ResponseData<>();

                        if (throwable == null || TextUtils.isEmpty(throwable.getMessage())) {
                            errorData.setReturnMsg("未知错误");
                        } else if (throwable.getMessage().contains("Failed to")) {
                            errorData.setReturnMsg("连接失败，请检查网络");
                        } else if (throwable.getMessage().contains("failed to")) {
                            errorData.setReturnMsg("连接失败，请检查网络");
                        } else if (throwable.getMessage().contains("timeout")) {
                            errorData.setReturnMsg("连接超时，请稍后重试");
                        } else {
                            errorData.setReturnMsg(throwable.getMessage());
                        }
                        return errorData;
                    }
                });

    }
}
