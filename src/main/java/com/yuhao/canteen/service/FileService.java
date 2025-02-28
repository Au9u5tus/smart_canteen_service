package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.entity.File;

public interface FileService extends IService<File> {
    File saveFile(String fileName,String path,String relateId);
}
