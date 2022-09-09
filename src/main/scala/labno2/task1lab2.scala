package labno2
import chisel3 . _
class M5to1Mux extends Bundle {
val in1 = Input ( UInt (32. W ) )
val in2 = Input ( UInt (32. W ) )
val in3 = Input ( UInt (32. W ) )
val in4 = Input ( UInt (32. W ) )
val in5 = Input ( UInt (32. W ) )
val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Output ( UInt (32. W ) )
}
class Mux_5to1 extends Module {
val io = IO ( new M5to1Mux )
val  MuxF=Mux(io.s1,Mux(io.s0,io.in1,io.in2),Mux(io.s0,io.in3,io.in4))
val Mux5_to_1_a = Mux (io.s2,io.in5,MuxF)
//val out= io.out.asUInt

io . out := Mux5_to_1_a
}