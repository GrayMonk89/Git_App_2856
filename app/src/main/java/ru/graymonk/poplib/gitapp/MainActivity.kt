package ru.graymonk.poplib.gitapp

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.mainActivityButtonCounterOne.setOnClickListener {
            presenter.counterOneClick()
        }
        binding.mainActivityButtonCounterTwo.setOnClickListener {
            presenter.counterTwoClick()
        }
        binding.mainActivityButtonCounterThree.setOnClickListener {
            presenter.counterThreeClick()
        }
    }

    override fun setCounterOneText(text: String) {
        binding.mainActivityTextViewCounterOne.text = text
    }

    override fun setCounterTwoText(text: String) {
        binding.mainActivityTextViewCounterTwo.text = text
    }

    override fun setCounterThreeText(text: String) {
        binding.mainActivityTextViewCounterThree.text = text
    }
}