package com.example.p2android.table;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class LojaTB {
    private LojaTB() {
    }

    public static class StructureLojaTB implements BaseColumns {

        public static final String TABLE_NAME = "lojahardware";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_ESTADO = "estado";
        public static final String COLUMN_NAME_CIDADE = "cidade";

        private static final String SQL_CREATE_LOJAHARDWARE =
                "CREATE TABLE " + StructureLojaTB.TABLE_NAME + " (" +
                        StructureLojaTB._ID + " INTEGER PRIMARY KEY," +
                        StructureLojaTB.COLUMN_NAME_NOME + " TEXT," +
                        StructureLojaTB.COLUMN_NAME_CIDADE + " TEXT," +
                        StructureLojaTB.COLUMN_NAME_ESTADO + " TEXT)";
        private static final String SQL_DELETE_LOJAHARDWARE =
                "DROP TABLE IF EXISTS " + StructureLojaTB.TABLE_NAME;

    }

    public static class HardwareDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "lojawesley.db";


        public HardwareDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(StructureLojaTB.SQL_CREATE_LOJAHARDWARE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(StructureLojaTB.SQL_DELETE_LOJAHARDWARE);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }


    }
}
