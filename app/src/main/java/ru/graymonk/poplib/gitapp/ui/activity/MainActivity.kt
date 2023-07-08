package ru.graymonk.poplib.gitapp.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.graymonk.poplib.gitapp.App
import ru.graymonk.poplib.gitapp.R
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding
import ru.graymonk.poplib.gitapp.mvp.presenter.MainPresenter
import ru.graymonk.poplib.gitapp.mvp.view.MainView
import javax.inject.Inject


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val presenter by moxyPresenter { MainPresenter().apply {
        App.instance.appComponent.inject(this)
    } }



    private val navigator = AppNavigator(this, R.id.mainContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()

        navigatorHolder.removeNavigator()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach{
            if (it is BackButtonListener && it.backPressed()){
                return
            }
        }

        presenter.backClicked()
    }

}