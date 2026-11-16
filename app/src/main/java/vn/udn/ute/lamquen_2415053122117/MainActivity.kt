package vn.udn.ute.lamquen_2415053122117

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var luotCuoi_2117: LuotNhan? = null
    private var soThuTu_2117 = 0
    private lateinit var edtTen: EditText
    private lateinit var edtSoLuong: EditText
    private lateinit var btnKiemTra: Button
    private lateinit var btnXoa: Button
    private lateinit var txtKetQua: TextView
    private lateinit var txtMaLuot: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTen = findViewById(R.id.edtTen)
        edtSoLuong = findViewById(R.id.edtSoLuong)
        btnKiemTra = findViewById(R.id.btnKiemTra)
        btnXoa = findViewById(R.id.btnXoa)
        txtKetQua = findViewById(R.id.txtKetQua)
        txtMaLuot = findViewById(R.id.txtMaLuot)
        btnKiemTra.setOnClickListener { kiemTra_2117() }
        btnXoa.setOnClickListener { xoa_2117() }
    }

    fun kiemTra_2117() {
        edtTen.error = null
        edtSoLuong.error = null

        val hoTen = edtTen.text.toString().chuanHoaTen_2117()
        if (hoTen.length !in 2..40) {
            edtTen.error = "Họ tên phải từ 2 đến 40 ký tự"
            xoaKetQuaCu()
            return
        }
        val soLuong = edtSoLuong.text.toString().trim().toIntOrNull()
        if (soLuong == null || soLuong !in 1..9) {
            edtSoLuong.error = "Số lượng phải là số nguyên từ 1 đến 9"
            xoaKetQuaCu()
            return
        }
        soThuTu_2117++
        val maLuot = QuyTacPhieu_2117.taoMaPhieu_2117(soThuTu_2117)
        luotCuoi_2117 = LuotNhan(
            maLuot_2117 = maLuot,
            hoTen_2117 = hoTen,
            soLuong_2117 = soLuong
        )
        luotCuoi_2117?.let {
            txtKetQua.text = "Xin chào ${it.hoTen_2117}, số lượng: ${it.soLuong_2117}"
            txtMaLuot.text = it.maLuot_2117
        }
    }
    fun xoa_2117() {
        edtTen.text.clear()
        edtSoLuong.text.clear()
        edtTen.error = null
        edtSoLuong.error = null
        xoaKetQuaCu()
    }
    private fun xoaKetQuaCu() {
        luotCuoi_2117 = null
        txtKetQua.text = ""
        txtMaLuot.text = ""
    }
}