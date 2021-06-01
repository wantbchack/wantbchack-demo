package com.wantbchack.business.controller.business;



import com.wantbchack.business.enums.ResultEnum;
import com.wantbchack.business.model.LsDestinationGlobalGroup;
import com.wantbchack.business.repository.LsDestinationGlobalGroupRepository;
import com.wantbchack.business.util.ResultUtil;
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
@RequestMapping("/lsDestinationGlobalGroup")
public class LsDestinationGlobalGroupController {

    @Autowired
    private LsDestinationGlobalGroupRepository lsDestinationGlobalGroupRepository;

    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    public Object save(LsDestinationGlobalGroup lsDestinationGlobalGroup){
        return lsDestinationGlobalGroupRepository.save(lsDestinationGlobalGroup);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Object delete(int id){
        Optional<LsDestinationGlobalGroup> lsDestinationGlobalGroup=lsDestinationGlobalGroupRepository.findById(id);
        if(lsDestinationGlobalGroup.isPresent()){
            lsDestinationGlobalGroupRepository.deleteById(id);
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
        Optional<LsDestinationGlobalGroup> lsDestinationGlobalGroup=lsDestinationGlobalGroupRepository.findById(id);
        if(lsDestinationGlobalGroup.isPresent()){
            return ResultUtil.success(lsDestinationGlobalGroup);
        }else{
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),"没有找到该对象");
        }
    }

    /**
     * 分页查询
     */
    @PostMapping("/list")
    public Object list(LsDestinationGlobalGroup lsDestinationGlobalGroup,
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {

        //创建匹配器，需要查询条件请修改此处代码
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        //创建实例
        Example<LsDestinationGlobalGroup> example = Example.of(lsDestinationGlobalGroup, matcher);
        //分页构造
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return lsDestinationGlobalGroupRepository.findAll(example, pageable);
    }
}
