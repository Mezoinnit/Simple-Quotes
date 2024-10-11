package com.example.quotely.qutotely.presentation

import androidx.lifecycle.ViewModel
import com.example.quotely.qutotely.data.quotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {

    private val _quote = MutableStateFlow("")

    val quote = _quote.asStateFlow()

    private lateinit var lateQuote: String

    private val usedQuotes = MutableStateFlow(mutableSetOf<String>())

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _visible = MutableStateFlow(true)

    var visible = _visible.asStateFlow()

    fun nextQuote() {
        scope.launch {
            visibility()
            delay(500)
            duplicateCheck()
            visibility()
        }
    }

    private fun visibility(){
        _visible.update { !it }
    }

    private fun duplicateCheck() {
        if (quotes.isEmpty()) {
            lateQuote = "You have read all the quotes :)"
            _quote.value = lateQuote
            quotes.addAll(usedQuotes.value)
            usedQuotes.value.clear()
        } else {
            getQuote()
            usedQuotes.value.add(lateQuote)
        }
    }

    private fun getQuote() {
        lateQuote = quotes.random().toString()
        _quote.value = lateQuote
        quotes.remove(lateQuote)
    }


    init {
        nextQuote()
    }

}