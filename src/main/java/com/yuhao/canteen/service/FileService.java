package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService extends IService<File> {
    Result<String> saveFile(MultipartFile file);
}
