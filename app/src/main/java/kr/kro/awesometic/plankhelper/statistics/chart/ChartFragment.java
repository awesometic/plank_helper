package kr.kro.awesometic.plankhelper.statistics.chart;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ViewAnimator;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.kro.awesometic.plankhelper.R;
import kr.kro.awesometic.plankhelper.util.Constants;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Awesometic on 2017-05-17.
 */

public class ChartFragment extends Fragment implements ChartContract.View {

    private ChartContract.Presenter mPresenter;
    private Context mContext;

    @BindView(R.id.statistics_chart_frag_animator)
    ViewAnimator mViewAnimator;

    // ButterKnife 가 아니라 mViewAnimator 에 의해 초기화 됨
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private boolean mIsViewsBound;
    private LineChartView mLineChartView;

    public ChartFragment() {

    }

    public static ChartFragment newInstance() {
        return new ChartFragment();
    }

    public void setPresenter(@NonNull ChartContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        mIsViewsBound = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.statistics_chart_frag, container, false);
        ButterKnife.bind(this, rootView);

        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView = (RecyclerView) mViewAnimator.getChildAt(Constants.COMMON_ANIMATOR_POSITION.RECYCLERVIEW);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!mIsViewsBound) {
                    mPresenter.bindViewsFromViewHolderToFrag();

                    mIsViewsBound = true;
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        mViewAnimator.setDisplayedChild(Constants.COMMON_ANIMATOR_POSITION.LOADING);
    }

    @Override
    public void showChart() {
        mViewAnimator.setDisplayedChild(Constants.COMMON_ANIMATOR_POSITION.RECYCLERVIEW);
    }

    @Override
    public Object getActivityContext() {
        return mContext;
    }

    @Override
    public void setRecyclerViewAdapter(Object recyclerViewAdapter) {
        mRecyclerView.setAdapter((RecyclerViewAdapter) recyclerViewAdapter);
    }

    @Override
    public void bindViewsFromViewHolder() {
        RecyclerViewAdapter.ViewHolder holder = (RecyclerViewAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(0);

        if (holder.getItemViewType() == Constants.RECYCLERVIEW_ADAPTER_VIEWTYPE.TYPE_HEAD) {

        }
    }
}
