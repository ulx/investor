package ru.sberbank.sberinvestor

import android.os.Bundle
import ru.sberbank.sberinvestor.databinding.ActivityNavHostBinding
import ru.sberinvestor.core.BaseActivity

class NavHostActivity : BaseActivity() {

    private lateinit var binding: ActivityNavHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
