package vn.udn.ute.lamquen_2415053122117

data class LuotNhan(
    val maLuot_2117: String,
    val hoTen_2117: String,
    val soLuong_2117: Int
)
fun String.chuanHoaTen_2117(): String = this.trim()

object QuyTacPhieu_2117 {
    fun taoMaPhieu_2117(soThuTu: Int): String = "L$soThuTu"
}