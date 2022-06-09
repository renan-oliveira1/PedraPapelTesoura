package ifsp.edu.br.pedrapapeltesoura

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import ifsp.edu.br.pedrapapeltesoura.controller.GameController
import ifsp.edu.br.pedrapapeltesoura.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private val acvitityMainBinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

//    private lateinit var activitySettingsResultLauncher: ActivityResultLauncher<Intent>

    private var playerGameChoice: String? = null

    private val controller: GameController by lazy{
        GameController(this.application)
    }

    private val numberPlayers: Int by lazy{
        controller.getGameSettings()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acvitityMainBinding.root)


//        activitySettingsResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
//            if(result.resultCode == RESULT_OK){
//                if(result.data != null){
//                    val configResult = result.data!!.extras?.getInt(Constants.ACTIVITY_RESULT.NUMBER_PLAYERS)
//                    if (configResult != null) {
//                        numberPlayers = configResult
//                    }
//                }
//            }
//        }

        dealWithImageClick()

        acvitityMainBinding.buttonPlay.setOnClickListener {
            playGame()
        }

    }

    private fun dealWithImageClick(){
        acvitityMainBinding.imageviewPaper.setOnClickListener {
            acvitityMainBinding.textviewPlayerChoice.text = Constants.GAME.PAPER
            playerGameChoice = Constants.GAME.PAPER
        }
        acvitityMainBinding.imageviewRock.setOnClickListener {
            acvitityMainBinding.textviewPlayerChoice.text = Constants.GAME.ROCK
            playerGameChoice = Constants.GAME.ROCK
        }
        acvitityMainBinding.imageviewScissor.setOnClickListener {
            acvitityMainBinding.textviewPlayerChoice.text = Constants.GAME.SCISSOR
            playerGameChoice = Constants.GAME.SCISSOR
        }
    }

    private fun playGame(){
        if(playerGameChoice != null){
            val listOptions = listOf(Constants.GAME.PAPER, Constants.GAME.ROCK, Constants.GAME.SCISSOR)
            val machineOne: String = listOptions[Random.nextInt(0..2)]

            if(numberPlayers == 2){

                if ( (playerGameChoice.equals(Constants.GAME.ROCK) && machineOne.equals(Constants.GAME.PAPER))
                    || (playerGameChoice.equals(Constants.GAME.PAPER) && machineOne.equals(Constants.GAME.SCISSOR))
                    || (playerGameChoice.equals(Constants.GAME.SCISSOR) && machineOne.equals(Constants.GAME.ROCK)) ){

                    acvitityMainBinding.textviewResult.text = "DERROTA"
                    acvitityMainBinding.textviewResult.setTextColor(Color.RED)

                }else if( (playerGameChoice.equals(Constants.GAME.ROCK) && machineOne.equals(Constants.GAME.SCISSOR))
                    || (playerGameChoice.equals(Constants.GAME.PAPER) && machineOne.equals(Constants.GAME.ROCK))
                    || (playerGameChoice.equals(Constants.GAME.SCISSOR) && machineOne.equals(Constants.GAME.PAPER)) ){

                    acvitityMainBinding.textviewResult.text = "VITÓRIA"
                    acvitityMainBinding.textviewResult.setTextColor(Color.GREEN)

                }else{
                    acvitityMainBinding.textviewResult.text = "EMPATE"
                    acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                }

                setImages(machineOne)
            }else{
                val machineTwo: String = listOptions[Random.nextInt(0..2)]

                if((playerGameChoice != machineOne && machineOne != machineTwo && machineTwo != playerGameChoice)
                    ||  (playerGameChoice == machineTwo && machineOne == machineTwo)){
                    acvitityMainBinding.textviewResult.text = "EMPATE"
                    acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                } else if(playerGameChoice.equals(Constants.GAME.ROCK) ){

                    if(machineOne.equals(Constants.GAME.SCISSOR)
                        && machineTwo.equals(Constants.GAME.SCISSOR)){
                        acvitityMainBinding.textviewResult.text = "VITÓRIA"
                        acvitityMainBinding.textviewResult.setTextColor(Color.GREEN)
                    }else if(machineOne.equals(Constants.GAME.PAPER)
                        && machineTwo.equals(Constants.GAME.PAPER)){
                        acvitityMainBinding.textviewResult.text = "EMPATE"
                        acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                    }else if( ( machineOne.equals(Constants.GAME.PAPER) && machineTwo.equals(Constants.GAME.ROCK))
                        || ( machineOne.equals(Constants.GAME.ROCK) && machineTwo.equals(Constants.GAME.PAPER))){
                        acvitityMainBinding.textviewResult.text = "DERROTA"
                        acvitityMainBinding.textviewResult.setTextColor(Color.RED)
                    }else{
                        acvitityMainBinding.textviewResult.text = "EMPATE"
                        acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                    }

                }else if( playerGameChoice.equals(Constants.GAME.PAPER) ){

                    if(machineOne.equals(Constants.GAME.ROCK)
                            && machineTwo.equals(Constants.GAME.ROCK) ){
                        acvitityMainBinding.textviewResult.text = "VITÓRIA"
                        acvitityMainBinding.textviewResult.setTextColor(Color.GREEN)
                    }else if(machineOne.equals(Constants.GAME.SCISSOR)
                        && machineTwo.equals(Constants.GAME.SCISSOR) ){
                        acvitityMainBinding.textviewResult.text = "EMPATE"
                        acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                    }else if( ( machineOne.equals(Constants.GAME.SCISSOR) && machineTwo.equals(Constants.GAME.PAPER))
                        || ( machineOne.equals(Constants.GAME.PAPER) && machineTwo.equals(Constants.GAME.SCISSOR))){
                        acvitityMainBinding.textviewResult.text = "DERROTA"
                        acvitityMainBinding.textviewResult.setTextColor(Color.RED)
                    }else{
                        acvitityMainBinding.textviewResult.text = "EMPATE"
                        acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                    }

                }else if(playerGameChoice.equals(Constants.GAME.SCISSOR) ){
                    if(machineOne.equals(Constants.GAME.PAPER)
                        && machineTwo.equals(Constants.GAME.PAPER)){
                        acvitityMainBinding.textviewResult.text = "VITÓRIA"
                        acvitityMainBinding.textviewResult.setTextColor(Color.GREEN)
                    }else if(machineOne.equals(Constants.GAME.ROCK)
                        && machineTwo.equals(Constants.GAME.ROCK)){
                        acvitityMainBinding.textviewResult.text = "EMPATE"
                        acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                    }else if( ( machineOne.equals(Constants.GAME.ROCK) && machineTwo.equals(Constants.GAME.SCISSOR))
                        || ( machineOne.equals(Constants.GAME.SCISSOR) && machineTwo.equals(Constants.GAME.ROCK))){
                        acvitityMainBinding.textviewResult.text = "DERROTA"
                        acvitityMainBinding.textviewResult.setTextColor(Color.RED)
                    }else{
                        acvitityMainBinding.textviewResult.text = "EMPATE"
                        acvitityMainBinding.textviewResult.setTextColor(Color.BLUE)
                    }
                }
                setImages(machineOne, machineTwo)
            }
        }else{
            Toast.makeText(this,"Selecione uma opção", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setImages(machineOne: String, machineTwo: String? = null){
        acvitityMainBinding.textviewX.text = "X"
        val playerIconName =  playerGameChoice?.lowercase()
        val machineOneIcon = machineOne.lowercase()

        acvitityMainBinding.imageviewResultGamePlayer.setImageResource(
            resources.getIdentifier(playerIconName, "mipmap", packageName)
        )

        acvitityMainBinding.imageviewResultGameMachine1.setImageResource(
            resources.getIdentifier(machineOneIcon, "mipmap", packageName)
        )

        if(machineTwo != null){
            acvitityMainBinding.imageviewResultGameMachine2.visibility = View.VISIBLE

            val machineTwoIcon = machineTwo.lowercase()
            acvitityMainBinding.imageviewResultGameMachine2.setImageResource(
                resources.getIdentifier(machineTwoIcon, "mipmap", packageName)
            )
        }else{
            acvitityMainBinding.imageviewResultGameMachine2.visibility = View.INVISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_settings){
//            val settingsIntent = Intent(this, SettingsActivity::class.java)
//            activitySettingsResultLauncher.launch(settingsIntent)
            val intent = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(intent)
        }
        return true
    }


}