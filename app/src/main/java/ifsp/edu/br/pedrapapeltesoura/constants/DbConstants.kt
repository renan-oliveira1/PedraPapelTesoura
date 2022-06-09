package ifsp.edu.br.pedrapapeltesoura.constants

class DbConstants {
    companion object{
        const val BD_GAME = "PedraPapelTesoura"
        const val  TABLE_GAME = "jogo"
        const val COLUMN_ID = "id"
        const val COLUMN_SETTINGS = "configuracoes"

        const val CREATE_TABLE_STMT = "CREATE TABLE IF NOT EXISTS ${TABLE_GAME} (" +
                "${COLUMN_ID} INTEGER NOT NULL PRIMARY KEY, " +
                "${COLUMN_SETTINGS} INTEGER NOT NULL)"

        const val INSERT_DEAULT_SETTINGS = "INSERT INTO ${TABLE_GAME} (${COLUMN_ID}, ${COLUMN_SETTINGS}) "+
                "VALUES ( 1, 2 )"
    }
}