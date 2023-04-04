package com.JasonAnh.LaptopLABackEnd.service.file;

import com.JasonAnh.LaptopLABackEnd.entity.UploadFile;
import com.JasonAnh.LaptopLABackEnd.entity.constants.UploadFileType;
import com.JasonAnh.LaptopLABackEnd.entity.response.UploadFroalaEditorResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileStorageService {
    UploadFroalaEditorResponse uploadFroalaEditor(HttpServletRequest request, final MultipartFile file) throws Exception;
    UploadFile storeImage(HttpServletRequest request, final MultipartFile file) throws Exception;
    UploadFile storeVideo(HttpServletRequest request, final MultipartFile thumbFile,  final MultipartFile videoFile) throws Exception;
    UploadFile storeAudio(HttpServletRequest request, final MultipartFile file, Integer timeRecord) throws Exception;
    UploadFile storeFile(HttpServletRequest request, final MultipartFile file) throws Exception;
    Resource loadFileAsResource(final String fileName)throws Exception;
    UploadFile getMedia(UploadFileType type, String mediaUrl, String thumbUrl) throws Exception;
}
