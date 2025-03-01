package com.yuhao.canteen.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.dao.FileMapper;
import com.yuhao.canteen.entity.File;
import com.yuhao.canteen.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
@Slf4j
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    public Result<String> saveFile(MultipartFile file){
        try {
            String fileName=file.getOriginalFilename();
            String fileId= IdUtils.generateId(Constant.FILE_PREFIX);
            String extension=fileName.substring(fileName.lastIndexOf("."));
            String filePath=Constant.UPLOAD_DIR + fileId+extension;
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            File fileinfo = new File();
            fileinfo.setId(fileId);
            fileinfo.setName(fileName);
            fileinfo.setPath(filePath);
            fileinfo.setStatus("1");
            fileinfo.setCreateTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            this.save(fileinfo);
            return Result.ok(fileId+extension,"文件上传成功！");
        } catch (Exception e) {
            log.error("文件上传异常！",e);
            return Result.failture("文件上传异常！");
        }
    }

}
