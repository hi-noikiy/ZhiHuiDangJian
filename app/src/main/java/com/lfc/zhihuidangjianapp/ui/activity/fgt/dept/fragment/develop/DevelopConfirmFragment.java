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
 * @description: 发展对象的确定和考察阶段
 */
public class DevelopConfirmFragment extends BaseDevelopPartyFragment {

    @Override
    public List<NativeDevelopParty> getParties() {
        return initPartys();
    }

    @Override
    public void submit(List<NativeDevelopParty> parties) {
        Map<String, Object> map = new HashMap<>();
        map.put("partyGroupPassTime3", parties.get(0).getContent());
        map.put("partyBranchPassTime3", parties.get(1).getContent());
        map.put("branchCommitteePassTime3", parties.get(2).getContent());
        map.put("partyCommitteeResearchDecisionTime3", parties.get(3).getContent());
        map.put("defineJoinPartyPerson3", parties.get(4).getContent());
        map.put("talkTime3", parties.get(5).getContent());
        map.put("talkCount3", parties.get(6).getContent());
        map.put("checkPoliticalBackgroundTime3", parties.get(7).getContent());
        map.put("politicalConclusion3", parties.get(8).getContent());
        map.put("concentratedTrainingTime3", parties.get(9).getContent());
        map.put("trainingResults3", parties.get(10).getContent());
        saveData(map);
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

    public void setPartyData(DevelopParty developParty){
        if(developParty.submitStatus == 1){

        }
        parties.get(0).setContent(developParty.partyGroupPassTime3);
        parties.get(1).setContent(developParty.partyBranchPassTime3);
        parties.get(2).setContent(developParty.branchCommitteePassTime3);
        parties.get(3).setContent(developParty.partyCommitteeResearchDecisionTime3);
        parties.get(4).setContent(developParty.defineJoinPartyPerson3);
        parties.get(5).setContent(developParty.talkTime3);
        parties.get(6).setContent(developParty.talkCount3);
        parties.get(7).setContent(developParty.politicalConclusion3);
        parties.get(8).setContent(developParty.partyCommitteeResearchDecisionTime3);
        parties.get(9).setContent(developParty.concentratedTrainingTime3);
        parties.get(10).setContent(developParty.trainingResults3);
//        mAdapter.getDatas().clear();
//        mAdapter.getDatas().addAll(parties);
        mAdapter.notifyDataSetChanged();
    }

}
