package com.olajideosho.tasktimer;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static com.olajideosho.tasktimer.AppProvider.CONTENT_AUTHORITY_URI;

public class TimingsContract {
    public static final String TABLE_NAME = "Timings";

    public static class Columns{
        public static final String _ID = BaseColumns._ID;
        public static final String TIMINGS_TASK_ID = "TaskId";
        public static final String TIMINGS_START_TIME = "StartTime";
        public static final String TIMINGS_DURATION = "Duration";

        private Columns(){
            //Private constructor to avoid instantiation
        }
    }

    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_URI + "." + TABLE_NAME;
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_URI + "." + TABLE_NAME;

    public static Uri buildTimingUri(long TimingId){
        return ContentUris.withAppendedId(CONTENT_URI, TimingId);
    }

    public static long getTimingId(Uri uri){
        return ContentUris.parseId(uri);
    }
}
