package com.cai.xiaolai.service.impl;

import com.cai.xiaolai.entity.UpFile;
import com.cai.xiaolai.mapper.FileMapper;
import com.cai.xiaolai.service.UpFileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpFileServiceImpl implements UpFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public PageInfo<UpFile> getFileList(int pageNum,int pageSize,String empname,String title) {
        PageHelper.startPage(pageNum,pageSize);
        List<UpFile> fileList = fileMapper.getFileList(empname,title);
        PageInfo<UpFile> pageInfo = new PageInfo<>(fileList);
        return pageInfo;
    }

    @Override
    public void save(UpFile upFile) {
        fileMapper.save(upFile);
    }

    @Override
    public void delete(int id) {
        fileMapper.delete(id);
    }
}
