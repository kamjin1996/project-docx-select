package service.impl;

import entity.Docx;
import service.Reader;
import util.DocxUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Docx文件读取处理器
 *
 * @author kamjin1996
 */
public class DocxReaderImpl implements Reader<Docx> {

    /**
     * 存放docx的集合
     */
    private List<Docx> docxList = new ArrayList<Docx>();

    /**
     * 读取docx文件的存放目录
     *
     * @param dir
     */
    public void read(String dir) {
        this.read(new File(dir));
    }

    /**
     * 读取docx文件的存放目录 文件
     *
     * @param dirFile
     */
    public void read(File dirFile) {
        /**
         * 判断是否是文件夹
         */
        if (!dirFile.isDirectory()) {
            throw new RuntimeException("输入路径不是文件夹:" + dirFile.getPath());
        }

        /**
         * 判断该路径下是否有文件
         */
        File[] docxFiles = dirFile.listFiles();
        if (docxFiles == null || docxFiles.length == 0) {
            throw new RuntimeException("该路径:" + dirFile.getPath() + "下不存在文件");
        }

        /**
         * 遍历所有文件
         */
        for (File docxFile : docxFiles) {
            //判断是否是docx文件
            if (docxFile.getPath().endsWith(".docx") || docxFile.getPath().endsWith(".DOCX")) {
                //根据文件得到docx对象
                Optional<Docx> optionalDocx = DocxUtil.toDocx(docxFile);
                optionalDocx.ifPresent(x -> docxList.add(x));
            }
        }

    }

    /**
     * 获取Docx对象列表
     *
     * @return
     */
    public List<Docx> getWorks() {
        return docxList;
    }

    /**
     * 获取有效文档总数
     *
     * @return
     */
    @Override
    public int workSize() {
        return docxList.size();
    }
}
