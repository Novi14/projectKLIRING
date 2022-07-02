package com.example.homekliring.Data.di

import com.example.homekliring.Data.Api.ApiService
import com.example.homekliring.Data.retrofit.RetrofitBuilder
import com.example.homekliring.DataStore.DataStoreRepository
import com.example.homekliring.ui.Auth.Authentication.login.LoginViewModel
import com.example.homekliring.ui.Auth.Authentication.login.dataStore
import com.example.homekliring.ui.Auth.Authentication.register.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<ApiService> {RetrofitBuilder.getRetrofit(androidContext())}
    factory { DataStoreRepository(androidContext().dataStore) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel {RegisterViewModel(get())}
}