package com.wantbchack.business.service;

import com.wantbchack.business.dto.PageVo;
import com.wantbchack.business.dto.business.StrategyCustom;
import com.wantbchack.business.model.LsDestination;
import com.wantbchack.business.model.LsDestinationGlobalCustom;
import com.wantbchack.business.model.LsDestinationGlobalStrategy;
import com.wantbchack.business.repository.LsDestinationGlobalCustomRepository;
import com.wantbchack.business.repository.LsDestinationGlobalGroupRepository;
import com.wantbchack.business.repository.LsDestinationGlobalStrategyRepository;
import com.wantbchack.business.repository.LsDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class GlobalService {


    @Autowired
    private LsDestinationGlobalCustomRepository lsDestinationGlobalCustomRepository;

    @Autowired
    private LsDestinationGlobalGroupRepository lsDestinationGlobalGroupRepository;

    @Autowired
    private LsDestinationGlobalStrategyRepository lsDestinationGlobalStrategyRepository;

    @Autowired
    private LsDestinationRepository lsDestinationRepository;

    /**
     * 分页查询
     */
    public PageVo<StrategyCustom> findStrategyWithPage(
                                                       int pageNumber, int pageSize, Integer destinationId){

        //获取有过联系的目的地
        Set<Integer> regionIds = new HashSet<>();
        getAllRegion(destinationId,regionIds);
        //分页查询Strategy
        Sort.Order order = Sort.Order.asc("id");
        Sort sort = Sort.by(order);
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);

        Page<LsDestinationGlobalStrategy> page = lsDestinationGlobalStrategyRepository.findAll(new Specification<LsDestinationGlobalStrategy>() {
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<LsDestinationGlobalStrategy> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();

                if (regionIds != null) {
                    CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get("regionId"));
                    for (Integer regionId : regionIds) {
                        in.value(regionId);
                    }
                    list.add(in);
                }
                Predicate[] arr = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(arr));
            }

        }, pageable);

        List<StrategyCustom> strategyCustoms = new ArrayList<>();
        //根据目的地Id以及查询文章Id查询自定义数据 如果为空就默认数据
        for (LsDestinationGlobalStrategy destinationGlobalStrategy : page.getContent()) {
            System.out.println("TargetId:"+destinationGlobalStrategy.getTargetId());
            System.out.println("destinationId:"+destinationId);

            LsDestinationGlobalCustom custom = lsDestinationGlobalCustomRepository.findByDestinationIdAndTargetId(destinationId,destinationGlobalStrategy.getTargetId());
            StrategyCustom strategyCustom =new StrategyCustom();
            if (custom == null){
                custom = new LsDestinationGlobalCustom();
                defaultParma(custom,destinationId);
                custom.setTargetType(destinationGlobalStrategy.getStrategyType());
                custom.setTargetId(destinationGlobalStrategy.getTargetId());
            }
            strategyCustom.setLsDestinationGlobalStrategy(destinationGlobalStrategy);
            strategyCustom.setLsDestinationGlobalCustom(custom);
            strategyCustoms.add(strategyCustom);
        }

        //获取到的集合进行排序
        strategyCustoms.sort((x,y) -> {
            return Integer.compare(y.getLsDestinationGlobalCustom().getRecommend(),
                    x.getLsDestinationGlobalCustom().getRecommend());
            }
        );

         return getStrategyCustomPageVo(pageNumber, pageSize, page, strategyCustoms);

    }

    private PageVo<StrategyCustom> getStrategyCustomPageVo(int pageNumber, int pageSize, Page<LsDestinationGlobalStrategy> page, List<StrategyCustom> strategyCustoms) {
        PageVo<StrategyCustom> pageVo =new PageVo<>();
        pageVo.setPageNum(pageNumber);
        pageVo.setPageSize(pageSize);
        pageVo.setTotalPageCount(page.getTotalPages());
        pageVo.setTotalElements((int) page.getTotalElements());
        pageVo.setItem(strategyCustoms);
        return pageVo;
    }

    private void getAllRegion(Integer destinationId,  Set<Integer> regionIds ) {
        //获得目的地Id
        LsDestination destination = lsDestinationRepository.findByDestinationId(destinationId);
        regionIds.add(destination.getRegionId());
        if (destination != null){
            if (destination.getLevel() == 1){
                List<LsDestination> lsDestinations = lsDestinationRepository.findByPid(destination.getId());
                for (LsDestination lsDestination : lsDestinations) {
                    regionIds.add(lsDestination.getRegionId());
                    List<LsDestination> sub = lsDestinationRepository.findByPid(lsDestination.getId());
                    for (LsDestination subDestination : sub) {
                        regionIds.add(subDestination.getRegionId());

                    }
                }
            }else if (destination.getLevel() == 2){
                List<LsDestination> sub = lsDestinationRepository.findByPid(destination.getId());
                for (LsDestination subDestination : sub) {
                    regionIds.add(subDestination.getRegionId());
                }
            }else {
                regionIds.add(destination.getRegionId());
            }
        }
    }

    private void defaultParma(LsDestinationGlobalCustom custom,Integer destinationId) {
        custom.setGroupId(0);
        custom.setRecommend(0);
        custom.setDestinationId(destinationId);
        custom.setIsBigCard(0);
        custom.setIsDestinationDisplay(0);
        custom.setIsDisplayTitle(0);
    }
}
