package com.shane.powersaver.viewpagerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.shane.powersaver.R;
import com.shane.powersaver.adapter.ViewPageFragmentAdapter;
import com.shane.powersaver.base.BaseListFragment;
import com.shane.powersaver.base.BaseViewPagerFragment;
//import net.oschina.app.bean.BlogList;
import com.shane.powersaver.bean.NewsList;
//import net.oschina.app.fragment.general.BlogFragment;
//import net.oschina.app.fragment.general.EventFragment;
import com.shane.powersaver.fragment.general.GeneralListFragment;
import com.shane.powersaver.fragment.general.NewsFragment;
//import net.oschina.app.fragment.general.QuestionFragment;
import com.shane.powersaver.interf.OnTabReselectListener;

/**
 * GeneralViewPagerFragment
 *
 * @author shane（https://github.com/lxxgreat）
 * @version 1.0
 * @created 2016-08-07 18:06:44
 *
 */
public class GeneralViewPagerFragment extends BaseViewPagerFragment implements
        OnTabReselectListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[] title = getResources().getStringArray(
                R.array.general_viewpage_arrays);

        adapter.addTab(title[0], "news", NewsFragment.class,
                getBundle(NewsList.CATALOG_ALL));
        adapter.addTab(title[1], "latest_blog", NewsFragment.class,
                getBundle(NewsList.CATALOG_WEEK));
        adapter.addTab(title[2], "question", NewsFragment.class,
                getBundle(NewsList.CATALOG_ALL));
        adapter.addTab(title[3], "activity", NewsFragment.class,
                getBundle(NewsList.CATALOG_ALL));
    }

    private Bundle getBundle(int newType) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, newType);
        return bundle;
    }

    @Override
    protected void setScreenPageLimit() {
        mViewPager.setOffscreenPageLimit(3);
    }

    /**
     * 基类会根据不同的catalog展示相应的数据
     *
     * @param catalog 要显示的数据类别
     * @return
     */
    private Bundle getBundle(String catalog) {
        Bundle bundle = new Bundle();
        bundle.putString("BUNDLE_BLOG_TYPE", catalog);
        return bundle;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onTabReselect() {
        Fragment fragment = mTabsAdapter.getItem(mViewPager.getCurrentItem());
        if (fragment != null && fragment instanceof GeneralListFragment) {
            ((GeneralListFragment) fragment).onTabReselect();
        }
    }
}