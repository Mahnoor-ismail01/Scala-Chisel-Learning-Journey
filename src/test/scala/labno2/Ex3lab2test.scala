package labno2
import chisel3._
import org.scalatest._
import chiseltest._

class Muxlookuptest extends FreeSpec with ChiselScalatestTester{
    "testlabno2" in {
        test(new MuxLookup1()){
            c=>
            c.io.in0.poke(1.B)
             c.io.in1.poke(0.B)
              c.io.in2.poke(1.B)
               c.io.in3.poke(1.B)
               c.io.in4.poke(1.B)
               c.io.in5.poke(1.B)
               c.io.in6.poke(1.B)
               c.io.in7.poke(1.B)  
               c.io.sel.poke(0.B)
                c.io.sel1.poke(0.B)
               c.io.sel2.poke(0.B)
               c.clock.step(1)
               c.io.out.expect(1.B)

        }
    }
    
}