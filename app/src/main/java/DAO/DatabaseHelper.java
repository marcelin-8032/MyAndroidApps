package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_NAME = "contact_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "LASTNAME";
    public static final String COL3 = "FIRSTNAME";
    public static final String COL4 = "EMAIL";
    public static final String COL5 = "TELEPHONE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "LASTNAME TEXT NOT NULL , FIRSTNAME TEXT NOT NULL, EMAIL TEXT NOT NULL UNIQUE, TELEPHONE TEXT NOT NULL UNIQUE)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String FNom, String IPrenom, String Eeemail, String Tttel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(COL2, FNom);
            contentValues.put(COL3, IPrenom);
            contentValues.put(COL4, Eeemail);
            contentValues.put(COL5, Tttel);
            long result = db.insert(TABLE_NAME, null, contentValues);

            if (result == -1) {
                return false;
            }
        } catch (NullPointerException ignored) {
//            e.printStackTrace();
        }
        return true;
    }

        public Cursor getListContents () {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return data;
        }

    }

