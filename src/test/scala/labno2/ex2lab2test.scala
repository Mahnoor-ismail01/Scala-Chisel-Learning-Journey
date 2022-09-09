package labno2
import chisel3._
import chiseltest._
import org.scalatest._

class mux4into1test extends FreeSpec with ChiselScalatestTester{
    "testlabno2" in {
        test(new mux_onehot_4to1()){
            c=>
            c.io.in0.poke(0.U)
            c.io.in1.poke(1.U)
             c.io.in2.poke(8.U)
              
               c.io.in3.poke(1.U)
             c.io.sel.poke(3.B)
           c.io.sel1.poke(0.B)
            c.clock.step(1)
            c.io.out.expect(8.U)
             
            c.io.out1.expect(0.U)
           
        }
    }
}