package entity;

import java.util.*;

/**
 * Docx文件重复结果
 *
 * @author kamjin1996
 */
public class DocxSimResult extends SimResult<Docx> {

    public DocxSimResult(double similarity, Docx a, Docx b) {
        super(similarity, a, b);
    }

    public DocxSimResult() {
    }

    /**
     * 自定义去重规则
     *
     * @param simResultList
     * @return
     */
    @Override
    public Set<? extends SimResult> distinct(List<? extends SimResult> simResultList) {
        Comparator<DocxSimResult> comparator = (o1, o2) -> {
            //定义当重复率相等时 判断结果1的A文档是否和结果2的B文档名称是否相同 若相同 则需要去重
            if (Objects.equals(String.valueOf(o1.getSimilarity()), String.valueOf(o2.getSimilarity())) && Objects.equals(o1.getA().getName(), o2.getB().getName())) {
                return 0;
            } else {
                return -1;
            }
        };

        //构造一个存放非重复数据的集合 Set的特性就是不重复
        Set<DocxSimResult> simResults = new TreeSet<>(comparator);

        //遍历并添加文档结果
        simResultList.forEach(x -> simResults.add((DocxSimResult) x));
        return simResults;
    }
}
