package com.business.controller.business;



import com.business.enums.ResultEnum;
import com.business.model.LsDestinationGlobalStrategy;
import com.business.repository.LsDestinationGlobalStrategyRepository;
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
@RequestMapping("/lsDestinationGlobalStrategy")
public class LsDestinationGlobalStrategyController {

    @Autowired
    private LsDestinationGlobalStrategyRepository lsDestinationGlobalStrategyRepository;

    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    public Object save(LsDestinationGlobalStrategy lsDestinationGlobalStrategy){
        return lsDestinationGlobalStrategyRepository.save(lsDestinationGlobalStrategy);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Object delete(int id){
        Optional<LsDestinationGlobalStrategy> lsDestinationGlobalStrategy=lsDestinationGlobalStrategyRepository.findById(id);
        if(lsDestinationGlobalStrategy.isPresent()){
            lsDestinationGlobalStrategyRepository.deleteById(id);
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
        Optional<LsDestinationGlobalStrategy> lsDestinationGlobalStrategy=lsDestinationGlobalStrategyRepository.findById(id);
        if(lsDestinationGlobalStrategy.isPresent()){
            return null;
        }else{
            return  ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),"没有找到该对象");
        }
    }

    /**
     * 分页查询
     */
    @PostMapping("/list")
    public Object list(LsDestinationGlobalStrategy lsDestinationGlobalStrategy,
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {

        //创建匹配器，需要查询条件请修改此处代码
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        //创建实例
        Example<LsDestinationGlobalStrategy> example = Example.of(lsDestinationGlobalStrategy, matcher);
        //分页构造
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return lsDestinationGlobalStrategyRepository.findAll(example, pageable);
    }
}
