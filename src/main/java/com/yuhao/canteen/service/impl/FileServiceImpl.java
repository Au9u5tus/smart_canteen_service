package com.yuhao.canteen.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.dao.FileMapper;
import com.yuhao.canteen.entity.File;
import com.yuhao.canteen.service.FileService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    public File saveFile(String fileName,String path,String relateId){
        File file = new File();
        file.setId(IdUtils.generateFileId());
        file.setName(fileName);
        file.setPath(path);
        file.setRelateId(relateId);
        file.setStatus("1");
        file.setCreateTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        this.save(file);
        return file;
    }

}
