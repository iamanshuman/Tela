package news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int TABCOUNT;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        TABCOUNT=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new HomeFragment();

            case 1:
                return new SportsFragment();

            case 2:
                return new TechnologyFragment();

            case 3:
                return new EntertainmentFragment();

            case 4:
                return new FinanceFragment();


            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return TABCOUNT;
    }
}
