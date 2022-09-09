package labno2
import chisel3._
import chisel3 . _
import chisel3.util._
// Mux IO interface class
class Mux_2to1_IO extends Bundle {
val in_A= Input ( UInt (32. W ) )
val in_B= Input ( UInt (32. W ) )
val select = Input ( Bool () )
val out= Output ( UInt () )
}
// 2 to 1 Mux implementation
class Mux_2to1 extends Module {
val io = IO ( new Mux_2to1_IO )
// update the output
val select = Fill (31 , io.select)

io.out := io.in_A & io.select | io.in_B & (~ io.select )
}
