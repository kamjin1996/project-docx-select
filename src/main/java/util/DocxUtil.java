package util;

import entity.Docx;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.Optional;


/**
 * 文件转为docx的util
 *
 * @author kamjin1996
 */
public class DocxUtil {

    /**
     * 将文件转为可能存在的Docx对象
     *
     * @param file
     * @return
     */
    public static Optional<Docx> toDocx(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String text = extractor.getText();
            return Optional.of(new Docx(file.getName(), text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
