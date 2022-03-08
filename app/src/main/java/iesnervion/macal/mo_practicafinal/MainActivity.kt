package iesnervion.macal.mo_practicafinal

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import iesnervion.macal.mo_practicafinal.databinding.ActivityMainBinding
import iesnervion.macal.mo_practicafinal.viewModels.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding

    private val userViewModel : UserVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonClick = findViewById<Button>(R.id.activity_login__btn__continue_products_list)
        buttonClick.setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            startActivity(intent)
        }
        userViewModel.userModel.observe(this, Observer{ currentUser->
            binding.activityLoginInputUsuEmail.text = currentUser.email

            //aqui tendria q recibir el nuevo email y guardarlo en el objeto User
        })
    }
}


