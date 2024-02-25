package com.dsm.fanflow.global.s3

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.dsm.fanflow.global.s3.exception.FileException
import java.io.IOException
import java.util.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class S3Util(
    private val amazonS3Client: AmazonS3,

    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String
) {

    fun upload(file: MultipartFile, folderName: String): String {
        verificationFile(file)

        val fileName = "${folderName}/${UUID.randomUUID().toString()}.${getFileExtension(file.originalFilename ?: "")}"
        inputS3(file, fileName)

        return getResourceUrl(fileName)
    }

    private fun inputS3(file: MultipartFile, fileName: String) {
        try {
            val inputStream = file.inputStream
            val objectMetadata = ObjectMetadata().apply {
                contentLength = file.size
                contentType = Mimetypes.getInstance().getMimetype(file.originalFilename)
            }

            amazonS3Client.putObject(
                PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead)
            )
        } catch (e: IOException) {
            throw RuntimeException("fail", e)
        }
    }

    fun delete(objectName: String?) {
        amazonS3Client.deleteObject(bucket, objectName)
    }

    private fun getResourceUrl(fileName: String): String {
        return amazonS3Client.getUrl(bucket, fileName).toString()
    }

    private fun getFileExtension(fileName: String): String {
        val lastDotIndex = fileName.lastIndexOf('.')
        return if (lastDotIndex >= 0) fileName.substring(lastDotIndex) else ""
    }

    fun verificationFile(file: MultipartFile): String {
        val extension = file.originalFilename!!.substring(file.originalFilename!!.lastIndexOf("."))
        if (!(extension.contains(".png") || extension.contains(".JPG") || extension.contains(".jpg") || extension.contains(
                ".JPEG"
            ) || extension.contains(".jpeg") || extension.contains(".WEBP") || extension.contains(".webp"))
        ) {
            throw FileException.ERROR
        }

        return extension
    }
}
