package com.example.jchandler.archeryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SetListDB {

    public static final String DB_NAME = "archeryScores.db";
    public static final int DB_VERSION = 1;

    public static final String ALL_SETS = "sets";

    public static final String SET_NUMBER = "setNumber";
    public static int SET_NUMBER_COL = 0;

    public static final String ARROW1 = "one";
    public static int ARROW1_COL = 1;

    public static final String ARROW2 = "two";
    public static int ARROW2_COL = 2;

    public static final String ARROW3 = "three";
    public static int ARROW3_COL = 3;

    public static final String ARROW4 = "four";
    public static int ARROW4_COL = 4;

    public static final String ARROW5 = "five";
    public static int ARROW5_COL = 5;

    public static final String ARROW6 = "six";
    public static int ARROW6_COL = 6;

    public static final String ARROW7 = "seven";
    public static int ARROW7_COL = 7;

    public static final String ARROW8 = "eight";
    public static int ARROW8_COL = 8;

    public static final String ARROW9 = "nine";
    public static int ARROW9_COL = 9;

    public static final String ARROW10 = "ten";
    public static int ARROW10_COL = 10;

    public static final String CREATE_ALL_SETS_TABLE =
            "CREATE TABLE IF NOT EXISTS " + ALL_SETS + " (" +
                    SET_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ARROW1 + " INTEGER NOT NULL, " +
                    ARROW2 + " INTEGER NOT NULL, " +
                    ARROW3 + " INTEGER NOT NULL, " +
                    ARROW4 + " INTEGER NOT NULL, " +
                    ARROW5 + " INTEGER NOT NULL, " +
                    ARROW6 + " INTEGER NOT NULL, " +
                    ARROW7 + " INTEGER NOT NULL, " +
                    ARROW8 + " INTEGER NOT NULL, " +
                    ARROW9 + " INTEGER NOT NULL, " +
                    ARROW10 + " INTEGER NOT NULL);";

    public static final String DROP_ALL_SETS_TABLE = "DROP TABLE IF EXISTS " + ALL_SETS;

    public static final String TEST_DATA1 = "INSERT INTO " + ALL_SETS + " VALUES (1,9,9,9,9,9,9,9,9,9,9)";
    public static final String TEST_DATA2 = "INSERT INTO " + ALL_SETS + " VALUES (2,8,8,8,8,8,8,8,8,8,8)";

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name,
                        CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // create tables
            db.execSQL(CREATE_ALL_SETS_TABLE);

            // insert sample tasks
            //db.execSQL(TEST_DATA1);
            //db.execSQL(TEST_DATA2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.d("Task list", "Upgrading db from version " + oldVersion + " to " + newVersion);

            db.execSQL(SetListDB.DROP_ALL_SETS_TABLE);
            onCreate(db);
        }
    }

    // database and database helper objects
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    // constructor
    public SetListDB(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    // private methods
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if (db != null)
            db.close();
    }

    private void closeCursor(Cursor cursor) {
        if (cursor != null)
            cursor.close();
    }

    // public methods
    public ArrayList<Set> getAllSets() {
        ArrayList<Set> sets = new ArrayList<Set>();
        try {
            openReadableDB();
            Cursor cursor = db.query(ALL_SETS, null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                Set s = new Set();
                s.SetSetID(cursor.getInt(SET_NUMBER_COL));
                s.setTheArrows(cursor.getInt(ARROW1_COL)
                        , cursor.getInt(ARROW2_COL)
                        , cursor.getInt(ARROW3_COL)
                        , cursor.getInt(ARROW4_COL)
                        , cursor.getInt(ARROW5_COL)
                        , cursor.getInt(ARROW6_COL)
                        , cursor.getInt(ARROW7_COL)
                        , cursor.getInt(ARROW8_COL)
                        , cursor.getInt(ARROW9_COL)
                        , cursor.getInt(ARROW10_COL)
                );
                sets.add(s);
            }
            closeCursor(cursor);
            closeDB();
        }
        catch (SQLiteException ex)
        {
            return sets;
        }
        return sets;
    }


    private static Set getSetFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Set s = new Set();
                s.setTheArrows(cursor.getInt(ARROW1_COL)
                        , cursor.getInt(ARROW2_COL)
                        , cursor.getInt(ARROW3_COL)
                        , cursor.getInt(ARROW4_COL)
                        , cursor.getInt(ARROW5_COL)
                        , cursor.getInt(ARROW6_COL)
                        , cursor.getInt(ARROW7_COL)
                        , cursor.getInt(ARROW8_COL)
                        , cursor.getInt(ARROW9_COL)
                        , cursor.getInt(ARROW10_COL)
                );
                return s;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    public long insertSet(Set s) {


        openWriteableDB();
        //db.execSQL(DROP_ALL_SETS_TABLE);
        db.execSQL(CREATE_ALL_SETS_TABLE);
        closeDB();

        ContentValues cv = new ContentValues();
        cv.put(ARROW1, s.getArrow1());
        cv.put(ARROW2, s.getArrow2());
        cv.put(ARROW3, s.getArrow3());
        cv.put(ARROW4, s.getArrow4());
        cv.put(ARROW5, s.getArrow5());
        cv.put(ARROW6, s.getArrow6());
        cv.put(ARROW7, s.getArrow7());
        cv.put(ARROW8, s.getArrow8());
        cv.put(ARROW9, s.getArrow9());
        cv.put(ARROW10, s.getArrow10());

        this.openWriteableDB();
        long rowID = db.insert(ALL_SETS, null, cv);
        this.closeDB();

        return rowID;
    }


    public int deleteTask(long id) {
        String where = SET_NUMBER_COL + "= ?";
        String[] whereArgs = { String.valueOf(id) };

        this.openWriteableDB();
        int rowCount = db.delete(ALL_SETS, where, whereArgs);
        this.closeDB();

        return rowCount;
    }
}
