package labno8
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class arbitor extends FreeSpec with ChiselScalatestTester{
    "asslab8" in {
        test(new memory_assignment()){
            c=>
           // c.io.memory_out(0).poke(1.U) 
   c.io.requestor(0).bits.poke(1.U)
            c.io.requestor(1).bits.poke(1.U)
            c.io.requestor(2).bits.poke(0.U)
            c.io.requestor(3).bits.poke(1.U)
            c.io.requestor(0).valid.poke(1.B)
            c.io.requestor(1).valid.poke(1.B)
            c.io.requestor(2).valid.poke(1.B)
            c.io.requestor(3).valid.poke(1.B)
    c.io.Readaddr.poke(1.U) 
    c.io.Writeaddr.poke(2.U) 
                c.clock.step(100)
            //c.io.out.expect(1.U)
        }
    }
}