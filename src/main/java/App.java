
import entity.Docx;
import checktor.DocxDuplicateChecking;
import checktor.DuplicateChecking;
import service.Reader;
import service.impl.DocxReaderImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 应用程序
 *
 * @author kamjin1996
 */
public class App {

    /**
     * 得到Docx读取对象
     */
    private static Reader<Docx> docxReader = new DocxReaderImpl();

    /**
     * 得到Docx重复检查对象
     */
    private static DuplicateChecking<Docx> duplicateChecking = new DocxDuplicateChecking();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存放docx文件的目录:");
        if (scanner.hasNext()) {
            docxReader.read(scanner.next());
            List<Docx> works = docxReader.getWorks();
            duplicateChecking.print(duplicateChecking.checking(works));
        }
    }

}
