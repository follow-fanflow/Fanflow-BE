package com.dsm.fanflow.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    //user
    USER_NOT_MATCH(403, "User Not Match Error"),
    USER_NOT_FOUND(404, "User Not FoundException"),
    ALREADY_EXIST_ID(409, "Already Exist Error"),

    //server
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}