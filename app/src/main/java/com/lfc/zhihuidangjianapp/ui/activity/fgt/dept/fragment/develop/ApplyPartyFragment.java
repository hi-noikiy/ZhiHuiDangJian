package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.develop;

import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment.BaseDevelopPartyFragment;
import com.lfc.zhihuidangjianapp.ui.activity.model.DevelopParty;
import com.lfc.zhihuidangjianapp.ui.activity.model.NativeDevelopParty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description:申请入党阶段
 */
public class ApplyPartyFragment extends BaseDevelopPartyFragment {

    @Override
    public List<NativeDevelopParty> getParties() {
        return initPartys();
    }

    @Override
    public void submit(List<NativeDevelopParty> parties) {
        Map<String,Object> map = new HashMap<>();
        map.put("submitApplicationTime1", parties.get(0).getContent());
        map.put("talkTime1", parties.get(1).getContent());
        map.put("talker1", parties.get(2).getContent());
        saveData(map);
    }

    private List<NativeDevelopParty> initPartys(){
        List<NativeDevelopParty> partyList= new ArrayList<>();
        partyList.add(new NativeDevelopParty(0,"递交入党申请书时间", ""));
        partyList.add(new NativeDevelopParty(0,"谈话时间", ""));
        partyList.add(new NativeDevelopParty(1,"谈话人", ""));
        return partyList;
    }

    public void setPartyData(DevelopParty developParty){
        if(developParty.submitStatus == 1){

        }
        List<NativeDevelopParty> partyList = parties;
//        mAdapter.getDatas().addAll(partyList);
        partyList.get(0).setContent(developParty.submitApplicationTime1);
        partyList.get(1).setContent(developParty.talkTime1);
        partyList.get(2).setContent(developParty.talker1);
        mAdapter.notifyDataSetChanged();
    }

}
