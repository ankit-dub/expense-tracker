package com.moneytap.splittest.controller;
import java.util.List;
import java.util.Optional;

import com.moneytap.splittest.Repository.CategoryRepository;
import com.moneytap.splittest.exception.RecordNotFoundException;
import com.moneytap.splittest.model.Category;
import com.moneytap.splittest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String getAllCategory(Model model)
    {
        List<Category> list = categoryService.getAllCategory();
        model.addAttribute("categories", list);
        return "list-categories";
    }


    @RequestMapping(path = "/edit")
    public String addCategory(Model model)
    {
        model.addAttribute("category", new Category());
        return "create";
    }

    @RequestMapping(path = "/category/edit/{id}")
    public String editCategoryById(Model model, @PathVariable("id") int id)
            throws RecordNotFoundException
    {
        if (id !=0) {
            Category entity = categoryService.getCategoryById(id);
            model.addAttribute("category", entity);
        } else {
            model.addAttribute("category", new Category());
        }
        return "create";
    }


    @RequestMapping(path = "/category/delete/{id}")
    public String deleteCategoryById(Model model, @PathVariable("id") int id)
    { categoryRepository.deleteById(id);
        return "redirect:/category";
    }

    @RequestMapping(path = "/category/createCategory", method = RequestMethod.POST)
    public String createOrUpdateCategories(Category categories)
    {
        categoryService.createOrUpdateEmployee(categories);
        return "redirect:/category";
    }
}
