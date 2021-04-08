package com.example.johntravolta.Model

class JohnTravolta {

    private var jamKerja: Int = 0
    private var gaji: Int = 0
    private var pengeluaran: Int = 0

    val totalGaji: Int
        get() {
            var jamNormal = 40
            var gajiNormal = 15000
            var gajiLembur: Int = 15000 * 150 / 100

            if (jamKerja > jamNormal) {
                gaji = (jamNormal * gajiNormal) + ((jamKerja - jamNormal) * gajiLembur)
            } else {
                gaji = jamKerja * gajiNormal
            }

            return gaji
        }

    val bisaMenabung: String
        get() {
            var message: String

            if (gaji > pengeluaran) {
                message = "John Bisa Menabung Sebesar " + (gaji - pengeluaran);
            } else if (gaji == pengeluaran) {
                message = "John Tidak Bisa Menabung";
            } else {
                message = "John Butuh Cari Uang!";
            }

            return message
        }

    fun hitungGaji(jamKerja: Int) {
        this.jamKerja = jamKerja
    }

    fun hitungPengeluaran(gaji: Int, pengeluaran: Int) {
        this.gaji = gaji
        this.pengeluaran = pengeluaran
    }


}