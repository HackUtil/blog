package xyz.stackoverflow.blog.dao;

import org.springframework.stereotype.Repository;
import xyz.stackoverflow.blog.pojo.entity.Article;
import xyz.stackoverflow.blog.util.db.Page;

import java.util.List;
import java.util.Map;

/**
 * 文章表DAO
 *
 * @author 凉衫薄
 */
@Repository
public interface ArticleDao {

    List<Article> selectByPage(Page page);

    List<Article> selectByCondition(Map<String, Object> searchMap);

    Article selectById(String id);

    Article selectByUrl(String url);

    int insert(Article article);

    int batchInsert(List<Article> list);

    int deleteById(String id);

    int batchDeleteById(List<String> list);

    int update(Article article);

    int batchUpdate(List<Article> list);

}
