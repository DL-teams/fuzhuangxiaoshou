package priv.jesse.mall.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import priv.jesse.mall.entity.Classification;

import java.util.List;

public interface ClassificationDao extends JpaRepository<Classification, Integer> {
    List<Classification> findByType(int type);

    /**
     *Pageable是Spring Data库中的一个接口，主要用于构造分页查询语句。
     * Pageable接口包含了分页的相关信息，
     * 使用getPageNumber()和getPageSize()，
     * 可以获取当前是第几页和每页的的数据量大小。
     * 在查询语句中加入Pageable对象作为参数，
     * JPA就能够通过该Pageable对象的信息，
     * 分析生成一个带分页查询的SQL语句。
     */

/**
 * Page也是Spring Data库中的一个接口，主要用于存储JPA查询数据库的结果集。
 *当使用Pageable对象作为参数进行查询的时候，JPA返回的是一个Page对象
 */
    Page<Classification> findByType(int type, Pageable pageable);

    List<Classification> findByParentId(int cid);
}
