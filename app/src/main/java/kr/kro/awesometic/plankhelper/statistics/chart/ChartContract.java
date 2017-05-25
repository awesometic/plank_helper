package kr.kro.awesometic.plankhelper.statistics.chart;

import kr.kro.awesometic.plankhelper.BasePresenter;
import kr.kro.awesometic.plankhelper.BaseView;

/**
 * Created by Awesometic on 2017-05-17.
 */

public interface ChartContract {

    interface View extends BaseView<Presenter> {

        void setRecyclerViewAdapter(Object recyclerViewAdapter);
    }

    interface Presenter extends BasePresenter {

    }
}
