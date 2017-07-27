package com.example.lbhsot.larch.exception

/**
 * Created by lbhsot on 2017/7/26.
 */

class ApiException(var throwable: Throwable?, var mCode: Int) : Exception(throwable) {
    var mMessage: String = ""
}

internal object ERROR {
    //未知错误
    val UNKNOWN = 1000

    //网络连接错误
    val NETWORK_ERROR = 1001

    //HTTP错误
    val HTTP_ERROR = 1002

    //主机不可达错误
    val UNKNOWN_HOST = 1003
}
