package entity;

import java.util.*;

/**
 * 分析结果类
 *
 * @author kamjin1996
 */
public abstract class SimResult<T> {

    private double similarity;

    /**
     * 定义a文档
     */
    private T a;

    /**
     * 定义b文档
     */
    private T b;

    public SimResult() {
    }

    /**
     * 构造器
     *
     * @param similarity
     * @param a
     * @param b
     */
    public SimResult(double similarity, T a, T b) {
        this.similarity = similarity;
        this.a = a;
        this.b = b;
    }


    /**
     * 查重结果排序
     *
     * @return
     */
    public static List<? extends SimResult> sort(Set<? extends SimResult> simResults) {
        ArrayList<SimResult> simResultList = new ArrayList<>(simResults);

        //按重复率由大到小排序文档集合
        simResultList.sort((o1, o2) -> (int) (o2.getSimilarity() * 100000 - o1.getSimilarity() * 100000));
        return simResultList;
    }

    /**
     * 根据自定义规则去重
     *
     * @param simResultList
     * @return
     */
    public abstract Set<? extends SimResult> distinct(List<? extends SimResult> simResultList);

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }
}
