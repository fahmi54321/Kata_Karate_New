package com.mobile.katakaratenew.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mobile.katakaratenew.Model.ResponsePenilaian
import com.mobile.katakaratenew.R
import com.mobile.katakaratenew.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class MainActivity : AppCompatActivity() {

    var angka:Double = 5.0
    var df = DecimalFormat(
        "#.##",
        DecimalFormatSymbols.getInstance(Locale.US)
    )

    //todo 2 deklarasi view model
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 3 inisialisasi view model
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        // todo 4 pengamatan
        pengamatan()

        txtAngkaTeknik.text = angka.toString()

        val bundle = intent.extras
        var wasit = bundle?.getString("wasit")

        nomorWasit.text = "Judge "+wasit.toString()

        btnreset.setOnClickListener {
            txtAngkaTeknik.text = angka.toString()
            txtAngkaAtlit.text = angka.toString()
        }



        LnPlusSatuTeknik.setOnClickListener {
            var angka = txtAngkaTeknik.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble+1.0
            var format = df.format(angkaDouble)
            txtAngkaTeknik.text = format.toString()
        }
        LNMinSatuTeknik.setOnClickListener {
            var angka = txtAngkaTeknik.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble-1.0
            var format = df.format(angkaDouble)
            txtAngkaTeknik.text = format.toString()
        }
        LnPlusNolDuaTeknik.setOnClickListener {
            var angka = txtAngkaTeknik.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble+0.2
            var format = df.format(angkaDouble)
            txtAngkaTeknik.text = format.toString()
        }
        LnMinNolDuaTeknik.setOnClickListener {
            var angka = txtAngkaTeknik.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble-0.2
            var format = df.format(angkaDouble)
            txtAngkaTeknik.text = format.toString()
        }

        LnPlusSatuAtlit.setOnClickListener {
            var angka = txtAngkaAtlit.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble+1.0
            var format = df.format(angkaDouble)
            txtAngkaAtlit.text = format.toString()
        }
        LnMinSatuAtlit.setOnClickListener {
            var angka = txtAngkaAtlit.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble-1.0
            var format = df.format(angkaDouble)
            txtAngkaAtlit.text = format.toString()
        }
        LnPlusNolDuaAtlit.setOnClickListener {
            var angka = txtAngkaAtlit.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble+0.2
            var format = df.format(angkaDouble)
            txtAngkaAtlit.text = format.toString()
        }
        LnMinNolDuaAtlit.setOnClickListener {
            var angka = txtAngkaAtlit.text.toString()
            var angkaDouble = angka.toDouble()
            angkaDouble = angkaDouble-0.2
            var format = df.format(angkaDouble)
            txtAngkaAtlit.text = format.toString()
        }

        btnsend.setOnClickListener {
            //todo ambil view
            var angkaTeknik = txtAngkaTeknik.text.toString()
            var angkaAtlit = txtAngkaAtlit.text.toString()
            var nomor = wasit.toString()

            // todo 5 eksekusi view model
            viewModel.penilaia(nomor,angkaTeknik,angkaAtlit)
        }
    }

    private fun pengamatan() {
        viewModel.responPenilaian.observe(this, androidx.lifecycle.Observer { responPenilaian(it) })
        viewModel.errorPenilaian.observe(this, androidx.lifecycle.Observer { errorPenilaian(it) })
        viewModel.showLoading.observe(this, androidx.lifecycle.Observer { showLoading(it) })
    }

    private fun showLoading(it: Boolean?) {
        if (it==true){
            progressBar.visibility = View.VISIBLE
            btnsend.text = "Loading"
            btnsend.isEnabled = false
            btnreset.isEnabled = false
        }
        if (it==false){
            progressBar.visibility = View.GONE
            btnsend.text = "Simpan"
            btnsend.isEnabled = true
            btnreset.isEnabled = true
        }
    }

    private fun showDialogGagal() {
        AlertDialog.Builder(this).apply {
            setTitle("Gagal")
            setMessage("Klik Tutup Untuk Kembali ?")
            setPositiveButton("Tutup") { dialog, which ->
                dialog.dismiss()
            }.show()
        }
    }

    private fun showDialogSukses() {
        AlertDialog.Builder(this).apply {
            setTitle("Berhasil")
            setMessage("Klik Tutup Untuk Kembali ?")
            setPositiveButton("Tutup") { dialog, which ->
                dialog.dismiss()
            }.show()
        }
    }

    private fun errorPenilaian(it: Throwable?) {
        toast(it?.message)
        showDialogGagal()
    }

    private fun responPenilaian(it: ResponsePenilaian?) {
        toast(it?.message)
        showDialogSukses()
    }

    fun toast(message: String?){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}