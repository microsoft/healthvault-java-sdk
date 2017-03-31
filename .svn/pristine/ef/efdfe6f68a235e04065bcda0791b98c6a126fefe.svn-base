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
	
	private ArrayList<String> resultList;
	private VocabIdentifier vocabKey;
	
	private LruCache<String, ArrayList<String>> cache;

    public VocabAutoCompleteAdapter(Context context, 
    		int textViewResourceId,
    		VocabIdentifier vocabKey,
    		HealthVaultClient hvClient) {
        super(context, textViewResourceId);
        
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        int memSize = am.getMemoryClass() * 1024 * 1024;
        
        this.vocabKey = vocabKey;
        cache = new LruCache<String, ArrayList<String>>(memSize);
        resultList = new ArrayList<String>(0);
    }

	@Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public String getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                	String searchText = constraint.toString();
                	String key = vocabKey.getFamily() + "_" + vocabKey.getName() + "_" + searchText;
                	
                	resultList = cache.get(key) == null ? new ArrayList<String>() : cache.get(key);
                	
                	if(resultList.size() == 0) {
	                    resultList = autocomplete(searchText);
	                    
	                    ArrayList<String> cachedResults = new ArrayList<String>();
	                    cachedResults.addAll(resultList);
	                    
	                    cache.put(key, cachedResults);
                	}
	
                    filterResults.values = resultList;
                    filterResults.count = resultList.size();
                }
                
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }
    
    private ArrayList<String> autocomplete(String searchText) {
    	Vocabs vocabs = HealthVaultApp.getInstance().getVocabs();
    	VocabQueryResult result = vocabs.search(vocabKey, searchText);
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
