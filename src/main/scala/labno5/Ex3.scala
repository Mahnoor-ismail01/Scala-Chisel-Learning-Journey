package labno5
import chisel3._
import chisel3.util._

class Operator [ T <: Data ]( n : Int , generic : T ) ( op : (T , T ) => T ) extends
Module {
require ( n>0)
val io = IO ( new Bundle {
val in = Input ( Vec (n , generic ) )
val out = Output (Vec(n, generic ))
})
io.out(0) := io.in.reduce(op)
io.out(1) := io.in.reduce( op )
io.out(2) := io.in.reduce( op )//sary vector ki value reduce kr k output 1 dega
}

// object UserOperator1 extends App {
//  val a=(new Operator (2 , UInt
// (16.W) ) ( _ + _ ) )
// }

// object UserOperator2 extends App {
// val b=( new Operator (3 , UInt
// (8.W ) ) ( _ & _ ) ) 
// }