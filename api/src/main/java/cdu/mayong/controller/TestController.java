package cdu.mayong.controller;

import cdu.mayong.entity.Category;
import cdu.mayong.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/get")
    @ResponseBody
    public Category getCategory(int id){
        return categoryService.getCategoryById(id);
    }
}
