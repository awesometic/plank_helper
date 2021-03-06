package kr.kro.awesometic.plankhelper.statistics.calendar;

import kr.kro.awesometic.plankhelper.BasePresenter;
import kr.kro.awesometic.plankhelper.BaseView;

/**
 * Created by Awesometic on 2017-05-17.
 */

public interface CalendarContract {

    interface View extends BaseView<Presenter> {

        void showLoading();
        void showCalendar();

        Object getApplicationContext();
        void setRecyclerViewAdapter(Object recyclerViewAdapter);

        void bindViewsFromViewHolder();
    }

    interface Presenter extends BasePresenter {

        void bindViewsFromViewHolderToFrag();
    }
}
