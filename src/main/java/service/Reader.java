package service;

import java.io.File;
import java.util.List;

/**
 * 文档读取接口
 *
 * @author kamjin1996
 */
public interface Reader<T> {

    /**
     * 读取文档目录
     *
     * @param dir
     */
    void read(String dir);

    /**
     * 读取文档目录
     *
     * @param dirFile
     */
    void read(File dirFile);

    /**
     * 获取文档
     *
     * @return
     */
    List<T> getWorks();

    /**
     * 有效文档个数
     *
     * @return
     */
    int workSize();
}
