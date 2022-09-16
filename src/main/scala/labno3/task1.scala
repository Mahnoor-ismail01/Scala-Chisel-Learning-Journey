package labno3
import chisel3._

import chisel3 . util . _
object instruction{
    val I="b0010011".U
    val S="b0100011".U(7.W)
    val SB="b1100011".U(7.W)
    val U="b0110111".U(7.W)
    val UJ="b1101111".U(7.W)

}
import instruction._
class LM_IO_Interface_ImmdValGen extends Bundle {
val instr = Input ( UInt (32. W ) )
val immd_se = Output ( UInt (32. W ) )


}
class ImmdValGen extends Module {
val io = IO ( new LM_IO_Interface_ImmdValGen )




val extractopcode=io.instr(6,0)

    when (extractopcode===I){
        val Ival=(Cat(Fill (20,0.B ),io.instr(31,20)))
        io.immd_se:=Ival
    }

    .elsewhen(extractopcode===S){
        val Ival=Cat(Fill (20,0.B ),io.instr(31,25),io.instr(11,7))
        io.immd_se:=Ival

    }
    .elsewhen(extractopcode===SB){
        val Ival=Cat(Fill (20,0.B ),io.instr(11,8),io.instr(30,25),io.instr(7),io.instr(31))
        io.immd_se:=Ival

    }
    .elsewhen(extractopcode===U){
        val Ival =Cat(io.instr(31,12),Fill (12,0.B ))
        io.immd_se:=Ival

    }
    .elsewhen(extractopcode===UJ){
        val Ival=Cat(Fill (12,0.B ),io.instr(30,21),io.instr(20),io.instr(19,12),io.instr(31))
        io.immd_se:=Ival
    }
    .otherwise{
        io.immd_se:=0.U
    }
    //io.immd_se:=Ival


}