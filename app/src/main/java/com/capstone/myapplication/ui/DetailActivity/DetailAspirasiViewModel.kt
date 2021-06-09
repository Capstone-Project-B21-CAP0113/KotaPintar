package com.capstone.myapplication.ui.DetailActivity

import androidx.lifecycle.ViewModel
import com.capstone.myapplication.data.dataSturcture
import com.capstone.myapplication.dummy.dummyData

class DetailAspirasiViewModel : ViewModel() {
    companion object {
        const val ASPIRASI = "aspirasi"
        const val LAPORAN = "laporan"
        const val EVENT = "event"
    }

    private lateinit var form: dataSturcture

    fun setFilm(id: String, category: String) {
        when (category) {
            ASPIRASI -> {
                for (aspirasi in dummyData.generateDummyAspirasi()) {
                    if (aspirasi.id == id) form = aspirasi
                }
            }
            LAPORAN -> {
                for (laporan in dummyData.generateDummyLaporan()) {
                    if (laporan.id == id) form = laporan
                }
            }
            EVENT -> {
                for (event in dummyData.generateDummyEvent()) {
                    if (event.id == id) form = event
                }
            }


        }
    }

    fun getFilmDetail() = form

}