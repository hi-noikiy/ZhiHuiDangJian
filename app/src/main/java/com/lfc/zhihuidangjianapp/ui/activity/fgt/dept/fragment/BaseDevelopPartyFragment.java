package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.ui.activity.adapter.DividerItemDecoration;
import com.lfc.zhihuidangjianapp.ui.activity.model.NativeDevelopParty;
import com.lfc.zhihuidangjianapp.utlis.DispalyUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/**
 * @date: 2019-09-02
 * @autror: guojian
 * @description:
 */
public abstract class BaseDevelopPartyFragment extends BaseFragment {

    private List<NativeDevelopParty> parties = new ArrayList<>();

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.parent_recyclerview;
    }

    @Override
    protected void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        parties = getParties();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<NativeDevelopParty>(getActivity(), R.layout.item_develop_party, parties) {
            @Override
            protected void convert(ViewHolder holder, NativeDevelopParty data, int position) {
                if(data.getStyleId() == 0){
                    holder.getConvertView().findViewById(R.id.input).setVisibility(View.GONE);
                    TextView tvContent = holder.getConvertView().findViewById(R.id.tvContent);
                    tvContent.setVisibility(View.VISIBLE);
                    tvContent.setText("请选择"+data.getTitle());
                    tvContent.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //选择时间
                            selectTime(position, tvContent);
                        }
                    });
                }else{
                    EditText input = holder.getConvertView().findViewById(R.id.input);
                    input.setHint("请输入"+data.getTitle());
                    input.setVisibility(View.VISIBLE);
                    holder.getConvertView().findViewById(R.id.tvContent).setVisibility(View.GONE);
                    input.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            parties.get(position).setContent(s.toString());
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });
                }
                holder.setText(R.id.tvTitle, data.getTitle());
            }

        });
        recyclerView.addItemDecoration(new DividerItemDecoration(
                DividerItemDecoration.VERTICAL_LIST,
                ContextCompat.getColor(getActivity(), R.color.background),
                DispalyUtil.dp2px(getActivity(), 1),
                0, 0, false
        ));
    }

    private void selectTime(final int position, TextView text) {
        final DatePicker picker = new DatePicker(getActivity());
        picker.setCanceledOnTouchOutside(true);
        picker.setUseWeight(true);
        picker.setTopPadding(ConvertUtils.toPx(getActivity(), 10));
        picker.setRangeEnd(2050, 1, 11);
        picker.setRangeStart(2016, 8, 29);
        picker.setSelectedItem(2019, 10, 14);
        picker.setResetWhileWheel(false);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                String time = year+"-"+month+"-"+day+" 00:00:00";
                text.setText(time);
                parties.get(position).setContent(time);
            }
        });
        picker.show();
    }

    public abstract List<NativeDevelopParty> getParties();

}
