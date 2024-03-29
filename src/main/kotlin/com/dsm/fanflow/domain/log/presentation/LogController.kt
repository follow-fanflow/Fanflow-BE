package com.dsm.fanflow.domain.log.presentation

import com.dsm.fanflow.domain.log.presentation.dto.request.LogRequest
import com.dsm.fanflow.domain.log.presentation.dto.response.LogDetailResponse
import com.dsm.fanflow.domain.log.presentation.dto.response.LogListResponse
import com.dsm.fanflow.domain.log.presentation.dto.response.ReturnIdResponse
import com.dsm.fanflow.domain.log.service.LogDetailService
import com.dsm.fanflow.domain.log.service.LogFileService
import com.dsm.fanflow.domain.log.service.LogListService
import com.dsm.fanflow.domain.log.service.LogService
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/log")
@RestController
class LogController(
    private val logService: LogService,
    private val logListService: LogListService,
    private val logDetailService: LogDetailService,
    private val logFileService: LogFileService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createLog(@RequestBody @Valid request: LogRequest): ReturnIdResponse {
        return logService.execute(request)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pic/{id}")
    fun upload(@PathVariable id: Long, @RequestPart(value = "image") file: MultipartFile): String {
        return logFileService.execute(id, file)
    }

    @PostMapping("/like/{id}")
    fun addLike(@PathVariable @Valid id: Long) {
        logService.addLike(id)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/like/{id}")
    fun deleteLike(@PathVariable @Valid id: Long) {
        logService.deleteLike(id)
    }

    @GetMapping("/get")
    fun findLog(@RequestParam(value = "group") group: String): LogListResponse? {
        return logListService.findLog(group)
    }

    @GetMapping("/getAll")
    fun findAllLog(): LogListResponse? {
        return logListService.findAllLogs()
    }

    @GetMapping("/{id}")
    fun logDetail(@PathVariable @Valid id: Long): LogDetailResponse {
        return logDetailService.execute(id)
    }

    @PostMapping("/admin/{id}")
    fun approveLog(@PathVariable @Valid id: Long) {
        logService.approveLog(id)
    }

}