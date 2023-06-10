package ru.graymonk.poplib.gitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter: MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }
        binding.mainActivityButtonCounterOne.setOnClickListener(listener)
        binding.mainActivityButtonCounterTwo.setOnClickListener(listener)
        binding.mainActivityButtonCounterThree.setOnClickListener(listener)
        setOnClickListener()
    }

    private fun setOnClickListener() {

    }

    override fun setCounterText(index: Int, text: String) {
        when (index) {
            0 -> {
                binding.mainActivityTextViewCounterOne.text = text
                Toast.makeText(this, "Boom ", Toast.LENGTH_SHORT).show()
            }

            1 -> {
                binding.mainActivityTextViewCounterTwo.text = text
                Toast.makeText(this, "Boom ", Toast.LENGTH_SHORT).show()
            }

            2 -> {
                binding.mainActivityTextViewCounterThree.text = text
                Toast.makeText(this, "Boom ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}