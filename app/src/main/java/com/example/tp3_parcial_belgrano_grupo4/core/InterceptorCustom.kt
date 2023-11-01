package com.example.tp3_parcial_belgrano_grupo4.core

import okhttp3.Interceptor
import okhttp3.Response

object InterceptorCustom : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }
}