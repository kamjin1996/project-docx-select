package checktor;

import entity.Docx;
import entity.DocxSimResult;
import entity.SimResult;
import util.SimilarityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Docx文件查重处理
 *
 * @author kamjin1996
 */
public class DocxDuplicateChecking implements DuplicateChecking<Docx> {

    /**
     * 根据所有Docx文件进行查重
     *
     * @param docxs
     * @return 查重结果
     */
    public List<SimResult> checking(List<Docx> docxs) {
        List<SimResult> simResultList = new ArrayList<>();
        int size = docxs.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                //文档A
                Docx docxA = docxs.get(i);
                //文档B
                Docx docxB = docxs.get(j);
                //此处不与自身作比较
                boolean isMySelf = Objects.equals(docxA.getName(), docxB.getName());
                if (isMySelf) {
                    continue;
                }
                //得到两个文档的重复度数值
                double similarity = SimilarityUtils.similarity(docxA.getText(), docxB.getText());
                //添加文档到结果集中
                simResultList.add(new DocxSimResult(similarity, docxA, docxB));
            }
        }

        //结果去重与排序
        return (List<SimResult>) SimResult.sort(new DocxSimResult().distinct(simResultList));
    }

    /**
     * 打印Docx文件列表的查重结果
     *
     * @param simResultList
     */
    @Override
    public void print(List<? extends SimResult> simResultList) {
        //遍历文件查重结果
        for (SimResult simResult : simResultList) {
            if (simResult instanceof DocxSimResult) {
                DocxSimResult docxSimResult = (DocxSimResult) simResult;
                System.out.println("文档名称：<<" + docxSimResult.getA().getName() + ">> 和文档名称：<<" + docxSimResult.getB().getName() + ">>,的相似度为: " + new Double(docxSimResult.getSimilarity() * 100).intValue() + "%");
            }
        }

    }


}
