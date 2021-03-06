package kr.kro.awesometic.plankhelper.statistics.calendar;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.kro.awesometic.plankhelper.R;
import kr.kro.awesometic.plankhelper.data.PlankLog;
import kr.kro.awesometic.plankhelper.util.Constants;

/**
 * Created by Awesometic on 2017-05-30.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<PlankLog> mPlankLogs = new ArrayList<PlankLog>();

    public RecyclerViewAdapter() {

    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_HEAD;
            default:
                return Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_BODY;
        }
    }

    @Override
    public int getItemCount() {
        return mPlankLogs.size();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_HEAD:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.statistics_calendar_head, parent, false);
                break;
            case Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_BODY:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.statistics_calendar_body, parent, false);
                break;

            default:
                view = null;
                break;
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_HEAD:

                break;
            case Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_BODY:

                break;
        }
    }

    public void setPlankLogs(ArrayList<PlankLog> plankLogs) {
        mPlankLogs.clear();
        notifyDataSetChanged();

        // position 0 에 카드를 그리기 위한 더미 데이터(null) 삽입
        mPlankLogs.add(null);
        if (plankLogs != null && plankLogs.size() > 0) {
            // position 1부터 실제 데이터 삽입
            mPlankLogs.addAll(plankLogs);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.statistics_calendar)
        MaterialCalendarView mMaterialCalendarView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
