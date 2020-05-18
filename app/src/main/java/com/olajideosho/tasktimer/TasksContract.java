package com.olajideosho.tasktimer;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static com.olajideosho.tasktimer.AppProvider.CONTENT_AUTHORITY_URI;

public class TasksContract {
    public static final String TABLE_NAME = "Tasks";

    public static class Columns{
        public static final String _ID = BaseColumns._ID;
        public static final String TASKS_NAME = "Name";
        public static final String TASKS_DESCRIPTION = "Description";
        public static final String TASKS_SORTORDER = "SortOrder";

        private Columns(){
            //Private constructor to avoid instantiation
        }
    }

    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_URI + "." + TABLE_NAME;
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_URI + "." + TABLE_NAME;

    public static Uri buildTaskUri(long taskId){
        return ContentUris.withAppendedId(CONTENT_URI, taskId);
    }

    public static long getTaskId(Uri uri){
        return ContentUris.parseId(uri);
    }
}
