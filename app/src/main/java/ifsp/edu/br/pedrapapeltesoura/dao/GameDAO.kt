package ifsp.edu.br.pedrapapeltesoura.dao

interface GameDAO {

    fun updateSettings(numberPlayers: Int): Int
    fun getSettings(): Int

}