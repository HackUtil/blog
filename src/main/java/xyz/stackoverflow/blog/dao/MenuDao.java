package xyz.stackoverflow.blog.dao;

import org.springframework.stereotype.Repository;
import xyz.stackoverflow.blog.pojo.entity.Menu;
import xyz.stackoverflow.blog.util.db.Page;

import java.util.List;
import java.util.Map;

/**
 * menu表DAO类
 *
 * @author 凉衫薄
 */
@Repository
public interface MenuDao {

    List<Menu> selectByPage(Page page);

    List<Menu> selectByCondition(Map<String, String> searchMap);

    Menu selectById(String id);

    int insert(Menu menu);

    int batchInsert(List<Menu> list);

    int deleteById(String id);

    int batchDeleteById(List<String> list);

    int update(Menu menu);

    int batchUpdate(List<Menu> list);


    int insertMenu(Menu menu);

    List<Menu> getAllMenu();

    List<Menu> getLimitMenu(Page page);

    Menu getMenuById(String id);

    int getMenuCount();

    int updateMenu(Menu menu);

    int deleteMenuById(String id);
}
