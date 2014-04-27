package com.antonyt.demos.androidsupportlibrary;

import com.antonyt.demos.androidsupportlibrary.actionbarcompat.ActionBarCompatExampleActivity;
import com.antonyt.demos.androidsupportlibrary.drawerlayout.DrawerLayoutExampleActivity;
import com.antonyt.demos.androidsupportlibrary.fragment.FragmentExampleActivity;
import com.antonyt.demos.androidsupportlibrary.gridlayout.GridLayoutExampleActivity;
import com.antonyt.demos.androidsupportlibrary.loader.LoaderExampleActivity;
import com.antonyt.demos.androidsupportlibrary.navutils.NavUtilsExampleActivity;
import com.antonyt.demos.androidsupportlibrary.nestedfragment.NestedFragmentExampleActivity;
import com.antonyt.demos.androidsupportlibrary.notifications.NotificationsExampleActivity;
import com.antonyt.demos.androidsupportlibrary.sharing.SharingExampleActivity;
import com.antonyt.demos.androidsupportlibrary.swiperefreshlayout.SwipeRefreshLayoutExampleActivity;
import com.antonyt.demos.androidsupportlibrary.viewpager.ViewPagerExampleActivity;
import com.antonyt.demos.androidsupportlibrary.wakefulbroadcastreceiver.WakefulBroadcastReceiverExampleActivity;

public enum ExampleType {

    FRAGMENTS(R.string.fragments_title, FragmentExampleActivity.class),
    LOADERS(R.string.loaders_title, LoaderExampleActivity.class),
    VIEWPAGER(R.string.viewpager_title, ViewPagerExampleActivity.class),
    NAV_UTILS(R.string.nav_utils_title, NavUtilsExampleActivity.class),
    NOTIFICATIONS(R.string.notifications_title, NotificationsExampleActivity.class),
    SHARING(R.string.sharing_title, SharingExampleActivity.class),
    NESTED_FRAGMENTS(R.string.nested_fragments_title, NestedFragmentExampleActivity.class),
    DRAWER_LAYOUT(R.string.drawer_layout_title, DrawerLayoutExampleActivity.class),
    GRID_LAYOUT(R.string.grid_layout_title, GridLayoutExampleActivity.class),
    WAKEFUL_BROADCAST_RECEIVER(R.string.wakeful_broadcast_receiver_title,
            WakefulBroadcastReceiverExampleActivity.class),
    ACTION_BAR_COMPAT(R.string.action_bar_compat_title, ActionBarCompatExampleActivity.class),
   SWIPE_REFRESH_LAYOUT(R.string.swipe_refresh_layout_title, SwipeRefreshLayoutExampleActivity.class);

    private final int mTitleResId;
    private final Class<?> mClazz;

    ExampleType(int titleResId, Class<?> clazz) {
        mTitleResId = titleResId;
        mClazz = clazz;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public Class<?> getClazz() {
        return mClazz;
    }
}
