package com.capstone.myapplication.dummy

import com.capstone.myapplication.data.dataProfile
import com.capstone.myapplication.data.dataSturcture

object dummyData {

    fun generateDummyProfile(): ArrayList<dataProfile>{

        val profile = ArrayList<dataProfile>()
        profile.add(dataProfile(
            "Camelia",
            "Camelia@gmail.com",
            "12345678",
            ""))
        return profile
    }

    fun generateDummyAspirasi(): ArrayList<dataSturcture>{

        val aspirasi = ArrayList<dataSturcture>()
        aspirasi.add(
            dataSturcture(
            "A1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""))
        return aspirasi
    }

    fun generateDummyEvent(): ArrayList<dataSturcture>{

        val event = ArrayList<dataSturcture>()
        event.add(dataSturcture(
            "E1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""))
        return event
    }

    fun generateDummyLaporan(): ArrayList<dataSturcture>{
        val laporan = ArrayList<dataSturcture>()
        laporan.add(dataSturcture(
            "L1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""))
        return laporan
    }


}