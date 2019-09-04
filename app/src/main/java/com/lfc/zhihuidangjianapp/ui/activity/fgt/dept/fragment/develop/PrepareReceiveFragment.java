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
 * @description: 预备党员的接收阶段
 */
public class PrepareReceiveFragment extends BaseDevelopPartyFragment {

    @Override
    public List<NativeDevelopParty> getParties() {
        return initPartys();
    }

    @Override
    public void submit(List<NativeDevelopParty> parties) {
        Map<String, Object> map = new HashMap<>();
        map.put("subcommitteeReviewTime4", parties.get(0).getContent());
        map.put("publicityTime4", parties.get(1).getContent());
        map.put("parentPartyCommitteePretrialTime4", parties.get(2).getContent());
        map.put("branchConferencePassTime4", parties.get(3).getContent());
        map.put("parentPartyCommitteeTalkTime4", parties.get(4).getContent());
        map.put("talker4", parties.get(5).getContent());
        map.put("parentPartyCommitteePassTime4", parties.get(6).getContent());
        map.put("meetingTime4", parties.get(7).getContent());
        map.put("partyMembersCount4", parties.get(8).getContent());
        map.put("partyMembershipCount4", parties.get(9).getContent());
        map.put("sendVotes4", parties.get(10).getContent());
        map.put("takeBackVotes4", parties.get(11).getContent());
        map.put("agreeVotes4", parties.get(12).getContent());
        saveData(map);
    }

    public void setPartyData(DevelopParty developParty){
        if(developParty.submitStatus == 1){

        }
        parties.get(0).setContent(developParty.subcommitteeReviewTime4);
        parties.get(1).setContent(developParty.publicityTime4);
        parties.get(2).setContent(developParty.parentPartyCommitteePretrialTime4);
        parties.get(3).setContent(developParty.branchConferencePassTime4);
        parties.get(4).setContent(developParty.parentPartyCommitteeTalkTime4);
        parties.get(5).setContent(developParty.talker4);
        parties.get(6).setContent(developParty.meetingTime4);
        parties.get(7).setContent(developParty.partyMembersCount4);
        parties.get(8).setContent(developParty.partyMembershipCount4);
        parties.get(9).setContent(developParty.partyMembershipCount4);
        parties.get(10).setContent(developParty.sendVotes4);
        parties.get(11).setContent(developParty.takeBackVotes4);
        parties.get(12).setContent(developParty.agreeVotes4);
//        mAdapter.getDatas().clear();
//        mAdapter.getDatas().addAll(parties);
        mAdapter.notifyDataSetChanged();
    }

    private List<NativeDevelopParty> initPartys(){
        List<NativeDevelopParty> partyList= new ArrayList<>();
        partyList.add(new NativeDevelopParty(0,"支委会审查时间", ""));
        partyList.add(new NativeDevelopParty(0,"公示时间", ""));
        partyList.add(new NativeDevelopParty(0,"上级党委预审时间", ""));
        partyList.add(new NativeDevelopParty(0,"支部大会通过时间", ""));
        partyList.add(new NativeDevelopParty(0,"上级党委谈话时间", ""));
        partyList.add(new NativeDevelopParty(1,"谈话人", ""));
        partyList.add(new NativeDevelopParty(0,"上级党委通过时间", ""));
        partyList.add(new NativeDevelopParty(0,"会议时间", ""));
        partyList.add(new NativeDevelopParty(1,"应到会党员数", ""));
        partyList.add(new NativeDevelopParty(1,"实到会党员数", ""));
        partyList.add(new NativeDevelopParty(1,"发出票数", ""));
        partyList.add(new NativeDevelopParty(1,"收回票数", ""));
        partyList.add(new NativeDevelopParty(1,"同意票数", ""));
        return partyList;
    }

}
