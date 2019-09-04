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
 * @description: 预备党员的教育考察和转正
 */
public class PrepareMainFragment extends BaseDevelopPartyFragment {

    @Override
    public List<NativeDevelopParty> getParties() {
        return initPartys();
    }

    @Override
    public void submit(List<NativeDevelopParty> parties) {
        Map<String, Object> map = new HashMap<>();
        map.put("compilePartyGroupPartyBranchTime5", parties.get(0).getContent());
        map.put("joinPartySwearOathTime5", parties.get(1).getContent());
        map.put("applicationCorrectionTime5", parties.get(2).getContent());
        map.put("partyGroupPassTime5", parties.get(3).getContent());
        map.put("branchConferencePassTime5", parties.get(4).getContent());
        map.put("parentPartyCommitteeTalkTime5", parties.get(5).getContent());
        map.put("talker5", parties.get(6).getContent());
        map.put("parentPartyCommitteePassTime5", parties.get(7).getContent());
        map.put("meetingTime5", parties.get(8).getContent());
        map.put("partyMembersCount5", parties.get(9).getContent());
        map.put("partyMembershipCount5", parties.get(10).getContent());
        map.put("sendVotes5", parties.get(11).getContent());
        map.put("takeBackVotes5", parties.get(12).getContent());
        map.put("agreeVotes5", parties.get(13).getContent());
        saveData(map);
    }

    public void setPartyData(DevelopParty developParty){
        if(developParty.submitStatus == 1){

        }
        parties.get(0).setContent(developParty.compilePartyGroupPartyBranchTime5);
        parties.get(1).setContent(developParty.joinPartySwearOathTime5);
        parties.get(2).setContent(developParty.applicationCorrectionTime5);
        parties.get(3).setContent(developParty.partyGroupPassTime5);
        parties.get(4).setContent(developParty.branchConferencePassTime5);
        parties.get(5).setContent(developParty.parentPartyCommitteeTalkTime5);
        parties.get(6).setContent(developParty.talker5);
        parties.get(7).setContent(developParty.parentPartyCommitteePassTime5);
        parties.get(8).setContent(developParty.meetingTime5);
        parties.get(9).setContent(developParty.partyMembersCount5);
        parties.get(10).setContent(developParty.partyMembershipCount5);
        parties.get(11).setContent(developParty.sendVotes5);
        parties.get(12).setContent(developParty.takeBackVotes5);
        parties.get(13).setContent(developParty.agreeVotes5);
//        mAdapter.getDatas().clear();
//        mAdapter.getDatas().addAll(parties);
        mAdapter.notifyDataSetChanged();
    }

    private List<NativeDevelopParty> initPartys(){
        List<NativeDevelopParty> partyList= new ArrayList<>();
        partyList.add(new NativeDevelopParty(0,"编入党支部和党小组时间", ""));
        partyList.add(new NativeDevelopParty(0,"入党宣誓时间", ""));
        partyList.add(new NativeDevelopParty(0,"提出转正申请时间", ""));
        partyList.add(new NativeDevelopParty(0,"支部大会通过时间", ""));
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
