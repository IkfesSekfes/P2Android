package com.example.p2android.table;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class FuncionarioTB {

    private FuncionarioTB() {
    }

    public static class StructureFuncionarioTB implements BaseColumns {

        public static final String TABLE_NAME = "funcionariohardware";
        public static final String COLUMN_NAME_USUARIO = "usuario";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_SOBRENOME = "sobrenome";
        public static final String COLUMN_NAME_IDADE = "idade";
        public static final String COLUMN_NAME_SENHA = "senha";

        private static final String SQL_CREATE_FUNCIONARIOHARDWARE =
                "CREATE TABLE " + FuncionarioTB.StructureFuncionarioTB.TABLE_NAME + " (" +
                        FuncionarioTB.StructureFuncionarioTB._ID + " INTEGER PRIMARY KEY," +
                        FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_USUARIO + " TEXT," +
                        FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_NOME + " TEXT," +
                        FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_SOBRENOME + " TEXT,"+
                        FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_IDADE + " NUMBER," +
                        FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_SENHA + " NUMBER)";
        private static final String SQL_DELETE_FUNCIONARIOHARDWARE =
                "DROP TABLE IF EXISTS " + FuncionarioTB.StructureFuncionarioTB.TABLE_NAME;

    }

    public static class HardwareDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "lojawesley.db";


        public HardwareDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(StructureFuncionarioTB.SQL_CREATE_FUNCIONARIOHARDWARE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(StructureFuncionarioTB.SQL_DELETE_FUNCIONARIOHARDWARE);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }


    }
}
