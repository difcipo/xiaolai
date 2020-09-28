package com.cai.xiaolai.service;

import com.cai.xiaolai.entity.UpFile;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpFileService {
    PageInfo<UpFile> getFileList(int pageNum,int pageSize,String empname,String title);

    void save(UpFile upFile);

    void delete(int id);
}
