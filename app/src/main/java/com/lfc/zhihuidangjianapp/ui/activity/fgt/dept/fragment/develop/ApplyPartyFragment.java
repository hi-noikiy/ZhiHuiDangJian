package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop;

import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.BaseDevelopPartyFragment;
import com.lfc.zhihuidangjianapp.ui.activity.model.NativeDevelopParty;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description:
 */
public class ApplyPartyFragment extends BaseDevelopPartyFragment {

    @Override
    public List<NativeDevelopParty> getParties() {
        return initPartys();
    }

    private List<NativeDevelopParty> initPartys(){
        List<NativeDevelopParty> partyList= new ArrayList<>();
        partyList.add(new NativeDevelopParty(0,"递交入党申请书时间", ""));
        partyList.add(new NativeDevelopParty(1,"谈话时间", ""));
        partyList.add(new NativeDevelopParty(0,"谈话人", ""));
        return partyList;
    }

}
