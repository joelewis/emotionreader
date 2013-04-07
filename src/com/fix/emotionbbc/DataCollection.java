package com.fix.emotionbbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mcsoxford.rss.RSSFeed;
import org.mcsoxford.rss.RSSItem;
import org.mcsoxford.rss.RSSReader;
import org.mcsoxford.rss.RSSReaderException;

import synesketch.emotion.EmotionalState;
import synesketch.emotion.Empathyscope;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DataCollection extends IntentService {

	  private Exception exception;
	  RSSFeed feed = null;
	  List<RSSItem> feedItems;
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
	  private EmotionalState state;
	  
	/** 
	   * A constructor is required, and must call the super IntentService(String)
	   * constructor with a name for the worker thread.
	   */
	  public DataCollection() {
	      super("DataCollection");
	  }

	  /**
	   * The IntentService calls this method from the default worker thread with
	   * the intent that started the service. When this method returns, IntentService
	   * stops the service, as appropriate.
	   */
	  @Override
	  protected void onHandleIntent(Intent intent) {
		  Log.i("dataservice","into service handle intent...");
		  try {
	        	
	        	RSSReader reader = new RSSReader();
	            String uri = "http://feeds.bbci.co.uk/news/rss.xml";
	            
	            try {
	             	feed = reader.load(uri);
	     		} catch (RSSReaderException e) {
	     			// TODO Auto-generated catch block
	     			e.printStackTrace();
	     			Log.i("exception", "exception: failed to load");
	     		}
	        	
	       
	    	} catch (Exception e) {
	            this.exception = e;
	            Log.i("exception", "dint fetch rss..." );
	            e.printStackTrace();
	        }
		  Log.i("dataservice","data fetched from" + feed.getTitle());
		  feedItems = feed.getItems();
		  //Intent dataClassifyIntent = new Intent(this, DataCategorization.class);
		  //Bundle data = new Bundle();
		  //data.putParcelableArrayList("feedListItems", feedItems);
		  //startService(dataClassifyIntent);
		  Toast.makeText(MainActivity.context, "news fetched!", Toast.LENGTH_LONG).show();
		  for(int i=0; i<feedItems.size(); i++) {
	        	try {
	        		String text = feedItems.get(i).getDescription();
	        		state = Empathyscope.getInstance().feel(text);
	        		switch(state.getStrongestEmotion().getType()) {
					case 0:
						joy.add(feedItems.get(i).getTitle()); 
						joydes.add(feedItems.get(i).getDescription());
						Log.i("j", ""+feedItems.get(i).getTitle() + "belongs to joy"); break;
					case 1:
						sadness.add(feedItems.get(i).getTitle()); 
						sadnessdes.add(feedItems.get(i).getDescription());
						Log.i("j", ""+feedItems.get(i).getTitle() + "belongs to SAD"); break;
					case 2:
						fear.add(feedItems.get(i).getTitle());
						feardes.add(feedItems.get(i).getDescription());
						Log.i("j", ""+feedItems.get(i).getTitle() + "belongs to FEAR"); break;
					case 3:
						anger.add(feedItems.get(i).getTitle());
						angerdes.add(feedItems.get(i).getDescription());
						Log.i("j", ""+feedItems.get(i).getTitle() + "belongs to ANGER"); break;
					case 4:
						disgust.add(feedItems.get(i).getTitle()); 
						disgustdes.add(feedItems.get(i).getDescription());
						Log.i("j", ""+feedItems.get(i).getTitle() + "belongs to disgust"); break;
					case 5:
						surprise.add(feedItems.get(i).getTitle()); 
						surprisedes.add(feedItems.get(i).getDescription());
						Log.i("j", ""+feedItems.get(i).getTitle() + "belongs to surprise"); break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.i("exception","categorization failed!");
				}
	        	//headlines.add(feedItems.get(i).getTitle());
	        }
		  Toast.makeText(MainActivity.context, "categorization complete", Toast.LENGTH_LONG).show();
		  Intent showNews = new Intent(this, EmotionBBC.class);
		  Bundle data = new Bundle();
		  data.putStringArrayList("joy", joy);
		  data.putStringArrayList("joydes", joydes);
		  data.putStringArrayList("sadness", sadness);
		  data.putStringArrayList("sadnessdes", sadnessdes);
		  data.putStringArrayList("fear", fear);
		  data.putStringArrayList("feardes", feardes);
		  data.putStringArrayList("anger", anger);
		  data.putStringArrayList("angerdes", angerdes);
		  data.putStringArrayList("disgust", disgust);
		  data.putStringArrayList("disgustdes", disgustdes);
		  data.putStringArrayList("surprise", surprise);
		  data.putStringArrayList("surprisedes", surprisedes);
		  showNews.putExtra("databundle", data);
		  showNews.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		  getApplication().startActivity(showNews);
		  
	  }
	}