package labno4
import chisel3._
import chisel3.util._
import scala.language.postfixOps

object ALUOP1 {
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

import ALUOP1._


class ALUIO2 extends Bundle with Config1 {
val in_A= Input ( UInt ( XLEN . W ) )
val in_B= Input ( UInt ( XLEN . W ) )
val alu_Op= Input ( UInt ( ALUOP_SIG_LEN . W ) )
val out= Output ( UInt ( XLEN . W ) )
val sum= Output ( UInt ( XLEN . W ) )
}
class ALU3 extends Module with Config1 {
val io = IO ( new ALUIO2 )
val sum= io . in_A + Mux ( io . alu_Op (0) , - io . in_B , io . in_B )
val cmp= Mux ( io . in_A ( XLEN -1) === io . in_B ( XLEN -1) , sum ( XLEN -1) ,
Mux ( io . alu_Op (1) , io . in_B ( XLEN -1) , io . in_A ( XLEN -1) ) )

val shamt =io.in_B(4 ,0).asUInt
val shin=Mux ( io . alu_Op (3) , io . in_A , Reverse ( io . in_A ) )
val shiftr =( Cat ( io . alu_Op (0) && shin ( XLEN -1) , shin ) . asSInt >> shamt ) (XLEN -1 , 0)
val shiftl =Reverse ( shiftr )
io . out := 0. U
switch ( io . alu_Op ) {
is ( ALU_ADD ) {
io . out := sum
}
is ( ALU_SUB ) {
io . out := sum
}
is ( ALU_SLT ) {
io . out := cmp
}
is ( ALU_SLTU ) {
io . out := cmp
}
is ( ALU_SRA ) {
io . out := shiftr
}
is ( ALU_SRL) {
io . out := shiftr
}
is ( ALU_SLL ) {
io . out := shiftl
}
is ( ALU_AND ) {
io . out := ( io . in_A & io . in_B )
}

is ( ALU_OR ) {
io . out :=  ( io . in_A | io . in_B )
} 
is ( ALU_XOR ) {
io . out :=  ( io . in_A ^ io . in_B )
} 
is ( ALU_COPY_A ) {
io . out :=  ( io . in_A )
}
is ( ALU_COPY_B ) {
io . out :=  ( io . in_B )
}
 
}

io . sum := sum
}