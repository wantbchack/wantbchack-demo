package com.business.dto.business;


import com.business.model.LsDestinationGlobalCustom;
import com.business.model.LsDestinationGlobalStrategy;

public class StrategyCustom {

    private LsDestinationGlobalStrategy lsDestinationGlobalStrategy;

    private LsDestinationGlobalCustom lsDestinationGlobalCustom;

    //需要补充文章详细信息


    public LsDestinationGlobalStrategy getLsDestinationGlobalStrategy() {
        return lsDestinationGlobalStrategy;
    }

    public void setLsDestinationGlobalStrategy(LsDestinationGlobalStrategy lsDestinationGlobalStrategy) {
        this.lsDestinationGlobalStrategy = lsDestinationGlobalStrategy;
    }

    public LsDestinationGlobalCustom getLsDestinationGlobalCustom() {
        return lsDestinationGlobalCustom;
    }

    public void setLsDestinationGlobalCustom(LsDestinationGlobalCustom lsDestinationGlobalCustom) {
        this.lsDestinationGlobalCustom = lsDestinationGlobalCustom;
    }
}
