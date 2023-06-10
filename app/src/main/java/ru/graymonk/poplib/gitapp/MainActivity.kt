package ru.graymonk.poplib.gitapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding
import ru.graymonk.poplib.gitapp.utils.Constants


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter: MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.mainActivityButtonCounterOne.setOnClickListener {
            presenter.counterClick(Constants.DEFAULT_VALUE_ZERO)
        }
        binding.mainActivityButtonCounterTwo.setOnClickListener {
            presenter.counterClick(Constants.DEFAULT_VALUE_ONE)
        }
        binding.mainActivityButtonCounterThree.setOnClickListener {
            presenter.counterClick(Constants.DEFAULT_VALUE_TWO)
        }
    }

    override fun setCounterText(index: Int, text: String) {
        when (index) {
            Constants.DEFAULT_VALUE_ZERO -> {
                binding.mainActivityTextViewCounterOne.text = text
            }

            Constants.DEFAULT_VALUE_ONE -> {
                binding.mainActivityTextViewCounterTwo.text = text
            }

            Constants.DEFAULT_VALUE_TWO -> {
                binding.mainActivityTextViewCounterThree.text = text
            }
        }
    }
}