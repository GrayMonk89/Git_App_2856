package ru.graymonk.poplib.gitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val counter = mutableListOf(0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCounters()

        setOnClickListener()
    }

    private fun initCounters() {
        binding.mainActivityTextViewCounterOne.text = counter[0].toString()
        binding.mainActivityTextViewCounterTwo.text = counter[1].toString()
        binding.mainActivityTextViewCounterThree.text = counter[2].toString()
    }

    private fun setOnClickListener() {
        binding.mainActivityButtonCounterOne.setOnClickListener {
            binding.mainActivityTextViewCounterOne.text = (++counter[0]).toString()
        }
        binding.mainActivityButtonCounterTwo.setOnClickListener {
            binding.mainActivityTextViewCounterTwo.text = (++counter[1]).toString()
        }
        binding.mainActivityButtonCounterThree.setOnClickListener {
            binding.mainActivityTextViewCounterThree.text = (++counter[2]).toString()
        }
    }
}