package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.R.id
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import kotlinx.android.synthetic.main.activity_main.*
import android.R.id.toggle

import androidx.drawerlayout.widget.DrawerLayout




class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private fun showNavigation(){
        bottomNavigationView.visibility = View.VISIBLE
        navView.visibility = View.VISIBLE
    }

    private fun hideNavigation(){
        bottomNavigationView.visibility = View.GONE
        navView.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.loginFragment,
//                R.id.registerFragment,
//            )
//        )

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(navView,navController)

//        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            when(destination.id){
                R.id.loginFragment -> hideNavigation()
                R.id.registerFragment -> hideNavigation()
                else -> showNavigation()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout) || super.onSupportNavigateUp()
    }



}