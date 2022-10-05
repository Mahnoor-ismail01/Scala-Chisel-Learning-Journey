package SingleCycle
import chisel3._
import chisel3.util._

object instruction2{
    val I="b0010011".U
    val S="b0100011".U(7.W)
    val SB="b1100011".U(7.W)
    val U="b0110111".U(7.W)
    val UJ="b1101111".U(7.W)

}
import instruction2._
class LM_IO_Interface_ImmdValGen2 extends Bundle {
val instr = Input ( UInt (32. W ) )
val immd_I = Output ( SInt (32. W ) )
val immd_S = Output ( SInt (32. W ) )
val immd_SB = Output ( SInt (32. W ) )
val immd_U = Output ( SInt (32. W ) )
val immd_UJ = Output ( SInt (32. W ) )


}
class ImmdValGen2 extends Module {
val io = IO ( new LM_IO_Interface_ImmdValGen2 )




val extractopcode=io.instr(6,0)

io.immd_I:=0.S
io.immd_S:=0.S
io.immd_SB:=0.S
io.immd_U:=0.S
io.immd_UJ:=0.S

    when (extractopcode===I){
        val Ival=(Cat(Fill (20,0.B ),io.instr(31,20)))
        io.immd_I:=Ival.asSInt
    }

    .elsewhen(extractopcode===S){
        val Ival=Cat(Fill (20,0.B ),io.instr(31,25),io.instr(11,7))
        io.immd_S:=Ival.asSInt

    }
    .elsewhen(extractopcode===SB){
        val Ival=Cat(Fill (20,0.B ),io.instr(11,8),io.instr(30,25),io.instr(7),io.instr(31))
        io.immd_SB:=Ival.asSInt

    }
    .elsewhen(extractopcode===U){
        val Ival =Cat(io.instr(31,12),Fill (12,0.B ))
        io.immd_U:=Ival.asSInt

    }
    .elsewhen(extractopcode===UJ){
        val Ival=Cat(Fill (12,0.B ),io.instr(30,21),io.instr(20),io.instr(19,12),io.instr(31))
        io.immd_UJ:=Ival.asSInt
    }
    
    //io.immd_se:=Ival


}
