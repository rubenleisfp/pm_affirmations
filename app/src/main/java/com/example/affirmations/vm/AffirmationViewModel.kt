package com.example.affirmations.vm

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AffirmationViewModel  : ViewModel(){
    //Envolvemos nuestra lista dentro de un _uiState
    private val _uiState = MutableStateFlow(AffirmationState(emptyList()))
    //UiState es una copia de _uiState no modificable
    val uiState: StateFlow<AffirmationState> = _uiState.asStateFlow()


    /**
     * Carga la lista de affirmations
     *
     */
    fun loadAffirmations() {
        _uiState.value.affirmations = Datasource().loadAffirmations()
    }

}
