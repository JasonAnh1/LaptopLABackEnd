package com.JasonAnh.LaptopLABackEnd.controller;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.UploadFile;
import com.JasonAnh.LaptopLABackEnd.entity.response.BaseResponse;
import com.JasonAnh.LaptopLABackEnd.service.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
@Transactional
public class FileController extends BaseController{
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("v1/file/upload-image")
    public ResponseEntity<?> uploadImage1(HttpServletRequest httpServletRequest, @RequestParam("file") final MultipartFile file) {
        try {
            if(file == null || httpServletRequest == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            if(file.getSize() > 1024*1024*20) {
                throw new Exception("Dung lượng file quá lớn, vui lòng chọn file nhỏ hơn 20MB");
            }
            UploadFile uploadFile = fileStorageService.storeImage(httpServletRequest, file);
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), uploadFile));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }

    @GetMapping("images/{fileName:.+}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable final String fileName) throws Exception {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(resource.getInputStream()));
    }

}
