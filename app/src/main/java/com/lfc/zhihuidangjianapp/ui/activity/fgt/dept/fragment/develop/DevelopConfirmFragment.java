package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop;

import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.BaseDevelopPartyFragment;
import com.lfc.zhihuidangjianapp.ui.activity.model.NativeDevelopParty;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description: 发展对象的确定和考察阶段
 */
public class DevelopConfirmFragment extends BaseDevelopPartyFragment {

    @Override
    public List<NativeDevelopParty> getParties() {
        return initPartys();
    }

    private List<NativeDevelopParty> initPartys(){
        List<NativeDevelopParty> partyList= new ArrayList<>();
        partyList.add(new NativeDevelopParty(0,"党小组通过时间", ""));
        partyList.add(new NativeDevelopParty(0,"党支部通过时间", ""));
        partyList.add(new NativeDevelopParty(0,"支委会通过时间", ""));
        partyList.add(new NativeDevelopParty(0,"党委研究决定时间", ""));
        partyList.add(new NativeDevelopParty(1,"确定入党介绍人", ""));
        partyList.add(new NativeDevelopParty(0,"谈话时间", ""));
        partyList.add(new NativeDevelopParty(1,"谈话次数", ""));
        partyList.add(new NativeDevelopParty(0,"政治审查时间", ""));
        partyList.add(new NativeDevelopParty(1,"政审结论", ""));
        partyList.add(new NativeDevelopParty(0,"集中培训时间", ""));
        partyList.add(new NativeDevelopParty(1,"培训成绩", ""));
        return partyList;
    }

}
