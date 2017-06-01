package com.microsoft.hsg.android.hvsample;

import java.util.ArrayList;

import android.app.ActivityManager;
import android.content.Context;
import android.util.LruCache;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.Vocabs;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.methods.searchvocabulary.response.VocabQueryResult;
import com.microsoft.hsg.android.simplexml.vocabs.types.VocabIdentifier;
import com.microsoft.hsg.android.simplexml.vocabs.types.VocabItem;

public class VocabAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
	
	private ArrayList<String> mResultList;
	private VocabIdentifier mVocabKey;
	
	private LruCache<String, ArrayList<String>> mCache;

	public VocabAutoCompleteAdapter(Context context,
			int textViewResourceId,
			VocabIdentifier vocabKey,
			HealthVaultClient hvClient) {
		super(context, textViewResourceId);

		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		int memSize = am.getMemoryClass() * 1024 * 1024;

		mVocabKey = vocabKey;
		mCache = new LruCache<String, ArrayList<String>>(memSize);
		mResultList = new ArrayList<String>(0);
	}

	@Override
	public int getCount() {
		return mResultList.size();
	}

	@Override
	public String getItem(int index) {
		return mResultList.get(index);
	}

	@Override
	public Filter getFilter() {
		Filter filter = new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults filterResults = new FilterResults();
				if (constraint != null) {
					String searchText = constraint.toString();
					String key = mVocabKey.getFamily() + "_" + mVocabKey.getName() + "_" + searchText;

					mResultList = mCache.get(key) == null ? new ArrayList<String>() : mCache.get(key);

					if(mResultList.size() == 0) {
						mResultList = autocomplete(searchText);

						ArrayList<String> cachedResults = new ArrayList<String>();
						cachedResults.addAll(mResultList);

						mCache.put(key, cachedResults);
					}
	
					filterResults.values = mResultList;
					filterResults.count = mResultList.size();
				}

				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				if (results != null && results.count > 0) {
					notifyDataSetChanged();
				} else {
					notifyDataSetInvalidated();
				}
			}};
		return filter;
	}

	private ArrayList<String> autocomplete(String searchText) {
		Vocabs vocabs = HealthVaultApp.getInstance().getVocabs();
		VocabQueryResult result = vocabs.search(mVocabKey, searchText);
		ArrayList<String> results = new ArrayList<String>();

		if(result != null && result.hasItems()) {
			ArrayList<VocabItem> items = result.getItems();
			for(VocabItem item : items) {
				results.add(item.getDisplayText());
			}
		}

		return results;
	}
}
