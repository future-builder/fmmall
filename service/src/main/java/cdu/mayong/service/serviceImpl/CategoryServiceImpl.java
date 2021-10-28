package cdu.mayong.service.serviceImpl;

import cdu.mayong.dao.CategoryDao;
import cdu.mayong.entity.Category;
import cdu.mayong.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryDao categoryDao;
    @Override
    public Category getCategoryById(int id) {
        return categoryDao.queryCategoryById(id);
    }
}
