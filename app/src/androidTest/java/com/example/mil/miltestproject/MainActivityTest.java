package com.example.mil.miltestproject;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mil on 3/5/2018 AD.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule(MainActivity.class);

    private MainActivity mActivity = null;

    //setup method is the method before execute
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {

        View view = mActivity.findViewById(R.id.password);

        assertNotNull(view);
    }

    //tearDown method is the method after execute
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

}