package com.ginzo.remote

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
abstract class RemoteModule {

  @Module
  companion object {
    @Provides
    @JvmStatic
    @Singleton
    fun okHttpClientProvider(): OkHttpClient {
      return OkHttpClient().newBuilder().build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun retrofitProvider(okHttpClient: OkHttpClient): Retrofit {
      return Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(okHttpClient)
        .build()
    }
  }

}