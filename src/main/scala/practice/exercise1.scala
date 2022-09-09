package practice
import chisel3._
import chisel3 . util . _
import java.io.File
class counter_up_down ( n : Int ) extends Module {
val io = IO ( new Bundle {
//val data_in = Input ( UInt ( n . W ) )
val reload = Input ( Bool () )
val out = Output ( Bool () )
})
val counter = RegInit (0. U ( n . W ) )
val max_count = 7.U //RegInit (6. U ( n . W ) )
val rel= RegInit (0.U (1.W))
println(max_count)
io.out := 0.U
when (rel===0.U){
    when (counter=/=max_count){
        rel:=1.B
        io.out:=1.U
        counter:=counter + 1.U
        println("1")
         //rel:=1.U
    }
    .elsewhen(counter===max_count){
        rel:=1.U
        io.out:=1.U
        counter:=counter-1.U
         //rel:=1.U
        // counter:=counter-1.U
    }
    // .elsewhen(counter===0.U){
    //     counter:=counter - 1.U
       
    //     io.out := 1.U

    // }
    //val rel=WireInit ( false . B )
    

   
   }
  // rel:=1.U
   when (rel===1.U){
    when (counter=/=max_count){
        rel:=1.B
        io.out:=1.U
        counter:=counter + 1.U
        println("1")
         //rel:=1.U
    }
    .elsewhen(counter===max_count){
        rel:=1.U
        io.out:=1.U
        counter:=counter-1.U
         //rel:=1.U
        // counter:=counter-1.U
    }
    // .elsewhen(counter===0.U){
    //     counter:=counter - 1.U
       
    //     io.out := 1.U

    // }
    //val rel=WireInit ( false . B )
    

   
   }


//Your code

// object Top2 {
// def main ( args : Array [ String ]) : Unit =
// {
// var pObject = new  counter_up_down(2)

// }}
}