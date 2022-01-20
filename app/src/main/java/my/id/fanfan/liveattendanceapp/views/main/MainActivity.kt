package my.id.fanfan.liveattendanceapp.views.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import my.id.fanfan.liveattendanceapp.R
import my.id.fanfan.liveattendanceapp.databinding.ActivityMainBinding
import my.id.fanfan.liveattendanceapp.views.attendance.AttendanceFragment
import my.id.fanfan.liveattendanceapp.views.history.HistoryFragment
import my.id.fanfan.liveattendanceapp.views.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        binding.btmNavigationMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_history ->{
                    openFragment(HistoryFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_attendance ->{
                    openFragment(AttendanceFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_profile ->{
                    openFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        openHomeFragment()
    }

    private fun openHomeFragment() {
        binding.btmNavigationMain.selectedItemId = R.id.action_attendance
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_main,fragment)
            .addToBackStack(null)
            .commit()
    }


}