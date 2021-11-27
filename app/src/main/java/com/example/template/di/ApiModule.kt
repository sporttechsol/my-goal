package com.example.template.di

import com.example.template.api.MyGoalApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object ApiModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://dev-loforoll.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideMyGoalApi(
        retrofit: Retrofit
    ): MyGoalApi {
        return retrofit.create(MyGoalApi::class.java)
    }
}
