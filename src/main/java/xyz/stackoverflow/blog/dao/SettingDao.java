package xyz.stackoverflow.blog.dao;

import org.springframework.stereotype.Repository;
import xyz.stackoverflow.blog.pojo.entity.Setting;
import xyz.stackoverflow.blog.util.db.Page;

import java.util.List;
import java.util.Map;

/**
 * 设置信息表DAO
 *
 * @author 凉衫薄
 */
@Repository
public interface SettingDao {

    List<Setting> selectByPage(Page page);

    List<Setting> selectByCondition(Map<String,String> searchMap);

    Setting selectById(String id);

    int insert(Setting setting);

    int batchInsert(List<Setting> list);

    int deleteById(String id);

    int batchDeleteById(List<String> list);

    int update(Setting setting);

    int batchUpdate(List<Setting> list);


    int insertSetting(Setting setting);

    List<Setting> getAllSetting();

    Setting getSetting(String key);

    int updateSetting(Setting setting);
}
