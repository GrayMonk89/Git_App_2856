package ru.graymonk.poplib.gitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}