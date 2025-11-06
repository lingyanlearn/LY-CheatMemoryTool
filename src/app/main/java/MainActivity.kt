package com.lingyan.tool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lingyan.tool.databinding.ActivityMainBinding

public class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("tomaslib")
        }
    }
    
    private var _binding: ActivityMainBinding? = null
    
    private val binding: ActivityMainBinding
      get() = checkNotNull(_binding) { "Activity has been destroyed" }
    
    // Native method declaration
    external fun sayHello(): String
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate and get instance of binding
        _binding = ActivityMainBinding.inflate(layoutInflater)

        // set content view to binding's root
        setContentView(binding.root)
        
        // Call native method and show toast
        val message = sayHello()
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
