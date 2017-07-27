package com.example.lbhsot.larch.exception

import retrofit2.adapter.rxjava.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * Created by lbhsot on 2017/7/26.
 */
object ExceptionEngine {
    private val UNAUTHORIZED = 401
    private val FORBIDDEN = 403
    private val NOT_FOUND = 404
    private val REQUEST_TIMEOUT = 408
    private val INTERNAL_SERVER_ERROR = 500
    private val BAD_GATEWAY = 502
    private val SERVICE_UNAVAILABLE = 503
    private val GATEWAY_TIMEOUT = 504

    fun convertException(throwable: Throwable?): ApiException {
        val exception: ApiException
        if (throwable == null) {
            exception = ApiException(throwable, ERROR.UNKNOWN)
            exception.mMessage = "小么走神啦，请稍后再试一次！"
            return exception
        }
        if (throwable is HttpException) {
            val httpException = throwable
            exception = ApiException(throwable, ERROR.HTTP_ERROR)
            when (httpException.code()) {
                UNAUTHORIZED, FORBIDDEN, NOT_FOUND, REQUEST_TIMEOUT, INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT -> exception.mMessage = "网络出现错误，请稍后再试！"
                else -> {}
            }
        } else if (throwable is ConnectException) {
            exception = ApiException(throwable, ERROR.NETWORK_ERROR)
            exception.mMessage = "网络连接失败，请稍后再试！"
        } else if (throwable is UnknownHostException) {
            exception = ApiException(throwable, ERROR.UNKNOWN_HOST)
            exception.mMessage = "请检查您的网络连接后再试哦！"
        } else {
            exception = ApiException(throwable, ERROR.UNKNOWN)
            exception.mMessage = "小么走神啦，请稍后再试一次！"
        }
        return exception
    }
}
