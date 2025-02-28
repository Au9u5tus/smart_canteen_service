package com.yuhao.canteen.controller;

import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.Dictionary;
import com.yuhao.canteen.service.DictionaryService;
import com.yuhao.canteen.service.FileService;
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
import java.util.List;

@RequestMapping("file")
@RestController
@Slf4j
public class FileController {
    @Autowired
    private FileService fileService;

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("relateId")String relateId) {
        try {
            String fileName = file.getOriginalFilename();
            String extension = file.getOriginalFilename().substring(fileName.lastIndexOf("."));
            String fileId= IdUtils.generateFileId();
            String filePath=UPLOAD_DIR + fileId+extension;
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            fileService.saveFile(fileName,filePath,relateId);
            return Result.ok(fileId+extension,"上传附件成功");
        } catch (Exception e) {
            log.error("上传附件异常",e,e.getMessage());
            return Result.failture("上传附件失败");
        }
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable String filename) {
        Path filePath = Paths.get(UPLOAD_DIR + filename);
        FileSystemResource fileSystemResource = new FileSystemResource(filePath.toFile());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileSystemResource.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileSystemResource);
    }

    @GetMapping("/preview/{filename}")
    public ResponseEntity<byte[]> previewImage(@PathVariable String filename) {
        Path filePath = Paths.get(UPLOAD_DIR + filename);
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

