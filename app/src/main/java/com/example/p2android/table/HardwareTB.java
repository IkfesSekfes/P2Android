package com.example.p2android.table;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

//hardware = produto
public final class HardwareTB {
    private HardwareTB(){}
    public static class StructureHardwareTB implements BaseColumns {

        public static final String TABLE_NAME = "produtohardware";
        public static final String COLUMN_NAME_NOMEPRODUTO = "nome_produto";
        public static final String COLUMN_NAME_TIPO = "tipo_produto";
        public static final String COLUMN_NAME_MARCA = "marca_produto";
        public static final String COLUMN_NAME_PRECO = "preco_produto";

        private static final String SQL_CREATE_PRODUTOHARDWARE =
                "CREATE TABLE " + HardwareTB.StructureHardwareTB.TABLE_NAME + " (" +
                        HardwareTB.StructureHardwareTB._ID + " INTEGER PRIMARY KEY," +
                        HardwareTB.StructureHardwareTB.COLUMN_NAME_NOMEPRODUTO + " TEXT," +
                        HardwareTB.StructureHardwareTB.COLUMN_NAME_TIPO + " TEXT," +
                        HardwareTB.StructureHardwareTB.COLUMN_NAME_MARCA + " TEXT,"+
                        HardwareTB.StructureHardwareTB.COLUMN_NAME_PRECO + " NUMBER)";
        private static final String SQL_DELETE_PRODUTOHARDWARE =
                "DROP TABLE IF EXISTS " + HardwareTB.StructureHardwareTB.TABLE_NAME;

    }

    public static class HardwareDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "lojawesleyhardware.db";
        //mudar o banco quando for ver outra tela


        public HardwareDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(HardwareTB.StructureHardwareTB.SQL_CREATE_PRODUTOHARDWARE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(StructureHardwareTB.SQL_DELETE_PRODUTOHARDWARE);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }


}
