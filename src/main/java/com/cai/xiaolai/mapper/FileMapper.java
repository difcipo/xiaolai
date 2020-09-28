package com.cai.xiaolai.mapper;

import com.cai.xiaolai.entity.UpFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {

    List<UpFile> getFileList(@Param("empname") String empname,@Param("title") String title);

    void save(@Param("upFile") UpFile upFile);

    void delete(@Param("id") int id);

}
