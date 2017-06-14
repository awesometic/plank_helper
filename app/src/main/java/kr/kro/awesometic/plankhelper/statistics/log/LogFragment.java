package kr.kro.awesometic.plankhelper.statistics.log;

import android.content.Context;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.kro.awesometic.plankhelper.R;
import kr.kro.awesometic.plankhelper.util.Constants;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Awesometic on 2017-05-17.
 */

public class LogFragment extends Fragment implements LogContract.View {

    private LogContract.Presenter mPresenter;
    private Context mContext;

    @BindView(R.id.statistics_log_frag_animator)
    ViewAnimator mViewAnimator;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private boolean mIsViewsBound;

    public LogFragment() {

    }

    public static LogFragment newInstance() {
        return new LogFragment();
    }

    public void setPresenter(@NonNull LogContract.Presenter presenter) {
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
        View rootView = inflater.inflate(R.layout.statistics_log_frag, container, false);
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
    public void showLog() {
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
