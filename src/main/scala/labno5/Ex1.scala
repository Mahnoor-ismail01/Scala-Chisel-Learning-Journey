package labno5
import chisel3._
import chisel3.util . _
import scala.language.postfixOps

object ALUOP {
// ALU Operations , may expand / modify in future
val ALU_ADD= 0. U (4. W )
val ALU_SUB= 1. U (4. W )
val ALU_AND= 2. U (4. W )
val ALU_OR= 3. U (4. W )
val ALU_XOR= 4. U (4. W )
val ALU_SLT= 5. U (4. W )
val ALU_SLL= 6. U (4. W )
val ALU_SLTU= 7. U (4. W )
val ALU_SRL= 8. U (4. W )
val ALU_SRA= 9. U (4. W )
val ALU_COPY_A = 10. U (4. W )
val ALU_COPY_B = 11. U (4. W )
val ALU_XXX= 15. U (4. W )
}

trait Config1 {
// word length configuration parameter
val XLEN= 32
// ALU operation control signal width
val ALUOP_SIG_LEN = 4
}

import ALUOP._
//import chisel3.iotesters.{ Driver , PeekPokeTester }
class ALU5 ( width_parameter : Int ) extends Module {
val io = IO ( new IO_Interface ( width_parameter ) )

val index = log2Ceil ( width_parameter )
when( io . alu_Op===" b0000 " . U ) { // AND

io.out :=io.in_A &io.in_B
} // OR
.elsewhen(io . alu_Op=== " b0001 " . U ) {
io.out :=io.in_A |io.in_B
} // ADD
.elsewhen (io . alu_Op=== " b0010 " . U ) {
io.out :=io.in_A +io.in_B
} // SUB
.elsewhen( io . alu_Op===" b0110 " . U ) {
io.out :=io.in_A -io.in_B
} // XOR
.elsewhen( io . alu_Op===" b0011 " . U ) {
io.out :=io.in_A ^io.in_B
} // SLL
.elsewhen (io . alu_Op=== " b0100 " . U ) {
io.out :=io.in_A <<io.in_B ( index -1 , 0)
} // SRL
.elsewhen( io . alu_Op===" b0101 " . U ) {
io.out :=io.in_A >>io.in_B ( index -1 , 0)
} // SRA
.elsewhen(io . alu_Op=== " b0111 " . U ) {
io.out := (io.in_A . asSInt >>io.in_B ( index -1 , 0) ) . asUInt
} // SLT
.elsewhen (io . alu_Op=== " b1000 " . U ) {
io.out :=io.in_A . asSInt < io.in_B . asSInt
} // SLTU
.elsewhen (io . alu_Op=== " b1001 " . U ) {
io . out :=io.in_A < io.in_B
}
.otherwise{
    io . out := 0.U
}
}

class IO_Interface ( width : Int ) extends Bundle {
    val alu_Op = Input ( UInt ( width . W ) )
    val in_A = Input ( UInt ( width . W ) )
    val in_B= Input ( UInt ( width . W ) )
    val out = Output ( UInt ( width . W ) )
}
// println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new ALU (32) ) )
// println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new ALU (64) ) )