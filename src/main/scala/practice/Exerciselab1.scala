package practice

import chisel3._

class counter1 ( counterBits : SInt ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})
val max =( ((1.U) << (counterBits).asUInt ) - (1.U) ).asSInt 
println(max)
val count = RegInit (0.S (16. W )  ) 

when ( count === max ) {
count := (0.S)
} .otherwise {
count := count + (1.S) 
}
io.result := count(3.U)//index negative nahi hota is liye

}