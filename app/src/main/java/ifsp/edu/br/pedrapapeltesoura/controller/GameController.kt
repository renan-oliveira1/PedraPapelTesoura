package ifsp.edu.br.pedrapapeltesoura.controller

import android.app.Activity
import android.app.Application
import ifsp.edu.br.pedrapapeltesoura.dao.GameSqlite

class GameController(application: Application) {
    private val context = application.applicationContext

    private val gameDAO: GameSqlite = GameSqlite(context)

    fun updateGameSettings(numberOfPlayer: Int){
        gameDAO.updateSettings(numberOfPlayer)
    }

    fun getGameSettings(): Int{
        return gameDAO.getSettings()
    }
}