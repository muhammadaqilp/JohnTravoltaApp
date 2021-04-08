package com.example.johntravolta.Model

internal class MainViewModel(private val johnTravolta: JohnTravolta) {

    val jamKerja: Int
        get() = johnTravolta.totalGaji

    val bisaMenabung: String
        get() = johnTravolta.bisaMenabung

    fun hitungGaji(jamKerja: Int) {
        johnTravolta.hitungGaji(jamKerja)
    }

    fun hitungPengeluaran(gaji: Int, pengeluaran: Int) {
        johnTravolta.hitungPengeluaran(gaji, pengeluaran)
    }
}