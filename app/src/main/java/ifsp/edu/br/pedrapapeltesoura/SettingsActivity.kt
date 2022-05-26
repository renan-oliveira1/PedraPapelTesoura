package ifsp.edu.br.pedrapapeltesoura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ifsp.edu.br.pedrapapeltesoura.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private val activitySettingsBinding: ActivitySettingsBinding by lazy{
        ActivitySettingsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activitySettingsBinding.root)

        activitySettingsBinding.buttonSave.setOnClickListener {
            val numberPlayers = (activitySettingsBinding.spinnerNumberPlayers.selectedView as TextView)
                .text
                .toString()
                .toInt()

            val resultIntent = Intent()
            resultIntent.putExtra(Constants.ACTIVITY_RESULT.NUMBER_PLAYERS, numberPlayers)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}