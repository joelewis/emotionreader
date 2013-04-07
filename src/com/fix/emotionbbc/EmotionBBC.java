package com.fix.emotionbbc;

import java.util.ArrayList;
import java.util.Locale;

import com.fix.emotionbbc.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EmotionBBC extends FragmentActivity {
	public static Context EmotionBBCcontext;
	 
	
	private static ArrayList<String> joy = new ArrayList<String>();
	  private static ArrayList<String> anger = new ArrayList<String>();
	  private static ArrayList<String> fear = new ArrayList<String>();
	  private static ArrayList<String> sadness = new ArrayList<String>();
	  private static ArrayList<String> surprise = new ArrayList<String>();
	  private static ArrayList<String> disgust = new ArrayList<String>();
	  private static ArrayList<String> joylink = new ArrayList<String>();
	  private static ArrayList<String> angerlink = new ArrayList<String>();
	  private static ArrayList<String> fearlink = new ArrayList<String>();
	  private static ArrayList<String> sadnesslink = new ArrayList<String>();
	  private static ArrayList<String> surpriselink = new ArrayList<String>();
	  private static ArrayList<String> disgustlink = new ArrayList<String>();
	  private static ArrayList<String> joydes = new ArrayList<String>();
	  private static ArrayList<String> angerdes = new ArrayList<String>();
	  private static ArrayList<String> feardes = new ArrayList<String>();
	  private static ArrayList<String> sadnessdes = new ArrayList<String>();
	  private static ArrayList<String> surprisedes = new ArrayList<String>();
	  private static ArrayList<String> disgustdes = new ArrayList<String>();
	  
	  Intent intent1 = getIntent();
	  

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emotion_bbc);
		EmotionBBCcontext = this;

		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		String[] emotionList = {"Joy", "Sadness", "Fear", "Surprise", "Disgust", "Anger"};
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras().getBundle("databundle");
		anger = bundle.getStringArrayList("anger");
		joy = bundle.getStringArrayList("joy");
		sadness = bundle.getStringArrayList("sadness");
		fear = bundle.getStringArrayList("fear");
		disgust = bundle.getStringArrayList("disgust");
		surprise = bundle.getStringArrayList("surprise");
		angerdes = bundle.getStringArrayList("angerdes");
		joydes = bundle.getStringArrayList("joydes");
		sadnessdes = bundle.getStringArrayList("sadnessdes");
		feardes = bundle.getStringArrayList("feardes");
		disgustdes = bundle.getStringArrayList("disgustdes");
		surprisedes = bundle.getStringArrayList("surprisedes");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emotion_bbc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			/*
			switch (position) {
			case 0:
				
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				args.putStringArrayList("title", joy);
				args.putStringArrayList("description", joydes);
			case 1:
				
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				args.putStringArrayList("title", sadness);
				args.putStringArrayList("description", sadnessdes);
			
			case 2:				
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				args.putStringArrayList("title", anger);
				args.putStringArrayList("description", angerdes);
			
			case 3:				
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				args.putStringArrayList("title", surprise);
				args.putStringArrayList("description", surprisedes);
			
			case 4:				
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				args.putStringArrayList("title", fear);
				args.putStringArrayList("description", feardes);
				
			case 5:				
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				args.putStringArrayList("title", disgust);
				args.putStringArrayList("description", disgustdes);
				
			} */
			
	
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 6;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return "JOY";
				//return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return "SADNESS";
				//return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return "ANGER";
				//return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return "SURPRISE";
			case 4:
				return "FEAR";
			case 5:
				return "DISGUST";
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_emotion_bbc_dummy, container, false);
			ListView lv = (ListView) rootView
					.findViewById(R.id.emotion_list);
			int pageId = getArguments().getInt(ARG_SECTION_NUMBER);
		    
			MyArrayAdapter adapter = null;
			switch(pageId) {
			case 1:	
			    adapter = new MyArrayAdapter(EmotionBBCcontext,joy, joydes); break;			
			case 2:
			    adapter = new MyArrayAdapter(EmotionBBCcontext,sadness, sadnessdes); break;
			case 3:
				adapter = new MyArrayAdapter(EmotionBBCcontext, anger, angerdes); break;
			case 4:
			    adapter = new MyArrayAdapter(EmotionBBCcontext, surprise, surprisedes); break;
			case 5:
				adapter = new MyArrayAdapter(EmotionBBCcontext, fear, feardes); break;
			case 6:
				adapter = new MyArrayAdapter(EmotionBBCcontext, disgust, disgustdes); break;
			}
			
			//dummyTextView.setText(Integer.toString(getArguments().getInt(
			//		ARG_SECTION_NUMBER)));
		    lv.setAdapter(adapter);
			return rootView;
		}
	}

}
