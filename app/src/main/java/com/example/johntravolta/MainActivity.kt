package com.example.johntravolta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.johntravolta.Model.JohnTravolta
import com.example.johntravolta.Model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private var gaji: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(JohnTravolta())

        btn_hitungGaji.setOnClickListener(this)
        btn_hitungPengeluaran.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val jamKerja = edt_jamKerja.text.toString().trim()
        val pengeluaran = edt_pengeluaran.text.toString().trim()

        when {
            v.id == R.id.btn_hitungGaji -> {
                if (jamKerja.isEmpty()) edt_jamKerja.error = "Field ini tidak boleh kosong"
                else {
                    val jk = jamKerja.toInt()
                    mainViewModel.hitungGaji(jk)
                    gaji = mainViewModel.jamKerja
                    tv_result_gaji.text = gaji.toString()
                }
            }

            v.id == R.id.btn_hitungPengeluaran -> {
                if (pengeluaran.isEmpty()) edt_pengeluaran.error = "Field ini tidak boleh kosong"
                else {
                    val p = pengeluaran.toInt()
                    mainViewModel.hitungPengeluaran(gaji, p)
                    val abc = mainViewModel.bisaMenabung
                    tv_result_pengeluaran.text = abc
                }
            }
        }

    }
}
