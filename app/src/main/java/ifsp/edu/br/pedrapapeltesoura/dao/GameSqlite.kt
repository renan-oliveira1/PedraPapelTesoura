package ifsp.edu.br.pedrapapeltesoura.dao

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import ifsp.edu.br.pedrapapeltesoura.R
import ifsp.edu.br.pedrapapeltesoura.constants.DbConstants
import java.sql.SQLException

class GameSqlite(context: Context): GameDAO {

    private val gameBD: SQLiteDatabase
    init {
        gameBD = context.openOrCreateDatabase(DbConstants.BD_GAME, MODE_PRIVATE, null)

        try {
            gameBD.execSQL(DbConstants.CREATE_TABLE_STMT)
            val query =
                "SELECT * FROM ${DbConstants.TABLE_GAME} WHERE ${DbConstants.COLUMN_ID} = 1"
            val cursor = gameBD.rawQuery(query, null)
            if(!cursor.moveToNext()){
                gameBD.execSQL(DbConstants.INSERT_DEAULT_SETTINGS)
            }

        }catch (se: SQLException){
            Log.e(context.getString(R.string.app_name), se.toString())
        }

    }

    override fun updateSettings(numberPlayers: Int): Int {
        val gameSettings = ContentValues()

        gameSettings.put(DbConstants.COLUMN_SETTINGS, numberPlayers)

        return gameBD.update(DbConstants.TABLE_GAME, gameSettings,
            "${DbConstants.COLUMN_ID} = 1", null)
    }

    override fun getSettings(): Int {
        val query =
            "SELECT * FROM ${DbConstants.TABLE_GAME} WHERE ${DbConstants.COLUMN_ID} = 1"
        val cursor = gameBD.rawQuery(query, null)
        val index = cursor.getColumnIndex(DbConstants.COLUMN_SETTINGS)

        cursor.moveToNext()
        return cursor.getInt(index)

    }
}