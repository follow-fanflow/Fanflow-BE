package com.dsm.fanflow.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    //user
    TOKEN_UNAUTHORIZED(401, "Token Unauthorized"),
    PASSWORD_MISMATCH(403, "Password Mismatch"),
    USER_NOT_FOUND(404, "User Not Found"),
    ACCOUNT_ID_ALREADY_EXIST(409, "AccountId Already Exist"),

    //log
    CANT_DELETE_LOG(403, "Cant Delete Log"),
    LOG_NOT_EXIST(404, "Log Not Exist"),

    //server
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}