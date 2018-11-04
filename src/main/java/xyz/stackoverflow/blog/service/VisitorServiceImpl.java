package xyz.stackoverflow.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.stackoverflow.blog.dao.VisitorDao;
import xyz.stackoverflow.blog.pojo.entity.Visitor;
import xyz.stackoverflow.blog.util.IdGenerator;

/**
 * 访客服务实现类
 *
 * @author 凉衫薄
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertVisitor(Visitor visitor) {
        visitor.setId(IdGenerator.getId());
        return visitorDao.insertVisitor(visitor);
    }
}
