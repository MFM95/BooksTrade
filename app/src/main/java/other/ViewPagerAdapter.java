package other;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragments.AboutUsFragment;
import fragments.FindBookFragment;
import fragments.HomeFragment;
import fragments.MyProfileFragment;
import fragments.NotificationFragment;
import fragments.OfferBookFragment;
import fragments.PrivacyPolicyFragment;
import fragments.SettingsFragment;
import fragments.ShareFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new FindBookFragment();
        }
        else if (position == 2) {
            return new OfferBookFragment();
        }
        else if (position == 3) {
            return new NotificationFragment();
        }
        else if (position == 4) {
            return new SettingsFragment();
        }

        else if (position == 5) {
            return new AboutUsFragment();
        }
        else if (position == 6) {
            return new PrivacyPolicyFragment();
        }
        else if (position == 7) {
            return new MyProfileFragment();
        }

        else return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}