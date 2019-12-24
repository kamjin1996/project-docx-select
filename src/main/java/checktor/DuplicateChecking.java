package checktor;

import entity.SimResult;

import java.util.List;

/**
 * 查重处理接口
 *
 * @author kamjin1996
 */
public interface DuplicateChecking<T> {

    /**
     * 根据文档进行查重 返回查重结果集
     *
     * @param ts
     * @return
     */
    List<? extends SimResult> checking(List<T> ts);

    /**
     * 打印查重结果
     *
     * @param simResultList
     */
    void print(List<? extends SimResult> simResultList);

}
