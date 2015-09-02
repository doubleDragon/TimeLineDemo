package com.wsl.library.timeline.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wsl.library.image.TimeLineView;

/**
 * Created by wsl on 15-9-2.
 */
public class TimeLineListAdapter extends ArrayAdapter<Bean> {

    private LayoutInflater mInflater;

    public TimeLineListAdapter(Context context) {
        super(context, R.layout.item);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Bean item = getItem(position);
        View result;
        TimeLineListItemViewCache viewCache;
        if (convertView == null) {
            result = mInflater.inflate(R.layout.item, null);
            viewCache = new TimeLineListItemViewCache(result);
            result.setTag(viewCache);
        } else {
            result = convertView;
            viewCache = (TimeLineListItemViewCache) result.getTag();
        }
        viewCache.text.setText(item.text);
        viewCache.timeLineView.setDone(item.done);
        viewCache.timeLineView.setLast(item.last);
        return result;
    }

    private class TimeLineListItemViewCache {
        public final TextView text;
        public final TimeLineView timeLineView;

        public TimeLineListItemViewCache(View view) {
            this.text = (TextView) view.findViewById(R.id.text);
            this.timeLineView = (TimeLineView) view.findViewById(R.id.timeline);
        }
    }
}
