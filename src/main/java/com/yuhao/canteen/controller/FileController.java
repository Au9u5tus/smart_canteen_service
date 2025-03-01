package com.yuhao.canteen.controller;

import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("file")
@RestController
@Slf4j
@Api(value = "文件上传接口", description = "提供文件上传功能")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件", notes = "支持单个文件上传")
    public Result<String> uploadFile(@RequestPart("file") MultipartFile file) {
        try {
            return fileService.saveFile(file);
        } catch (Exception e) {
            log.error("上传附件异常",e,e.getMessage());
            return Result.failture("上传附件失败");
        }
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable String filename) {
        Path filePath = Paths.get(Constant.UPLOAD_DIR + filename);
        FileSystemResource fileSystemResource = new FileSystemResource(filePath.toFile());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileSystemResource.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileSystemResource);
    }

    @GetMapping("/preview/{filename}")
    public ResponseEntity<byte[]> previewImage(@PathVariable String filename) {
        Path filePath = Paths.get(Constant.UPLOAD_DIR + filename);
        if (!Files.exists(filePath)) {
            return ResponseEntity.notFound().build();
        }
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            MediaType mediaType = MediaType.IMAGE_JPEG; // or MediaType.IMAGE_PNG based on your file type
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}

