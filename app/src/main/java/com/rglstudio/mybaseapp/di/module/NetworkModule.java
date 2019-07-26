package com.rglstudio.mybaseapp.di.module;

import android.content.Context;

import com.rglstudio.mybaseapp.BuildConfig;
import com.rglstudio.mybaseapp.api.ApiInterface;
import com.rglstudio.mybaseapp.util.InternetUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    ApiInterface provideApiInterface(OkHttpClient okHttpClient) {
        return provideRetrofit(okHttpClient).create(ApiInterface.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Context context, HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (InternetUtil.checkInternetConnection(context)) {
                    int maxAge = 60; // read from cache for 1 minute
                    request.newBuilder()
                            .header("Accept", "application/json")
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 7; // tolerate 7-day stale
                    request.newBuilder()
                            .header("Accept", "application/json")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }


                return chain.proceed(request);
            }
        });

        okHttpClient.addInterceptor(httpLoggingInterceptor);

        okHttpClient.connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);

        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        okHttpClient.cache(cache);

        return okHttpClient.build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                        : HttpLoggingInterceptor.Level.NONE);
    }
}
