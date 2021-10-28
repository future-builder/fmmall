package dao;

import cdu.mayong.ApiApplication;
import cdu.mayong.dao.CategoryDao;
import cdu.mayong.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class CategoryDaoTest {

    @Resource
    private CategoryDao categoryDao;

    @Test
    public void queryCategoryById() {
        Category category = categoryDao.queryCategoryById(10);
        System.out.println(category);
    }
}