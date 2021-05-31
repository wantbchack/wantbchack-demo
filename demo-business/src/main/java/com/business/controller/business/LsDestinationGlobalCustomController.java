package com.business.controller.business;


import com.business.enums.ResultEnum;
import com.business.model.LsDestinationGlobalCustom;
import com.business.repository.LsDestinationGlobalCustomRepository;
import com.business.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/lsDestinationGlobalCustom")
public class LsDestinationGlobalCustomController {

    @Autowired
    private LsDestinationGlobalCustomRepository lsDestinationGlobalCustomRepository;

    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    public Object save(LsDestinationGlobalCustom lsDestinationGlobalCustom){
        return lsDestinationGlobalCustomRepository.save(lsDestinationGlobalCustom);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Object delete(int id){
        Optional<LsDestinationGlobalCustom> lsDestinationGlobalCustom=lsDestinationGlobalCustomRepository.findById(id);
        if(lsDestinationGlobalCustom.isPresent()){
            lsDestinationGlobalCustomRepository.deleteById(id);
            return ResultUtil.success("删除成功");
        }else{
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),"没有找到该对象");
        }
    }

    /**
     * 查询
     */
    @PostMapping("/find")
    public Object find(int id){
        Optional<LsDestinationGlobalCustom> lsDestinationGlobalCustom=lsDestinationGlobalCustomRepository.findById(id);
        if(lsDestinationGlobalCustom.isPresent()){
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),"没有找到该对象");
        }
    }

    /**
     * 分页查询
     */
    @PostMapping("/list")
    public Object list(LsDestinationGlobalCustom lsDestinationGlobalCustom,
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {

        //创建匹配器，需要查询条件请修改此处代码
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        //创建实例
        Example<LsDestinationGlobalCustom> example = Example.of(lsDestinationGlobalCustom, matcher);
        //分页构造
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return lsDestinationGlobalCustomRepository.findAll(example, pageable);
    }
}
